package app.helperClasses;

public class fourstateAgeData {
    private String bracket;
    private int bracketData;

    public fourstateAgeData(String b, int d){
        setBRACKETfourstateAgeData(b);
        setBRACKETDATAfourstateAgeData(d);
    }

    public int getBRACKETDATAfourstateAgeData() {
        return bracketData;
    }

    public void setBRACKETDATAfourstateAgeData(int bracketData) {
        this.bracketData = bracketData;
    }

    public String getBRACKETfourstateAgeData() {
        return bracket;
    }

    public void setBRACKETfourstateAgeData(String bracket) {
        this.bracket = bracket;
    }
}
