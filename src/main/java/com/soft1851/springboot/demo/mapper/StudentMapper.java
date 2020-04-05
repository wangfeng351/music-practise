package com.soft1851.springboot.demo.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/5
 * @Version 1.0
 */
public interface StudentMapper {

    @Select("SELECT * FROM t_student")
    List<Map<String, Object>> selectAll();
}
