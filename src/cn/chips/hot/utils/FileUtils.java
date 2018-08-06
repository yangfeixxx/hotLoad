package cn.chips.hot.utils;

import jdk.nashorn.api.scripting.ClassFilter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static cn.chips.hot.filter.FileFilter.isExcludeClassFile;
import static cn.chips.hot.filter.FileFilter.isExcludeFolder;

//2018/7/21 cread by yangfei
public class FileUtils {

    public static void getClassFileList(String fileLocation, List<File> list) {
        File currentFile = new File(fileLocation);
        if (pickDirectory(currentFile)) {
            File[] files = currentFile.listFiles();
            for (int i = 0; i < files.length; i++) {
                //考虑运行速度和版本兼容,不使用foreach和Stream
                if (pickDirectory(files[i]))
                    getClassFileList(files[i].getAbsolutePath(), list);
                else if (pickFile(currentFile))
                    list.add(files[i]);
//                    FileMetaDataCache.setFileMetaData(files[i].getAbsolutePath(), files[i].lastModified());

            }
        } else if (pickFile(currentFile))
            list.add(currentFile);
//            FileMetaDataCache.setFileMetaData(currentFile.getAbsolutePath(), currentFile.lastModified());
    }

    private static boolean pickDirectory(File file) {

        return file.isDirectory() && !isExcludeFolder(file.getAbsolutePath());

    }

    private static boolean pickFile(File file) {
        return file.getName().lastIndexOf(".class") != -1 && !isExcludeClassFile(file.getAbsolutePath());
    }


}
