package com.amei.knowledge.设计模式.迭代器模式;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf();
        bookShelf.appendBook(new Book("a"));
        bookShelf.appendBook(new Book("b"));
        bookShelf.appendBook(new Book("c"));
        Iterator iterator = bookShelf.iterator();
        while (iterator.hasNext()) {
            Book next = (Book) iterator.next();
            System.out.println(next.getName());
        }
    }
}
