package com.amei.knowledge.utils;

import java.io.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * read(byte b[])  从该输入流中读取最多b.length个字节的数据，并存储到字节数组b中
 * 返回值：返回存储到字节数据b中的字节总数（≤b.length）或者当到达该文件的末尾时返回-1。
 */
public class FileUtils {

    private static String filePath = "/Users/meihua/DownLoads/studyTest/HelloWorld.txt";
    private static String jpgPath = "/Users/meihua/DownLoads/02";

    public static void main(String[] args) throws IOException {
        sort();
    }

    /**
     * 使用随机文件流类RandomAccessFile将一个文本文件倒置读出。
     * https://www.cnblogs.com/huanghanyu/p/13803396.html
     */
    public static void daoxu() {
//        File file = new File(filePath);
//        try {
//            RandomAccessFile raf = new RandomAccessFile(file, "r");
//            long length = raf.length();
//            StringBuffer stringBuffer = new StringBuffer();
//            while (length > 0) {
//                length--;
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    /**
     * 将所有文件夹/文件 按照名称进行排序
     */
    public static void sort() {
        String filePath = "/Users/meihua/DownLoads/studyTest/BOM模型";
        List<File> allFiles = getAllFiles(filePath);
        //按文件名称显示的顺序
        Collections.sort(allFiles, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        //遍历集合
        for (File file : allFiles) {
            System.out.println(file.getName());
        }
    }

    /**
     * 输入两个文件夹名称，将A文件夹内容全部拷贝到B文件夹，要求使用多线程来操作。
     */
    public static void copyDir() {
//        String formPath = "/Users/meihua/DownLoads/BOM模型";
//        String toPath = "/Users/meihua/DownLoads/studyTest";
        Scanner scanner = new Scanner(System.in);
        System.out.println("要复制的文件夹：");
        //接收输入
        String fromDir = scanner.next();
        System.out.println("要复制到哪里去：");
        String toDir = scanner.next();// 接收输入
        // 把输入的地址转化为File类型
        File fromFile = new File(fromDir);
        File toFile = new File(toDir);
        //新建线程
        // 判断如果要复制的是文件，直接复制就可以了
        if (fromFile.isFile()) {
            System.out.println("复制单个文件");
            copy(fromFile, toFile);
        } else {
            //防止要复制的文件复制到自己的子文件夹中，导致死循环。
            if (toDir.replace("/", "\\").toLowerCase().startsWith(fromDir.replace("/", "\\").toLowerCase())) {
                return;
            }
            //先获取该文件的所有文件
            List<File> allFiles = getAllFiles(fromDir);
            //创建线程池
            ExecutorService threadPool = Executors.newFixedThreadPool(20);
            //对每一个文件路径进行处理
            for (File file : allFiles) {
                String name = file.getAbsolutePath();
                //把原来的路径换成新的路径
                String toName = name.replace(fromFile.getParent(), toDir);
                System.out.println(name + "变成了" + toName);
                //如果是文件夹直接创建
                if (file.isDirectory()) {
                    new File(toName).mkdir();
                } else {
                    //如果是文件，在线程里面复制
                    threadPool.execute(new Runnable() {
                        @Override
                        public void run() {
                            File copyFile = new File(toName);
                            copyFile.getParentFile().mkdir();
                            //开始复制文件
                            copy(file, copyFile);
                        }
                    });
                }
            }
        }
        scanner.close();

    }

    /**
     * 拷贝图片
     */
    public static void copy(File formFile, File toFile) {
//        String formPath = "/Users/meihua/DownLoads/02.jpg";
//        String toPath = "/Users/meihua/DownLoads/studyTest/002.jpg";
//        File formFile = new File(formPath);
//        File toFile = new File(toPath);
        try {
            //创建文件
            if (!toFile.createNewFile()) {
                System.out.println("文件创建失败！");
            }
            //写入到文件
            FileInputStream fileInputStream = new FileInputStream(formFile);
            FileOutputStream fileOutputStream = new FileOutputStream(toFile);
            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = fileInputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, len);
            }
            //刷新输出流
            fileOutputStream.flush();
            fileOutputStream.close();
            System.out.println("文件复制成功！");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /**
     * 在电脑下创建一个文件为HelloWorld.txt文件，
     * 判断他是文件还是目录
     * 在创建一个目录IOTest,之后将HelloWorld.txt移动到IOTest目录下去；
     * 之后遍历IOTest这个目录下的文件
     */
    public static void createDocument() {
        //创建文件
        File file = new File("/Users/meihua/Downloads/", "HelloWorld.txt");
        File file3 = new File("/Users/meihua/Downloads/", "HelloWorld2.txt");
        boolean isCreate;
        try {
            isCreate = file.createNewFile();
            if (isCreate) {
                System.out.println("创建文件成功！");
            } else {
                System.out.println("文件创建失败！文件已经存在");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 判断他是文件还是目录，
        if (file.isFile()) {
            System.out.println("这是一个文件");
        } else {
            System.out.println("这是一个目录");
        }
        //创建文件夹
        File file2 = new File("/Users/meihua/Downloads/studyTest");
        file2.mkdir();
        //移动文件到文件夹
        if (file.renameTo(new File(file2.getAbsolutePath() + "/" + file3.getName()))) {
            System.out.println("文件移动成功");
        } else {
            System.out.println("文件移动失败");
        }
        String[] list = file2.list();
        /**
         * 遍历文件
         */
        for (String str : list) {
            System.out.println(str);
        }
    }

    /**
     * 向文件中写入内容
     */
    public static void FileOutStreamDemo() {
        File file = new File(filePath);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            //把String类型的字符串转化为byte数组的数据保存在输出流中
            fos.write("hello,又是元气满满的一天！".getBytes());
            //刷新输出流
            fos.flush();
            //关闭输出流
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 从磁盘读取一个文件到内存中，再打印到控制台
     */
    public static void FileInputSteamDemo() throws IOException {
        try {
            File file = new File("/Users/meihua/DownLoads/星际制造科研平台接口对接文档.docx");
            FileInputStream fileInputStream = new FileInputStream(file);
            // FileInputStream fileInputStream = new FileInputStream(new File(new String(filePath.getBytes(StandardCharsets.UTF_8), Charset.defaultCharset())));
            int len = 0;
            byte[] bytes = new byte[1024];
            StringBuffer stringBuffer = new StringBuffer();
            // 把读取的数据添加到StringBuffer里面
            while ((len = fileInputStream.read(bytes)) != -1) {
                String str = new String(bytes, 0, len);
                stringBuffer.append(str);
            }
            //打印stringBuffer中的内容
            System.out.println(stringBuffer);
            fileInputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 递归实现列出当前工程下所有.java文件
     */
    public static void getAllFile3() {
        //先获取所有文件
        List<File> allFiles = getAllFiles("/Users/meihua/DownLoads");
        //输出.java后缀的文件
        for (File file : allFiles) {
            if (file.toString().endsWith(".java")) {
                System.out.println(file.getName());
            }
        }
    }

    /**
     * 获取文件夹下所有文件
     */
    public static List<File> getAllFiles(String dir) {
        ArrayList<File> fileList = new ArrayList<>();
        //判断文件夹是否存在
        File file = new File(dir);
        if (file.exists() && file.isDirectory()) {
            //递归遍历里面的所有文件
            longErgodic(file, fileList);
        }
        for (File file3 : fileList) {
            System.out.println(file3.getName());
        }
        return fileList;
    }

    /**
     * 递归查询当前文件夹下的所有文件
     *
     * @param file
     * @param fileList
     */
    private static void longErgodic(File file, List<File> fileList) {
        //获取文件夹的所有文件包括文件夹
        File[] files = file.listFiles();
        if (files != null) {
            for (File file2 : files) {
                if (!file2.isDirectory()) {
                    fileList.add(file2);
                } else {
                    longErgodic(file2, fileList);
                }
            }
        }
    }


}
