package com.amei.knowledge.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class Dog {
    public long age;
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getObjectAddress() {
        return super.toString();
    }

    public static void main(String[] args) throws NoSuchFieldException {
        Field name = Dog.class.getDeclaredField("name");
        log.info("getDeclaredField: ", name.getName());
    }
}
