package com.chongzi.thread;

import java.util.Arrays;
import java.util.List;

/**
 * @Description Lambda表达式
 * @Author chongzi
 * @Date 2019/10/30 19:46
 **/
public class ParallelStreamThread {

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(10,20,30,40);
        int res = new ParallelStreamThread().add(values);
        System.out.println("计算的结果为："+res);
    }

    public int add (List<Integer> values){
        return values.parallelStream().mapToInt(i -> i * 2).sum();
    }
}
