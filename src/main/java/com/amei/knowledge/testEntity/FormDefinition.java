package com.amei.knowledge.testEntity;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

/**
 * 基础模型 - 物 - 表单定义模型 - POJO
 */
@Data
@Document(collection = "form_definition")
public class FormDefinition {
    private String id;
    private String category_id;
    private String caption;
    //表单模式:是否为单表 否则为主子表
    private boolean single;
    //是否生成模板json文件 默认 false
    private boolean generate_desion_pc_json;
    //是否生成模板json文件 默认 false
    private boolean generate_desion_mobile_json;
    //支持终端设备 1 PC端 2 移动端 3 PC端 + 移动端
    private int support_device;
    //关联子表（明细表）ID集合
    private List<String> detail_form_id_list;
    private long create_time;
    private String create_account;
}
