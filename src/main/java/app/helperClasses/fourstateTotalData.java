package app.helperClasses;

public class fourstateTotalData {
    private static int totalStatePop;

    public fourstateTotalData(int t){
        settotalStatePop(t);
    }

    public static int gettotalStatePop() {
        return totalStatePop;
    }

    public void settotalStatePop(int totalStatePop) {
        fourstateTotalData.totalStatePop = totalStatePop;
    }
    
}
