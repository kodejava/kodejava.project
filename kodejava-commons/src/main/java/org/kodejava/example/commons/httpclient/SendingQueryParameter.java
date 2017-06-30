package org.kodejava.example.commons.httpclient;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.util.URIUtil;
import org.apache.commons.httpclient.methods.GetMethod;

import java.io.IOException;

public class SendingQueryParameter {
    public static void main(String[] args) {
        HttpClient client = new HttpClient();
        HttpMethod method = new GetMethod("http://localhost:8080/hello.jsp");

        try {
            // Set query string information for accessing the page using a
            // simple string information.
            method.setQueryString(URIUtil.encodeQuery("catid=10&page=1"));
            client.executeMethod(method);
            System.out.println(method.getResponseBodyAsString());

            // Other cleaner alternative is to use the NameValuePair object to
            // define the parameters for a HTTP GET method.
            NameValuePair param1 = new NameValuePair("catid", URIUtil.encodeQuery("20"));
            NameValuePair param2 = new NameValuePair("page", URIUtil.encodeQuery("2"));
            NameValuePair[] params = new NameValuePair[] {param1, param2};
            method.setQueryString(params);

            client.executeMethod(method);
            System.out.println(method.getResponseBodyAsString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            method.releaseConnection();
        }
    }
}
