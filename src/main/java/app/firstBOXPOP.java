package app;

public class firstBOXPOP {
    private static int currentPop;
    private static int previousPop;

    firstBOXPOP(int c, int p){
        setcurrentPop(c);
        setpreviousPop(p);
    }

    public static int getpreviousPop() {
        return previousPop;
    }

    public void setpreviousPop(int previousPop) {
        firstBOXPOP.previousPop = previousPop;
    }

    public static int getcurrentPop() {
        return currentPop;
    }

    public void setcurrentPop(int currentPop) {
        firstBOXPOP.currentPop = currentPop;
    }
}
