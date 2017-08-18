package org.kodejava.example.lang;

public class ThreadGroupDestroy {
    public static void main(String[] args) {
        ThreadGroup root = new ThreadGroup("Root");
        ThreadGroup server = new ThreadGroup(root, "ServerGroup");
        ThreadGroup client = new ThreadGroup(root, "ClientGroup");

        // Destroy 'root' thread groups and all its subgroup
        // ('server' & 'client')
        root.destroy();

        // Check if 'root' group and its subgroups already destroyed
        if (root.isDestroyed()) {
            System.out.println("Root group is destroyed");
        }

        if (server.isDestroyed()) {
            System.out.println("Server group is destroyed");
        }

        if (client.isDestroyed()) {
            System.out.println("Client group is destroyed");
        }
    }
}
