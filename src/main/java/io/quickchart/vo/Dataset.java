package io.quickchart.vo;

import java.util.List;

public class Dataset {
    private String label;
    private List<String> data;
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public List<String> getData() {
        return data;
    }
    public void setData(List<String> data) {
        this.data = data;
    }
}
