/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.components.dashboard;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;
import frc.robot.components.IAngleGetter;

/**
 * Add your docs here.
 */
public class DashboardAngleGetterComponent extends DashboardComponent implements IAngleGetter {
    protected double angle;

    public DashboardAngleGetterComponent(String name, String subsystem) {
        super(name + " " + "Angle Getter Component", subsystem);
    }

    @Override
    public double getAngle() {
        return angle;
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        builder.addDoubleProperty("RawValue", null, value -> angle = value);
        builder.addDoubleProperty("Value", () -> angle * -180 / Math.PI, null);
        builder.setSmartDashboardType(BuiltInWidgets.kGyro.getWidgetName());
    }
}
