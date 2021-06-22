package basic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 
 * This is the main class of the application. 
 * It will launch the main window. 
 * @author Alyanna Santos
 * 
 */
public class Main extends Application {

    private ObservableList<Pervalence> pervList = FXCollections.observableArrayList();
    private TextField textField = new TextField();
    private TableView<Pervalence> table = new TableView<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Pervalence Caused by Disorders in Different Countries");

        Label label = new Label("Search Result:");

        //button to open window to the pie chart
        Button chartBtn = new Button();
        chartBtn.setText("Chart");
        chartBtn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Yoyo");
            }
        });

        //button to close window
        Button closeBtn = new Button();
        closeBtn.setText("Close");
        closeBtn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });
        
        TableColumn<Pervalence, String> countryCol = new TableColumn<>("Country");
        countryCol.setCellValueFactory(new PropertyValueFactory<>("country"));

        TableColumn<Pervalence, String> codeCol = new TableColumn<>("Code");
        codeCol.setCellValueFactory(new PropertyValueFactory<>("code"));

        TableColumn<Pervalence, Integer> yearCol = new TableColumn<>("Year");
        yearCol.setCellValueFactory(new PropertyValueFactory<>("year"));

        TableColumn<Pervalence, Double> schizonphreniaCol = new TableColumn<>("Schizonphrenia");
        schizonphreniaCol.setMinWidth(150);
        schizonphreniaCol.setCellValueFactory(new PropertyValueFactory<>("schizonphrenia"));

        TableColumn<Pervalence, Double> bipolarCol = new TableColumn<>("Bipolar");
        bipolarCol.setMinWidth(150);
        bipolarCol.setCellValueFactory(new PropertyValueFactory<>("bipolar"));

        TableColumn<Pervalence, Double> eatingCol = new TableColumn<>("Eating");
        eatingCol.setMinWidth(150);
        eatingCol.setCellValueFactory(new PropertyValueFactory<>("eating"));

        TableColumn<Pervalence, Double> anxietyCol = new TableColumn<>("Anxiety");
        anxietyCol.setMinWidth(150);
        anxietyCol.setCellValueFactory(new PropertyValueFactory<>("anxiety"));

        TableColumn<Pervalence, Double> drugCol = new TableColumn<>("Drug");
        drugCol.setMinWidth(150);
        drugCol.setCellValueFactory(new PropertyValueFactory<>("drug"));

        TableColumn<Pervalence, Double> depressCol = new TableColumn<>("Depress");
        depressCol.setMinWidth(150);
        depressCol.setCellValueFactory(new PropertyValueFactory<>("depress"));

        TableColumn<Pervalence, Double> alcoholCol = new TableColumn<>("Alcohol");
        alcoholCol.setMinWidth(150);
        alcoholCol.setCellValueFactory(new PropertyValueFactory<>("alcohol"));


        loadData();

        table.getColumns().addAll(countryCol, 
                                    codeCol,
                                    yearCol,
                                    schizonphreniaCol, 
                                    bipolarCol, 
                                    eatingCol, 
                                    anxietyCol,
                                    drugCol,
                                    depressCol,
                                    alcoholCol);


        HBox header = new HBox();
        header.setAlignment(Pos.TOP_LEFT);
        header.setSpacing(10);
        header.getChildren().addAll(label, textField);

        HBox bottom = new HBox(150);
        bottom.setAlignment(Pos.BOTTOM_CENTER);
        bottom.getChildren().addAll(chartBtn, closeBtn);
        
        VBox vbox = new VBox(15);
        vbox.setPadding(new Insets(10, 20, 30, 20));
        vbox.getChildren().addAll(header, table, bottom);

        primaryStage.setScene(new Scene(vbox, 1320, 600));
        primaryStage.show();     
    }
    
    /**
     * Loads data from the csv file.
     * It also calculates the total points per position.
     * @throws FIOException
     */
    private void loadData() throws IOException {

        //ArrayList<Pervalence> pervalenceName = new ArrayList<Pervalence>();
        BufferedReader br = new BufferedReader(new FileReader("src/basic/PervalenceByDisorders.csv"));
        br.readLine();
        String data;
        data = br.readLine();
        while(data != null){
            var split = data.split(",");
            pervList.add(new Pervalence(split[0], split[1], Integer.parseInt(split[2]), Double.parseDouble(split[3]), Double.parseDouble(split[4]), Double.parseDouble(split[5]), Double.parseDouble(split[6]), Double.parseDouble(split[7]), Double.parseDouble(split[8]), Double.parseDouble(split[9])));
            data = br.readLine();
        }
        br.close();
        
    }


    /**
     * Adds a listener to filter the data while entering value in the text box. 
     */

}