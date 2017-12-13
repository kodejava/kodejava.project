package org.kodejava.example.math;

public class GetMinMaxValueExample {
    public static void main(String[] args) {

        Double value1 = 100.0D;
        Double value2 = 200.0D;

        double max1 = Math.max(value1, value2);
        double min1 = Math.min(value1, value2);

        float max2 = Math.max(value1.floatValue(), value2.floatValue());
        float min2 = Math.min(value1.floatValue(), value2.floatValue());

        int max3 = Math.max(value1.intValue(), value2.intValue());
        int min3 = Math.min(value1.intValue(), value2.intValue());

        long max4 = Math.max(value1.longValue(), value2.longValue());
        long min4 = Math.min(value1.longValue(), value2.longValue());

        System.out.println("Max value in double: " + max1);
        System.out.println("Min value in double: " + min1);
        System.out.println("Max value in float : " + max2);
        System.out.println("Min value in float : " + min2);
        System.out.println("Max value in int   : " + max3);
        System.out.println("Min value in int   : " + min3);
        System.out.println("Max value in long  : " + max4);
        System.out.println("Min value in long  : " + min4);
    }
}
