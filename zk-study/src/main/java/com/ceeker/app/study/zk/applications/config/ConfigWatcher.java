package com.ceeker.app.study.zk.applications.config;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

import java.io.IOException;

public class ConfigWatcher implements Watcher {

    private KeyValueStore store;

    public ConfigWatcher(String hosts) throws IOException, InterruptedException {
        store = new KeyValueStore();
        store.connect(hosts);
    }

    public static void main(String[] args) throws Exception {
        String host = "127.0.0.1:2181";
        ConfigWatcher configWatcher = new ConfigWatcher(host);
        configWatcher.displayConfig();
        // stay alive until process is killed or thread is interrupted
        Thread.sleep(Long.MAX_VALUE);
    }

    public void displayConfig() throws InterruptedException, KeeperException {
        String value = store.read(ConfigUpdater.PATH, this);
        System.out.printf("Read %s as %s\n", ConfigUpdater.PATH, value);
    }

    @Override
    public void process(WatchedEvent event) {
        if (event.getType() == Event.EventType.NodeDataChanged) {
            try {
                System.out.println("receive WatchedEvent=" + event);
                displayConfig();
            } catch (InterruptedException e) {
                System.err.println("Interrupted. Exiting.");
                Thread.currentThread().interrupt();
            } catch (KeeperException e) {
                System.err.printf("KeeperException: %s. Exiting.\n", e);
            }
        }
    }
}