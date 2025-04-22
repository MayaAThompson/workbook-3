package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) {

        FileReader reader;
        try {
            reader = new FileReader("/c:/Users/ru551/pluralsight/workbook-3/Mod01/PayrollCalculator/DataFiles/employees.csv");
            String input;
            BufferedReader bufReader = new BufferedReader(reader);

            Employee[] employees = new Employee[8];
            int lineIndex = 0;
            while ((input = bufReader.readLine()) != null) {
                String[] lineData = input.split("\\|");
                if (lineData[0].equals("id")) {
                    continue;
                }

                int id= Integer.parseInt(lineData[0]);
                String name = lineData[1];
                double hours = Double.parseDouble(lineData[2]);
                double rate = Double.parseDouble(lineData[3]);
                employees[lineIndex] = new Employee(id, name, hours, rate);
                System.out.printf("ID: %d \nName: %s \nGross Pay: $%.2f\n\n", employees[lineIndex].getEmployeeId(), employees[lineIndex].getName(), employees[lineIndex].calculateGrossPay());
                lineIndex++;
            }
        } catch (Exception e) {
            System.err.println("There was a problem: " + e.getMessage());
        }



    }
}
