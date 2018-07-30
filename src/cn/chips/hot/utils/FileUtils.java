package cn.chips.hot.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//2018/7/21 cread by yangfei
public class FileUtils {
    private static final List<String> excludeFolders = new ArrayList<>();
    private static final List<String> excludeClassFiles = new ArrayList<>();

    public static void getClassFileList(String fileLocation, List<File> list) {
        File currentFile = new File(fileLocation);
        if (currentFile.isDirectory()) {
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

    private static boolean isExcludeFolder(String fileName) {
        return excludeFolders.contains(fileName);
    }

    private static boolean isExcludeClassFile(String fileName) {
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

    public static void reLoadFileClass(File file) throws ClassNotFoundException {
        MyClassLoader myClassLoader = new MyClassLoader(file);
        myClassLoader.loadClass(file.getAbsolutePath());
    }

    private static class MyClassLoader extends ClassLoader {
        private File file;

        public MyClassLoader(File file) {
            super(Thread.currentThread().getContextClassLoader());
            this.file = file;
        }

        @Override
        protected Class<?> findClass(String name) {

            byte[] bytes = new byte[0];
            try {
                bytes = MyLoadClass();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return this.defineClass(name, bytes, 0, bytes.length);
        }

        private byte[] MyLoadClass() throws IOException {
            int b = 0;
            FileInputStream fileInputStream = null;
            ByteArrayOutputStream byteArrayOutputStream = null;
            try {
                fileInputStream = new FileInputStream(file);
                byteArrayOutputStream = new ByteArrayOutputStream();

                while ((b = fileInputStream.read()) != -1) {
                    byteArrayOutputStream.write(b);
                }
                return byteArrayOutputStream.toByteArray();
            } finally {
                fileInputStream.close();
                byteArrayOutputStream.close();
            }
        }
    }


}
