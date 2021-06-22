package CPT;

import java.io.BufferedReader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    //private TableView<Pervalence> dataTable = new TableView<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Pervalence Caused by Disorders in Different Countries");

        Label label = new Label("Search Result:");
        ChoiceBox cb = new ChoiceBox();
        cb.getItems().addAll("Dog", "Cat", "Horse");
        cb.getSelectionModel().selectFirst();

        //button to open the line chart
        Button chartBtn = new Button();
        chartBtn.setText("Chart");
        chartBtn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Yoyo");
            }
        });

        //button to open the other chart
        Button otherChart = new Button();
        otherChart.setText("Another Chart");
        otherChart.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("bar chart ??");
            }
        });

        //button to do the merge sort
        Button mergeBtn = new Button();
        mergeBtn.setText("Merge Sort");
        mergeBtn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("merge merge");
            }
        });

        readFile();
        
        TableColumn countryCol = new TableColumn();
        countryCol.setText("Country");
        countryCol.setCellValueFactory(new PropertyValueFactory("country"));

        TableColumn codeCol = new TableColumn();
        codeCol.setText("Code");
        codeCol.setCellValueFactory(new PropertyValueFactory("code"));

        TableColumn yearCol = new TableColumn();
        yearCol.setText("Year");
        yearCol.setCellValueFactory(new PropertyValueFactory("year"));

        TableColumn schizophreniaCol = new TableColumn();
        schizophreniaCol.setText("Schizonphrenia");
        schizophreniaCol.setMinWidth(150);
        schizophreniaCol.setCellValueFactory(new PropertyValueFactory("schizophrenia"));

        TableColumn bipolarCol = new TableColumn();
        bipolarCol.setText("Bipolar Disorders");
        bipolarCol.setMinWidth(150);
        bipolarCol.setCellValueFactory(new PropertyValueFactory("bipolar"));
        
        TableColumn eatingCol = new TableColumn();
        eatingCol.setText("Eating Disorders");
        eatingCol.setMinWidth(150);
        eatingCol.setCellValueFactory(new PropertyValueFactory("eating"));
        
        TableColumn anxietyCol = new TableColumn();
        anxietyCol.setText("Anxiety Disorders");
        anxietyCol.setMinWidth(150);
        anxietyCol.setCellValueFactory(new PropertyValueFactory("anxiety"));
        
        TableColumn drugCol = new TableColumn();
        drugCol.setText("Drug use Disorders");
        drugCol.setMinWidth(150);
        drugCol.setCellValueFactory(new PropertyValueFactory("drug"));
        
        TableColumn depressCol = new TableColumn();
        depressCol.setText("Depressive disorders");
        depressCol.setMinWidth(150);
        depressCol.setCellValueFactory(new PropertyValueFactory("depress"));
        
        TableColumn alcoholCol = new TableColumn();
        alcoholCol.setText("Alcohol use Disorders");
        alcoholCol.setMinWidth(150);
        alcoholCol.setCellValueFactory(new PropertyValueFactory("alcohol"));
        
        table.setItems(pervList);
        table.getColumns().addAll(countryCol, codeCol, yearCol, schizophreniaCol, bipolarCol, eatingCol, anxietyCol, drugCol, depressCol, alcoholCol);

        HBox header = new HBox(10);
        header.setAlignment(Pos.TOP_CENTER);
        header.getChildren().addAll(label, textField, cb);

        HBox bottom = new HBox(150);
        bottom.setAlignment(Pos.BOTTOM_CENTER);
        bottom.getChildren().addAll(chartBtn, mergeBtn, otherChart);
        
        VBox vbox = new VBox(15);
        vbox.setPadding(new Insets(10, 20, 30, 20));
        vbox.getChildren().addAll(header, table, bottom);

        primaryStage.setScene(new Scene(vbox, 1290, 600));
        primaryStage.show();     
    }
    
    /**
     * Loads data from the csv file.
     * It also calculates the total points per position.
     * @throws FIOException
     */
    private void readFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/CPT/PervalenceByDisorders.csv"));
        br.readLine();
        String data;
        data = br.readLine();
        while (data != null) {
            var split = data.split(",");
            pervList.add(new Pervalence(split[0], split[1], Integer.parseInt(split[2]), Double.parseDouble(split[3]), Double.parseDouble(split[4]), Double.parseDouble(split[5]), Double.parseDouble(split[6]), Double.parseDouble(split[7]), Double.parseDouble(split[8]), Double.parseDouble(split[9])));
            data = br.readLine();
        }
        br.close();
    }

}