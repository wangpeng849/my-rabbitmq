package com.wangp.myrabbitmq.util;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Objects.compare;

/**
 * @Author farling
 * @Date 2019/11/25
 */
public class Map2Bean {

    @Data
    @AllArgsConstructor
    static class Student {
        private String id;
        private int age;
    }


    public static void main(String[] args) {
        Student stu1 = new Student("1", 26);
        Student stu2 = new Student("2", 15);
        Student stu3 = new Student("3", 40);
        Student stu4 = new Student("4", 1);
        Student stu5 = new Student("5", 112);
        Student stu6 = new Student("1", 24);
        Student stu7 = new Student("2", 32);
        Student stu8 = new Student("3", 5);
        Student stu9 = new Student("4", 14);
        Student stu10 = new Student("5", 110);

        List<Student> list1 = Arrays.asList(stu1, stu2, stu3, stu4, stu5);
        List<Student> list2 = Arrays.asList(stu6, stu7, stu8, stu9, stu10);

        List<Student> list3 =
                list1.stream()
                        .map(map1 -> {
                            list2.stream()
                                    .filter(map2 -> map1.getId().equals(map2.getId()) && map1.getAge() > map2.getAge())
                                    .findFirst()
                                    .map(map2 -> {
                                        map1.setAge(map2.getAge());
                                        return map1;
                                    }).orElse(map1);
                                        return map1;
                        }).filter(Objects::nonNull)
                        .collect(Collectors.toList());
        System.out.println(list3);
    }
}
