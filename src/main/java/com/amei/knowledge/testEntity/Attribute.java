package com.amei.knowledge.testEntity;

import lombok.Data;
import java.util.Map;

/**
 * 本体 - 属性实体模型
 */
@Data
public class Attribute {
    //属性ID
    private String id;
    //分类ID
    private String category_id;
    private String name;
    //属性中文名称
    private String caption;
    //属性类型
    private String type;
    //默认值
    private String default_value;
    //字段排序
    private int sort;
    //是否必填
    private boolean required;
    //是否隐藏
    //<!--是否显示数据（读操作） 用户可自行配置-->
    private boolean display;
    //是否为系统内置 1 是 -1 否
    private boolean system;
    //业务类型
    private String business_type;
    //是否允许用户传入该值
    private boolean support_insert;
    //是否<!--是否支持客户端编辑--><!--用户不可编辑属性执行自动过滤逻辑-->
    private boolean support_edit;

    //客户端组件类型
    private String component_type;
    //客户端组件配置
    private Map<String, Object> component_config;
    //校验规则
    private Map<String, Object> verification_rule;
    //计算规则
    private Map<String, Object> computed_rule;
    //显示规则
    private Map<String, Object> display_rule;
    //修改规则
    private Map<String, Object> update_rule;

    //创建时间
    private long create_time;
    //创建人员
    private String create_account;
}
