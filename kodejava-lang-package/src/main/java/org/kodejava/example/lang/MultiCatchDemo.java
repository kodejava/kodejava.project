package org.kodejava.example.lang;

import java.io.IOException;
import java.sql.SQLException;

public class MultiCatchDemo {
    public static void main(String[] args) {
        MultiCatchDemo demo = new MultiCatchDemo();
        try {
            demo.callA();
            demo.callB();
            demo.callC();
        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void callA() throws IOException {
        throw new IOException("IOException");
    }

    private void callB() throws SQLException {
        throw new SQLException("SQLException");
    }

    private void callC() throws ClassNotFoundException {
        throw new ClassNotFoundException("ClassNotFoundException");
    }
}
