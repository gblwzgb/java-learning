package cn.java.learning.java8stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 阅读Stream源码
 */
public class Test01 {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("I", "learn", "Java");
        stringStream.filter(str -> str.length() > 1).map(str -> str + "1").collect(Collectors.toList());
        //List<String> stringList = new ArrayList<>();
        BiConsumer<List<String>, String> biConsumer = List::add;//(list, string) -> list.add(string);
        Supplier<List<String>> supplier1 = (Supplier<List<String>>) ArrayList::new;
        Supplier<List<String>> supplier2 = ArrayList::new;
        Supplier<List<String>> supplier3 =  ()->new ArrayList<String>();
    }
}
