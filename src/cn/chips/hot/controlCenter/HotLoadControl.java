package cn.chips.hot.controlCenter;


import cn.chips.hot.configuration.HotLoadConfiguration;
import cn.chips.hot.handler.ScanHandler;
import cn.chips.hot.utils.StringUtils;

//2018/7/21 cread by yangfei
public class HotLoadControl {
    private HotLoadConfiguration hotLoadConfiguration;
    private static final Long DEFAULINTERVAL = 1L;
    private static final String DEFAULTLOCATION = System.getProperty("user.dir") + "/target";

    public HotLoadControl() {
    }

    public HotLoadControl(HotLoadConfiguration hotLoadConfiguration) {
        this.hotLoadConfiguration = hotLoadConfiguration;
    }

    public void start() {
        check(hotLoadConfiguration);
        new ScanHandler(this.hotLoadConfiguration).startScan();
    }

    private void check(HotLoadConfiguration hotLoadConfiguration) {


        if (hotLoadConfiguration.getInterval() == null || hotLoadConfiguration.getInterval() <= 0) {
            hotLoadConfiguration.setInterval(DEFAULINTERVAL);
        }
        if (!StringUtils.isNotEmpty(hotLoadConfiguration.getLocation())) {
            hotLoadConfiguration.setLocation(DEFAULTLOCATION);
        }

    }


}
