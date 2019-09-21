/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.components.dashboard;

import frc.robot.components.ISpeedSetter;

/**
 * Add your docs here.
 */
public class DashboardSpeedSetterComponent extends DashboardComponent implements ISpeedSetter {

    public DashboardSpeedSetterComponent(String name) {
        super(name + " " + "Speed");
    }

    @Override
    public void setSpeed(double speed) {
        putNumber(speed);
    }
}
