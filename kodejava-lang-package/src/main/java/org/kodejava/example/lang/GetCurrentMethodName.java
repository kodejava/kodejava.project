package org.kodejava.example.lang;

public class GetCurrentMethodName {
    public static void main(String[] args) {
        // Get the current executing method name
        String methodName =
            Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.println("methodName = " + methodName);

        GetCurrentMethodName obj = new GetCurrentMethodName();
        obj.executeAMethod();
    }

    private void executeAMethod() {
        // Get the current executing method name
        String methodName =
            Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.println("methodName = " + methodName);
    }
}
