package io.quickchart.util;

import com.google.gson.Gson;

import io.quickchart.vo.ChartConfig;

public class ChartUtils {
    
    public static String getJSON(Object obj) {
        return new Gson().toJson(obj);
    }

    public static String getChartConfigJSON(ChartConfig config) {
        return new Gson().toJson(config);
    }
}
