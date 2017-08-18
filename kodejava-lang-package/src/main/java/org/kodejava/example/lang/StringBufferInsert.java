package org.kodejava.example.lang;

public class StringBufferInsert {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("kodeava");
        System.out.println("Text before        = " + sb.toString());

        //  |k|o|d|e|a|v|a|....
        //  0|1|2|3|4|5|6|7|...
        //
        // From the above sequence you can see that the index of the
        // string is started from 0, so when we insert a string in
        // the fourth offset it means it will be inserted after the
        // "e" letter. There are other overload version of this
        // method that can be used to insert other type of data such
        // as char, int, long, float, double, Object, etc.
        sb.insert(4, "j");
        System.out.println("After first insert = " + sb.toString());

        // Here we insert a string to the StringBuffer at index 8
        sb.insert(8, " examples");
        System.out.println("Final result       = " + sb.toString());
    }
}
