package com.ceeker.app.study.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ceeker
 * @create 2017/11/4 20:46
 **/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Log {
    private String id;
    private String ip;
    private int is_success;
}
