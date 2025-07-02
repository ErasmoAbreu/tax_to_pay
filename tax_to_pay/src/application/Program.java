package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> list = new ArrayList<>();

        System.out.print("Enter the number of tax players: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Tax payer #" + i + " data: ");
            System.out.print("Individual or Company: (i/c)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Anual income: ");
            double anualIncome = sc.nextDouble();
            if(ch == 'i' && anualIncome > 20000.00) {
                System.out.print("Health Expenditures: ");
                double healthExpenditures = sc.nextDouble();
                list.add(new Individual(name, anualIncome, healthExpenditures));
            }else if(ch == 'i') {
                list.add(new Individual(name, anualIncome));
            }else if(ch == 'c') {
                System.out.print("Number of employees: ");
                int numberOfEmployees = sc.nextInt();
                list.add(new Company(name, anualIncome, numberOfEmployees));
            }
        }

        System.out.println();
        System.out.println("TAXES PAID:");
        for (TaxPayer t : list) {
            System.out.println(t.getName()+ ": $ " + String.format("%.2f", t.tax()));
        }

        System.out.println();

        double sum = 0.0;
        for (TaxPayer t : list) {
           sum += t.tax();
        }
        System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));
        sc.close();
    }
}
