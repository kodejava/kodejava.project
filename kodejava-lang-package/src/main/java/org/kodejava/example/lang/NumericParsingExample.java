package org.kodejava.example.lang;

public class NumericParsingExample {
    public static void main(String[] args) {
        String age = "15";
        String height = "160.5";
        String weight = "55.9";

        try {
            int theAge = Integer.parseInt(age);
            float theHeight = Float.parseFloat(height);
            double theWeight = Double.parseDouble(weight);

            System.out.println("Age    = " + theAge);
            System.out.println("Height = " + theHeight);
            System.out.println("Weight = " + theWeight);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
