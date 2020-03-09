package org.kodejava.example.commons.lang;

import java.util.Date;
import org.apache.commons.lang3.StringUtils;

public class NestedString {
    public static void main(String[] args) {
        String helloHtml = "<html>" +
                "<head>" +
                "   <title>Hello World from Java</title>" +
                "<body>" +
                "Hello, today is: " + new Date() +
                "</body>" +
                "</html>";

        String title = StringUtils.substringBetween(helloHtml, "<title>", "</title>");
        String content = StringUtils.substringBetween(helloHtml, "<body>", "</body>");

        System.out.println("title = " + title);
        System.out.println("content = " + content);
    }
}
