package CPT;
import java.io.*;
import java.util.ArrayList;
import java.util.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.util.HashMap;

public class Print extends Application{
    public static void main(String[] args) throws IOException{
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
      br.close();
      Sort_Search.setList(pervalenceName);
      
      launch(args);


    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(lineChart.createLine("China", primaryStage), 300, 250));
        primaryStage.setTitle("Death From Mental Illness");
        primaryStage.show();
    }
}