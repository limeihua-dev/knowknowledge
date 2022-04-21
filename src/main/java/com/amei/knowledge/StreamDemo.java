package com.amei.knowledge;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


/**
 * 字符流的使用
 */
public class StreamDemo {

    List<String> ignore = Stream.of("id", "create_account", "create_time").collect(toList());

}
