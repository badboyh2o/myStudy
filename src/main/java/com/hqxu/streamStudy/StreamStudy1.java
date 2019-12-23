package com.hqxu.streamStudy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamStudy1 {

    
    public static void main(String[] args) {
        
        Stream<String> stream = Stream.of("hello welcome","world","hahah","hello welcome");
        Stream<String> stream1 = Stream.of("hello welcome","world","hahah","hello welcome");
        
        stream.distinct().collect(Collectors.toList()).forEach(System.out::println);
        
        System.out.println("====================================");
        
        // 使用 flatmap   将多个Stream 合并为一个Stream
        stream1.map(item -> item.split(" ")).flatMap(Arrays::stream).distinct().collect(Collectors.toList()).forEach(System.out::println);
        
        System.out.println("====================================");
        
        // 使用 flatmap   将多个Stream 合并为一个Stream
        List<String> list2 = Arrays.asList("hello","hi");
        List<String> list3 = Arrays.asList("zhangsan","lisi","wangwu");
        
        list2.stream().flatMap(item -> list3.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList()).forEach(System.out::println);
        
    }
    
    
}
