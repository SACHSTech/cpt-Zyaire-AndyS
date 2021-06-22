/* ....Show License.... */
package basic;
 
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.Year;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
/**
 * A chart that displays rectangular bars with heights indicating data values
 * for categories. Used for displaying information when at least one axis has
 * discontinuous or discrete data.
 */
public class BarChartApp extends Application {
 
    private BarChart chart;
    private CategoryAxis xAxis;
    private NumberAxis yAxis;
 
    public Parent BarChartSettings(Stage primaryStage) {
      VBox layout = new VBox();
      ArrayList<Pervalence> list = Sort_Search.getList();
      String country;
        String prevC = "";
        Pervalence pervalence;
        ChoiceBox<Pervalence> c1 = new ChoiceBox <Pervalence>();
        c1.setMaxSize(140, ChoiceBox.USE_COMPUTED_SIZE);

        ChoiceBox<Pervalence> c2 = new ChoiceBox <Pervalence>();
        c2.setMaxSize(140, ChoiceBox.USE_COMPUTED_SIZE);

        ChoiceBox<Pervalence> c3 = new ChoiceBox <Pervalence>();
        c3.setMaxSize(140, ChoiceBox.USE_COMPUTED_SIZE);

        TextField startY = new TextField("What year?");
        startY.setMaxSize(140, TextField.USE_COMPUTED_SIZE);

        TextField endY = new TextField("Which disorder?");
        endY.setMaxSize(140, TextField.USE_COMPUTED_SIZE);

        Button create = new Button("Create!");
        Label settingLabel = new Label("BarChart Settings");

        for (int intCount = 0; intCount < list.size(); intCount++) {
          pervalence = list.get(intCount);
          country = pervalence.getCountry();

            if (!country.equals(prevC)) {
                c1.getItems().add(pervalence);
                c2.getItems().add(pervalence);
                c3.getItems().add(pervalence);
            }

            prevC = country;
        }

        create.setOnAction(e -> primaryStage.setScene(new Scene(createBarChart(startY.getText(), Year.getText(),
                c1.getValue(), c2.getValue(), c3.getValue(), primaryStage))));

        Button back = new Button("Back to Menu");
        back.setOnAction(e -> primaryStage.setScene(new Scene(mainMenu(primaryStage), 300, 250)));

        layout.getChildren().addAll(settingLabel, c1, c2, c3, startY, endY, create, back);
        layout.setAlignment(Pos.CENTER);

        return layout;
    }
    }
    public Parent createBarChart(String country, int year,  Pervalence pervalence1, Pervalence pervalence2, Pervalence pervalence3, Stage primaryStage) {
        String[] years = {"2007", "2008", "2009"};
        xAxis = new CategoryAxis();
        xAxis.setCategories(FXCollections.<String>observableArrayList(years));
        yAxis = new NumberAxis("Units Sold", 0.0d, 3000.0d, 1000.0d);
        ObservableList<BarChart.Series> barChartData =
            FXCollections.observableArrayList(
              new BarChart.Series("Apples", FXCollections.observableArrayList(
                new BarChart.Data(years[0], 567d),
                new BarChart.Data(years[1], 1292d),
                new BarChart.Data(years[2], 1292d))),
              new BarChart.Series("Lemons", FXCollections.observableArrayList(
                new BarChart.Data(years[0], 956),
                new BarChart.Data(years[1], 1665),
                new BarChart.Data(years[2], 2559))),
              new BarChart.Series("Oranges", FXCollections.observableArrayList(
                new BarChart.Data(years[0], 1154),
                new BarChart.Data(years[1], 1927),
                new BarChart.Data(years[2], 2774)))
            );
        chart = new BarChart(xAxis, yAxis, barChartData, 25.0d);
        return chart;
    }
 
    @Override public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createBarChart()));
        primaryStage.show();
    }
 
    /**
     * Java main for when running without JavaFX launcher
     */
    public static void main(String[] args) {
        launch(args);
    }
}