package com.amei.knowledge.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.springframework.http.HttpStatus;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadXml {

    public static void main(String[] args) {

//        xmlPath;
//        readFile();
    }



    /**
     * 读取XML类型文件，返回Jsoup文档对象，文件存在于用户家目录
     *
     * @param xmlPath 文件地址
     * @return Jsoup文档对象
     */
    public static Document readFile(String xmlPath) throws com.amei.knowledge.exception.GlobalException {
        Document document;
        BufferedInputStream bufferedInputStream = null;
        //获取文件转换为jsoup文档对象
        try {
            try {
                //读取用户家目录文件
                bufferedInputStream = new BufferedInputStream(new FileInputStream(xmlPath));
//                bufferedInputStream = new BufferedInputStream(InitUtils.getResourceFile(xmlPath).getInputStream());
                document = Jsoup.parse(bufferedInputStream, "utf-8", "", Parser.xmlParser());
            } finally {
                if (bufferedInputStream != null) bufferedInputStream.close();
            }
        } catch (IOException e) {
//            e.printStackTrace();
            throw new com.amei.knowledge.exception.GlobalException(HttpStatus.INTERNAL_SERVER_ERROR, "缺失文件 - " + xmlPath);
        }
        return document;
    }
}
