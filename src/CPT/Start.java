package CPT;

import java.io.*;

import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.HashMap;
import javafx.stage.Stage;


public class Start extends Application {

    public static void main(String[] args) throws IOException {
        ArrayList<Pervalence> pervalenceName = new ArrayList<Pervalence>();
        BufferedReader br = new BufferedReader(new FileReader("src/CPT/PervalenceByDisorders.csv"));
        br.readLine();
        String data;
        data = br.readLine();
        while(data != null){
            var split = data.split(",");
            pervalenceName.add(new Pervalence(split[0], split[1], Integer.parseInt(split[2]), Double.parseDouble(split[3]), Double.parseDouble(split[4]), Double.parseDouble(split[5]), Double.parseDouble(split[6]), Double.parseDouble(split[7]), Double.parseDouble(split[8]), Double.parseDouble(split[9])));
            data = br.readLine();
        }
        Sort_Search.setList(pervalenceName);
        br.close();
        // final ObservableList<Pervalence> aryObserve = FXCollections.observableArrayList(pervalenceName);
        launch(args);
    }

    // Start app
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(Main.start(primaryStage), 1290, 600));
        primaryStage.setTitle("Pervalence Caused by Disorders in Different Countries");
        primaryStage.show();
    }
}
