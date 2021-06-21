package basic;

public class Pervalence {

    private String entity;
    private String code;
    private int year;
    private double schizophrenia;
    private double bipolar;
    private double eating;
    private double anxiety;
    private double drug;
    private double depress;
    private double alcohol;

    public Pervalence(String theEntity, String theCode, int theYear, double theSchizophrenia, double theBipolar, double theEating, double theAnxiety, double theDrug, double theDepress, double theAlcohol) {
        this.entity = theEntity;
        this.code = theCode;
        this.year = theYear;
        this.schizophrenia = theSchizophrenia;
        this.bipolar = theBipolar;
        this.eating = theEating;
        this.anxiety = theAnxiety;
        this.drug = theDrug;
        this.depress = theDepress;
        this.alcohol = theAlcohol;
    }

    public String getEntity() {
        return this.entity;
    }

    public String getCode() {
        return this.code;
    }

    public int getYear() {
        return this.year;
    }

    public double getSchizophrenia() {
        return this.schizophrenia;
    }

    public double getBipolar() {
        return this.bipolar;
    }

    public double getEating() {
        return this.eating;
    }

    public double getAnxiety() {
        return this.anxiety;
    }

    public double getDrug() {
        return this.drug;
    }

    public double getDepress() {
        return this.depress;
    }

    public double getAlcohol() {
        return this.alcohol;
    }
}