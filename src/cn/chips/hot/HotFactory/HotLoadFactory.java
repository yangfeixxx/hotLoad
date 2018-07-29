package cn.chips.hot.HotFactory;

import cn.chips.hot.configuration.HotLoadConfiguration;
import cn.chips.hot.controlCenter.HotLoadControl;
import cn.chips.hot.hotInterface.Control;

//2018/7/21 cread by yangfei
public class HotLoadFactory {

    public HotLoadControl build(HotLoadConfiguration configuration) {

        return new HotLoadControl(configuration);
    }

    public HotLoadControl build() {

        return new HotLoadControl(new HotLoadConfiguration());
    }


}
