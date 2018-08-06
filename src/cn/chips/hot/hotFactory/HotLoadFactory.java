package cn.chips.hot.hotFactory;

import cn.chips.hot.configuration.HotLoadConfiguration;
import cn.chips.hot.controlCenter.HotLoadControl;

//2018/7/21 cread by yangfei
public class HotLoadFactory {

    public HotLoadControl build(HotLoadConfiguration configuration) {

        return new HotLoadControl(configuration);
    }

    public HotLoadControl build() {

        return new HotLoadControl(new HotLoadConfiguration());
    }


}
