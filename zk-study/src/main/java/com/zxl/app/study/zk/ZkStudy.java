package com.zxl.app.study.zk;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * zk学习
 *
 * @author ceeker
 * @create 2017/9/25 13:01
 **/
public class ZkStudy {

    public static final String PATH = "/zk_study";

    public static void main(String[] args) throws InterruptedException, IOException, KeeperException {
        new ZkStudy().create(PATH, "zxl");
    }

    public boolean create(String path, String data) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zk = new ZooKeeper("127.0.0.1:2181", 1000, null);
        String result = zk.create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        String dataStr = new String(zk.getData(path, null, null));
        System.out.println(String.format("create data=%s, result=%s", data, result));
        return true;
    }
}
