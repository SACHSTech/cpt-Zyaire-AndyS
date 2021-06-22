package basic;


import java.io.*;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * A simple table with a header row.
 *
 * @sampleName TableView
 * @preview preview.png
 * @docUrl http://www.oracle.com/pls/topic/lookup?ctx=javase80&id=JFXUI336 Using JavaFX UI Controls
 * @see javafx.scene.control.TableColumn
 * @see javafx.scene.control.TablePosition
 * @see javafx.scene.control.TableRow
 * @see javafx.scene.control.TableView
 * @see javafx.scene.control.cell.PropertyValueFactory
 * @embedded
 *
 * @related /Controls/TableCellFactory
 * @related /Controls/TreeTableView
 */
public class TableViewApp extends Application {

    public Parent createContent() throws IOException{


        ArrayList<Pervalence> pervalenceName = new ArrayList<Pervalence>();
        BufferedReader br = new BufferedReader(new FileReader("src/basic/PervalenceByDisorders.csv"));
        br.readLine();
        String data;
        data = br.readLine();
        while(data != null){
            var split = data.split(",");
            pervalenceName.add(new Pervalence(split[0], split[1], Integer.parseInt(split[2]), Double.parseDouble(split[3]), Double.parseDouble(split[4]), Double.parseDouble(split[5]), Double.parseDouble(split[6]), Double.parseDouble(split[7]), Double.parseDouble(split[8]), Double.parseDouble(split[9])));
            data = br.readLine();
        }
        br.close();
        Sort_Search.
        final ObservableList<Pervalence> aryList = FXCollections.observableArrayList(pervalenceName);
        Sort_Search.setList(pervalenceName);

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
        schizophreniaCol.setMinWidth(200);
        schizophreniaCol.setCellValueFactory(new PropertyValueFactory("schizophrenia"));

        TableColumn bipolarCol = new TableColumn();
        bipolarCol.setText("Bipolar Disorders");
        bipolarCol.setMinWidth(200);
        bipolarCol.setCellValueFactory(new PropertyValueFactory("bipolar"));
        
        TableColumn eatingCol = new TableColumn();
        eatingCol.setText("Eating Disorders");
        eatingCol.setMinWidth(200);
        eatingCol.setCellValueFactory(new PropertyValueFactory("eating"));
        
        TableColumn anxietyCol = new TableColumn();
        anxietyCol.setText("Anxiety Disorders");
        anxietyCol.setMinWidth(200);
        anxietyCol.setCellValueFactory(new PropertyValueFactory("anxiety"));
        
        TableColumn drugCol = new TableColumn();
        drugCol.setText("Drug use Disorders");
        drugCol.setMinWidth(200);
        drugCol.setCellValueFactory(new PropertyValueFactory("drug"));
        
        TableColumn depressCol = new TableColumn();
        depressCol.setText("Depressive disorders");
        depressCol.setMinWidth(200);
        depressCol.setCellValueFactory(new PropertyValueFactory("depress"));
        
        TableColumn alcoholCol = new TableColumn();
        alcoholCol.setText("Alcohol use Disorders");
        alcoholCol.setMinWidth(200);
        alcoholCol.setCellValueFactory(new PropertyValueFactory("alcohol"));
        
        final TableView tableView = new TableView();
        tableView.setItems(aryList);
        tableView.getColumns().addAll(countryCol, codeCol, yearCol, schizophreniaCol, bipolarCol, eatingCol, anxietyCol, drugCol, depressCol, alcoholCol);
        return tableView;
    }


    @Override public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }

    /**
     * Java main for when running without JavaFX launcher
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}