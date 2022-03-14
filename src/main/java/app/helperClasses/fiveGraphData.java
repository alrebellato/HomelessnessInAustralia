package app.helperClasses;

public class fiveGraphData{
    private String name = "";
    private float ratio = 0f;
    private int total = 0;
    private int population = 0;
    private int age = 0;
    private int mortgage = 0;
    private int rent = 0;
    private int income = 0;

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int getMortgage() {
        return mortgage;
    }

    public void setMortgage(int mortgage) {
        this.mortgage = mortgage;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getRatio() {
        return ratio;
    }

    public void setRatio(float ratio) {
        this.ratio = ratio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int count) {
        this.total = count;
    }


    public String xPrint(){
        if(!this.name.isEmpty()){
            return "" + name.charAt(0);
        }
        if(this.total != 0){
            return "" + total;
        }
        if(this.population != 0){
            return "" + population;
        }
        if(this.age != 0){
            return "" + age;
        }
        if(this.mortgage != 0){
            return "" + mortgage;
        }
        if(this.rent != 0){
            return "" + rent;
        }
        if(this.income != 0){
            return "" + income;
        }

        return null;
    }

    public float yPrint(){
        return this.getRatio();
    }


    public void chartGrabTotal(fiveTotalData datum, String sort) {
        this.setRatio(datum.getRatio());
        switch(sort){
            case "total":
                this.setTotal(datum.getTotal());
            break;
            case "ratio":
                this.setRatio(datum.getRatio());
            break;
            case "income":
                this.setIncome(datum.getIncome());
            break;
            case "rent":
                this.setRent(datum.getRent());
            break;
            case "mortgage":
                this.setMortgage(datum.getMortgage());
            break;
            case "age":
                this.setAge(datum.getAge());
            break;
            case "population":
                this.setPopulation(datum.getPopulation());
            break;
            case "alphabetical":
                this.setName(datum.getName());
            break;
        }
    }

    public void chartGrabGender(fiveGenderData datum, String sort) {
        this.setRatio(datum.getRatio());
        switch(sort){
            case "total":
                this.setTotal(datum.getCount());
            break;
            case "ratio":
                this.setRatio(datum.getRatio());
            break;
            case "income":
                this.setIncome(datum.getIncome());
            break;
            case "rent":
                this.setRent(datum.getRent());
            break;
            case "mortgage":
                this.setMortgage(datum.getMortgage());
            break;
            case "Age":
                this.setAge(datum.getAge());
            break;
            case "population":
                this.setPopulation(datum.getPopulation());
            break;
            case "alphabetical":
                this.setName(datum.getName());
            break;
        }
    }

    public void chartGrabAge(fiveAgeData datum, String sort) {
        this.setRatio(datum.getRatio());
        switch(sort){
            case "total":
                this.setTotal(datum.getCount());
            break;
            case "ratio":
                this.setRatio(datum.getRatio());
            break;
            case "income":
                this.setIncome(datum.getIncome());
            break;
            case "rent":
                this.setRent(datum.getRent());
            break;
            case "mortgage":
                this.setMortgage(datum.getMortgage());
            break;
            case "Age":
                this.setAge(datum.getAge());
            break;
            case "population":
                this.setPopulation(datum.getPopulation());
            break;
            case "alphabetical":
                this.setName(datum.getName());
            break;
        }
    }
}