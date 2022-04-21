package com.amei.knowledge.javaDemo.streamAnd函数编程;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 *  Collectors.joining(", ")
 *  Collectors.toList()
 *  Collectors.toSet() ，
 * 生成set集合 Collectors.toMap(MemberModel::getUid, Function.identity())
 * Collectors.toMap(ImageModel::getAid, o -> IMAGE_ADDRESS_PREFIX + o.getUrl()) ¶
 * */
public class collectors用法 {
    public static void main(String[] args) {
        // 将字符串换成大写并用逗号链接起来
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "Canada");
        String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
        System.out.println(G7Countries);

    }
}
