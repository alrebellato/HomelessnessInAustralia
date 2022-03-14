package app.helperClasses;

public class AgeData {
    private String name;
    private int total;
    private int zero;
    private int ten;
    private int twen;
    private int thir;
    private int fort;
    private int fift;
    private int sixt;

    public AgeData(String n, int to, int z, int t, int tw, int th, int f, int fi, int si){
        setName(n);
        setTotal(to);
        setZero(z);
        setTen(t);
        setTwen(tw);
        setThir(th);
        setFort(f);
        setFift(fi);
        setSixt(si);
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSixt() {
        return sixt;
    }

    public void setSixt(int sixt) {
        this.sixt = sixt;
    }

    public int getFift() {
        return fift;
    }

    public void setFift(int fift) {
        this.fift = fift;
    }

    public int getFort() {
        return fort;
    }

    public void setFort(int fort) {
        this.fort = fort;
    }

    public int getThir() {
        return thir;
    }

    public void setThir(int thir) {
        this.thir = thir;
    }

    public int getTwen() {
        return twen;
    }

    public void setTwen(int twen) {
        this.twen = twen;
    }

    public int getTen() {
        return ten;
    }

    public void setTen(int ten) {
        this.ten = ten;
    }

    public int getZero() {
        return zero;
    }

    public void setZero(int zero) {
        this.zero = zero;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
