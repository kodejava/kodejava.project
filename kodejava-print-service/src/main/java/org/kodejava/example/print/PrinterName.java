package org.kodejava.example.print;

import javax.print.PrintService;
import java.awt.print.PrinterJob;

public class PrinterName {
    public static void main(String[] args) {
        // Lookup for the available print services.
        PrintService[] printServices = PrinterJob.lookupPrintServices();

        // Iterates the print services and print out its name.
        for (PrintService printService : printServices) {
            String name = printService.getName();
            System.out.println("Name = " + name);
        }
    }
}
