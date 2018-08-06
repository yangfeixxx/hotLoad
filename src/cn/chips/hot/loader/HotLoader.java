package cn.chips.hot.loader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class HotLoader extends ClassLoader {
    private File file;

    public HotLoader(File file) {
        super(Thread.currentThread().getContextClassLoader());
        this.file = file;
    }

    public static void reLoadFileClass(File file) throws ClassNotFoundException {
        if (file == null || file.getName().lastIndexOf(".class") == -1)
            throw new RuntimeException("不能加载非class文件");

        HotLoader hotLoader = new HotLoader(file);
        hotLoader.loadClass(file.getAbsolutePath());
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
