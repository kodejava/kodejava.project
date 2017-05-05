package org.kodejava.example.commons.lang;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ReflectionToStringDemo {
    private Integer id;
    private String name;
    private String description;
    public static final String KEY = "APP-KEY";
    private transient String secretKey;

    public ReflectionToStringDemo(Integer id, String name, String description,
                                  String secretKey) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.secretKey = secretKey;
    }

    @Override
    public String toString() {
        // Generate toString including transient and static fields.
        return ReflectionToStringBuilder.toString(this,
            ToStringStyle.MULTI_LINE_STYLE, true, true);
    }

    public static void main(String[] args) {
        ReflectionToStringDemo demo = new ReflectionToStringDemo(1, "MANUTD",
            "Manchester United", "secret**");
        System.out.println("Demo = " + demo);
    }
}
