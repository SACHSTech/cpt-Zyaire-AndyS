package CPT;

/**
* This is an oop getter method, with a contructor and its vars.
* @author: Zyaire Q
*/
public class Pervalence {
    // Instance vars
    private String country;
    private String code;
    private int year;
    private double schizophrenia;
    private double bipolar;
    private double eating;
    private double anxiety;
    private double drug;
    private double depress;
    private double alcohol;

    /**
    * Constructor - creates a new Item instance
    * @param theCountry - the country name
    * @param theCode - the code name
    * @param theYear - the year
    * @param theSchizophrenia - one of the disorders
    * @param theBipolar - one of the disorders
    * @param theEating - one of the disorders
    * @param theAnxiety - one of the disorders
    * @param theDrug - one of the disorders
    * @param theDepress - one of the disorders
    * @param theAlcohol - one of the disorders
    */

    public Pervalence(String theCountry, String theCode, int theYear, double theSchizophrenia, double theBipolar, double theEating, double theAnxiety, double theDrug, double theDepress, double theAlcohol) {
        this.country = theCountry;
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
    /**
    * Get the name that the costomer chose
    * @return the country
    */
    public String getCountry() {
        return this.country;
    }

    /**
    * Get the name that the costomer chose
    * @return the code
    */
    public String getCode() {
        return this.code;
    }

    /**
    * Get the name that the costomer chose
    * @return the year
    */
    public int getYear() {
        return this.year;
    }

    /**
    * Get the name that the costomer chose
    * @return the schizophrenia, one of the disorders
    */
    public double getSchizophrenia() {
        return this.schizophrenia;
    }

    /**
    * Get the name that the costomer chose
    * @return the bipolar, one of the disorders
    */
    public double getBipolar() {
        return this.bipolar;
    }

    /**
    * Get the name that the costomer chose
    * @return the eating, one of the disorders
    */
    public double getEating() {
        return this.eating;
    }

    /**
    * Get the name that the costomer chose
    * @return the anxiety, one of the disorders
    */
    public double getAnxiety() {
        return this.anxiety;
    }

    /**
    * Get the name that the costomer chose
    * @return the drug, one of the disorders
    */
    public double getDrug() {
        return this.drug;
    }

    /**
    * Get the name that the costomer chose
    * @return the depress, one of the disorders
    */
    public double getDepress() {
        return this.depress;
    }

    /**
    * Get the name that the costomer chose
    * @return the alcohol, one of the disorders
    */
    public double getAlcohol() {
        return this.alcohol;
    }

    public String toString(){
        return getCountry() + " " + getYear() + " " + getCode() + " " + getSchizophrenia() + " " + getBipolar() + " " + getEating() + " " + getAnxiety() + " " + getDrug() + " " + getDepress() + " " + getAlcohol();
    }
}