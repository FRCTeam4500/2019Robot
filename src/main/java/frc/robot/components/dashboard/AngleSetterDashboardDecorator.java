/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.components.dashboard;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;
import frc.robot.components.IAngleSetter;

/**
 * Add your docs here.
 */
public class AngleSetterDashboardDecorator extends DashboardDecorator implements IAngleSetter {

    private double lastSetAngle = 0;
    private IAngleSetter setter;

    public AngleSetterDashboardDecorator(String name, String subsystem, IAngleSetter setter) {
        super(name + " " + "Angle Setter Component", subsystem);
        this.setter = setter;
    }

    @Override
    public void setAngle(double angle) {
        this.lastSetAngle = angle;
        setter.setAngle(angle);
    }

    public double getLastSetAngle() {
        return lastSetAngle;
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        builder.setSmartDashboardType(BuiltInWidgets.kGyro.getWidgetName());
        builder.addDoubleProperty("Value", () -> -Math.toDegrees(getLastSetAngle()), null);
    }
}
