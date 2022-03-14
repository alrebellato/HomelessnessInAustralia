package app.helperClasses;

public class fiveTotalData{
    private String name;
    private float ratio;
    private int total;
    private int population;
    private int age;
    private int mortgage;
    private int rent;
    private int income;

    public fiveTotalData(String n, float r, int c, int p, int a, int m, int rent, int in){
        setName(n);
        setRatio(r);
        setTotal(c);
        setPopulation(p);
        setAge(a);
        setMortgage(m);
        setRent(rent);
        setIncome(in);
    }

    public fiveTotalData(){}

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

    public int getTotal() {
        return total;
    }

    public void setTotal(int count) {
        this.total = count;
    }
}