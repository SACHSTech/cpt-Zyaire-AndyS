package CPT;

import java.io.BufferedReader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
/**
 * This is the main class of the application.  
 * It will launch the main window. 
 * @author Q.Zyaire
 */

public class Main {

    

    public static Parent start(Stage primaryStage) {
        
        //TableView<Pervalence> table = new TableView<>();
        
        

        Label label = new Label("Search Result:");
        ChoiceBox cb = new ChoiceBox();
        cb.getItems().addAll("Dog", "Cat", "Horse");
        cb.getSelectionModel().selectFirst();

        //text file to enter year search
        TextField yearS = new TextField("Year");
        yearS.setMaxSize(140, TextField.USE_COMPUTED_SIZE);
        yearS.setOnAction(e -> primaryStage.setScene(new Scene(byYear(Integer.parseInt(yearS.getText()), primaryStage), 350, 450)));

        //button to open the line chart
        Button lineChart = new Button("Create Line Chart");
        lineChart.setDefaultButton(true);
        lineChart.setOnAction((ActionEvent t) -> primaryStage.setScene(new Scene(lineSettings(primaryStage), 300, 250)));
        
        //Table view
        Button viewAll = new Button("View All Data");
        viewAll.setOnAction(e -> primaryStage.setScene(new Scene(createTable(Sort_Search.Everything(), primaryStage), 350, 450)));
        

        //button to open the bar chart
        Button barChart = new Button("Create Bar Chart");
        barChart.setDefaultButton(true);
        barChart.setOnAction((ActionEvent t) -> primaryStage.setScene(new Scene(barSettings(primaryStage), 300, 250)));

        HBox header = new HBox(10);
        header.setAlignment(Pos.TOP_CENTER);
        header.getChildren().addAll(label, yearS, cb);

        HBox bottom = new HBox(150);    
        bottom.setAlignment(Pos.BOTTOM_CENTER);
        bottom.getChildren().addAll(lineChart, barChart);
        
        VBox vbox = new VBox(15);
        vbox.setPadding(new Insets(10, 20, 30, 20));
        vbox.getChildren().addAll(header,viewAll, cb, bottom); 
        
        return vbox;
    } 
   
    
    public static Parent byYear(int year, Stage primaryStage) {
        ObservableList<Pervalence> data = Sort_Search.searchYear(year);
        Parent table = createTable(data, primaryStage);

        return table;
    }

    public static Parent barSettings(Stage primaryStage) {
        VBox layout = new VBox();
        ArrayList<Pervalence> list = Sort_Search.getList();
        String country;
        Pervalence pervItem;
        TextField c1 = new TextField("Enter Country 1");
        c1.setMaxSize(140, TextField.USE_COMPUTED_SIZE);

        TextField c2 = new TextField("Enter Country 2");
        c2.setMaxSize(140, TextField.USE_COMPUTED_SIZE);

        TextField c3 = new TextField("Enter Country 3");
        c3.setMaxSize(140, TextField.USE_COMPUTED_SIZE);

        TextField year = new TextField("Year 1990 - 2017");
        year.setMaxSize(140, TextField.USE_COMPUTED_SIZE);

        TextField disorder = new TextField("Disorder");
        disorder.setMaxSize(140, TextField.USE_COMPUTED_SIZE);

        Button create = new Button("Create!");
        Label settingLabel = new Label("BarChart Settings");

        for (int i = 0; i < list.size(); i++) {
            pervItem = list.get(i);
            country = pervItem.getCountry();
        }
        

        create.setOnAction(e -> primaryStage.setScene(new Scene(BarChartApp.createContent(disorder.getText(), c1.getText(),
                c2.getText(), c3.getText(), Integer.parseInt(year.getText()), primaryStage))));

        Button back = new Button("Back to Menu");
        back.setOnAction(e -> primaryStage.setScene(new Scene(start(primaryStage), 300, 250)));

        layout.getChildren().addAll(settingLabel, c1, c2, c3, year, disorder, create, back);
        layout.setAlignment(Pos.CENTER);

        return layout;
    }

    public static Parent lineSettings(Stage primaryStage) {
        VBox layout = new VBox();
        ArrayList<Pervalence> list = Sort_Search.getList();
        String country;
        Pervalence pervItem;
        TextField c1 = new TextField("Enter Country");
        c1.setMaxSize(140, TextField.USE_COMPUTED_SIZE);

        Button create = new Button("Create!");
        Label settingLabel = new Label("BarChart Settings");

        for (int i = 0; i < list.size(); i++) {
            pervItem = list.get(i);
            country = pervItem.getCountry();
        }
        

        create.setOnAction(e -> primaryStage.setScene(new Scene(lineChart.createLine(c1.getText(), primaryStage))));

        Button back = new Button("Back to Menu");
        back.setOnAction(e -> primaryStage.setScene(new Scene(start(primaryStage), 300, 250)));

        layout.getChildren().addAll(settingLabel, c1, create, back);
        layout.setAlignment(Pos.CENTER);

        return layout;
    }
    public static Parent createTable(ObservableList<Pervalence> data, Stage primaryStage) {

        TableColumn <String, String> country = new TableColumn <String, String>();
        country.setText("Country");
        country.setCellValueFactory(new PropertyValueFactory <String, String> ("country"));

        TableColumn <String, String> year = new TableColumn <String, String>();
        year.setText("Year");
        year.setCellValueFactory(new PropertyValueFactory <String, String> ("year"));

        TableColumn <String, String> code = new TableColumn <String, String>();
        code.setText("Code");
        code.setCellValueFactory(new PropertyValueFactory <String, String> ("code"));

        TableColumn <String, String> schizophrenia = new TableColumn <String, String>();
        schizophrenia.setText("Schizophrenia");
        schizophrenia.setCellValueFactory(new PropertyValueFactory <String, String> ("schizophrenia"));

        TableColumn <String, String> bipolar = new TableColumn <String, String>();
        bipolar.setText("Bipolar");
        bipolar.setCellValueFactory(new PropertyValueFactory <String, String> ("bipolar"));
        
        TableColumn <String, String> eating = new TableColumn <String, String>();
        eating.setText("eating disorder");
        eating.setCellValueFactory(new PropertyValueFactory <String, String> ("eating"));

        TableColumn <String, String> anxiety = new TableColumn <String, String>();
        anxiety.setText("Anxiety");
        anxiety.setCellValueFactory(new PropertyValueFactory <String, String> ("anxiety"));

        TableColumn <String, String> drug = new TableColumn <String, String>();
        drug.setText("Drug Addiction");
        drug.setCellValueFactory(new PropertyValueFactory <String, String> ("drug"));

        TableColumn <String, String> depress = new TableColumn <String, String>();
        depress.setText("Depression");
        depress.setCellValueFactory(new PropertyValueFactory <String, String> ("depression"));

        TableColumn <String, String> alcohol = new TableColumn <String, String>();
        alcohol.setText("Alcohol Addiction");
        alcohol.setCellValueFactory(new PropertyValueFactory <String, String> ("alcohol"));


        final TableView tableView = new TableView();
        tableView.setItems(data);
        tableView.getColumns().addAll(country, year, code, schizophrenia, bipolar, eating, anxiety, drug, depress, alcohol);

        Button back = new Button("Back to Menu");
        back.setOnAction(e -> primaryStage.setScene(new Scene(start(primaryStage), 1290, 400)));

        VBox layout = new VBox();
        layout.getChildren().addAll(tableView, back);

        return layout;
    }
}