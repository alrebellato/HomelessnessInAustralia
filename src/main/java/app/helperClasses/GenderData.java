package app.helperClasses;

public class GenderData{
    private String name;
    private int female;
    private int male;
    private int total;

    public GenderData(String n, int total, int m, int f){
        setName(n);
        setTotal(total);
        setFemale(f);
        setMale(m);
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}