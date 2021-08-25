package com.thorinhood;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        RobotFactory robotFactory = new RobotFactory(new ObjectFactory());
        IRobot iRobot = robotFactory.createRobot(IRobot.class);
        iRobot.cleanRoom();
    }
}
