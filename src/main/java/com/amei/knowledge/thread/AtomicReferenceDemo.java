package com.amei.knowledge.thread;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

@Getter
@ToString
@AllArgsConstructor
class User {
    String username;
    int age;
}
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        AtomicReference<User> objectAtomicReference = new AtomicReference<>();
        User zhangsan = new User("zhangsan", 22);
        User lisi = new User("lisi", 25);
        objectAtomicReference.set(zhangsan);
        System.out.println(objectAtomicReference.compareAndSet(zhangsan, lisi));
        System.out.println(objectAtomicReference.get().toString());
        System.out.println(objectAtomicReference.compareAndSet(zhangsan, lisi));
    }
    /**
     * 打印：
     * true
     * User(username=lisi, age=25)
     * false
     */
}
