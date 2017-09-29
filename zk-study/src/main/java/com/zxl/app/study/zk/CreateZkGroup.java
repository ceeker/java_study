package com.zxl.app.study.zk;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * 创建zk group
 *
 * @author ceeker
 * @create 2017/9/29 22:19
 **/
public class CreateZkGroup implements Watcher {

    private static final int SESSION_TIMEOUT = 5000;
    private ZooKeeper zk;
    private CountDownLatch connectedSignal = new CountDownLatch(1);


    public static void main(String[] args) throws Exception {
        CreateZkGroup createGroup = new CreateZkGroup();
        String host = args[0];
        String path = args[1];
        createGroup.connect(host);
        createGroup.create(path);
        createGroup.close();
    }

    public void connect(String hosts) throws IOException, InterruptedException {
        zk = new ZooKeeper(hosts, SESSION_TIMEOUT, this);
        //需要等待连接建立成功后才能执行操作，因此这里先阻塞线程
        connectedSignal.await();
    }


    public void create(String groupName) throws KeeperException,
            InterruptedException {
        String path = "/" + groupName;
        String createdPath = zk.create(path, null, ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT);
        System.out.println("Created " + createdPath);
    }

    public void close() throws InterruptedException {
        zk.close();
    }


    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            System.out.println("zk connected:" + watchedEvent);
            connectedSignal.countDown();
        }
    }

}

