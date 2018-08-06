package cn.chips.hot.filter;

import cn.chips.hot.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FileFilter {
    private static final List<String> excludeFolders = new ArrayList<>();
    private static final List<String> excludeClassFiles = new ArrayList<>();

    public static boolean isExcludeFolder(String fileName) {

        return excludeFolders.contains(fileName);
    }

    public static boolean isExcludeClassFile(String fileName) {
        return excludeClassFiles.contains(fileName);
    }

    public static void addExcludeFile(String... fileNames) {

        for (int i = 0; i < fileNames.length; i++) {

            String fileName = fileNames[i];

            if (StringUtils.isNotEmpty(fileName)) {

                String[] fileSplit = fileName.split(".");

                if (fileSplit.length > 1 && "class".equals(fileSplit[1]))
                    excludeClassFiles.add(fileName);

                else if (fileSplit.length == 1)
                    excludeFolders.add(fileName);
            }
        }
    }
}
