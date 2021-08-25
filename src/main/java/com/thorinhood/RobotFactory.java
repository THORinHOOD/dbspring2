package com.thorinhood;

import com.thorinhood.annotations.InjectByType;
import lombok.SneakyThrows;

import java.lang.reflect.Field;

public class RobotFactory {

    private final ObjectFactory objectFactory;

    public RobotFactory(ObjectFactory objectFactory) {
        this.objectFactory = objectFactory;
    }

    @SneakyThrows
    public <ROBOT> ROBOT createRobot(Class<ROBOT> robotClass) {
        ROBOT robot = robotClass.getDeclaredConstructor().newInstance();
        Field[] fields = robotClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectByType.class)) {
                field.setAccessible(true);
                field.set(robot, objectFactory.createObject(field.getType()));
                field.setAccessible(false);
            }
        }
        return robot;
    }

}
