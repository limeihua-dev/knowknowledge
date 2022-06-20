package com.amei.knowledge.设计模式.迭代器模式;


import java.util.Iterator;

public class BookShelf implements Aggregate {

    private int last;

    private Book[] books;

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }

    public int getLength() {
        return last;
    }

    public Book getBookAt(int index) {
        return books[index];
    }

    public void appendBook(Book book) {
        this.books[last] = book;
        last++;
    }
}
