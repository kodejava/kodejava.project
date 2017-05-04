package org.kodejava.example.commons.lang;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ToStringBuilderDemo {
    private Long id;
    private String firstName;
    private String lastName;

    public static void main(String[] args) {
        ToStringBuilderDemo demo = new ToStringBuilderDemo();
        demo.id = 1L;
        demo.firstName = "First Name";
        demo.lastName = "Last Name";

        System.out.println(demo);
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", id)
            .append("firstName", firstName)
            .append("lastName", lastName)
            .toString();
    }
}
