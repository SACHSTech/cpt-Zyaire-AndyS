
package CPT;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.NumberAxis;
import javafx.stage.Stage;
import javafx.scene.chart.CategoryAxis;

public class lineChart {

    public static Parent createLine(String country, Stage primaryStage) {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        LineChart<String, Double> chart = new LineChart(xAxis, yAxis);
        ObservableList<Pervalence> pData = Sort_Search.byEntity(country);
        Pervalence pervalence; 
        
        chart.setTitle(country);
        xAxis.setLabel("Year");
        yAxis.setLabel("The number of death");

        XYChart.Series <String, Double> line = new XYChart.Series <String, Double>();
        line.setName(country);

        for (int intCount = 0; intCount < pData.size(); intCount ++) {
            pervalence = pData.get(intCount);
            line.getData().add(new XYChart.Data <String, Double>(Integer.toString(pervalence.getYear()), (pervalence.getSchizophrenia() + pervalence.getBipolar() + pervalence.getEating() + pervalence.getAnxiety() + pervalence.getDrug() + pervalence.getDepress() + pervalence.getAlcohol())));
        }
        chart.getData().add(line);

        return chart;
    }
}