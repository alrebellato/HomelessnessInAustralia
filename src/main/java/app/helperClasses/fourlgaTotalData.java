package app.helperClasses;

public class fourlgaTotalData {
    private static int totallgaPop;

    public fourlgaTotalData(int t){
        settotallgaPop(t);
    }

    public static int gettotallgaPop() {
        return totallgaPop;
    }

    public void settotallgaPop(int totallgaPop) {
        fourlgaTotalData.totallgaPop = totallgaPop;
    }
}
