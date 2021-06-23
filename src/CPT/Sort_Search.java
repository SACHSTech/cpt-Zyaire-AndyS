package CPT;

import java.io.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class contains all of the methods needed for app to run
 * Also contains sorting and searching methods
 * It can also store data in the arraylist for other calss to use.
 * It can also get the summary informaiton
 * @author: A. Shan
 */
public class Sort_Search{

    private static ArrayList<Pervalence> list;
    private static ArrayList<Pervalence> inputList;
    
    /**
    * Getter method for array list
    * @return an array list that holds all the data
    */
    public static ArrayList <Pervalence> getList() {
        return list;
    }
    /**
    * Setter method for this private array list. 
    * @param newList an array list of the data set
    * @return void
    */
    public static void setList(ArrayList<Pervalence> newList) {
        list = newList;
    }
    /**
    * Convert the array list into an observableList 
    * @param inputList an array list of the data set
    * @return ObservableList of data set
    */
    public static ObservableList convert(ArrayList inputList) {
        ObservableList deathData = FXCollections.observableArrayList();
        int intCount;

        for (intCount = 0; intCount < list.size(); intCount ++) {
            deathData.add(inputList.get(intCount));
        }

        return deathData;
    }
    /**
    * put everything in the list into the observable list
    * @return Observable list of everything in the data set 
    */
    public static ObservableList <Pervalence> Everything() {
        ObservableList<Pervalence> deathData = FXCollections.observableArrayList();
        int intCount;

        for (intCount = 0; intCount < list.size(); intCount ++) {
            deathData.add(list.get(intCount));
        }
        return deathData;
    }
    /**
    * put everything in the list that has the specific year into the observable list
    * @param year the year of the data set
    * @return Observable list of everything in the data set that has the specific year
    */
    public static ObservableList <Pervalence> searchYear(int year) {
        ObservableList<Pervalence> deathData = FXCollections.observableArrayList();

        for (int intCount = 0; intCount < list.size(); intCount ++) {

            if (year == (list.get(intCount).getYear())) {
                deathData.add(list.get(intCount));
            }
        }
        return deathData;
    }
    /**
    * put everything in the list that is the specific country into the observable list
    * @param country the country of the data set
    * @return Observable list of everything in the data set that has the specific country
    */
    public static ObservableList <Pervalence> byEntity(String country) {
        ObservableList<Pervalence> deathData = FXCollections.observableArrayList();

        for (int intCount = 0; intCount < list.size(); intCount ++) {

            if (country.equalsIgnoreCase(list.get(intCount).getCountry())) {
                deathData.add(list.get(intCount));
            }

        }
        return deathData;
    }
    /**
    * put everything in the list that is the specific country and year into the observable list
    * @param country the country of the data set
    * @param year the year of the data set
    * @return Observable list of everything in the data set that has the specific country and year
    */
    public static Pervalence byEntityAndYear(String country, int year) {
        Pervalence rightPervalence;
        for (int intCount = 0; intCount < list.size(); intCount ++) {

            if (country.equalsIgnoreCase(list.get(intCount).getCountry()) &&  year == (list.get(intCount).getYear())) {
                rightPervalence = list.get(intCount);
                return rightPervalence;
            }
        }
        return null;
    }
    /**
    * put everything in the list that is the specific code into the observable list
    * @param code the code of the data set
    * @return Observable list of everything in the data set that has the specific code
    */
    public static ObservableList <Pervalence> byCode(String code) {
        ObservableList<Pervalence> deathData = FXCollections.observableArrayList();

        for (int intCount = 0; intCount < list.size(); intCount ++) {

            if (code.equalsIgnoreCase(list.get(intCount).getCode())) {
                deathData.add(list.get(intCount));
            }
        }
        return deathData;
    }
    /**
    * calculate the average death caused by Schizophrenia
    * @return the average for death caused by Schizophrenia
    */
    public static Double avgForSchizophrenia() {
        double total = 0;
        double avg;

        for (int intCount = 0; intCount < list.size(); intCount ++) {
            total = total + (list.get(intCount).getSchizophrenia());
        }

        avg = total / list.size();
        return avg;
    }
    /**
    * calculate the average death caused by Bipolar
    * @return the average for death caused by Bipolar
    */
    public static Double avgForBipolar() {
        double total = 0;
        double avg;
        for (int intCount = 0; intCount < list.size(); intCount ++) {
            total = total + (list.get(intCount).getBipolar());
        }

        avg = total / list.size();
        return avg;
    }
    /**
    * calculate the average death caused by eating disorder
    * @return the average for death caused by eating disorder
    */
    public static Double avgForEating() {
        double total = 0;
        double avg;
        for (int intCount = 0; intCount < list.size(); intCount ++) {
            total = total + (list.get(intCount).getEating());
        }

        avg = total / list.size();
        return avg;
    }
    /**
    * calculate the average death caused by anxiety
    * @return the average for death caused by anxiety
    */
    public static Double avgForAnxiety() {
        double total = 0;
        double avg;
        for (int intCount = 0; intCount < list.size(); intCount ++) {
            total = total + (list.get(intCount).getAnxiety());
        }

        avg = total / list.size();
        return avg;
    }
    /**
    * calculate the average death caused by drug addiction
    * @return the average for death caused by drug addiction
    */
    public static Double avgForDrug() {
        double total = 0;
        double avg;
        for (int intCount = 0; intCount < list.size(); intCount ++) {
            total = total + (list.get(intCount).getDrug());
        }

        avg = total / list.size();
        return avg;
    }
    /**
    * calculate the average death caused by depression
    * @return the average for death caused by depression
    */
    public static Double avgForDepress() {
        double total = 0;
        double avg;
        for (int intCount = 0; intCount < list.size(); intCount ++) {
            total = total + (list.get(intCount).getDepress());
        }

        avg = total / list.size();
        return avg;
    }
    /**
    * calculate the average death caused by alcohol addiction
    * @return the average for death caused by alcohol addiction
    */
    public static Double avgForAlcohol() {
        double total = 0;
        double avg;
        for (int intCount = 0; intCount < list.size(); intCount ++) {
            total = total + (list.get(intCount).getAlcohol());
        }

        avg = total / list.size();
        return avg;
    }
    /**
    * count the number of countries
    * @return the number of countries
    */
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
    /**
    * calculate the maximum
    * @return the maximum for drug death
    */
    public static double MaxForDrug() {
        double max = 0;
        for (int count = 0; count < list.size(); count++) {
            if (list.get(count).getDrug() >= max) {
                max = Math.round(list.get(count).getDrug() * 100.0) / 100.0;
            }
        }
        return max;
    }
    /**
    * calculate the minimum for alcohol death
    * @return the minimum for alcohol death
    */
    public static double MinForAlcohol() {
        double min = 0;
        for (int count = 0; count < list.size(); count++) {
            if (list.get(count).getAlcohol() <= min) {
                min = Math.round(list.get(count).getAlcohol() * 100.0) / 100.0;
            }
        }
        return min;
    }
    /**
    * the standard deviation for anxiety death
    * @return the standard deviation for anxiety death
    */
    public static double SDForAnxiety() {
        double avg;
        double squared;
        double sum = 0;
        double meanSum;
        double deviation;

        avg = Sort_Search.avgForAnxiety();
        
        for (int count = 0; count < list.size(); count++) {
            squared = Math.pow((list.get(count).getAnxiety() - avg), 2);
            
            sum = sum + squared;
        }

        meanSum = sum / list.size();

        deviation = Math.round(Math.sqrt(meanSum) * 100.0) / 100.0;

        return deviation;
    }
    public ArrayList getSortedArray() {
        return inputList;
    }
    public static void setMSortArray(ArrayList<Pervalence> input) {
        inputList = input;
    }
    /**
    * merge sort
    * @param input an unsorted array list 
    * @return the sorted data set
    */
    public static ArrayList <Pervalence> mergeSort(ArrayList<Pervalence> input) {
        setMSortArray(input);
        divide(0, inputList.size()-1);

        return inputList;
    }
    private static void divide(int startIndex,int endIndex) {

        if (startIndex < endIndex && (endIndex - startIndex) >= 1) {
            int mid = (endIndex + startIndex) / 2;
            divide(startIndex, mid);
            divide(mid + 1, endIndex);        
            
            TheMerge(startIndex,mid,endIndex);            
        }
    }
        private static void TheMerge(int startIndex,int midIndex,int endIndex) {

            ArrayList <Pervalence> mergedSortedData = new ArrayList<Pervalence>();
            
            int leftIndex = startIndex;
            int rightIndex = midIndex+1;
            
            while (leftIndex <= midIndex && rightIndex <= endIndex) {
                if ((inputList.get(leftIndex).getYear()) <= (inputList.get(rightIndex).getYear())) {
                    mergedSortedData.add(inputList.get(rightIndex));
                    rightIndex++;
    
                } else {
                    mergedSortedData.add(inputList.get(leftIndex));
                    leftIndex++;
    
                }
            }       
            
            while (leftIndex <= midIndex) {
                mergedSortedData.add(inputList.get(leftIndex));
                leftIndex++;
            }
            
            while (rightIndex <= endIndex) {
                mergedSortedData.add(inputList.get(rightIndex));
                rightIndex++;
            }
            
            int i = 0;
            int j = startIndex;
    
            while (i < mergedSortedData.size()) {
                inputList.set(j, mergedSortedData.get(i++));
                j++;
            }
        }
}
