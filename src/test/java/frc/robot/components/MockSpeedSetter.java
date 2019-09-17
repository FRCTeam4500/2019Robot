package frc.robot.components;

import frc.robot.components.ISpeedSetter;

public class MockSpeedSetter implements ISpeedSetter {

    private double speed;

    public double getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(double speed) {
        this.speed = speed;
    }

}
