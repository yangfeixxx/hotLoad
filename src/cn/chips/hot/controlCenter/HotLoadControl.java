package cn.chips.hot.controlCenter;


import cn.chips.hot.configuration.HotLoadConfiguration;
import cn.chips.hot.handler.ScanHandler;
import cn.chips.hot.utils.StringUtils;

//2018/7/21 cread by yangfei
public class HotLoadControl {


    public HotLoadControl() {
    }


    public void start() {
        check();
        new ScanHandler().startScan();
    }

    private void check() {
        if (HotLoadConfiguration.interval.intValue() <= 0) {
            throw new RuntimeException("每次扫描间隔时间必须大于0,如不设置,默认为1S一次");
        }


    }

    public static void main(String args[]) {
        Long a = 1L;
        System.out.println(a == 1);
    }
}
