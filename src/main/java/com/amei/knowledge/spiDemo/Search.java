package com.amei.knowledge.spiDemo;

import java.util.List;

/**
 * 内容搜索接口 ，基于文件搜索或基于数据库搜索
 */
public interface Search {
    public List<String> searchDoc(String keyWord);
}
