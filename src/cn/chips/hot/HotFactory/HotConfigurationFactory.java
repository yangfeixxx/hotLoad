package cn.chips.hot.HotFactory;

import cn.chips.hot.configuration.HotLoadConfiguration;
//2018/7/21 cread by yangfei
public class HotConfigurationFactory {
    private HotLoadConfiguration hotLoadConfiguration;

    public HotLoadConfiguration buildHotLoadConfiguration() {
        this.hotLoadConfiguration = new HotLoadConfiguration();
        return hotLoadConfiguration;
    }

}
