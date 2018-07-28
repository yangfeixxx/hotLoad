package cn.chips.hot.controlCenter;


import cn.chips.hot.configuration.HotLoadConfiguration;
import cn.chips.hot.handler.ScanHandler;
import cn.chips.hot.utils.StringUtils;

//2018/7/21 cread by yangfei
public class HotLoadControl {
    private HotLoadConfiguration hotLoadConfiguration;

    public HotLoadControl() {

    }

    public HotLoadControl(HotLoadConfiguration hotLoadConfiguration) {
        this.hotLoadConfiguration = hotLoadConfiguration;
    }

    public void start() {
        check();
        new ScanHandler(hotLoadConfiguration).startScan();
    }

    private void check() {
        if (hotLoadConfiguration.getInterval() <= 0) {
            throw new RuntimeException("每次扫描间隔时间必须大于0");
        }
    }

    public static void main(String args[]) {
        Long a = 1L;
        System.out.println(a == 1);
    }
}
