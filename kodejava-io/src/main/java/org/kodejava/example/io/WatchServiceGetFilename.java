package org.kodejava.example.io;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;

public class WatchServiceGetFilename {
    public static void main(String[] args) {
        try {
            // Create a WatchService and register the logDir path with the
            // WatchService for ENTRY_CREATE.
            WatchService watcher = FileSystems.getDefault().newWatchService();
            Path logDir = Paths.get("C:/Users/wsaryada/Desktop");
            logDir.register(watcher, ENTRY_CREATE);

            while (true) {
                WatchKey key;
                try {
                    key = watcher.take();
                } catch (InterruptedException e) {
                    return;
                }

                for (WatchEvent<?> event : key.pollEvents()) {
                    if (event.kind() == ENTRY_CREATE) {
                        // Get the name of created file.
                        WatchEvent<Path> ev = cast(event);
                        Path filename = ev.context();

                        System.out.printf("A new file %s was created.%n",
                            filename.getFileName());

                        Path directory = (Path) key.watchable();
                        Path fullPath = directory.resolve(ev.context());
                        System.out.printf("A new file %s was created.%n",
                            fullPath);
                    }
                }
                key.reset();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private static <T> WatchEvent<T> cast(WatchEvent<?> event) {
        return (WatchEvent<T>)event;
    }
}
