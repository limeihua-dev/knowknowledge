package com.amei.knowledge.javaDemo.file;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class writeFile {
    /**
     * 写入文件，更新JSON信息，文件不存在则自动创建
     *
     * @param categoryId 分类ID
     * @param id         表单模版ID
     * @param designJson 表单结构体JSON
     * @return
     */
    private void writeDesignJson(String categoryId, String id, List designJson) throws com.amei.knowledge.exception.GlobalException, IOException {
        //如果没有，则创建文件夹 /ns/basic_model/form/分类ID
//        String dir = this.getDir(categoryId).getPath();
//        File file = this.getFileByType(categoryId, id);
        File file = new File("");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            ObjectMapper objectMapper = new ObjectMapper();
            String string = objectMapper.writeValueAsString(designJson);
//            String string = JSON.toJSONString(designJson);
            fos.write(string.getBytes());
        } catch (FileNotFoundException e) {
            throw new com.amei.knowledge.exception.GlobalException(HttpStatus.NOT_FOUND, "模板文件不存在");
        } catch (IOException e) {
            throw new com.amei.knowledge.exception.GlobalException(HttpStatus.INTERNAL_SERVER_ERROR, "模板文件写入失败");
        } finally {
            if (fos != null) {
                fos.close();
            }
        }
    }
}
