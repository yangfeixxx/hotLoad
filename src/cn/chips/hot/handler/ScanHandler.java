package cn.chips.hot.handler;

import cn.chips.hot.cache.FileMetaDataCache;
import cn.chips.hot.configuration.HotLoadConfiguration;
import cn.chips.hot.utils.FileUtils;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

//2018/7/21 cread by yangfei
public class ScanHandler {
    private HotLoadConfiguration hotLoadConfiguration;

    public ScanHandler() {
    }

    public ScanHandler(HotLoadConfiguration hotLoadConfiguration) {
        this.hotLoadConfiguration = hotLoadConfiguration;
    }

    public void startScan() {
        List<File> list = new ArrayList<>();
        FileUtils.getClassFileList(hotLoadConfiguration.getLocation(), list);
        for (int i = 0; i < list.size(); i++) {
            //考虑运行速度和版本兼容,不使用foreach和Stream
            FileMetaDataCache.setFileMetaData(list.get(i).getAbsolutePath(), list.get(i));
        }
        new ScanTimerHandler(hotLoadConfiguration).startScanTimer();
    }
}
