package basic;

import java.io.*;
import basic.Pervalence;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Sort_Search{
    private static ObservableList<Pervalence> list;
    
    public static ObservableList <Pervalence> Everything() {
        ObservableList<Pervalence> data = FXCollections.observableArrayList();
        int intCount;

        for (intCount = 0; intCount < list.size(); intCount ++) {
            data.add(list.get(intCount));
        }
        return data;
    }

    public static ObservableList <Pervalence> SearchYear(int year) {
        ObservableList<Pervalence> data = FXCollections.observableArrayList();

        for (int intCount = 0; intCount < list.size(); intCount ++) {

            if (year == (list.get(intCount).getYear())) {
                data.add(list.get(intCount));
            }
        }
        return data;
    }
    
}
