package com.amei.knowledge.javaDemo.string;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class String2List {
    String string= "文学-小说-历史-言情-科幻-悬疑";
    List list = Arrays.asList(string.split("-")).stream().map(s -> String.format(s.trim())).collect(Collectors.toList());
}
