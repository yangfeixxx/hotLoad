package cn.chips.hot.configuration;

//2018/7/21 cread by yangfei
public class HotLoadConfiguration extends HotConfiguration {
    private long interval = DEFAULTINTERVAL;
    private String location = DEFAULTLOCATION;

    private static final long DEFAULTINTERVAL = 1L;
    private static final String DEFAULTLOCATION = System.getProperty("user.dir") + "/target";

    public Long getInterval() {
        return interval;
    }

    public void setInterval(Long interval) {
        this.interval = interval;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
