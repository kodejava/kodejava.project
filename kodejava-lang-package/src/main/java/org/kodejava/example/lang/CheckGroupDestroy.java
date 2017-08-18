package org.kodejava.example.lang;

public class CheckGroupDestroy {
    public static void main(String[] args) {
        ThreadGroup grandParent = new ThreadGroup("GrandParent");
        ThreadGroup uncle = new ThreadGroup(grandParent, "Uncle");
        ThreadGroup parent = new ThreadGroup(grandParent, "Parent");
        ThreadGroup son = new ThreadGroup(parent, "Son");
        ThreadGroup daughter = new ThreadGroup(parent, "Daughter");
        ThreadGroup neighbour = new ThreadGroup("Neighbour");

        ThreadGroup[] groupArray = {
            grandParent, uncle, parent, son, daughter, neighbour
        };

        // Destroy 'parent' group and all its subgroups
        parent.destroy();

        // Check whether the group is destroyed. The result is,
        // GrandParent, Uncle, and Neighbour did not destroyed
        // because they are not Parent's subgroups
        for (ThreadGroup tg : groupArray) {
            if (tg.isDestroyed()) {
                System.out.println(tg.getName() + " is destroyed");
            } else {
                System.out.println(tg.getName() + " is not destroyed");
            }
        }
    }
}
