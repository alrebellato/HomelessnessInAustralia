package app.helperClasses;

public class twoGrowth{
    private String name;
    private float count;

    public twoGrowth(String n, float c){
        setName(n);
        setCount(c);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCount() {
        return count;
    }

    public void setCount(float count) {
        this.count = count;
    }
}