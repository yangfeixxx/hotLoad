package cn.chips.hot.cache;

import java.util.concurrent.ConcurrentHashMap;
//2018/7/21 cread by yangfei
public class FileMetaDataCache {
    private static final ConcurrentHashMap<String, Long> fileMetaDataCache = new ConcurrentHashMap();

    public static void setFileMetaData(String key, Long value) {
        fileMetaDataCache.put(key, value);
    }

    public static Long getFileMetaData(String key) {
        return fileMetaDataCache.get(key);
    }

    public static ConcurrentHashMap<String, Long> getFileMetaDataCache() {
        return fileMetaDataCache;
    }
}
