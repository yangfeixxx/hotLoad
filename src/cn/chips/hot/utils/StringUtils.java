package cn.chips.hot.utils;

//2018/7/21 cread by yangfei
public class StringUtils {
    public static boolean isNotEmpty(String str) {
        return str != null && str.trim().length() != 0;
    }
}
