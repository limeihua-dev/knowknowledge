package com.amei.knowledge.javaDemo.file;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class DeleteDir {
    public static void main(String[] args) {
//        deleteDir();
        deleteFile();
    }

    /**
     * 递归删除某目录   FileUtils.deleteDirectory(new File(filePath));
     *     <dependency>
     *             <groupId>commons-io</groupId>
     *             <artifactId>commons-io</artifactId>
     *             <version>2.6</version>
     *         </dependency>
     */
    public static void deleteDir(){
        String filePath =System.getProperties().getProperty("user.home") + File.separator + "ns"
                + File.separator + "business_model" + File.separator+"123123"+File.separator+"form";
        try{
            FileUtils.deleteDirectory(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void deleteFile(){
        String filePath =System.getProperties().getProperty("user.home")+ File.separator + "ns"
                + File.separator + "business_model" + File.separator+"123123"+File.separator+"form"+File.separator+"8c145bc4-b8bb-4aab-b8a0-5ab9f0ab4997_config.xml";
        System.out.println(filePath);
        try{
            File file = new File(filePath);
            if(file.delete()){
                System.out.println(file.getName() + " 文件已被删除！");
            }else{
                System.out.println("文件删除失败！");
            }
        }catch(Exception e){
            e.printStackTrace();
        }


    }

}
