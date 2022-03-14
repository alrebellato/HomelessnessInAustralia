package app.helperClasses;

public class fiveGenderData{
    private String name;
    private float ratio;
    private int count;
    private float male_ratio;
    private int male;
    private float female_ratio;
    private int female;
    private int population;
    private int age;
    private int mortgage;
    private int rent;
    private int income;

    public fiveGenderData(String n, float r, int c, float m_ratio, int male, float f_ratio, int female,  int p, int a, int m, int rent, int in){
        setName(n);
        setRatio(r);
        setCount(c);
        setMale_ratio(m_ratio);
        setMale(male);
        setFemale_ratio(f_ratio);
        setFemale(female);
        setPopulation(p);
        setAge(a);
        setMortgage(m);
        setRent(rent);
        setIncome(in);
    }

    public float getFemale_ratio() {
        return female_ratio;
    }

    public void setFemale_ratio(float female_ratio) {
        this.female_ratio = female_ratio;
    }

    public float getMale_ratio() {
        return male_ratio;
    }

    public void setMale_ratio(float male_ratio) {
        this.male_ratio = male_ratio;
    }

    public int getFemale() {
        return female;
    }

    public void setFemale(int female) {
        this.female = female;
    }

    public int getMale() {
        return male;
    }

    public void setMale(int male) {
        this.male = male;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int getMortgage() {
        return mortgage;
    }

    public void setMortgage(int mortgage) {
        this.mortgage = mortgage;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getRatio() {
        return ratio;
    }

    public void setRatio(float ratio) {
        this.ratio = ratio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}