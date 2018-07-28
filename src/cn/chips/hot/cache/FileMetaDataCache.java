package cn.chips.hot.cache;

import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

//2018/7/21 cread by yangfei
public class FileMetaDataCache {
    private static final ConcurrentHashMap<String, File> fileMetaDataCache = new ConcurrentHashMap();

    public static void setFileMetaData(String key, File value) {
        fileMetaDataCache.put(key, value);
    }

    public static File getFileMetaData(String key) {
        return fileMetaDataCache.get(key);
    }

    public static ConcurrentHashMap<String, File> getFileMetaDataCache() {
        return fileMetaDataCache;
    }
}
