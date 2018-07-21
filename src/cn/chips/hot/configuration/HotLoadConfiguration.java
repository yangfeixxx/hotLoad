package cn.chips.hot.configuration;
//2018/7/21 cread by yangfei
public class HotLoadConfiguration {
    private Long interval;
    private String location;

    public HotLoadConfiguration() {
    }

    public HotLoadConfiguration(Long interval, String location) {
        this.interval = interval;
        this.location = location;
    }

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
