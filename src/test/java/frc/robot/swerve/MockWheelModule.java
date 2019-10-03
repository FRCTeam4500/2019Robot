/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.swerve;

import frc.robot.subsystems.swerve.WheelModule;

/**
 * Add your docs here.
 */
public class MockWheelModule extends WheelModule {
    private double lastSetSpeed, lastSetAngle;

    public MockWheelModule() {
        super(null, null);
    }

    @Override
    public void drive(double angle, double speed) {
        lastSetSpeed = speed;
        lastSetAngle = angle;
    }

    public double getLastSetSpeed() {
        return lastSetSpeed;
    }

    /**
     * @return the lastSetAngle
     */
    public double getLastSetAngle() {
        return lastSetAngle;
    }
}
