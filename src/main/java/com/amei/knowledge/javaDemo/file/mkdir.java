package com.amei.knowledge.javaDemo.file;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//创建文件夹//生成xml文件
public class mkdir {

    /**
     * 根据文件路径 查看文件，如果文件所在目录不存在，则创建目录
     * 目录存在，则创建这个文件
     * ----->  目的是创建文件夹，或者创建文件，不会覆盖文件
     *
     * @param filePath 文件路径
     */
    public static void fileExist(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            File dir = new File(filePath.substring(0, filePath.lastIndexOf("/")));

            try {
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                file.createNewFile();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    static final String FORM_DEFINITION_PATH = "src/main/resources/basic_model/form";
    static final String FORM_DEFINITION_TEMPLATE_PATH = "src/main/resources/basic_model/form/template";
    static final String DESIGN_PC_POSTFIX = "_design.json";
    static final String DESIGN_MOBILE_POSTFIX = "_design_m.json";
    static final String STRUCTURE_POSTFIX = "_structure.xml";

    public static void main(String[] args) throws Exception {

        //创建表单分类目录
        File form = new File(FORM_DEFINITION_PATH);
        File template = new File(FORM_DEFINITION_TEMPLATE_PATH);
        //创建目录
        if (!form.exists()) {
            if (!template.mkdirs())
                System.out.println(("创建form目录创建失败完成"));
        } else {
            //删除TEMPLATE目录外所有目录
            for (File file : form.listFiles()) {
                if (!file.getName().equals("template") && !file.getName().equals("18e3879a-49ca-4164-be00-68d0d8fd7927")) {
                    if (file.isDirectory()) {
                        try {
                            FileUtils.deleteDirectory(file);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        file.delete();
                    }
                }
            }
            //删除模板文件外所有文件
            for (File file : template.listFiles()) {
                if (file.getName().equals(STRUCTURE_POSTFIX) || file.getName().equals(DESIGN_MOBILE_POSTFIX) || file.getName().equals(DESIGN_PC_POSTFIX)) {
                    continue;
                }
                if (file.isDirectory()) {
                    try {
                        FileUtils.deleteDirectory(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    file.delete();
                }
            }
        }


        //创建XML模板文件
        String xmlPath = template.getPath() + "/" + STRUCTURE_POSTFIX;
        File xml = new File(xmlPath);
        if (!xml.exists()) {
            createTemplateFile(xmlPath, structureXML);
        }

    }


    /**
     * 获取文件目录地址,不存在则创建
     *
     * @param dirName 目录名称
     * @return 目录地址
     */
    private File getDir(String dirName) throws com.amei.knowledge.exception.GlobalException {
        String path = "/form/" + dirName;
        File file = new File(path.replace("/", File.separator));
        file.mkdirs();
        return file;
    }

    /**
     * 获取文件：
     *
     * @param categoryId
     * @param id
     * @return
     */
    private File getFileByType(String categoryId, String id) throws com.amei.knowledge.exception.GlobalException {
        String path = "/form/" + categoryId + "/" + id;
        return new File(path.replace("/", File.separator));
    }

    public static boolean createTemplateFile(String dir, String text) throws Exception {
        Document document = null;
        try {
            document = DocumentHelper.parseText(text);
        } catch (DocumentException e) {
            e.printStackTrace();
            System.out.println(("DOM异常：xml不符合要求"));
        }
        //写入文件
        try {

            FileWriter fileWriter = new FileWriter(dir);
            OutputFormat format = OutputFormat.createPrettyPrint();
            org.dom4j.io.XMLWriter writer = new org.dom4j.io.XMLWriter(fileWriter, format);
            writer.write(document);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(("IO异常"));
        }
        return true;
    }


    static String structureXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
            "<!-- 基础模型 - 表单定义模型 -->\n" +
            "<formDefinitionModel>\n" +
            "    <!-- 表单定义ID -->\n" +
            "    <id>id</id>\n" +
            "    <!-- 表单名称 -->\n" +
            "    <caption>caption</caption>\n" +
            "    <!-- 表单分类ID 注意： 表单定义分类指定后系统不支持更换分类 -->\n" +
            "    <categoryId>categoryId</categoryId>\n" +
            "    <categoryName>categoryName</categoryName>\n" +
            "    <!-- 是否为单表 -->\n" +
            "    <!-- 1 为单表模式 0 为主子表模式 -->\n" +
            "    <isSingle>single</isSingle>\n" +
            "    <!-- 表单创建人 -->\n" +
            "    <createAccount>admin</createAccount>\n" +
            "    <!-- 表单创建时间 -->\n" +
            "    <createTime>1615540152778</createTime>\n" +
            "    \n" +
            "    <!-- 表单属性集合 -->\n" +
            "    <attributeItems>\n" +
            "        <!-- 属性ID 示例 1 -->\n" +
            "        <attribute id=\"8b326463-20e8-4b7e-bcf1-ca9f8ee6ef1f\">\n" +
            "            <!-- 属性英文标识符 -->\n" +
            "            <name>user_mobile</name>\n" +
            "            <!-- 属性中文标识符 -->\n" +
            "            <caption>手机号码</caption>\n" +
            "            <!-- 属性类别 -->\n" +
            "            <type>text</type>\n" +
            "            <!-- 属性默认值 -->\n" +
            "            <default></default>\n" +
            "            <!-- 属性排序 -->\n" +
            "            <sort>10</sort>\n" +
            "            <!-- 是否必填 1 是 0 否-->\n" +
            "            <require>1</require>\n" +
            "            <!-- 是否隐藏 1 是 0 否-->\n" +
            "            <hidden>0</hidden>\n" +
            "            <!-- 是否为系统内置属性 -->\n" +
            "            <system>0</system>\n" +
            "            <!-- 属性类型配置json信息 -->\n" +
            "            <!-- 不同类型属性 配置json结构不同，此处不一一例举 -->\n" +
            "            <config></config>\n" +
            "        </attribute>\n" +
            "        <!-- 属性ID 示例 2 -->\n" +
            "        <attribute id=\"5919026b-224d-4e77-aa01-b08454192f5a\">\n" +
            "            <name>user_email</name>\n" +
            "            <caption>用户邮箱</caption>\n" +
            "            <type>text</type>\n" +
            "            <default></default>\n" +
            "            <sort>20</sort>\n" +
            "            <require>1</require>\n" +
            "            <hidden>0</hidden>\n" +
            "            <system>0</system>\n" +
            "            <config></config>\n" +
            "        </attribute>\n" +
            "    </attributeItems>\n" +
            "\n" +
            "    <!-- 表单属性规则配置 -->\n" +
            "    <attributeRuleConfig>\n" +
            "        <!-- 隐藏属性集合 -->\n" +
            "        <invisibleRuleList>\n" +
            "            <attribute id=\"8b326463-20e8-4b7e-bcf1-ca9f8ee6ef1f\" />\n" +
            "            <attribute id=\"5919026b-224d-4e77-aa01-b08454192f5a\" />\n" +
            "        </invisibleRuleList>\n" +
            "\n" +
            "        <!-- 属性校验规则 -->\n" +
            "        <!-- 属性校验规则 系统内置常见规则 如 手机号码、邮箱、身份证号、组织信用代码等 -->\n" +
            "        <verificationRuleList>\n" +
            "            <attribute id=\"8b326463-20e8-4b7e-bcf1-ca9f8ee6ef1f\" checkType=\"mobile\" />\n" +
            "            <attribute id=\"5919026b-224d-4e77-aa01-b08454192f5a\" checkType=\"email\" />\n" +
            "        </verificationRuleList>\n" +
            "\n" +
            "        <!-- 修改规则 -->\n" +
            "        <modifyRuleList></modifyRuleList>\n" +
            "\n" +
            "        <!-- 必填规则 -->\n" +
            "        <requireRuleList></requireRuleList>\n" +
            "\n" +
            "        <!-- 属性自动计算规则 此处集成规则引擎执行计算 -->\n" +
            "        <computedAttrRuleList>\n" +
            "            <attribute id=\"8b326463-20e8-4b7e-bcf1-ca9f8ee6ef1f\" ruleGroupId=\"规则组ID-1\" />\n" +
            "            <attribute id=\"5919026b-224d-4e77-aa01-b08454192f5a\" ruleGroupId=\"规则组ID-2\" />\n" +
            "        </computedAttrRuleList>\n" +
            "\n" +
            "        <!-- 表单字段权限控制 业务模型中 单独生成配置XML -->\n" +
            "    </attributeRuleConfig>\n" +
            "\n" +
            "    <!-- 子表（明细）表配置信息 -->\n" +
            "    <!-- 该标签 仅在 isSingle值为0 时（主子表模式）存在 -->\n" +
            "    <detailFormItems>\n" +
            "        <detailForm id=\"子表1 ID\" caption=\"子表1 名称\" >\n" +
            "            <!-- 子表-1 明细表单属性集合 -->\n" +
            "            <attributeItems>\n" +
            "                <!-- 属性ID 示例 1 -->\n" +
            "                <attribute id=\"8b326463-20e8-4b7e-bcf1-ca9f8ee6ef1f\">\n" +
            "                    <!-- 属性英文标识符 -->\n" +
            "                    <name>user_mobile</name>\n" +
            "                    <!-- 属性中文标识符 -->\n" +
            "                    <caption>手机号码</caption>\n" +
            "                    <!-- 属性类别 -->\n" +
            "                    <type>text</type>\n" +
            "                    <!-- 属性默认值 -->\n" +
            "                    <default></default>\n" +
            "                    <!-- 属性排序 -->\n" +
            "                    <sort>10</sort>\n" +
            "                    <!-- 是否必填 1 是 0 否-->\n" +
            "                    <require>1</require>\n" +
            "                    <!-- 是否隐藏 1 是 0 否-->\n" +
            "                    <hidden>0</hidden>\n" +
            "                    <!-- 是否为系统内置属性 -->\n" +
            "                    <system>0</system>\n" +
            "                    <!-- 属性类型配置json信息 -->\n" +
            "                    <config></config>\n" +
            "                </attribute>\n" +
            "                <!-- 属性ID 示例 2 -->\n" +
            "                <attribute id=\"5919026b-224d-4e77-aa01-b08454192f5a\">\n" +
            "                    <!-- 属性英文标识符 -->\n" +
            "                    <name>user_email</name>\n" +
            "                    <!-- 属性中文标识符 -->\n" +
            "                    <caption>用户邮箱</caption>\n" +
            "                    <!-- 属性类别 -->\n" +
            "                    <type>text</type>\n" +
            "                    <!-- 属性默认值 -->\n" +
            "                    <default></default>\n" +
            "                    <!-- 属性排序 -->\n" +
            "                    <sort>20</sort>\n" +
            "                    <!-- 是否必填 1 是 0 否-->\n" +
            "                    <require>1</require>\n" +
            "                    <!-- 是否隐藏 1 是 0 否-->\n" +
            "                    <hidden>0</hidden>\n" +
            "                    <!-- 是否为系统内置属性 -->\n" +
            "                    <system>0</system>\n" +
            "                    <!-- 属性类型配置json信息 -->\n" +
            "                    <config></config>\n" +
            "                </attribute>\n" +
            "            </attributeItems>\n" +
            "            <!-- 子表-1 明细表单属性规则配置 -->\n" +
            "            <attributeRuleConfig>\n" +
            "                <!-- 隐藏属性集合 -->\n" +
            "                <invisibleRuleList>\n" +
            "                    <attribute id=\"8b326463-20e8-4b7e-bcf1-ca9f8ee6ef1f\" />\n" +
            "                    <attribute id=\"5919026b-224d-4e77-aa01-b08454192f5a\" />\n" +
            "                </invisibleRuleList>\n" +
            "\n" +
            "                <!-- 属性校验规则 -->\n" +
            "                <!-- 属性校验规则 系统内置常见规则 如 手机号码、邮箱、身份证号、组织信用代码等 -->\n" +
            "                <verificationRuleList>\n" +
            "                    <attribute id=\"8b326463-20e8-4b7e-bcf1-ca9f8ee6ef1f\" checkType=\"mobile\" />\n" +
            "                    <attribute id=\"5919026b-224d-4e77-aa01-b08454192f5a\" checkType=\"email\" />\n" +
            "                </verificationRuleList>\n" +
            "\n" +
            "                <!-- 修改规则 -->\n" +
            "                <modifyRuleList></modifyRuleList>\n" +
            "\n" +
            "                <!-- 必填规则 -->\n" +
            "                <requireRuleList></requireRuleList>\n" +
            "\n" +
            "                <!-- 属性自动计算规则 此处集成规则引擎执行计算 -->\n" +
            "                <computedAttrRuleList>\n" +
            "                    <attribute id=\"8b326463-20e8-4b7e-bcf1-ca9f8ee6ef1f\" ruleGroupId=\"规则组ID-1\" />\n" +
            "                    <attribute id=\"5919026b-224d-4e77-aa01-b08454192f5a\" ruleGroupId=\"规则组ID-2\" />\n" +
            "                </computedAttrRuleList>\n" +
            "\n" +
            "                <!-- 表单字段权限控制 业务模型中 单独生成配置XML -->\n" +
            "            </attributeRuleConfig>\n" +
            "        </detailForm>\n" +
            "        <detailForm id=\"子表2 ID\" caption=\"子表2 名称\">\n" +
            "            ...\n" +
            "        </detailForm>\n" +
            "    </detailFormItems>\n" +
            "    \n" +
            "</formDefinitionModel>";


}
