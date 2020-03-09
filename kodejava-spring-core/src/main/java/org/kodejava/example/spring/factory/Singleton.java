package org.kodejava.example.spring.factory;

public class Singleton {

    /**
     * Private constructor.
     */
    private Singleton() {
    }

    private static class SingletonHolder {
        static Singleton instance = new Singleton();
    }

    /**
     * Get an instance of Singleton class.
     * @return an instance of Singleton class.
     */
    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }

    /**
     * Do something.
     */
    public void doSomething() {
        System.out.println("Singleton.doSomething");
    }
}
