package com.amei.knowledge;

import org.springframework.core.io.ClassPathResource;

import javax.servlet.ServletContextEvent;
import java.io.*;
import java.net.URL;

//public class getFilePath {
//    public static void main(String[] args) {
//        String path1 = "C:" + File.separator + "Program Files" + File.separator + "a.txt";
//        System.out.println(path1);
//        //输出C:\Program Files\a.txtString path2="C:\\Program Files\\a.txt";//第一个\表示转义System.out.println(path2);//输出C:\Program Files\a.txt}}
//    }
//}


public class getFilePath {

    public static void main(String[] args) throws Exception {
        String xmlPath = getXMLPath();
        try {
            OutputStream f = new FileOutputStream(xmlPath);
            PrintStream printStream = new PrintStream(f);
            System.out.println(printStream);
        } catch (IOException e) {
        }
    }

    //不同环境下找到跟路径
    private static String getXMLPath() throws Exception {
        String path = "";
        path = Thread.currentThread().getContextClassLoader().getResource("").toURI().getPath();
        System.out.println("source path:" + path);
        path = path.replace("/", File.separator); // 将/换成\  
        path = path.replace("file:", ""); //去掉file:  
        path = path.replace("classes" + File.separator, ""); //去掉class\
        path = path.replace("target" + File.separator, ""); //去掉class\
        if (path.indexOf(":") != -1) {
            path = path.substring(1); //去掉第一个\,如 \D:\JavaWeb...  
        }
        path += "main"+File.separator+"resources" + File.separator + "basic_model" + File.separator + "form"+File.separator+"template"+"_structure.xml";
        //path += File.separator + path;
        System.out.println("PATH=:" + path);
        System.out.println("-----------------");
        return path;
    }


}
