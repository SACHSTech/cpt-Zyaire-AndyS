package basic;

import java.io.*;

import basic.Pervalence;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.HashMap;

public class Sort_Search{

    private static ArrayList<Pervalence> list;
    
    public static ArrayList <Pervalence> getList() {
        return list;
    }
    public static void setList(ArrayList<Pervalence> newList) {
        list = newList;
    }
    public static ObservableList convert(ArrayList list) {
        ObservableList deathData = FXCollections.observableArrayList();
        int intCount;

        for (intCount = 0; intCount < list.size(); intCount ++) {
            deathData.add(list.get(intCount));
        }

        return deathData;
    }
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

    public static ObservableList <Pervalence> byEntity(String country) {
        ObservableList<Pervalence> deathData = FXCollections.observableArrayList();

        for (int intCount = 0; intCount < list.size(); intCount ++) {

            if (country.equalsIgnoreCase(list.get(intCount).getCountry())) {
                deathData.add(list.get(intCount));
            }

        }
        return deathData;
    }
    public static ObservableList <Pervalence> byCode(String code) {
        ObservableList<Pervalence> deathData = FXCollections.observableArrayList();

        for (int intCount = 0; intCount < list.size(); intCount ++) {

            if (code.equalsIgnoreCase(list.get(intCount).getCode())) {
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

    public static Integer avgForBipolar() {
        ObservableList<Pervalence> deathData = FXCollections.observableArrayList();
        double total = 0;
        double avg;
        int avgRounded; 
        for (int intCount = 0; intCount < deathData.size(); intCount ++) {
            total = total + (deathData.get(intCount).getBipolar());
        }

        avg = total / deathData.size();
        avgRounded = (int) Math.round(avg);
        return avgRounded;
    }

    public static Integer avgForEating() {
        ObservableList<Pervalence> deathData = FXCollections.observableArrayList();
        double total = 0;
        double avg;
        int avgRounded; 
        for (int intCount = 0; intCount < deathData.size(); intCount ++) {
            total = total + (deathData.get(intCount).getEating());
        }

        avg = total / deathData.size();
        avgRounded = (int) Math.round(avg);
        return avgRounded;
    }

    public static Integer avgForAnxiety() {
        ObservableList<Pervalence> deathData = FXCollections.observableArrayList();
        double total = 0;
        double avg;
        int avgRounded; 
        for (int intCount = 0; intCount < deathData.size(); intCount ++) {
            total = total + (deathData.get(intCount).getAnxiety());
        }

        avg = total / deathData.size();
        avgRounded = (int) Math.round(avg);
        return avgRounded;
    }

    public static Integer avgForDrug() {
        ObservableList<Pervalence> deathData = FXCollections.observableArrayList();
        double total = 0;
        double avg;
        int avgRounded; 
        for (int intCount = 0; intCount < deathData.size(); intCount ++) {
            total = total + (deathData.get(intCount).getDrug());
        }

        avg = total / deathData.size();
        avgRounded = (int) Math.round(avg);
        return avgRounded;
    }

    public static Integer avgForDepress() {
        ObservableList<Pervalence> deathData = FXCollections.observableArrayList();
        double total = 0;
        double avg;
        int avgRounded; 
        for (int intCount = 0; intCount < deathData.size(); intCount ++) {
            total = total + (deathData.get(intCount).getDepress());
        }

        avg = total / deathData.size();
        avgRounded = (int) Math.round(avg);
        return avgRounded;
    }
    public static Integer avgForAlcohol() {
        ObservableList<Pervalence> deathData = FXCollections.observableArrayList();
        double total = 0;
        double avg;
        int avgRounded; 
        for (int intCount = 0; intCount < deathData.size(); intCount ++) {
            total = total + (deathData.get(intCount).getAlcohol());
        }

        avg = total / deathData.size();
        avgRounded = (int) Math.round(avg);
        return avgRounded;
    }
    public static Integer count() {
        int count = 0; 
        HashMap <String, Integer> countryHash = new HashMap<>();
        for (Pervalence item: list) {
            if (!countryHash.containsKey(item.getCountry())) {
                countryHash.put(item.getCountry(), 1);
                count++;
            }
        }
        return count;
    }

}
