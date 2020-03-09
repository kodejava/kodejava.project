package org.kodejava.example.stream;

public class TestConverter {
    public static void main(String[] args) {
        Converter<String, Integer> converter = new Converter<String, Integer>() {
            @Override
            public Integer convert(String from) {
                return Integer.valueOf(from);
            }
        };

        Converter<String, Integer> convert = Integer::valueOf;

        System.out.println(converter.convert("1000"));
        System.out.println(convert.convert("100000"));

        Converter<String, String> startWith = Something::startWith;
        System.out.println("startWith = " + startWith.convert("Indonesia Raya"));
    }
}

class Something {
    static String startWith(String s) {
        return String.valueOf(s.charAt(0));
    }
}
