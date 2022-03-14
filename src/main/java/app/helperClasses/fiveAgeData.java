package app.helperClasses;

public class fiveAgeData{
    private String name;
    private float ratio;
    private int count;
    private int population;
    private int age;
    private int mortgage;
    private int rent;
    private int income;
    private float zero;
    private float ten;
    private float twen;
    private float thir;
    private float fort;
    private float fift;
    private float sixt;
    
    public fiveAgeData(String n, float r, int c, int p, int a, int m, int rent, int in, float zero, float ten, float twen, float thir, float fort, float fift, float sixt){
        setName(n);
        setRatio(r);
        setCount(c);
        setPopulation(p);
        setAge(a);
        setMortgage(m);
        setRent(rent);
        setIncome(in);
        setZero(zero);
        setTen(ten);
        setTwen(twen);
        setThir(thir);
        setFort(fort);
        setFift(fift);
        setSixt(sixt);
    }


    public void setThir(float thir) {
        this.thir = thir;
    }


    public void setSixt(float sixt) {
        this.sixt = sixt;
    }


    public void setFift(float fift) {
        this.fift = fift;
    }


    public void setFort(float fort) {
        this.fort = fort;
    }


    public void setTwen(float twen) {
        this.twen = twen;
    }


    public void setTen(float ten) {
        this.ten = ten;
    }


    public void setZero(float zero) {
        this.zero = zero;
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

    public float getTotal() {
        return count;
    }

    public float getZero() {
        return zero;
    }

    public float getTen() {
        return ten;
    }

    public float getTwen() {
        return twen;
    }

    public float getThir() {
        return thir;
    }

    public float getFort() {
        return fort;
    }

    public float getFift() {
        return fift;
    }

    public float getSixt() {
        return sixt;
    }
}