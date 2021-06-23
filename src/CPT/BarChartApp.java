/* ....Show License.... */
package CPT;
 
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.stage.Stage;
import javafx.scene.chart.XYChart;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.chart.LineChart;

 
/**
 * A bar graph that displays the number of death in three countries for a speicifc mental disorder
 * It allows the user to input the disorder, three different coutries and the year. 
 * The x-axis are the countries, they will be in different colours
 * The y-axis is the number of death caused by that mental disorder in that year
 * @author: A. Shan
 */
public class BarChartApp{
 
    public static Parent createContent(String disorder, String p1, String p2, String p3, int year, Stage primaryStage) { 
        Pervalence data1 = Sort_Search.byEntityAndYear(p1, year);
        Pervalence data2 = Sort_Search.byEntityAndYear(p2, year); 
        Pervalence data3 = Sort_Search.byEntityAndYear(p3, year); 
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("The number of death");
        ObservableList<String> countries = FXCollections.<String>observableArrayList();
        countries.add(p1);
        countries.add(p2);
        countries.add(p3);
        xAxis.setCategories(countries);
        BarChart <CategoryAxis, NumberAxis> chart = new BarChart(xAxis, yAxis);

        XYChart.Series d1 = new XYChart.Series<>();
        d1.setName(data1.getCountry());
        XYChart.Series d2 = new XYChart.Series<>();
        d2.setName(data2.getCountry());
        XYChart.Series d3 = new XYChart.Series<>();
        d3.setName(data3.getCountry());

        if (disorder.equalsIgnoreCase("schizophrenia")){
            d1.getData().add(new XYChart.Data(p1,data1.getSchizophrenia()));
            d2.getData().add(new XYChart.Data(p2,data2.getSchizophrenia()));
            d3.getData().add(new XYChart.Data(p3,data3.getSchizophrenia()));

        } else if(disorder.equalsIgnoreCase("Bipolar")){
            d1.getData().add(new XYChart.Data(p1,data1.getBipolar()));
            d2.getData().add(new XYChart.Data(p2,data2.getBipolar()));
            d3.getData().add(new XYChart.Data(p3,data3.getBipolar()));
        } else if(disorder.equalsIgnoreCase("Eating")){
            d1.getData().add(new XYChart.Data(p1,data1.getEating()));
            d2.getData().add(new XYChart.Data(p2,data2.getEating()));
            d3.getData().add(new XYChart.Data(p3,data3.getEating()));
        } else if(disorder.equalsIgnoreCase("Anxiety")){
            d1.getData().add(new XYChart.Data(p1,data1.getAnxiety()));
            d2.getData().add(new XYChart.Data(p2,data2.getAnxiety()));
            d3.getData().add(new XYChart.Data(p3,data3.getAnxiety()));
        } else if(disorder.equalsIgnoreCase("Drug")){
            d1.getData().add(new XYChart.Data(p1,data1.getDrug()));
            d2.getData().add(new XYChart.Data(p2,data2.getDrug()));
            d3.getData().add(new XYChart.Data(p3,data3.getDrug()));
        } else if(disorder.equalsIgnoreCase("Depression")){
            d1.getData().add(new XYChart.Data(p1, data1.getDepress()));
            d2.getData().add(new XYChart.Data(p2, data2.getDepress()));
            d3.getData().add(new XYChart.Data(p3, data3.getDepress()));
        } else if(disorder.equalsIgnoreCase("Alcohol")){
            d1.getData().add(new XYChart.Data(p1,data1.getAlcohol()));
            d2.getData().add(new XYChart.Data(p2,data2.getAlcohol()));
            d3.getData().add(new XYChart.Data(p3,data3.getAlcohol()));
        } else{
            d1.getData().add(null);
            d2.getData().add(null);           
            d3.getData().add(null);
        }
        chart.getData().add(d1);
        chart.getData().add(d2);
        chart.getData().add(d3);
        return chart;
    }
}