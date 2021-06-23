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
        
        // Button of year sort
        Button sortBtn = new Button("Sort by Year");;
        //sortBtn.setOnAction(e -> primaryStage.setScene(new Scene()));

        // button to open the Summary
        Button summaryInfo = new Button("Key information");
        summaryInfo .setOnAction(e -> primaryStage.setScene(new Scene(summary(primaryStage), 450, 250)));

        // Table view
        Button viewAll = new Button("View All Data");
        viewAll.setOnAction(e -> primaryStage.setScene(new Scene(createTable(Sort_Search.Everything(), primaryStage), 1200, 500)));
        

        // button to open the bar chart
        Button barChart = new Button("Create Bar Chart");
        barChart.setDefaultButton(true);
        barChart.setOnAction(e -> primaryStage.setScene(new Scene(barSettings(primaryStage), 500, 330)));

        // search by year
        HBox high1 = new HBox(10);
        high1.setAlignment(Pos.CENTER);
        high1.getChildren().addAll(yearLabel, yearS);

        // search by country
        HBox high2= new HBox(10);
        high2.setAlignment(Pos.CENTER);
        high2.getChildren().addAll(countryLabel, countryS);

        // sort by year
        HBox high3 = new HBox(10);
        high3.setAlignment(Pos.CENTER);
        high3.getChildren().addAll(sortBtn);

        // search individual
        HBox high4 = new HBox(10);
        high4.setAlignment(Pos.CENTER);
        high4.getChildren().addAll(indiLabel, indiS);

        // view the summary
        HBox high5 = new HBox(10);
        high5.setAlignment(Pos.CENTER);
        high5.getChildren().addAll(summaryInfo);

        // charts and view all
        HBox bottom = new HBox(10);    
        bottom.setAlignment(Pos.BOTTOM_CENTER);
        bottom.getChildren().addAll(lineChart, viewAll, barChart);
        
        VBox vbox = new VBox(15);
        vbox.setPadding(new Insets(10, 20, 30, 20));
        vbox.getChildren().addAll(high1, high2, high5, high4, high3, bottom); 
        
        return vbox;
    } 
   
    /**
     * Year search
     * input a sepcific year
     * Displays all the data in that year
     * You can go back to the menu
     * @param year
     * @param primaryStage
     * @return table
     */
    public static Parent yearSch(int year, Stage primaryStage) {
        ObservableList<Pervalence> data = Sort_Search.searchYear(year);
        Parent table = createTable(data, primaryStage);

        return table;
    }

    /**
     * country search
     * input a sepcific coubtry
     * Displays all the data in that country
     * You can go back to the menu
     * @param country
     * @param primaryStage
     * @return table
     */
    public static Parent countrySch(String country, Stage primaryStage) {
        ObservableList<Pervalence> data = Sort_Search.byEntity(country);
        Parent table = createTable(data, primaryStage);
        return table;
    }

    /**
     * set the bar UI
     * input 3 countries, one year and a disorder
     * Display a bar chart that could compare the pervalent of 3 country in that year
     * You can go back to the menu or the setting UI
     * @param primaryStage
     * @return layout
     */
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

    /**
     * set the Line chart UI
     * input 1 country, generate the total death of disorder in every year
     * Display a line chart
     * You can go back to the menu or the setting UI
     * @param primaryStage
     * @return layout
     */
    public static Parent lineSettings(Stage primaryStage) {
        VBox layout = new VBox(10);
        ArrayList<Pervalence> list = Sort_Search.getList();
        String country;
        Pervalence pervItem;
        TextField c1 = new TextField("Enter Country");
        c1.setMaxSize(140, TextField.USE_COMPUTED_SIZE);

        Button create = new Button("Create!");
        Label settingLabel = new Label("Linechart Settings");

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

    /**
     * Table view thing
     * gives you all the datas
     * You can go back to the menu
     * @param data
     * @param primaryStage
     * @return layout
     */
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

    /**
     * search individually
     * input country and year, gives you individual data
     * You can go back to the menu
     * @param input
     * @param primaryStage
     * @return layout
     */
    public static Parent searchEntry(String input, Stage primaryStage) {
        String[] spli = input.split(" ");
        Pervalence pervalence = Sort_Search.byEntityAndYear(spli[0], Integer.parseInt(spli[1]));
        Label entry = new Label(pervalence.toString());

        Button back = new Button("Back");
        back.setOnAction(e -> primaryStage.setScene(new Scene(start(primaryStage), 1200, 500)));

        VBox layout = new VBox();
        layout.getChildren().addAll(entry, back);
        layout.setAlignment(Pos.TOP_CENTER);

        return layout;
    }

    /**
     * press the button gives you all the average
     * Gives you total countries
     * You can go back to the menu
     * @param primaryStage
     * @return layout
     */
    public static Parent summary(Stage primaryStage) {
        Label avgSch = new Label("Average death caused by Schizophrenia: "+ Sort_Search.avgForSchizophrenia());
        Label avgBi = new Label("Average death caused by Bipolar: "+ Sort_Search.avgForBipolar());
        Label avgEat = new Label("Average death caused by Eating Disorder: "+ Sort_Search.avgForEating());
        Label avgAnx = new Label("Average death caused by Anxiety: "+ Sort_Search.avgForAnxiety());
        Label avgDru = new Label("Average death caused by Drug Addiction: "+ Sort_Search.avgForDrug());
        Label avgDep = new Label("Average death caused by Depression: "+ Sort_Search.avgForDepress());
        Label avgAlc = new Label("Average death caused by Alcohol Addiction: "+ Sort_Search.avgForAlcohol());
        Label countries = new Label("Countries: " + Sort_Search.count());
        Label minForAlc = new Label("The minimum for alcohol addiction is : " + Sort_Search.MinForAlcohol());
        Label maxForDrug = new Label("The maximum for drug addiction is : " + Sort_Search.MaxForDrug());
        Label anxSD = new Label("The standard deviation for anxiety is : " + Sort_Search.SDForAnxiety());

        Button back = new Button("Back");
        back.setOnAction(e -> primaryStage.setScene(new Scene(start(primaryStage), 500, 330)));

        HBox line = new HBox(10);
        line.getChildren().addAll(minForAlc, maxForDrug, anxSD);
        VBox layout = new VBox();
        layout.getChildren().addAll(avgSch, avgBi, avgEat, avgAnx, avgDru, avgDep, avgAlc, countries, back);

        return layout;
    }
}