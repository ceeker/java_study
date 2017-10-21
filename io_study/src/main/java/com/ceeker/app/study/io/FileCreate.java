package com.ceeker.app.study.io;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import org.apache.commons.io.FileSystemUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;


/**
 * 文件创建
 *
 * @author ceeker
 * @create 2017/10/21 9:47
 **/
public class FileCreate {

    public static final int max = Integer.MAX_VALUE / 3;

    public static final int gb = 1024 * 1024;

    public static void main(String[] args) throws IOException {
        String src = "test.txt";
        String dis = "C:\\test";
        long start = System.currentTimeMillis();
        FileUtils.copyFileToDirectory(FileUtils.getFile(src), FileUtils.getFile(dis));
        long end = System.currentTimeMillis();
        System.out.println("cost=" + (end - start) / 1000);
    }

    private static List<String> getLines(int count) {
        List<String> list = Lists.newArrayListWithCapacity(count);
        for (int i = 0; i < count; i++) {
            list.add(RandomStringUtils.randomNumeric(6, 12));
        }
        return list;
    }

    public static void copyDir(String srcDir, String disDir) throws IOException {
        FileUtils.copyDirectoryToDirectory(FileUtils.getFile(srcDir), FileUtils.getFile(disDir));
    }

    public void readFile(String path) throws IOException {
        String str = RandomStringUtils.randomNumeric(5);
        File file = FileUtils.getFile("test.txt");
        LineIterator iterator = FileUtils.lineIterator(file, "utf-8");
        int index = 0;
        long start = System.currentTimeMillis();
        while (iterator.hasNext()) {
            index++;
            String line = iterator.nextLine();
            if (line.contains(str) || index % 100000 == 0) {
                System.out.println(String.format("str=%s,line=%s,index=%s", str, line, index));
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("cost=" + (end - start) / 1000);
    }

    private void test() throws IOException {
        long freeSpace = FileSystemUtils.freeSpaceKb("D:\\");
        int i = 0;
        File file = FileUtils.getFile("test.txt");
        while (i < max && freeSpace > gb) {
            FileUtils.writeLines(file, getLines(10000), true);
            i++;
            if (i % 10 == 0) {
                freeSpace = FileSystemUtils.freeSpaceKb("D:\\");
                System.out.println(String.format("i=%d,space=%d g", i, freeSpace / gb));
            }
        }
    }

    public void createFile(String name, String path) throws IOException {
        FileUtils.writeStringToFile(FileUtils.getFile("123.txt"), "123");
        long freeSpaceKb = FileSystemUtils.freeSpaceKb("D:\\");
        FileUtils.lineIterator(FileUtils.getFile("123.txt"), Charsets.UTF_8.toString());
    }
}
