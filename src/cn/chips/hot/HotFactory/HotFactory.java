package cn.chips.hot.HotFactory;

import cn.chips.hot.configuration.HotLoadConfiguration;
import cn.chips.hot.controlCenter.HotLoadControl;

//2018/7/21 cread by yangfei
public class HotFactory {
    public HotLoadControl buildHotLoad(HotLoadConfiguration configuration) {
        return new HotLoadControl(configuration);
    }

    public HotLoadControl buildHotLoad() {
        return new HotLoadControl(new HotLoadConfiguration());
    }
}
