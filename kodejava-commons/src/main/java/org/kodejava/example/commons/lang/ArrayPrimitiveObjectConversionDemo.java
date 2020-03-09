package org.kodejava.example.commons.lang;

import org.apache.commons.lang3.ArrayUtils;

public class ArrayPrimitiveObjectConversionDemo {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        boolean[] booleans = {true, false, false, true};
        float[] decimals = {10.1f, 3.14f, 2.17f};

        Integer[] numbersObjects = ArrayUtils.toObject(numbers);
        Boolean[] booleansObjects = ArrayUtils.toObject(booleans);
        Float[] decimalsObjects = ArrayUtils.toObject(decimals);

        numbers = ArrayUtils.toPrimitive(numbersObjects);
        booleans = ArrayUtils.toPrimitive(booleansObjects);
        decimals = ArrayUtils.toPrimitive(decimalsObjects);
    }
}
