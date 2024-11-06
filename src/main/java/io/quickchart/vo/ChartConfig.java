package io.quickchart.vo;


public class ChartConfig {
    private String type;
    private ChartData data;
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public ChartData getData() {
        return data;
    }
    public void setData(ChartData data) {
        this.data = data;
    }
}
