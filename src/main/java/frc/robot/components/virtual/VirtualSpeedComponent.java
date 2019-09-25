/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.components.virtual;

import frc.robot.components.ISpeedSetter;

/**
 * Add your docs here.
 */
public class VirtualSpeedComponent implements ISpeedSetter {

    private double speed;

    public double getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(double speed) {
        // TODO Auto-generated method stub

    }
}
