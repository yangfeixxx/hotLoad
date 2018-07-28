package cn.chips.hot.HotFactory;

import cn.chips.hot.hotInterface.HotFactory;
import cn.chips.hot.controlCenter.HotLoadControl;

//2018/7/21 cread by yangfei
public class HotLoadFactory implements HotFactory<HotLoadControl> {

    @Override
    public HotLoadControl build() {
        return new HotLoadControl();
    }
}
