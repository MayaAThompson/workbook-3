package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {

    public static void main(String[] args) {

        String fromFile = Utils.messageAndResponse("What file would you like to process? ");
        String toFile = Utils.messageAndResponse("What would you like to call the output file? ");

        FileReader reader;
        FileWriter writer;
        try {
            String input;

            reader = new FileReader("/c:/Users/ru551/pluralsight/workbook-3/Mod01/PayrollCalculator/DataFiles/" + fromFile);
            writer = new FileWriter("/c:/Users/ru551/pluralsight/workbook-3/Mod01/PayrollCalculator/DataFiles/" + toFile);

            BufferedReader bufReader = new BufferedReader(reader);
            BufferedWriter bufWriter = new BufferedWriter(writer);

            Employee[] employees = new Employee[8];
            int lineIndex = 0;
            while ((input = bufReader.readLine()) != null) {
                String[] lineData = input.split("\\|");
                if (lineData[0].equals("id")) {
                    bufWriter.write("id|name|gross pay");
                    continue;
                }

                employees[lineIndex] = new Employee(Integer.parseInt(lineData[0]), lineData[1], Double.parseDouble(lineData[2]), Double.parseDouble(lineData[3]));
                bufWriter.write("\n" + employees[lineIndex].getEmployeeId() + "|" + employees[lineIndex].getName() + "|" + employees[lineIndex].calculateGrossPay());
                lineIndex++;
            }
            bufReader.close();
            bufWriter.close();
        }
        catch (Exception e) {
            System.err.println("There was a problem: " + e.getMessage());
        }



    }
}
