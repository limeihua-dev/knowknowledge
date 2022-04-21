package com.amei.knowledge.javaDemo.file;

import com.fasterxml.jackson.core.JsonParseException;
import org.springframework.http.HttpStatus;

import java.io.*;
public class readFile {

    static  String s = "/Library/Java/JavaVirtualMachines/jdk1.8.0_281.jdk/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=63977:/Applications/IntelliJ IDEA.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Library/Java/JavaVirtualMachines/jdk1.8.0_281.jdk/Contents/Home/jre/lib/charsets.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_281.jdk/Contents/Home/jre/lib/deploy.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_281.jdk/Contents/Home/jre/lib/ext/cldrdata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_281.jdk/Contents/Home/jre/lib/ext/dnsns.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_281.jdk/Contents/Home/jre/lib/ext/jaccess.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_281.jdk/Contents/Home/jre/lib/ext/jfxrt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_281.jdk/Contents/Home/jre/lib/ext/localedata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_281.jdk/Contents/Home/jre/lib/ext/nashorn.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_281.jdk/Contents/Home/jre/lib/ext/sunec.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_281.jdk/Contents/Home/jre/lib/ext/sunjce_provider.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_281.jdk/Contents/Home/jre/lib/ext/sunpkcs11.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_281.jdk/Contents/Home/jre/lib/ext/zipfs.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_281.jdk/Contents/Home/jre/lib/javaws.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_281.jdk/Contents/Home/jre/lib/jce.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_281.jdk/Contents/Home/jre/lib/jfr.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_281.jdk/Contents/Home/jre/lib/jfxswt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_281.jdk/Contents/Home/jre/lib/jsse.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_281.jdk/Contents/Home/jre/lib/management-agent.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_281.jdk/Contents/Home/jre/lib/plugin.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_281.jdk/Contents/Home/jre/lib/resources.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_281.jdk/Contents/Home/jre/lib/rt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_281.jdk/Contents/Home/lib/ant-javafx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_281.jdk/Contents/Home/lib/dt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_281.jdk/Contents/Home/lib/javafx-mx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_281.jdk/Contents/Home/lib/jconsole.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_281.jdk/Contents/Home/lib/packager.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_281.jdk/Contents/Home/lib/sa-jdi.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_281.jdk/Contents/Home/lib/tools.jar:/Users/meihua/IdeaProjects/knowledge/target/classes:/Users/meihua/.m2/repository/org/springframework/boot/spring-boot-starter-web/2.3.6.RELEASE/spring-boot-starter-web-2.3.6.RELEASE.jar:/Users/meihua/.m2/repository/org/springframework/boot/spring-boot-starter/2.3.6.RELEASE/spring-boot-starter-2.3.6.RELEASE.jar:/Users/meihua/.m2/repository/org/springframework/boot/spring-boot/2.3.6.RELEASE/spring-boot-2.3.6.RELEASE.jar:/Users/meihua/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/2.3.6.RELEASE/spring-boot-autoconfigure-2.3.6.RELEASE.jar:/Users/meihua/.m2/repository/org/springframework/boot/spring-boot-starter-logging/2.3.6.RELEASE/spring-boot-starter-logging-2.3.6.RELEASE.jar:/Users/meihua/.m2/repository/ch/qos/logback/logback-classic/1.2.3/logback-classic-1.2.3.jar:/Users/meihua/.m2/repository/ch/qos/logback/logback-core/1.2.3/logback-core-1.2.3.jar:/Users/meihua/.m2/repository/org/apache/logging/log4j/log4j-to-slf4j/2.13.3/log4j-to-slf4j-2.13.3.jar:/Users/meihua/.m2/repository/org/apache/logging/log4j/log4j-api/2.13.3/log4j-api-2.13.3.jar:/Users/meihua/.m2/repository/org/slf4j/jul-to-slf4j/1.7.30/jul-to-slf4j-1.7.30.jar:/Users/meihua/.m2/repository/jakarta/annotation/jakarta.annotation-api/1.3.5/jakarta.annotation-api-1.3.5.jar:/Users/meihua/.m2/repository/org/yaml/snakeyaml/1.26/snakeyaml-1.26.jar:/Users/meihua/.m2/repository/org/springframework/boot/spring-boot-starter-json/2.3.6.RELEASE/spring-boot-starter-json-2.3.6.RELEASE.jar:/Users/meihua/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.11.3/jackson-databind-2.11.3.jar:/Users/meihua/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.11.3/jackson-annotations-2.11.3.jar:/Users/meihua/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.11.3/jackson-core-2.11.3.jar:/Users/meihua/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jdk8/2.11.3/jackson-datatype-jdk8-2.11.3.jar:/Users/meihua/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jsr310/2.11.3/jackson-datatype-jsr310-2.11.3.jar:/Users/meihua/.m2/repository/com/fasterxml/jackson/module/jackson-module-parameter-names/2.11.3/jackson-module-parameter-names-2.11.3.jar:/Users/meihua/.m2/repository/org/springframework/boot/spring-boot-starter-tomcat/2.3.6.RELEASE/spring-boot-starter-tomcat-2.3.6.RELEASE.jar:/Users/meihua/.m2/repository/org/apache/tomcat/embed/tomcat-embed-core/9.0.39/tomcat-embed-core-9.0.39.jar:/Users/meihua/.m2/repository/org/glassfish/jakarta.el/3.0.3/jakarta.el-3.0.3.jar:/Users/meihua/.m2/repository/org/apache/tomcat/embed/tomcat-embed-websocket/9.0.39/tomcat-embed-websocket-9.0.39.jar:/Users/meihua/.m2/repository/org/springframework/spring-web/5.2.11.RELEASE/spring-web-5.2.11.RELEASE.jar:/Users/meihua/.m2/repository/org/springframework/spring-beans/5.2.11.RELEASE/spring-beans-5.2.11.RELEASE.jar:/Users/meihua/.m2/repository/org/springframework/spring-webmvc/5.2.11.RELEASE/spring-webmvc-5.2.11.RELEASE.jar:/Users/meihua/.m2/repository/org/springframework/spring-context/5.2.11.RELEASE/spring-context-5.2.11.RELEASE.jar:/Users/meihua/.m2/repository/org/springframework/spring-expression/5.2.11.RELEASE/spring-expression-5.2.11.RELEASE.jar:/Users/meihua/.m2/repository/org/projectlombok/lombok/1.18.16/lombok-1.18.16.jar:/Users/meihua/.m2/repository/org/slf4j/slf4j-api/1.7.30/slf4j-api-1.7.30.jar:/Users/meihua/.m2/repository/org/springframework/spring-core/5.2.11.RELEASE/spring-core-5.2.11.RELEASE.jar:/Users/meihua/.m2/repository/org/springframework/spring-jcl/5.2.11.RELEASE/spring-jcl-5.2.11.RELEASE.jar:/Users/meihua/.m2/repository/org/springframework/boot/spring-boot-starter-data-mongodb/2.3.6.RELEASE/spring-boot-starter-data-mongodb-2.3.6.RELEASE.jar:/Users/meihua/.m2/repository/org/mongodb/mongodb-driver-sync/4.0.5/mongodb-driver-sync-4.0.5.jar:/Users/meihua/.m2/repository/org/mongodb/bson/4.0.5/bson-4.0.5.jar:/Users/meihua/.m2/repository/org/mongodb/mongodb-driver-core/4.0.5/mongodb-driver-core-4.0.5.jar:/Users/meihua/.m2/repository/org/springframework/data/spring-data-mongodb/3.0.5.RELEASE/spring-data-mongodb-3.0.5.RELEASE.jar:/Users/meihua/.m2/repository/org/springframework/spring-tx/5.2.11.RELEASE/spring-tx-5.2.11.RELEASE.jar:/Users/meihua/.m2/repository/org/springframework/data/spring-data-commons/2.3.5.RELEASE/spring-data-commons-2.3.5.RELEASE.jar:/Users/meihua/.m2/repository/org/dom4j/dom4j/2.1.3/dom4j-2.1.3.jar:/Users/meihua/.m2/repository/org/springframework/boot/spring-boot-starter-aop/2.3.6.RELEASE/spring-boot-starter-aop-2.3.6.RELEASE.jar:/Users/meihua/.m2/repository/org/springframework/spring-aop/5.2.11.RELEASE/spring-aop-5.2.11.RELEASE.jar:/Users/meihua/.m2/repository/org/aspectj/aspectjweaver/1.9.4/aspectjweaver-1.9.4.jar:/Users/meihua/.m2/repository/org/aspectj/aspectjrt/1.8.9/aspectjrt-1.8.9.jar:/Users/meihua/.m2/repository/com/alibaba/fastjson/1.2.58/fastjson-1.2.58.jar:/Users/meihua/.m2/repository/com/google/code/gson/gson/2.8.5/gson-2.8.5.jar:/Users/meihua/.m2/repository/org/jsoup/jsoup/1.12.1/jsoup-1.12.1.jar com.amei.knowledge.javaDemo.file.readFile\n" +
            "/Users/meihua\n" +
            "source path:/Users/meihua/IdeaProjects/knowledge/target/classes/\n" +
            "PATH=:/Users/meihua/IdeaProjects/knowledge/src/main/resources/basic_model/form/template/_structure.xml\n" +
            "-----------------\n" +
            "filePath:---->/Users/meihua/IdeaProjects/knowledge/src/main/resources/basic_model/form/template/_structure.xml\n" +
            "以字节为单位读取文件内容，一次读一个字节：\n" +
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "\n" +
            "<!-- 基础模型 - 表单定义模型 -->\n" +
            "<formDefinitionModel> \n" +
            "  <!-- 表单定义ID -->  \n" +
            "  <id>id</id>  \n" +
            "  <!-- 表单名称 -->  \n" +
            "  <caption>caption</caption>  \n" +
            "  <!-- 表单分类ID 注意： 表单定义分类指定后系统不支持更换分类 -->  \n" +
            "  <categoryId>categoryId</categoryId>  \n" +
            "  <categoryName>categoryName</categoryName>  \n" +
            "  <!-- 是否为单表 -->  \n" +
            "  <!-- 1 为单表模式 0 为主子表模式 -->  \n" +
            "  <isSingle>single</isSingle>  \n" +
            "  <!-- 表单创建人 -->  \n" +
            "  <createAccount>admin</createAccount>  \n" +
            "  <!-- 表单创建时间 -->  \n" +
            "  <createTime>1615540152778</createTime>  \n" +
            "  <!-- 表单属性集合 -->  \n" +
            "  <attributeItems> \n" +
            "    <!-- 属性ID 示例 1 -->  \n" +
            "    <attribute id=\"8b326463-20e8-4b7e-bcf1-ca9f8ee6ef1f\"> \n" +
            "      <!-- 属性英文标识符 -->  \n" +
            "      <name>user_mobile</name>  \n" +
            "      <!-- 属性中文标识符 -->  \n" +
            "      <caption>手机号码</caption>  \n" +
            "      <!-- 属性类别 -->  \n" +
            "      <type>text</type>  \n" +
            "      <!-- 属性默认值 -->  \n" +
            "      <default/>  \n" +
            "      <!-- 属性排序 -->  \n" +
            "      <sort>10</sort>  \n" +
            "      <!-- 是否必填 1 是 0 否-->  \n" +
            "      <require>1</require>  \n" +
            "      <!-- 是否隐藏 1 是 0 否-->  \n" +
            "      <hidden>0</hidden>  \n" +
            "      <!-- 是否为系统内置属性 -->  \n" +
            "      <system>0</system>  \n" +
            "      <!-- 属性类型配置json信息 -->  \n" +
            "      <!-- 不同类型属性 配置json结构不同，此处不一一例举 -->  \n" +
            "      <config/> \n" +
            "    </attribute>  \n" +
            "    <!-- 属性ID 示例 2 -->  \n" +
            "    <attribute id=\"5919026b-224d-4e77-aa01-b08454192f5a\"> \n" +
            "      <name>user_email</name>  \n" +
            "      <caption>用户邮箱</caption>  \n" +
            "      <type>text</type>  \n" +
            "      <default/>  \n" +
            "      <sort>20</sort>  \n" +
            "      <require>1</require>  \n" +
            "      <hidden>0</hidden>  \n" +
            "      <system>0</system>  \n" +
            "      <config/> \n" +
            "    </attribute> \n" +
            "  </attributeItems>  \n" +
            "  <!-- 表单属性规则配置 -->  \n" +
            "  <attributeRuleConfig> \n" +
            "    <!-- 隐藏属性集合 -->  \n" +
            "    <invisibleRuleList> \n" +
            "      <attribute id=\"8b326463-20e8-4b7e-bcf1-ca9f8ee6ef1f\"/>  \n" +
            "      <attribute id=\"5919026b-224d-4e77-aa01-b08454192f5a\"/> \n" +
            "    </invisibleRuleList>  \n" +
            "    <!-- 属性校验规则 -->  \n" +
            "    <!-- 属性校验规则 系统内置常见规则 如 手机号码、邮箱、身份证号、组织信用代码等 -->  \n" +
            "    <verificationRuleList> \n" +
            "      <attribute id=\"8b326463-20e8-4b7e-bcf1-ca9f8ee6ef1f\" checkType=\"mobile\"/>  \n" +
            "      <attribute id=\"5919026b-224d-4e77-aa01-b08454192f5a\" checkType=\"email\"/> \n" +
            "    </verificationRuleList>  \n" +
            "    <!-- 修改规则 -->  \n" +
            "    <modifyRuleList/>  \n" +
            "    <!-- 必填规则 -->  \n" +
            "    <requireRuleList/>  \n" +
            "    <!-- 属性自动计算规则 此处集成规则引擎执行计算 -->  \n" +
            "    <computedAttrRuleList> \n" +
            "      <attribute id=\"8b326463-20e8-4b7e-bcf1-ca9f8ee6ef1f\" ruleGroupId=\"规则组ID-1\"/>  \n" +
            "      <attribute id=\"5919026b-224d-4e77-aa01-b08454192f5a\" ruleGroupId=\"规则组ID-2\"/> \n" +
            "    </computedAttrRuleList>  \n" +
            "    <!-- 表单字段权限控制 业务模型中 单独生成配置XML --> \n" +
            "  </attributeRuleConfig>  \n" +
            "  <!-- 子表（明细）表配置信息 -->  \n" +
            "  <!-- 该标签 仅在 isSingle值为0 时（主子表模式）存在 -->  \n" +
            "  <detailFormItems> \n" +
            "    <detailForm id=\"子表1 ID\" caption=\"子表1 名称\"> \n" +
            "      <!-- 子表-1 明细表单属性集合 -->  \n" +
            "      <attributeItems> \n" +
            "        <!-- 属性ID 示例 1 -->  \n" +
            "        <attribute id=\"8b326463-20e8-4b7e-bcf1-ca9f8ee6ef1f\"> \n" +
            "          <!-- 属性英文标识符 -->  \n" +
            "          <name>user_mobile</name>  \n" +
            "          <!-- 属性中文标识符 -->  \n" +
            "          <caption>手机号码</caption>  \n" +
            "          <!-- 属性类别 -->  \n" +
            "          <type>text</type>  \n" +
            "          <!-- 属性默认值 -->  \n" +
            "          <default/>  \n" +
            "          <!-- 属性排序 -->  \n" +
            "          <sort>10</sort>  \n" +
            "          <!-- 是否必填 1 是 0 否-->  \n" +
            "          <require>1</require>  \n" +
            "          <!-- 是否隐藏 1 是 0 否-->  \n" +
            "          <hidden>0</hidden>  \n" +
            "          <!-- 是否为系统内置属性 -->  \n" +
            "          <system>0</system>  \n" +
            "          <!-- 属性类型配置json信息 -->  \n" +
            "          <config/> \n" +
            "        </attribute>  \n" +
            "        <!-- 属性ID 示例 2 -->  \n" +
            "        <attribute id=\"5919026b-224d-4e77-aa01-b08454192f5a\"> \n" +
            "          <!-- 属性英文标识符 -->  \n" +
            "          <name>user_email</name>  \n" +
            "          <!-- 属性中文标识符 -->  \n" +
            "          <caption>用户邮箱</caption>  \n" +
            "          <!-- 属性类别 -->  \n" +
            "          <type>text</type>  \n" +
            "          <!-- 属性默认值 -->  \n" +
            "          <default/>  \n" +
            "          <!-- 属性排序 -->  \n" +
            "          <sort>20</sort>  \n" +
            "          <!-- 是否必填 1 是 0 否-->  \n" +
            "          <require>1</require>  \n" +
            "          <!-- 是否隐藏 1 是 0 否-->  \n" +
            "          <hidden>0</hidden>  \n" +
            "          <!-- 是否为系统内置属性 -->  \n" +
            "          <system>0</system>  \n" +
            "          <!-- 属性类型配置json信息 -->  \n" +
            "          <config/> \n" +
            "        </attribute> \n" +
            "      </attributeItems>  \n" +
            "      <!-- 子表-1 明细表单属性规则配置 -->  \n" +
            "      <attributeRuleConfig> \n" +
            "        <!-- 隐藏属性集合 -->  \n" +
            "        <invisibleRuleList> \n" +
            "          <attribute id=\"8b326463-20e8-4b7e-bcf1-ca9f8ee6ef1f\"/>  \n" +
            "          <attribute id=\"5919026b-224d-4e77-aa01-b08454192f5a\"/> \n" +
            "        </invisibleRuleList>  \n" +
            "        <!-- 属性校验规则 -->  \n" +
            "        <!-- 属性校验规则 系统内置常见规则 如 手机号码、邮箱、身份证号、组织信用代码等 -->  \n" +
            "        <verificationRuleList> \n" +
            "          <attribute id=\"8b326463-20e8-4b7e-bcf1-ca9f8ee6ef1f\" checkType=\"mobile\"/>  \n" +
            "          <attribute id=\"5919026b-224d-4e77-aa01-b08454192f5a\" checkType=\"email\"/> \n" +
            "        </verificationRuleList>  \n" +
            "        <!-- 修改规则 -->  \n" +
            "        <modifyRuleList/>  \n" +
            "        <!-- 必填规则 -->  \n" +
            "        <requireRuleList/>  \n" +
            "        <!-- 属性自动计算规则 此处集成规则引擎执行计算 -->  \n" +
            "        <computedAttrRuleList> \n" +
            "          <attribute id=\"8b326463-20e8-4b7e-bcf1-ca9f8ee6ef1f\" ruleGroupId=\"规则组ID-1\"/>  \n" +
            "          <attribute id=\"5919026b-224d-4e77-aa01-b08454192f5a\" ruleGroupId=\"规则组ID-2\"/> \n" +
            "        </computedAttrRuleList>  \n" +
            "        <!-- 表单字段权限控制 业务模型中 单独生成配置XML --> \n" +
            "      </attributeRuleConfig> \n" +
            "    </detailForm>  \n" +
            "    <detailForm id=\"子表2 ID\" caption=\"子表2 名称\">...</detailForm> \n" +
            "  </detailFormItems> \n" +
            "</formDefinitionModel>\n" +
            "以字节为单位读取文件内容，一次读多个字节：\n" +
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "\n" +
            "<!-- 基础模型 - 表单定义模型 -->\n" +
            "<formDefinitionModel> \n" +
            "  <!-- 表单定义ID -->  \n" +
            "  <id>id</id>  \n" +
            "  <!-- 表单名称 -->  \n" +
            "  <caption>caption</caption>  \n" +
            "  <!-- 表单分类ID 注意： 表单定义分类指定后系统不支持更换分类 -->  \n" +
            "  <categoryId>categoryId</categoryId>  \n" +
            "  <categoryName>categoryName</categoryName>  \n" +
            "  <!-- 是否为单表 -->  \n" +
            "  <!-- 1 为单表模式 0 为主子表模式 -->  \n" +
            "  <isSingle>single</isSingle>  \n" +
            "  <!-- 表单创建人 -->  \n" +
            "  <createAccount>admin</createAccount>  \n" +
            "  <!-- 表单创建时间 -->  \n" +
            "  <createTime>1615540152778</createTime>  \n" +
            "  <!-- 表单属性集合 -->  \n" +
            "  <attributeItems> \n" +
            "    <!-- 属性ID 示例 1 -->  \n" +
            "    <attribute id=\"8b326463-20e8-4b7e-bcf1-ca9f8ee6ef1f\"> \n" +
            "      <!-- 属性英文标识符 -->  \n" +
            "      <name>user_mobile</name>  \n" +
            "      <!-- 属性中文标识符 -->  \n" +
            "      <caption>手机号码</caption>  \n" +
            "      <!-- 属性类别 -->  \n" +
            "      <type>text</type>  \n" +
            "      <!-- 属性默认值 -->  \n" +
            "      <default/>  \n" +
            "      <!-- 属性排序 -->  \n" +
            "      <sort>10</sort>  \n" +
            "      <!-- 是否必填 1 是 0 否-->  \n" +
            "      <require>1</require>  \n" +
            "      <!-- 是否隐藏 1 是 0 否-->  \n" +
            "      <hidden>0</hidden>  \n" +
            "      <!-- 是否为系统内置属性 -->  \n" +
            "      <system>0</system>  \n" +
            "      <!-- 属性类型配置json信息 -->  \n" +
            "      <!-- 不同类型属性 配置json结构不同，此处不一一例举 -->  \n" +
            "      <config/> \n" +
            "    </attribute>  \n" +
            "    <!-- 属性ID 示例 2 -->  \n" +
            "    <attribute id=\"5919026b-224d-4e77-aa01-b08454192f5a\"> \n" +
            "      <name>user_email</name>  \n" +
            "      <caption>用户邮箱</caption>  \n" +
            "      <type>text</type>  \n" +
            "      <default/>  \n" +
            "      <sort>20</sort>  \n" +
            "      <require>1</require>  \n" +
            "      <hidden>0</hidden>  \n" +
            "      <system>0</system>  \n" +
            "      <config/> \n" +
            "    </attribute> \n" +
            "  </attributeItems>  \n" +
            "  <!-- 表单属性规则配置 -->  \n" +
            "  <attributeRuleConfig> \n" +
            "    <!-- 隐藏属性集合 -->  \n" +
            "    <invisibleRuleList> \n" +
            "      <attribute id=\"8b326463-20e8-4b7e-bcf1-ca9f8ee6ef1f\"/>  \n" +
            "      <attribute id=\"5919026b-224d-4e77-aa01-b08454192f5a\"/> \n" +
            "    </invisibleRuleList>  \n" +
            "    <!-- 属性校验规则 -->  \n" +
            "    <!-- 属性校验规则 系统内置常见规则 如 手机号码、邮箱、身份证号、组织信用代码等 -->  \n" +
            "    <verificationRuleList> \n" +
            "      <attribute id=\"8b326463-20e8-4b7e-bcf1-ca9f8ee6ef1f\" checkType=\"mobile\"/>  \n" +
            "      <attribute id=\"5919026b-224d-4e77-aa01-b08454192f5a\" checkType=\"email\"/> \n" +
            "    </verificationRuleList>  \n" +
            "    <!-- 修改规则 -->  \n" +
            "    <modifyRuleList/>  \n" +
            "    <!-- 必填规则 -->  \n" +
            "    <requireRuleList/>  \n" +
            "    <!-- 属性自动计算规则 此处集成规则引擎执行计算 -->  \n" +
            "    <computedAttrRuleList> \n" +
            "      <attribute id=\"8b326463-20e8-4b7e-bcf1-ca9f8ee6ef1f\" ruleGroupId=\"规则组ID-1\"/>  \n" +
            "      <attribute id=\"5919026b-224d-4e77-aa01-b08454192f5a\" ruleGroupId=\"规则组ID-2\"/> \n" +
            "    </computedAttrRuleList>  \n" +
            "    <!-- 表单字段权限控制 业务模型中 单独生成配置XML --> \n" +
            "  </attributeRuleConfig>  \n" +
            "  <!-- 子表（明细）表配置信息 -->  \n" +
            "  <!-- 该标签 仅在 isSingle值为0 时（主子表模式）存在 -->  \n" +
            "  <detailFormItems> \n" +
            "    <detailForm id=\"子表1 ID\" caption=\"子表1 名称\"> \n" +
            "      <!-- 子表-1 明细表单属性集合 -->  \n" +
            "      <attributeItems> \n" +
            "        <!-- 属性ID 示例 1 -->  \n" +
            "        <attribute id=\"8b326463-20e8-4b7e-bcf1-ca9f8ee6ef1f\"> \n" +
            "          <!-- 属性英文标识符 -->  \n" +
            "          <name>user_mobile</name>  \n" +
            "          <!-- 属性中文标识符 -->  \n" +
            "          <caption>手机号码</caption>  \n" +
            "          <!-- 属性类别 -->  \n" +
            "          <type>text</type>  \n" +
            "          <!-- 属性默认值 -->  \n" +
            "          <default/>  \n" +
            "          <!-- 属性排序 -->  \n" +
            "          <sort>10</sort>  \n" +
            "          <!-- 是否必填 1 是 0 否-->  \n" +
            "          <require>1</require>  \n" +
            "          <!-- 是否隐藏 1 是 0 否-->  \n" +
            "          <hidden>0</hidden>  \n" +
            "          <!-- 是否为系统内置属性 -->  \n" +
            "          <system>0</system>  \n" +
            "          <!-- 属性类型配置json信息 -->  \n" +
            "          <config/> \n" +
            "        </attribute>  \n" +
            "        <!-- 属性ID 示例 2 -->  \n" +
            "        <attribute id=\"5919026b-224d-4e77-aa01-b08454192f5a\"> \n" +
            "          <!-- 属性英文标识符 -->  \n" +
            "          <name>user_email</name>  \n" +
            "          <!-- 属性中文标识符 -->  \n" +
            "          <caption>用户邮箱</caption>  \n" +
            "          <!-- 属性类别 -->  \n" +
            "          <type>text</type>  \n" +
            "          <!-- 属性默认值 -->  \n" +
            "          <default/>  \n" +
            "          <!-- 属性排序 -->  \n" +
            "          <sort>20</sort>  \n" +
            "          <!-- 是否必填 1 是 0 否-->  \n" +
            "          <require>1</require>  \n" +
            "          <!-- 是否隐藏 1 是 0 否-->  \n" +
            "          <hidden>0</hidden>  \n" +
            "          <!-- 是否为系统内置属性 -->  \n" +
            "          <system>0</system>  \n" +
            "          <!-- 属性类型配置json信息 -->  \n" +
            "          <config/> \n" +
            "        </attribute> \n" +
            "      </attributeItems>  \n" +
            "      <!-- 子表-1 明细表单属性规则配置 -->  \n" +
            "      <attributeRuleConfig> \n" +
            "        <!-- 隐藏属性集合 -->  \n" +
            "        <invisibleRuleList> \n" +
            "          <attribute id=\"8b326463-20e8-4b7e-bcf1-ca9f8ee6ef1f\"/>  \n" +
            "          <attribute id=\"5919026b-224d-4e77-aa01-b08454192f5a\"/> \n" +
            "        </invisibleRuleList>  \n" +
            "        <!-- 属性校验规则 -->  \n" +
            "        <!-- 属性校验规则 系统内置常见规则 如 手机号码、邮箱、身份证号、组织信用代码等 -->  \n" +
            "        <verificationRuleList> \n" +
            "          <attribute id=\"8b326463-20e8-4b7e-bcf1-ca9f8ee6ef1f\" checkType=\"mobile\"/>  \n" +
            "          <attribute id=\"5919026b-224d-4e77-aa01-b08454192f5a\" checkType=\"email\"/> \n" +
            "        </verificationRuleList>  \n" +
            "        <!-- 修改规则 -->  \n" +
            "        <modifyRuleList/>  \n" +
            "        <!-- 必填规则 -->  \n" +
            "        <requireRuleList/>  \n" +
            "        <!-- 属性自动计算规则 此处集成规则引擎执行计算 -->  \n" +
            "        <computedAttrRuleList> \n" +
            "          <attribute id=\"8b326463-20e8-4b7e-bcf1-ca9f8ee6ef1f\" ruleGroupId=\"规则组ID-1\"/>  \n" +
            "          <attribute id=\"5919026b-224d-4e77-aa01-b08454192f5a\" ruleGroupId=\"规则组ID-2\"/> \n" +
            "        </computedAttrRuleList>  \n" +
            "        <!-- 表单字段权限控制 业务模型中 单独生成配置XML --> \n" +
            "      </attributeRuleConfig> \n" +
            "    </detailForm>  \n" +
            "    <detailForm id=\"子表2 ID\" caption=\"子表2 名称\">...</detailForm> \n" +
            "  </detailFormItems> \n" +
            "</formDefinitionModel>\n" +
            "\n" +
            "Process finished with exit code 0\n";
    public static void main(String[] args) throws Exception {
        String xmlPath = getXMLPath();
        readTxtFileIntoStringArrList(xmlPath);
        printWriterMethod("src/main/resources/a.txt",s);
    }


    /**
     * 方法 3：使用 PrintWriter 写文件
     * @param filepath 文件目录
     * @param content  待写入内容
     * @throws IOException
     */
    public static void printWriterMethod(String filepath, String content) throws IOException {

        try (PrintWriter printWriter = new PrintWriter(new FileWriter(filepath))) {
            printWriter.print(content);
        }
    }
    /**
     * 功能：Java读取txt文件的内容 步骤：1：先获得文件句柄 2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取
     * 3：读取到输入流后，需要读取生成字节流 4：一行一行的输出。readline()。 备注：需要考虑的是异常情况
     *
     * @param filePath
     *            文件路径[到达文件:如： D:\aa.txt]
     * @return 将这个文件按照每一行切割成数组存放到list中。
     */
    public static void readTxtFileIntoStringArrList(String filePath) throws IOException {

        System.out.println("filePath:---->"+filePath);
        File file = new File(filePath);
        InputStream in = null;
        try {
            System.out.println("以字节为单位读取文件内容，一次读一个字节：");
            // 一次读一个字节
            in = new FileInputStream(file);
            int tempbyte;
            while ((tempbyte = in.read()) != -1) {
                System.out.write(tempbyte);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        try {
            System.out.println("以字节为单位读取文件内容，一次读多个字节：");
            // 一次读多个字节
            byte[] tempbytes = new byte[100];
            int byteread = 0;
            in = new FileInputStream(filePath);
//            ReadFromFile.showAvailableBytes(in);
            // 读入多个字节到字节数组中，byteread为一次读入的字节数
            while ((byteread = in.read(tempbytes)) != -1) {
                System.out.write(tempbytes, 0, byteread);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    //不同环境下找到跟路径
    private static String getXMLPath() throws Exception {
        String property = System.getProperties().getProperty("user.home");
        System.out.println(property);
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
        path += "src"+File.separator+"main"+File.separator+"resources" + File.separator + "basic_model" + File.separator + "form"+File.separator+"template"+File.separator+"_structure.xml";
        //path += File.separator + path;
        System.out.println("PATH=:" + path);
        System.out.println("-----------------");
        return path;
    }

    /**
     * 获取表单设计模板
     *
     * @param categoryId 分类ID
     * @param id         表单模版ID
     * @return
     */
    private String readDesignJson(String categoryId, String id) throws com.amei.knowledge.exception.GlobalException {
        //获取文件
//        File file = this.getFileByType(categoryId, id);
        File file = new File("");
        if (!file.exists()) {
            throw new com.amei.knowledge.exception.GlobalException(HttpStatus.INTERNAL_SERVER_ERROR, "该表单模板缺失JSON文件：" + id);
        }
        //读取xml     待修改为jsoup，jsoup直接解析有问题，搁置
        BufferedReader reader = null;
        String readJson = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                readJson += tempString;
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
            throw new com.amei.knowledge.exception.GlobalException(HttpStatus.NOT_FOUND, "该文件内容不符合Json结构");
        } catch (IOException e) {
            e.printStackTrace();
            throw new com.amei.knowledge.exception.GlobalException(HttpStatus.NOT_FOUND, "该资源不存在或已被删除");
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return readJson;
    }

}
