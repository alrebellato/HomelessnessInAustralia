package app.helperClasses;

public class fourlgaGenderData {
    private static int female;
    private static int male;

    public fourlgaGenderData( int f, int m){
        setfemale(f);
        setmale(m);
    }

    public static int getfemale() {
        return female;
    }

    public void setfemale(int female) {
        fourlgaGenderData.female = female;
    }

    public static int getmale() {
        return male;
    }

    public void setmale(int male) {
        fourlgaGenderData.male = male;
    }
}
