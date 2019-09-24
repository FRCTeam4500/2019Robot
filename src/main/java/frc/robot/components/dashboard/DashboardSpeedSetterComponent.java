/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.components.dashboard;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;
import frc.robot.components.ISpeedSetter;

/**
 * Add your docs here.
 */
public class DashboardSpeedSetterComponent extends DashboardComponent implements ISpeedSetter {

    private double speed;

    public DashboardSpeedSetterComponent(String name, String subsystem) {
        super(name + " " + "Speed Setter Component", subsystem);
    }

    @Override
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        builder.setSmartDashboardType(BuiltInWidgets.kNumberBar.getWidgetName());
        builder.addDoubleProperty("Value", () -> speed, null);
    }
}
