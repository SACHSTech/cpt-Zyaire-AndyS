package basic;

import java.io.*;
import basic.Pervalence;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Sort_Search{
    private static ObservableList<Pervalence> list;
    
    public static ObservableList <Pervalence> Everything() {
        ObservableList<Pervalence> deathData = FXCollections.observableArrayList();
        int intCount;

        for (intCount = 0; intCount < list.size(); intCount ++) {
            deathData.add(list.get(intCount));
        }
        return deathData;
    }

    public static ObservableList <Pervalence> searchYear(int year) {
        ObservableList<Pervalence> deathData = FXCollections.observableArrayList();

        for (int intCount = 0; intCount < list.size(); intCount ++) {

            if (year == (list.get(intCount).getYear())) {
                deathData.add(list.get(intCount));
            }
        }
        return deathData;
    }
    public static ObservableList <Pervalence> byEntity(String entity) {
        ObservableList<Pervalence> deathData = FXCollections.observableArrayList();

        for (int intCount = 0; intCount < list.size(); intCount ++) {

            if (entity.equalsIgnoreCase(list.get(intCount).getEntity())) {
                deathData.add(list.get(intCount));
            }

        }
        return deathData;
    }
    
    public static Integer avgForSchizophrenia() {
        ObservableList<Pervalence> deathData = FXCollections.observableArrayList();
        double total = 0;
        double avg;

        int avgRounded; 
        for (int intCount = 0; intCount < deathData.size(); intCount ++) {
            total = total + (deathData.get(intCount).getSchizophrenia());
        }

        avg = total / deathData.size();
        avgRounded = (int) Math.round(avg);
        return avgRounded;
    }

}
