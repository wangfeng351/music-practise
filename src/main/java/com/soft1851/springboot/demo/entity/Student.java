package com.soft1851.springboot.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
public class Student {
    /**
     * 学生id，主键
     */
    private Integer studentId;
    /**
     * 所属班级id
     */
    private Integer clazzId;
    /**
     * 学生姓名
     */
    private String studentName;
    /**
     * 学生籍贯
     */
    private String hometown;
    /**
     * 学生出生日期
     */
    private LocalDate birthday;
}
