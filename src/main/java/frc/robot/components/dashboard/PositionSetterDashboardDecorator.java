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
public class PositionSetterDashboardDecorator extends DashboardDecorator
        implements IPositionSetter {
    private double lastSetPosition;
    private IPositionSetter setter;

    public PositionSetterDashboardDecorator(String name, String subsystem, IPositionSetter setter) {
        super(name, subsystem);
        this.setter = setter;
    }

    @Override
    public void setPosition(double position) {
        this.lastSetPosition = position;
        setter.setPosition(position);
    }

    public double getLastSetPosition() {
        return lastSetPosition;
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        builder.setSmartDashboardType(BuiltInWidgets.kNumberBar.getWidgetName());
        builder.addDoubleProperty("Value", this::getLastSetPosition, null);
    }

}
