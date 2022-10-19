package com.amei.knowledge.lru;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheDemo2 {

    class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        //构造一个Node节点，作为数据载体
        public Node() {
            this.prev = this.next = null;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }
    }

    // 构造一个双向队列，里面存放Node
    public class DoubleLinkedList<K, V> {
        Node<K, V> head;
        Node<K, V> tail;

        public DoubleLinkedList() {
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.prev = head;
        }

        //添加头节点
        public void addHead(Node<K, V> node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        //删除节点
        public void deleteNode(Node<K, V> node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }

        //获取最后一个节点
        public Node getLast() {
            return tail.prev;
        }
    }


    private int cacheSize;
    Map<Integer, Node<Integer, Integer>> map;
    DoubleLinkedList<Integer, Integer> doubleLinkedList;

    public LRUCacheDemo2(int cacheSize) {
        this.cacheSize = cacheSize;
        map = new HashMap<>();
        doubleLinkedList = new DoubleLinkedList<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node<Integer, Integer> node = map.get(key);
        doubleLinkedList.deleteNode(node);
        doubleLinkedList.addHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node<Integer, Integer> node = map.get(key);
            node.value = value;
            map.put(key, node);
            doubleLinkedList.deleteNode(node);
            doubleLinkedList.addHead(node);
        } else {
            if (map.size() == cacheSize) {
                Node last = doubleLinkedList.getLast();
                map.remove(last.key);
                doubleLinkedList.deleteNode(last);
            }
            //做新增操作
            Node<Integer, Integer> integerIntegerNode = new Node<>(key, value);
            map.put(key, integerIntegerNode);
            doubleLinkedList.addHead(integerIntegerNode);
        }
    }

    public static void main(String[] args) {
        LRUCacheDemo2 lruCacheDemo = new LRUCacheDemo2(3);
        lruCacheDemo.put(1, 1);
        lruCacheDemo.put(2, 2);
        lruCacheDemo.put(3, 3);
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.put(4, 4);
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.put(3, 3);
        lruCacheDemo.put(3, 3);
        lruCacheDemo.put(3, 3);
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.put(5, 5);
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.put(6, 6);
        System.out.println(lruCacheDemo.map.keySet());
    }
}
