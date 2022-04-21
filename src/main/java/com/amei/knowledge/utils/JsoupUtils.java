package com.amei.knowledge.utils;


import com.amei.knowledge.testEntity.Attribute;
import com.amei.knowledge.testEntity.FormDefinition;
import com.amei.knowledge.exception.GlobalException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.http.HttpStatus;

import javax.xml.transform.*;
import java.io.*;
import java.util.List;
/*
*         <dependency>
            <groupId>org.jsoup</groupId>
            <artifactId>jsoup</artifactId>
            <version>1.12.1</version>
        </dependency>
* */
public class JsoupUtils {

    private static final String DESIGN_PC_POSTFIX = "_design.json";
    private static final String DESIGN_MOBILE_POSTFIX = "_design_m.json";
    private static final String STRUCTURE_POSTFIX = "_structure.xml";
    private static String FORM_DEFINITION_INSTANCE_PATH = "src/main/resources/basic_model/form";


    public static void main(String[] args) throws IOException, GlobalException, TransformerConfigurationException {
        Attribute attribute = createAttribute();
        String formId = "bca42273-25c9-4dcd-bb37-e72afcaebc07";
        File structure = getFileByType(attribute.getCategory_id(), "bca42273-25c9-4dcd-bb37-e72afcaebc07", "structure");
        //因为写入到文件需要将document变成string
        String document = getDocument(structure);
//   添加属性到xml----->
//   addXmlWithAttributeElement("attributeItems","attribute",Jsoup.parse(document), attribute,formId);
//   更改属性到xml----->
//        updateXmlWithAttributeElement(Jsoup.parse(document), attribute, formId);
//   删除属性，并更新xml
//        removeXmlWithSingleAttributeElement(Jsoup.parse(document),attribute,formId);
//    更新表单基本信息（覆盖）
        FormDefinition formDefinition = createFormDefinition();
        updateXmlWithBaseInfoElement(Jsoup.parse(document), formDefinition, formDefinition.getId());

    }


    /*
     *
     * */
    /**
     * 创建XML的属性节点,传递属性实体类,和xml相关的document对象
     * @param tagName
     * @param elementName
     * @param checkType
     * @param elementId
     * @param attribute
     * @param formDefinition
     * @return
     */
    private static Element createXmlElement(String tagName, String elementName, String checkType, String elementId, Attribute attribute, FormDefinition formDefinition) {
        //表单属性所需节点
        final String[] ATTRIBUTE_ELEMENT_SUB_NODE = {"name", "caption", "type", "default", "sort", "require", "hidden", "system", "config"};
        //表单基本信息所需节点
        final String[] BASE_ELEMENT_SUB_NODE = {"id", "categoryid", "categoryname", "issingle", "createaccount", "createtime"};
        Element element = new Element(elementName);
        if (tagName.equals("attributeitems")) {
            element.attr("id", elementId).appendElement("name").text(attribute.getName());
            element.appendElement("caption").text(attribute.getCaption());
            element.appendElement("type").text(attribute.getType());
            element.appendElement("default").text(attribute.getDefault_value());
            element.appendElement("sort").text(String.valueOf(attribute.getSort()));
            element.appendElement("require").text(String.valueOf(attribute.isRequired()));
            element.appendElement("hidden").text(String.valueOf(attribute.isDisplay()));
            element.appendElement("system").text(String.valueOf(attribute.isSystem()));
        } else if (tagName.equals("verificationrulelist")) {
            //创建属性校验规则 element
            element.attr("ID", elementId).attr("checkType", checkType);
            for (String key : attribute.getVerification_rule().keySet()) {
                element.appendElement(key).text((String) attribute.getVerification_rule().get(key));
            }
        } else if (tagName.equals("invisiblerulelist")) {
            element.attr("ID", elementId);
        } else if (tagName.equals("formdefinitionmodel")) {
            if (elementName.equals("id")) {
                element.text(String.valueOf(formDefinition.getId()));
            } else if (elementName.equals("categoryid")) {
                element.text(String.valueOf(formDefinition.getCategory_id()));
            } else if (elementName.equals("categoryname")) {
                element.text("默认分类233");
            } else if (elementName.equals("issingle")) {
                if (formDefinition.isSingle()) {
                    element.text("1");
                } else element.text("0");
            } else if (elementName.equals("createaccount")) {
                element.text(formDefinition.getCreate_account());
            } else if (elementName.equals("createtime")) {
                element.text(String.valueOf(formDefinition.getCreate_time()));
            }
        }
        return element;
    }


    /*
     * 添加基本信息
     * 一个element添加到要传入的document文件
     * */
    private static Document addXmlWithBaseInfoElement(String tagName, String elementTagName, Document document, FormDefinition formDefinition, String formId) throws GlobalException, IOException, TransformerConfigurationException {

        Element element = document.getElementsByTag(tagName).first();
        Element xmlElement = createXmlElement(tagName, elementTagName, "", "", null, formDefinition);
        //判断属性是否存在
//        if (element.getElementsByTag(elementTagName) != null)
//            throw new GlobalException(HttpStatus.INTERNAL_SERVER_ERROR, formDefinition.getCaption() + "表单基本信息已存在于XML中，请勿重复添加");
        xmlElement.appendTo(element);
        setStructXml(formDefinition.getCategory_id(), formId, document, false);
        return document;

    }


    /*
     * 添加表单属性
     * 一个element添加到要传入的document文件
     * */
    private static Document addXmlWithAttributeElement(String tagName, String elementTagName, Document document, Attribute attribute, String formId) throws GlobalException, IOException, TransformerConfigurationException {
        Element attributeItems = document.getElementsByTag(tagName).first();
        Element attribute1 = createXmlElement(tagName, elementTagName, "", attribute.getId(), attribute, null);

        //判断属性是否存在
        if (attributeItems.getElementById(attribute.getId()) != null)
            throw new GlobalException(HttpStatus.INTERNAL_SERVER_ERROR, attribute.getCaption() + "属性已存在于XML中，请勿重复添加");
        attribute1.appendTo(attributeItems);
        setStructXml(attribute.getCategory_id(), formId, document, false);
        return document;
    }


    /*
     * 更新表单属性
     * 将document文件上的对应的属性更新
     * */
    private static Document updateXmlWithAttributeElement(Document document, Attribute attribute, String formId) throws GlobalException, IOException, TransformerConfigurationException {
        //属性集合节点
        Element attributeItems = document.getElementsByTag("attributeItems").first();
        //判断属性是否存在
        Element element = attributeItems.getElementById(attribute.getId());
        if (element == null)
            throw new GlobalException(HttpStatus.INTERNAL_SERVER_ERROR, "属性不存在于xml中");
        //表单中已存在该属性，需移除
        element.remove();
        Document document1 = addXmlWithAttributeElement("attributeItems", "attribute", document, attribute, formId);

        //添加进xml文件中
        setStructXml(attribute.getCategory_id(), formId, document, false);
        return document1;
    }

    /*
     * 更新校验属性
     * 将document文件上的对应的属性更新
     * */
    private static Document updateXmlWithVerificationRulesElement(Document document, Attribute attribute, String formId) throws GlobalException, IOException, TransformerConfigurationException {
        //校验属性集合节点
        Element verificationrulelist = document.getElementsByTag("verificationrulelist").first();
        //隐性属性集合
        Element invisiblerulelist = document.getElementsByTag("invisiblerulelist").first();
        //判断属性是否存在
        Element element = verificationrulelist.getElementById(attribute.getId());
        Element element2 = invisiblerulelist.getElementById(attribute.getId());

        if (element == null || element2 == null)
            throw new GlobalException(HttpStatus.INTERNAL_SERVER_ERROR, "属性不存在于xml中");
        //表单中已存在该属性，需移除
        element.remove();
        element2.remove();
        // 更新校验属性
        addXmlWithAttributeElement("verificationrulelist", "attribute", document, attribute, formId);
        // 更新隐形属性
        addXmlWithAttributeElement("invisiblerulelist", "attribute", document, attribute, formId);
        //添加进xml文件中
        setStructXml(attribute.getCategory_id(), formId, document, false);
        return document;
    }


    /*
     * 更新基本信息属性
     * 将document文件上的对应的属性更新
     * */
    private static Document updateXmlWithBaseInfoElement(Document document, FormDefinition formDefinition, String formId) throws GlobalException, IOException, TransformerConfigurationException {

        String[] s = {"id", "categoryid", "categoryname", "issingle", "createaccount", "createtime"};
        //校验属性集合节点
        Element formdefinitionmodel = document.getElementsByTag("formdefinitionmodel").first();
        //覆盖基本信息
        for (int i = 0; i < s.length; i++) {
            Element elementByTag = formdefinitionmodel.getElementsByTag(s[i]).first();
            if (elementByTag != null) {
                elementByTag.remove();
                System.out.println(s[i]);
                addXmlWithBaseInfoElement("formdefinitionmodel", s[i], document, formDefinition, formId);
            } else {
                addXmlWithBaseInfoElement("formdefinitionmodel", s[i], document, formDefinition, formId);
            }
        }


        //添加进xml文件中
        setStructXml(formDefinition.getCategory_id(), formId, document, false);
        return document;
    }

    /*
     * 删除属性list
     * */
    private static Document removeXmlWithAttributeElement(Document document, List<Attribute> attributeList) throws GlobalException {
        //属性集合节点
        Element attributeItems = document.getElementsByTag("attributeItems").first();
        //判断属性是否存在
        for (Attribute attribute : attributeList) {
            Element element = attributeItems.getElementById(attribute.getId());
            if (element == null)
                throw new GlobalException(HttpStatus.INTERNAL_SERVER_ERROR, attribute.getCaption() + "属性不存在于XML中，删除失败");
            element.remove();
        }
        //更新单表单的xml
        return document;
    }

    /*
     * 删除属性
     * */
    private static Document removeXmlWithSingleAttributeElement(Document document, Attribute attribute, String formId) throws GlobalException, IOException, TransformerConfigurationException {

        //属性集合节点
        Element attributeItems = document.getElementsByTag("attributeItems").first();
        Element element = attributeItems.getElementById(attribute.getId());

        if (element == null)
            throw new GlobalException(HttpStatus.INTERNAL_SERVER_ERROR, "属性不存在于xml中，删除失败");
        element.remove();

        //更新单表单的xml
        setStructXml(attribute.getCategory_id(), formId, document, false);
        return document;
    }


    public static Attribute createAttribute() {
        //添加属性
        Attribute attribute1 = new Attribute();
        attribute1.setId("2a6603aa-85df-4be1-885d-f81149900fd6");
        attribute1.setSystem(false);
        attribute1.setCategory_id("2a6603aa-85df-4be1-885d-f81149900fd6");
        attribute1.setSystem(false);
        attribute1.setDisplay(false);
        attribute1.setRequired(false);
        attribute1.setSort(1);
        attribute1.setType("this is attribute1 --------- type");
        attribute1.setName("this is attribute1 name");
        attribute1.setDefault_value("this is attribute1 default_value");
        attribute1.setComponent_type("this is attribute1 component_type");
        attribute1.setCaption("this is attribute1 caption");
        return attribute1;
    }

    public static FormDefinition createFormDefinition() {
        //添加属性
        FormDefinition formDefinition = new FormDefinition();
        formDefinition.setId("bca42273-25c9-4dcd-bb37-e72afcaebc07");
        formDefinition.setCreate_time(System.currentTimeMillis());
        formDefinition.setCategory_id("2a6603aa-85df-4be1-885d-f81149900fd6");
        formDefinition.setCreate_account("admin2");
        formDefinition.isSingle();
        return formDefinition;
    }

    /*
     * 解析xml文件得到Document对象
     */
    public static String getDocument(File file) throws IOException {

        StringBuilder stringBuilder = new StringBuilder();
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        return stringBuilder.toString();
    }


    /*
     * 将document 更新到xml文件中
     * */
    private static void setStructXml(String categoryId, String id, Document document, boolean mkdir) throws GlobalException, TransformerConfigurationException, IOException {

        getDir(categoryId, mkdir);
        File structure = getFileByType(categoryId, id, "structure");
        FileWriter fileWriter = new FileWriter(structure);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(document.toString());
        bufferedWriter.close();
        System.out.println("File writing completed.");
    }
    /*
     * 将写入到xml文件
     * */


    /**
     * 获取文件目录地址,不存在则创建
     *
     * @param dirName 目录名称
     * @param mkdir   不存在是否创建文件夹
     * @return 目录地址
     * @throws GlobalException
     */
    private static File getDir(String dirName, boolean mkdir) throws GlobalException {
        String path = FORM_DEFINITION_INSTANCE_PATH + "/" + dirName;
        File file = new File(path);
        //表单分类目录不存在
        if (!file.exists()) {
            if (!mkdir) throw new GlobalException(HttpStatus.INTERNAL_SERVER_ERROR, "无效的目录地址");
            file.mkdir();
        }
        return file;
    }


    /**
     * 获取文件：
     *
     * @param categoryId
     * @param formId
     * @param supportDevice pc/mobile/structure
     * @return
     * @throws GlobalException
     */
    private static File getFileByType(String categoryId, String formId, String supportDevice) throws GlobalException {
        String path = FORM_DEFINITION_INSTANCE_PATH + "/" + categoryId + "/" + formId;
        switch (supportDevice) {
            case "pc":
            case "1":
            case "_design.json":
                path += DESIGN_PC_POSTFIX;
                break;
            case "mobile":
            case "2":
            case "_design_m.json":
                path += DESIGN_MOBILE_POSTFIX;
                break;
            case "structure":
            case "_structure.xml":
                path += STRUCTURE_POSTFIX;
                break;
            default:
                throw new GlobalException(HttpStatus.INTERNAL_SERVER_ERROR, "无效的模板类型:" + supportDevice);
        }
        return new File(path);
    }
}
