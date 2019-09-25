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
public class SpeedSetterDashboardDecorator extends DashboardDecorator implements ISpeedSetter {

    private double lastSetSpeed;
    private ISpeedSetter setter;

    public SpeedSetterDashboardDecorator(String name, String subsystem, ISpeedSetter setter) {
        super(name, subsystem);
        this.setter = setter;
    }

    @Override
    public void setSpeed(double speed) {
        lastSetSpeed = speed;
        setter.setSpeed(speed);
    }

    public double getLastSetSpeed() {
        return lastSetSpeed;
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        builder.setSmartDashboardType(BuiltInWidgets.kSpeedController.getWidgetName());
        builder.addDoubleProperty("Value", this::getLastSetSpeed, null);
    }
}
