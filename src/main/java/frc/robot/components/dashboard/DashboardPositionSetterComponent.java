/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.components.dashboard;

import frc.robot.components.IPositionSetter;

/**
 * Add your docs here.
 */
public class DashboardPositionSetterComponent extends DashboardComponent
        implements IPositionSetter {

    public DashboardPositionSetterComponent(String name) {
        super(name + " " + "Position");
    }

    @Override
    public void setPosition(double position) {
        putNumber(position);
    }

}
