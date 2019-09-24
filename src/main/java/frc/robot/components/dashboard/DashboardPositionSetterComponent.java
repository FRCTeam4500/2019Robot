/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.components.dashboard;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;
import frc.robot.components.IPositionSetter;

/**
 * Add your docs here.
 */
public class DashboardPositionSetterComponent extends DashboardComponent
        implements IPositionSetter {
    protected double position;

    public DashboardPositionSetterComponent(String name, String subsystem) {
        super(name + " " + "Position Setter Component", subsystem);
    }

    @Override
    public void setPosition(double position) {
        this.position = position;
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        builder.setSmartDashboardType(BuiltInWidgets.kNumberBar.getWidgetName());
        builder.addDoubleProperty("Position", () -> position, null);
    }

}
