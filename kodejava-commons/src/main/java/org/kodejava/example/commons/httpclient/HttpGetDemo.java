package org.kodejava.example.commons.httpclient;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;

import java.io.*;

public class HttpGetDemo {
    public static void main(String[] args) {
        HttpClient client = new HttpClient();
        HttpMethod method = new GetMethod("https://kodejava.org");

        try {
            client.executeMethod(method);

            if (method.getStatusCode() == HttpStatus.SC_OK) {
                InputStream is = method.getResponseBodyAsStream();

                if (is != null) {
                    Writer writer = new StringWriter();
                    char[] buffer = new char[1024];
                    try {
                        Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                        int length;
                        while ((length = reader.read(buffer)) != -1) {
                            writer.write(buffer, 0, length);
                        }
                    } finally {
                        is.close();
                    }
                    System.out.println("Response = " + writer.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            method.releaseConnection();
        }
    }
}
