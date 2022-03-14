package app.helperClasses;

public class GenderSortFOUR {
    private String areaName;
    private int popGender;

    public GenderSortFOUR(String a, int p){
        setareaName(a);
        setpopGender(p);
    }

    public int getpopGender() {
        return popGender;
    }

    public void setpopGender(int popGender) {
        this.popGender = popGender;
    }

    public String getareaName() {
        return areaName;
    }

    public void setareaName(String areaName) {
        this.areaName = areaName;
    }
}
