package org.kodejava.example.util;

import java.util.StringTokenizer;

public class StringTokenizerExample {
    public static void main(String[] args) {
        StringTokenizer st =
            new StringTokenizer("A StringTokenizer sample");

        // get how many tokens inside st object
        System.out.println("Tokens count: " + st.countTokens());

        // iterate st object to get more tokens from it
        while (st.hasMoreElements()) {
            String token = st.nextElement().toString();
            System.out.println("Token = " + token);
        }

        // split a date string using a forward slash as delimiter
        st = new StringTokenizer("2017/08/20", "/");
        while (st.hasMoreElements()) {
            String token = st.nextToken();
            System.out.println("Token = " + token);
        }
    }
}
