package com.zxl.app.study.zk.applications.config;

import com.zxl.app.study.zk.basic.ConnectionWatcher;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.Stat;

import java.nio.charset.Charset;

/**
 * @author vectorzhang
 * @desc kv存储
 * @date 2017/10/3 15:40
 */
public class KeyValueStore extends ConnectionWatcher {

    public static final Charset CHARSET = Charset.forName("utf-8");

    public void write(String path, String value) throws KeeperException, InterruptedException {
        Stat stat = zk.exists(path, false);
        if (stat == null) {
            zk.create(path, value.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        } else {
            zk.setData(path, value.getBytes(), -1);
        }
    }

    public String read(String path, Watcher watcher) throws InterruptedException,
            KeeperException {
        byte[] data = zk.getData(path, watcher, null);
        return new String(data, CHARSET);
    }
}
