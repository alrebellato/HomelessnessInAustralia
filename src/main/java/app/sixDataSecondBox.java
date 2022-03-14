package app;

public class sixDataSecondBox {
    static int citpCount;
    static int citp;
    static int cih;
    static int ciar;
    static int rh;

    public sixDataSecondBox(int citpC, int cit, int ch, int cia, int r){
        setcitpCount(citpC);
        setciar(cit);
        setcitp(ch);
        setciar(cia);
        setrh(r);
    }
// 
// count
    public static int getcitpCount() {
        return citpCount;
    }

    public void setcitpCount(int citpCount) {
        sixDataSecondBox.citpCount = citpCount;
    }
// citp
    public static int getcitp() {
        return citp;
    }

    public void setcitp(int citp) {
        sixDataSecondBox.citp = citp;
    }
// cih
    public static int getcih() {
        return cih;
    }

    public void setcih(int cih) {
        sixDataSecondBox.cih = cih;
    }
// ciar
    public static int getciar() {
        return ciar;
    }

    public void setciar(int ciar) {
        sixDataSecondBox.ciar = ciar;
    }
// rh
    public static int getrh() {
        return rh;
    }

    public void setrh(int rh) {
        sixDataSecondBox.rh = rh;
    }
}
