package entities;

public class Company extends TaxPayer{

    private int numberOfEmployees;

    public Company() {
    }

    public Company(String name, Double anualIncome, int numberOfEmployees) {
        super(name, anualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public double tax() {
        double tax = 0.0;
        if(numberOfEmployees > 10){
            tax = getAnualIncome() * 0.14;
        }else{
            tax = getAnualIncome() * 0.16;
        }
        return tax;
    }
}
