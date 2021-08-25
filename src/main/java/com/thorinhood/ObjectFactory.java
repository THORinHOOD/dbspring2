package com.thorinhood;

import com.thorinhood.annotations.InjectRandomInt;
import lombok.Getter;
import lombok.SneakyThrows;

import java.lang.reflect.Field;

/**
 * @author Evgeny Borisov
 */
public class ObjectFactory {

    @Getter
    private static ObjectFactory instance = new ObjectFactory();
    private Config config = new JavaConfig();

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        if (type.isInterface()) {
            type = config.getImplClass(type);
        }

        T t = type.getDeclaredConstructor().newInstance();

        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectRandomInt.class)) {
                InjectRandomInt injectRandomInt = field.getAnnotation(InjectRandomInt.class);
                field.setAccessible(true);
                field.set(t, Utils.randomInRange(injectRandomInt.min(), injectRandomInt.max()));
                field.setAccessible(false);
            }
        }

        return t;
    }



}
