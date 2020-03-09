package org.kodejava.example.commons.httpclient;

import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;

import java.io.IOException;

public class HttpGetProxy {
    private static final String PROXY_HOST = "proxy.host.com";
    private static final int PROXY_PORT = 8080;

    public static void main(String[] args) {
        HttpClient client = new HttpClient();
        HttpMethod method = new GetMethod("https://kodejava.org");

        HostConfiguration config = client.getHostConfiguration();
        config.setProxy(PROXY_HOST, PROXY_PORT);

        String username = "guest";
        String password = "s3cr3t";
        Credentials credentials = new UsernamePasswordCredentials(username, password);
        AuthScope authScope = new AuthScope(PROXY_HOST, PROXY_PORT);

        client.getState().setProxyCredentials(authScope, credentials);

        try {
            client.executeMethod(method);

            if (method.getStatusCode() == HttpStatus.SC_OK) {
                String response = method.getResponseBodyAsString();
                System.out.println("Response = " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            method.releaseConnection();
        }
    }
}
