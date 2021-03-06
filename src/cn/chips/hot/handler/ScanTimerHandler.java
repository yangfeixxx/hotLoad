package cn.chips.hot.handler;

import cn.chips.hot.cache.FileMetaDataCache;
import cn.chips.hot.configuration.HotLoadConfiguration;
import cn.chips.hot.loader.HotLoader;
import cn.chips.hot.utils.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//2018/7/21 cread by yangfei
public class ScanTimerHandler {
    private HotLoadConfiguration hotLoadConfiguration;
    private ScheduledExecutorService scheduledExecutorService;

    public ScanTimerHandler(HotLoadConfiguration hotLoadConfiguration) {
        this.hotLoadConfiguration = hotLoadConfiguration;
        this.scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    }


    public void startScanTimer() {
        scheduledExecutorService.scheduleAtFixedRate(new ScanTimerRunable(), 5, hotLoadConfiguration.getInterval(), TimeUnit.SECONDS);
    }

    private class ScanTimerRunable implements Runnable {

        @Override
        public void run() {
            // System.out.println("定时器启动了");
            List<File> fileList = new ArrayList();
            FileUtils.getClassFileList(hotLoadConfiguration.getLocation(), fileList);
            for (int i = 0; i < fileList.size(); i++) {
                //考虑运行速度和版本兼容,不使用foreach和Stream
                File file = fileList.get(i);
                File fileMetaData = FileMetaDataCache.getFileMetaData(file.getAbsolutePath());
                if (fileMetaData == null || fileMetaData.lastModified() != file.lastModified()) {
                    try {
                        HotLoader.reLoadFileClass(file);
                        FileMetaDataCache.setFileMetaData(file.getAbsolutePath(), file);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
