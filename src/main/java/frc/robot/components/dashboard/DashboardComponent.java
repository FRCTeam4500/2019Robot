/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.components.dashboard;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Add your docs here.
 */
public abstract class DashboardComponent {
    private String name;

    public DashboardComponent(String name) {
        this.name = name;
    }

    protected void putNumber(double value) {
        SmartDashboard.putNumber(name, value);
    }

    protected void putString(String value) {
        SmartDashboard.putString(name, value);
    }

    protected void putBoolean(boolean value) {
        SmartDashboard.putBoolean(name, value);
    }
}
