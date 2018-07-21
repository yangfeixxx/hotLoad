package cn.chips.hot.HotFactory;

import cn.chips.hot.configuration.HotLoadConfiguration;
import cn.chips.hot.controlCenter.HotLoadControl;

//2018/7/21 cread by yangfei
public class HotFactory {
    private HotLoadConfiguration configuration;

    public HotLoadConfiguration getConfiguration() {
        return configuration;
    }

    public HotLoadControl buildHotLoad(HotLoadConfiguration configuration) {
        this.configuration = configuration;
        return new HotLoadControl(configuration);
    }

    public HotLoadControl buildHotLoad() {
        this.configuration = new HotLoadConfiguration();
        return new HotLoadControl(configuration);
    }
}
