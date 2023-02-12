package aleks.spring.MeteorologyRestClient;

import aleks.spring.MeteorologyRestClient.DTO.DataDTO;
import aleks.spring.MeteorologyRestClient.DTO.DataResponse;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Chart {
    public static void main(String[] args) {

        List<Double> y = getTemperatureFromServer();

        List<Integer> x = new ArrayList<>();
        for (int i = 0; i < y.size(); i++) {
            x.add(i);
        }

        // Create Chart
        XYChart chart = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", x, y);

        // Show it
        new SwingWrapper(chart).displayChart();

    }

    public static List<Double> getTemperatureFromServer () {
        String url1 = "http://localhost:8080/measurements";
        final RestTemplate restTemplate = new RestTemplate();

        DataResponse data = restTemplate.getForObject(url1, DataResponse.class);

        if(data == null || data.getResponse() == null) {
            return Collections.emptyList();
        }

        return data.getResponse().stream().map(DataDTO::getValue).collect(Collectors.toList());
    }

}
