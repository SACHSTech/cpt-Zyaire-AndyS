package CPT;

import java.io.*;
import javafx.scene.Scene;
import javafx.application.Application;
import java.util.ArrayList;
import javafx.stage.Stage;

/**
 * This is the start of the whole cpt 
 * Basic UI and read file
 * @author Q.Zyaire
 */
public class Start extends Application {

    public static void main(String[] args) throws IOException {
        // set a list
        ArrayList<Pervalence> pervalenceName = new ArrayList<Pervalence>();
        // file.io
        BufferedReader br = new BufferedReader(new FileReader("src/CPT/PervalenceByDisorders.csv"));
        // ignore first line
        br.readLine();
        String data;
        data = br.readLine();
        // strts to add elements intolist
        while(data != null){
            var split = data.split(",");
            pervalenceName.add(new Pervalence(split[0], split[1], Integer.parseInt(split[2]), Double.parseDouble(split[3]), Double.parseDouble(split[4]), Double.parseDouble(split[5]), Double.parseDouble(split[6]), Double.parseDouble(split[7]), Double.parseDouble(split[8]), Double.parseDouble(split[9])));
            data = br.readLine();
        }
        Sort_Search.setList(pervalenceName);
        // close file
        br.close();
        launch(args);
    }

    // Start app
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(Main.start(primaryStage), 500, 330));
        primaryStage.setTitle("Pervalence Caused by Disorders in Different Countries");
        primaryStage.show();
    }
}
