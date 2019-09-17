package frc.robot.components;

import frc.robot.components.IAngleSetter;

public class MockAngleSetter implements IAngleSetter {

    private double angle;

    public double getAngle() {
        return angle;
    }

    @Override
    public void setAngle(double angle) {
        this.angle = angle;
    }

}
