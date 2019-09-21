/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.swerve;

import frc.robot.components.dashboard.DashboardAngleGetterComponent;
import frc.robot.components.dashboard.DashboardAngleSetterComponent;
import frc.robot.components.dashboard.DashboardSpeedSetterComponent;

/**
 * Add your docs here.
 */
public class DashboardSwerveFactory {
    public static Swerve MakeSwerve() {
        return new Swerve(1, 1,
                new WheelModule(new DashboardAngleSetterComponent("Swerve FL"),
                        new DashboardSpeedSetterComponent("Swerve FL")),
                new WheelModule(new DashboardAngleSetterComponent("Swerve FR"),
                        new DashboardSpeedSetterComponent("Swerve FR")),
                new WheelModule(new DashboardAngleSetterComponent("Swerve BL"),
                        new DashboardSpeedSetterComponent("Swerve BL")),
                new WheelModule(new DashboardAngleSetterComponent("Swerve BR"),
                        new DashboardSpeedSetterComponent("Swerve BR")),
                new DashboardAngleGetterComponent("Swerve Gyro"));
    }
}
