package io.quickchart.core;

import java.util.List;

import io.quickchart.QuickChart;
import io.quickchart.vo.ChartConfig;
import io.quickchart.vo.ChartData;
import io.quickchart.vo.Dataset;
import junit.framework.TestCase;

public class QuickChartTest extends TestCase {
	public void testUrl() {
		QuickChart chart = new QuickChart();
		chart.setWidth(500);
		chart.setHeight(300);
		chart.setConfig("{"
				+ "    type: 'bar',"
				+ "    data: {"
				+ "        labels: ['Q1', 'Q2', 'Q3', 'Q4'],"
				+ "        datasets: [{"
				+ "            label: 'Users',"
				+ "            data: [50, 60, 70, 180]"
				+ "        }]"
				+ "    }"
				+ "}"
		);

		String url = chart.getUrl();
		assertTrue(url.indexOf("https://quickchart.io/chart") == 0);
		assertTrue(url.indexOf("w=500&h=300") > -1);
		assertTrue(url.indexOf("50%2C+60%2C+") > -1);
		assertTrue(url.indexOf("key=") < 0);
		assertTrue(url.indexOf("bkg=") < 0);
	}

	public void testUrlWithBackgroundColor() {
		QuickChart chart = new QuickChart();
		chart.setBackgroundColor("pink");
		chart.setWidth(500);
		chart.setHeight(300);
		chart.setConfig("{"
				+ "    type: 'bar',"
				+ "    data: {"
				+ "        labels: ['Q1', 'Q2', 'Q3', 'Q4'],"
				+ "        datasets: [{"
				+ "            label: 'Users',"
				+ "            data: [50, 60, 70, 180]"
				+ "        }]"
				+ "    }"
				+ "}"
		);

		String url = chart.getUrl();
		assertTrue(url.indexOf("https://quickchart.io/chart") == 0);
		assertTrue(url.indexOf("w=500&h=300") > -1);
		assertTrue(url.indexOf("50%2C+60%2C+") > -1);
		assertTrue(url.indexOf("key=abc123") < 0);
		assertTrue(url.indexOf("bkg=pink") > -1);
	}

	public void testUrlWithKey() {
		QuickChart chart = new QuickChart();
		chart.setKey("abc123");
		chart.setWidth(500);
		chart.setHeight(300);
		chart.setConfig("{"
				+ "    type: 'bar',"
				+ "    data: {"
				+ "        labels: ['Q1', 'Q2', 'Q3', 'Q4'],"
				+ "        datasets: [{"
				+ "            label: 'Users',"
				+ "            data: [50, 60, 70, 180]"
				+ "        }]"
				+ "    }"
				+ "}"
		);

		String url = chart.getUrl();
		assertTrue(url.indexOf("https://quickchart.io/chart") == 0);
		assertTrue(url.indexOf("w=500&h=300") > -1);
		assertTrue(url.indexOf("50%2C+60%2C+") > -1);
		assertTrue(url.indexOf("key=abc123") > -1);
		assertTrue(url.indexOf("bkg=") < 0);
	}

	public void testUrlWithVersion() {
		QuickChart chart = new QuickChart();
		chart.setVersion("2.9.4");
		chart.setWidth(500);
		chart.setHeight(300);
		chart.setConfig("{"
				+ "    type: 'bar',"
				+ "    data: {"
				+ "        labels: ['Q1', 'Q2', 'Q3', 'Q4'],"
				+ "        datasets: [{"
				+ "            label: 'Users',"
				+ "            data: [50, 60, 70, 180]"
				+ "        }]"
				+ "    }"
				+ "}"
		);

		String url = chart.getUrl();
		assertTrue(url.indexOf("https://quickchart.io/chart") == 0);
		assertTrue(url.indexOf("w=500&h=300") > -1);
		assertTrue(url.indexOf("50%2C+60%2C+") > -1);
		assertTrue(url.indexOf("v=2.9.4") > -1);
		assertTrue(url.indexOf("bkg=") < 0);
	}

	public void testgetUrlV2(){
		QuickChart chart = new QuickChart();
		chart.setVersion("2.9.4");
		chart.setWidth(500);
		chart.setHeight(300);
		ChartConfig config = new ChartConfig();
		config.setType("bar");
		ChartData data = new ChartData();
		data.setLabels(List.of("Q1", "Q2", "Q3", "Q4"));
		Dataset dataset = new Dataset();
		dataset.setLabel("Users");
		dataset.setData(List.of("50", "60", "70", "180"));
		Dataset dataset2 = new Dataset();
		dataset2.setLabel("Revenue");
		dataset2.setData(List.of("100", "200", "300", "400"));
		data.setDatasets(List.of(dataset, dataset2));
		config.setData(data);
		chart.setChartConfig(config);
		String url = chart.getUrlV2();
		System.out.println(url);
		assertTrue(url.indexOf("https://quickchart.io/chart") == 0);
	}
}
