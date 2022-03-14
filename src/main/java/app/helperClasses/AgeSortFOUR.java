package app.helperClasses;

public class AgeSortFOUR {
    private String areaNameAS;
    private int popAS;

    public AgeSortFOUR(String a, int p){
        setareaNameAS(a);
        setpopAS(p);
    }

    public int getpopAS() {
        return popAS;
    }

    public void setpopAS(int popAS) {
        this.popAS = popAS;
    }

    public String getareaNameAS() {
        return areaNameAS;
    }

    public void setareaNameAS(String areaNameAS) {
        this.areaNameAS = areaNameAS;
    }
}
