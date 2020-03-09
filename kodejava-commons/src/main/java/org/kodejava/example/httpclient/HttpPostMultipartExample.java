package org.kodejava.example.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.File;
import java.io.IOException;

public class HttpPostMultipartExample {
    public static void main(String[] args) {
        File file = new File("data.zip");
        FileBody fileBody = new FileBody(file, ContentType.DEFAULT_BINARY);

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        builder.addPart("file", fileBody);
        HttpEntity entity = builder.build();

        HttpPost request = new HttpPost("http://localhost:8080/upload");
        request.setEntity(entity);

        HttpClient client = HttpClientBuilder.create().build();
        try {
            client.execute(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
