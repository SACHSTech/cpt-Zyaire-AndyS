package basic;

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

    public Parent createContent() {
        final ObservableList<Pervalence> data = FXCollections.observableArrayList(
                new Pervalence("qwq", "code", "1002", 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7));

        TableColumn entityCol = new TableColumn();
        entityCol.setText("Entity");
        entityCol.setCellValueFactory(new PropertyValueFactory("entity"));

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
        tableView.setItems(data);
        tableView.getColumns().addAll(entityCol, codeCol, yearCol, schizophreniaCol, bipolarCol, eatingCol, anxietyCol, drugCol, depressCol, alcoholCol);
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
© 2021 GitHub, Inc.