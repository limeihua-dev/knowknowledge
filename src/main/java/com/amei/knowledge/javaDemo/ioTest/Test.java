package com.amei.knowledge.javaDemo.ioTest;

import java.io.File;
import java.io.IOException;

/**
 * 在电脑下创建一个文件为HelloWorld.txt文件，
 * 判断他是文件还是目录
 * 在创建一个目录IOTest,之后将HelloWorld.txt移动到IOTest目录下去；
 * 之后遍历IOTest这个目录下的文件
 */
public class Test {
    public static void main(String[] args) {
        //创建文件
        File file = new File("/Users/meihua/Downloads/", "HelloWorld.txt");
        File file3 = new File("/Users/meihua/Downloads/", "HelloWorld2.txt");
        boolean isCreate;
        try {
            isCreate = file.createNewFile();
            if (isCreate) {
                System.out.println("创建文件成功！");
            } else {
                System.out.println("文件创建失败！文件已经存在");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 判断他是文件还是目录，
        if (file.isFile()) {
            System.out.println("这是一个文件");
        } else {
            System.out.println("这是一个目录");
        }
        //创建文件夹
        File file2 = new File("/Users/meihua/Downloads/studyTest");
        file2.mkdir();

        //移动文件到文件夹
        if (file.renameTo(new File(file2.getAbsolutePath() + "/" + file3.getName()))) {
            System.out.println("文件移动成功");
        } else {
            System.out.println("文件移动失败");
        }
        String[] list = file2.list();

        /**
         * 遍历文件
         */
        for (String str : list) {
            System.out.println(str);
        }
    }
}
