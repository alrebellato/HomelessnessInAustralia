package app.helperClasses;

public class fourstateGenderData {
    private static int female;
    private static int male;

    public fourstateGenderData( int f, int m){
        setfemale(f);
        setmale(m);
    }

    public static int getmale() {
        return male;
    }

    public void setmale(int male) {
        fourstateGenderData.male = male;
    }

    public static int getfemale() {
        return female;
    }

    public void setfemale(int female) {
        fourstateGenderData.female = female;
    }

}
