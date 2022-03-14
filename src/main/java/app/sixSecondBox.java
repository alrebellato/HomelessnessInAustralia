package app;

public class sixSecondBox {
    // private  String areaNameSecond;

    private  Double citpCount;
    private  Double citp;
    private  Double cih;
    private  Double ciar;
    private  Double rh;

    public sixSecondBox(/*String ans,*/ Double citpC, Double cit, Double ch, Double cia, Double r){
        // setareaNameSecond(ans);
        setcitpCount(citpC);
        setcitp(cit);
        setcih(ch);
        setciar(cia);
        setrh(r);
    }

    // public String getareaNameSecond() {
    //     return areaNameSecond;
    // }

    // public void setareaNameSecond(String areaNameSecond) {
    //     this.areaNameSecond = areaNameSecond;
    // }

    // 
    // count
    public Double getcitpCount() {
        return citpCount;
    }

    public void setcitpCount(Double citpCount) {
        this.citpCount = citpCount;
    }
    // citp
    public Double getcitp() {
        return citp;
    }

    public void setcitp(Double citp) {
        this.citp = citp;
    }
    // cih
    public Double getcih() {
        return cih;
    }

    public void setcih(Double cih) {
        this.cih = cih;
    }
    // ciar
    public Double getciar() {
        return ciar;
    }

    public void setciar(Double ciar) {
        this.ciar = ciar;
    }
    // rh
    public Double getrh() {
        return rh;
    }

    public void setrh(Double rh) {
        this.rh = rh;
    }
}
