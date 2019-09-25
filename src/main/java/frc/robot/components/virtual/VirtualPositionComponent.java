/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.components.virtual;

import frc.robot.components.IPositionSetter;

/**
 * Add your docs here.
 */
public class VirtualPositionComponent implements IPositionSetter {

    private double position;

    public double getPosition() {
        return position;
    }

    @Override
    public void setPosition(double position) {
        this.position = position;
    }
}
