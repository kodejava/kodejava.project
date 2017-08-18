package org.kodejava.example.lang;

public class ActiveGroupCount {
    public static void main(String[] args) {
        ThreadGroup root = new ThreadGroup("RootGroup");
        ThreadGroup server = new ThreadGroup(root, "ServerGroup");
        ThreadGroup client = new ThreadGroup(root, "ClientGroup");

        Thread t1 = new Thread(server, new ServerThread(), "ServerThread");
        Thread t2 = new Thread(client, new ClientThread(), "ClientThread");

        t1.start();
        t2.start();

        // Get estimate active groups in 'root' thread group
        int activeGroup = root.activeGroupCount();
        System.out.format("Estimated active group in %s is %d%n",
            root.getName(), activeGroup);

        // Get estimate active threads in 'root' thread group
        int activeThread = root.activeCount();
        System.out.format("Estimated active thread in %s is %d%n",
            root.getName(), activeThread);
    }
}

class ServerThread implements Runnable {
    public void run() {
        System.out.println("Running - Server Thread..");
    }
}


class ClientThread implements Runnable {
    public void run() {
        System.out.println("Running - Client Thread..");
    }
}
