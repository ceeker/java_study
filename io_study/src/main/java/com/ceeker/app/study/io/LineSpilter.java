package com.ceeker.app.study.io;

import com.google.common.base.Splitter;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.IOException;
import java.util.List;

/**
 * 分割器
 *
 * @author ceeker
 * @create 2017/10/22 19:14
 **/
public class LineSpilter {

    public static void main(String[] args) throws IOException {
        String filePath = "C:\\info.log";
        LineIterator iterator = getLineIterator(filePath);
        splite(iterator);
    }

    public static void splite(LineIterator iterator) {
        Splitter splitter = Splitter.on("\t").omitEmptyStrings().trimResults();
        while (iterator.hasNext()) {
            String line = iterator.nextLine();
            List<String> toList = splitter.splitToList(line);
            System.out.println(toList);

        }
    }

    public static LineIterator getLineIterator(String filePath) throws IOException {
        return FileUtils.lineIterator(FileUtils.getFile(filePath));
    }


}
