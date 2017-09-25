package com.zxl.app.study.zk;

/**
 * zk学习
 *
 * @author ceeker
 * @create 2017/9/25 13:01
 **/
public class ZkStudy {

    public static void main(String[] args) {
        synchronized (ZkStudy.class) {
            System.out.println("args = [" + args + "]");
        }
    }
}
