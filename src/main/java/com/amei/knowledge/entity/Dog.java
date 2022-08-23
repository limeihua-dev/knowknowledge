package com.amei.knowledge.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Dog {
    public long age;
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
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
