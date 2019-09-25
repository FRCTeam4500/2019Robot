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
public class AngleGetterDashboardDecorator extends DashboardDecorator implements IAngleGetter {
    private IAngleGetter getter;

    public AngleGetterDashboardDecorator(String name, String subsystem, IAngleGetter getter) {
        super(name, subsystem);
        this.getter = getter;
    }

    @Override
    public double getAngle() {
        return getter.getAngle();
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        builder.addDoubleProperty("Value", () -> -Math.toDegrees(getAngle()), null);
        builder.setSmartDashboardType(BuiltInWidgets.kGyro.getWidgetName());
    }
}
