package app.helperClasses;

public class Pair{
    private String name;
    private int count;

    public Pair(String n, int c){
        setName(n);
        setCount(c);
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