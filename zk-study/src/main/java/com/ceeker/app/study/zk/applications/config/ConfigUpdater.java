package com.ceeker.app.study.zk.applications.config;

import org.apache.zookeeper.KeeperException;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 更新zk配置
 */
public class ConfigUpdater {
    public static final String PATH = "/config";
    private KeyValueStore store;
    private Random random = new Random();

    public ConfigUpdater(String hosts) throws IOException, InterruptedException {
        store = new KeyValueStore();
        store.connect(hosts);
    }

    public static void main(String[] args) throws Exception {
        String host = "127.0.0.1:2181";
        ConfigUpdater configUpdater = new ConfigUpdater(host);
        configUpdater.run();
    }

    public void run() throws InterruptedException, KeeperException {
        while (true) {
            String value = random.nextInt(100) + "";
            store.write(PATH, value);
            System.out.printf("Set %s to %s\n", PATH, value);
            TimeUnit.SECONDS.sleep(random.nextInt(10));
        }
    }
}