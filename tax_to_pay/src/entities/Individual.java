package entities;

public class Individual extends TaxPayer{

    private Double healthExpenditures;

    public Individual(){
    }

    public Individual(String name, Double anualIncome, Double healthExpenditures) {
        super(name, anualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    public Individual(String name, Double anualIncome) {
        super(name, anualIncome);
    }

    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public double tax() {
        double taxHealthPositive = 0.0;
        if (getAnualIncome() < 20000.00) {
            return getAnualIncome() * 0.15;
        }else if(getHealthExpenditures() > 0 && getAnualIncome() >= 20000.00){
            taxHealthPositive = getAnualIncome() * 0.25 - getHealthExpenditures() * 0.5;
            if (taxHealthPositive < 0){
                return 0.0;
            }
            return taxHealthPositive;
        }else if(getAnualIncome() >= 20000.00) {
            return getAnualIncome() * 0.25;
        }
        return 0;
    }
}
