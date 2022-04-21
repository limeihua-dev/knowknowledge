package com.amei.knowledge.javaDemo.file;

import com.amei.knowledge.exception.GlobalException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.springframework.http.HttpStatus;
import org.springframework.util.DigestUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 使用Jsoup   读取/写入文件
 */
public class xml {


    /**
     * 写入XML类型的文件，传入Jsoup文档对象
     *
     * @param xmlPath  文件路径
     * @param document Jsoup文档对象
     * @throws IOException
     */
    public static void writeFile(String xmlPath, Document document) throws GlobalException {
        File file = new File(xmlPath);
        BufferedWriter bufferedWriter = null;
        try {
            try {
                //不存在则创建文件及目录
                if (!file.exists()) {
                    File dir = new File(xmlPath.substring(0, xmlPath.lastIndexOf("/")));
                    if (!dir.exists()) dir.mkdirs();
                    file.createNewFile();
                }
                //获取文件输出流
                bufferedWriter = new BufferedWriter(new FileWriter(file));
                bufferedWriter.write(document.toString());
            } finally {
                if (bufferedWriter != null) bufferedWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new GlobalException(HttpStatus.INTERNAL_SERVER_ERROR, "文件写入失败 - " + xmlPath);
        }
    }


    /**
     * 读取XML类型文件，返回Jsoup文档对象
     *
     * @param xmlPath 文件地址
     * @return Jsoup文档对象
     * @throws GlobalException
     */
    public static Document readFile(String xmlPath) throws GlobalException {
        Document document;
        BufferedInputStream bufferedInputStream = null;
        //获取文件转换为jsoup文档对象
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(xmlPath)));
                document = Jsoup.parse(bufferedInputStream, "utf-8", "", Parser.xmlParser());
            } finally {
                if (bufferedInputStream != null) bufferedInputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new GlobalException(HttpStatus.INTERNAL_SERVER_ERROR, "缺失文件 - " + xmlPath);
        }
        return document;
    }


    /**
     * 将一个map插入属性节点
     *
     * @param document
     * @param attributeName
     * @param ruleMap
     * @param ruleType
     * @return
     * @throws GlobalException
     */
    public static Document updateAttributeRule(Document document, String attributeName, Map ruleMap, RuleType ruleType) throws GlobalException {
        //属性节点
        Element attributeElement = document.getElementsByTag("attributeItems").first().getElementsByAttributeValue("name", attributeName).first();
        if (attributeElement == null) {
            throw new GlobalException(HttpStatus.INTERNAL_SERVER_ERROR, attributeName + " - 属性不存在于xml中，删除失败");
        }
        Element ruleElement = attributeElement.getElementsByTag(ruleType.parentTagName).first();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            HashMap ruleElementMap = objectMapper.readValue(ruleElement.text(), HashMap.class);
            ruleElementMap.put("system", ruleMap);
            ruleElement.text(objectMapper.writeValueAsString(ruleElementMap));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new GlobalException(HttpStatus.INTERNAL_SERVER_ERROR, attributeName + "的属性规则不符合JSON字符串规则");
        }
        return document;
    }


    /**
     * 属性规则类型
     */
    public enum RuleType {
        VERIFICATION("verification-rule"),
        COMPUTED("computed-rule"),
        UPDATE("update-rule"),
        DISPLAY("display-rule");
        private String parentTagName;

        RuleType(String parentTagName) {
            this.parentTagName = parentTagName;
        }
    }

}
