package org.kodejava.example.commons.beanutils;

import org.apache.commons.beanutils.PropertyUtils;

import java.util.Arrays;

public class PropertySetIndexedExample {
    public static void main(String[] args) {
        String[] colors = new String[]{"red", "green", "blue"};

        MyBean myBean = new MyBean();
        myBean.setColors(colors);
        System.out.println("Colors = " + Arrays.toString(myBean.getColors()));

        try {
            PropertyUtils.setIndexedProperty(myBean, "colors", 1, "orange");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Colors = " + Arrays.toString(myBean.getColors()));
    }
}
