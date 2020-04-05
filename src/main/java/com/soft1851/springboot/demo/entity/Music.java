package com.soft1851.springboot.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/2
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Music {
    private Integer musicId;
    private String name;
    private String thumbnail;
    private String url;
    private String singer;
    private String album;
    private Integer status;
    private String totalTime;
}
