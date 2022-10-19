package com.amei.knowledge.spiDemo;

import com.amei.knowledge.spiDemo.impl.DatabaseSearch;

import java.net.MalformedURLException;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, MalformedURLException {
//        Connection conn = DriverManager.getConnection(url,username,password);
//        Class<T>
//        ServiceLoader<Search> load = ServiceLoader.load(Search.class);
//        Iterator<Search> iterator = load.iterator();
//        while (iterator.hasNext()) {
//            Search next = iterator.next();
//            next.searchDoc("dd");
//        }
//        System.out.println(111);
//        System.out.println(ClassLoader.getSystemClassLoader().loadClass(DatabaseSearch.class.getName()).newInstance());
//        System.out.println(2222);
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(Class.forName(DatabaseSearch.class.getName(),true, classLoader));

//        String v1dir = "com.amei.knowledge.spiDemo.v1.Dep";
//        String v2dir = "com.amei.knowledge.spiDemo.v2.Dep";
//
//        URLClassLoader v1 = new URLClassLoader(new URL[]{new URL(v1dir)});
//        URLClassLoader v2 = new URLClassLoader(new URL[]{new URL(v2dir)});
//
//        Class<?> depv1Class = v1.loadClass("Dep");
//        Object depv1 = depv1Class.getConstructor().newInstance();
//        depv1Class.getMethod("print").invoke(depv1);
//
//        Class<?> depv2Class = v2.loadClass("Dep");
//        Object depv2 = depv2Class.getConstructor().newInstance();
//        depv2Class.getMethod("print").invoke(depv2);
//
//        System.out.println(depv1Class.equals(depv2Class));


    }


}
