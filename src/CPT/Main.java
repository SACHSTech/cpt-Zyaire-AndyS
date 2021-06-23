package CPT;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * This is the main class of the application.  
 * Basic UI 
 * @author Q.Zyaire
 */

public class Main {

    public static Parent start(Stage primaryStage) {
        
        //lable for year search
        Label yearLabel = new Label("Search for years: ");
        //text file to enter year search
        TextField yearS = new TextField("Year");
        yearS.setMaxSize(140, TextField.USE_COMPUTED_SIZE);
        yearS.setOnAction(e -> primaryStage.setScene(new Scene(yearSch(Integer.parseInt(yearS.getText()), primaryStage), 1200, 500)));

        //lable for year search
        Label indiLabel = new Label("Individual Search: ");
        //text file to enter year search
        TextField indiS = new TextField("Country Year");
        indiS.setMaxSize(140, TextField.USE_COMPUTED_SIZE);
        indiS.setOnAction(
                e -> primaryStage.setScene(new Scene(searchEntry(indiS.getText(), primaryStage), 350, 450)));


        // lable for country search
        Label countryLabel = new Label("Search for country: ");
        // text file to enter year search
        TextField countryS = new TextField("Country");
        countryS.setMaxSize(140, TextField.USE_COMPUTED_SIZE);
        countryS.setOnAction(e -> primaryStage.setScene(new Scene(countrySch(countryS.getText(), primaryStage), 1200, 500)));

        // button to open the line chart
        Button lineChart = new Button("Create Line Chart");
        lineChart.setDefaultButton(true);
        lineChart.setOnAction(e -> primaryStage.setScene(new Scene(lineSettings(primaryStage), 500, 330)));
        
        
        Button sortBtn = new Button("Sort by Year");
        /*
        sortBtn.setOnAction(e -> primaryStage.setScene(new Scene(createTable(Sort_Search.convert(Sort_Search.mergeSort(Sort_Search.searchYearInArrayList(Integer.parseInt((yearS).getText())))), primaryStage),350, 450)));
        */

        // Table view
        Button viewAll = new Button("View All Data");
        viewAll.setOnAction(e -> primaryStage.setScene(new Scene(createTable(Sort_Search.Everything(), primaryStage), 1200, 500)));
        

        // button to open the bar chart
        Button barChart = new Button("Create Bar Chart");
        barChart.setDefaultButton(true);
        barChart.setOnAction(e -> primaryStage.setScene(new Scene(barSettings(primaryStage), 500, 330)));

        // 
        HBox high1 = new HBox(10);
        high1.setAlignment(Pos.CENTER);
        high1.getChildren().addAll(yearLabel, yearS);

        HBox high2= new HBox(10);
        high2.setAlignment(Pos.CENTER);
        high2.getChildren().addAll(countryLabel, countryS);

        HBox high3 = new HBox(10);
        high3.setAlignment(Pos.CENTER);
        high3.getChildren().addAll(sortBtn);

        HBox high4 = new HBox(10);
        high4.setAlignment(Pos.CENTER);
        high4.getChildren().addAll(indiLabel, indiS);

        HBox bottom = new HBox(10);    
        bottom.setAlignment(Pos.BOTTOM_CENTER);
        bottom.getChildren().addAll(lineChart, viewAll, barChart);
        
        VBox vbox = new VBox(15);
        vbox.setPadding(new Insets(10, 20, 30, 20));
        vbox.getChildren().addAll(high1, high2, high3, high4, bottom); 
        
        return vbox;
    } 
   
    
    public static Parent yearSch(int year, Stage primaryStage) {
        ObservableList<Pervalence> data = Sort_Search.searchYear(year);
        Parent table = createTable(data, primaryStage);

        return table;
    }

    public static Parent countrySch(String country, Stage primaryStage) {
        ObservableList<Pervalence> data = Sort_Search.byEntity(country);
        Parent table = createTable(data, primaryStage);
        return table;
    }

    public static Parent barSettings(Stage primaryStage) {
        VBox layout = new VBox(10);
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
        back.setOnAction(e -> primaryStage.setScene(new Scene(start(primaryStage), 500, 330)));

        layout.getChildren().addAll(settingLabel, c1, c2, c3, year, disorder, create, back);
        layout.setAlignment(Pos.CENTER);

        return layout;
    }

    public static Parent lineSettings(Stage primaryStage) {
        VBox layout = new VBox(10);
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
        back.setOnAction(e -> primaryStage.setScene(new Scene(start(primaryStage), 500, 330)));

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
        depress.setCellValueFactory(new PropertyValueFactory <String, String> ("depress"));

        TableColumn <String, String> alcohol = new TableColumn <String, String>();
        alcohol.setText("Alcohol Addiction");
        alcohol.setCellValueFactory(new PropertyValueFactory <String, String> ("alcohol"));


        final TableView tableView = new TableView();
        tableView.setItems(data);
        tableView.getColumns().addAll(country, year, code, schizophrenia, bipolar, eating, anxiety, drug, depress, alcohol);

        Button back = new Button("Back to Menu");
        back.setOnAction(e -> primaryStage.setScene(new Scene(start(primaryStage), 500, 330)));

        VBox layout = new VBox();
        layout.getChildren().addAll(tableView, back);

        return layout;
    }
    public static Parent searchEntry(String input, Stage primaryStage) {
        String[] spli = input.split(" ");
        Pervalence pervalence = Sort_Search.byEntityAndYear(spli[0], Integer.parseInt(spli[1]));
        Label entry = new Label(pervalence.toString());

        Button back = new Button("Back");
        back.setOnAction(e -> primaryStage.setScene(new Scene(start(primaryStage), 300, 250)));

        VBox layout = new VBox();
        layout.getChildren().addAll(entry, back);
        layout.setAlignment(Pos.TOP_CENTER);

        return layout;
    }
}