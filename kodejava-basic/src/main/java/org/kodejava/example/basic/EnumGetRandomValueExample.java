package org.kodejava.example.basic;

import java.util.Random;

public class EnumGetRandomValueExample {
    public static void main(String[] args) {
        // Pick a random BaseColor for 10 times.
        for (int i = 0; i < 10; i++) {
            System.out.printf("color[%d] = %s%n", i,
                BaseColor.getRandomColor());
        }
    }

    /**
     * BaseColor enum.
     */
    private enum BaseColor {
        Red,
        Green,
        Blue;

        /**
         * Pick a random value of the BaseColor enum.
         * @return a random BaseColor.
         */
        public static BaseColor getRandomColor() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }
    }
}
