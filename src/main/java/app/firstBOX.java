package app;

public class firstBOX {
    private static int atRisk;
    private static int homeless;

    firstBOX(int a, int h){
        setatRisk(a);
        sethomeless(h);
    }

    public static int gethomeless() {
        return homeless;
    }

    public void sethomeless(int homeless) {
        firstBOX.homeless = homeless;
    }

    public static int getatRisk() {
        return atRisk;
    }

    public void setatRisk(int atRisk) {
        firstBOX.atRisk = atRisk;
    }
}
