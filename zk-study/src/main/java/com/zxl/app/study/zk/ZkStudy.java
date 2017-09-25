package com.zxl.app.study.zk;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * zk学习
 *
 * @author ceeker
 * @create 2017/9/25 13:01
 **/
public class ZkStudy {

    public static final String HOST = "127.0.0.1:2181";

    public static final String PATH = "/zk_study";

    private ZooKeeper zkClient;

    public ZkStudy() {
        try {
            zkClient = new ZooKeeper(HOST, 1000, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException, KeeperException {
        ZkStudy zkStudy = new ZkStudy();
        zkStudy.create(PATH, "zxl");
        zkStudy.delete(PATH);
        zkStudy.set(PATH, "1234");
    }


    public boolean create(String path, String data) {
        String result = null;
        try {
            Stat exists = zkClient.exists(path, false);
            if (null == exists) {
                result = zkClient.create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                String dataStr = new String(zkClient.getData(path, null, null));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(String.format("create data=%s, result=%s", data, result));
        return true;
    }

    public boolean set(String path, String data) {
        try {
            if (zkClient.exists(path, false) != null) {
                Stat stat = zkClient.setData(path, data.getBytes(), -1);
                System.out.println(String.format("set data=%s,result=%s", data, stat));
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean delete(String path) {
        try {
            if (zkClient.exists(path, false) != null) {
                zkClient.delete(path, -1);
                System.out.println(String.format("delete path=%s", path));
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }
}
