package cn.chips.hot.HotFactory;

import cn.chips.hot.configuration.HotLoadConfiguration;
import cn.chips.hot.hotInterface.HotFactory;

//2018/7/21 cread by yangfei
public class HotConfigurationFactory implements HotFactory<HotLoadConfiguration> {

    @Override
    public HotLoadConfiguration build() {
        return new HotLoadConfiguration();
    }
}
