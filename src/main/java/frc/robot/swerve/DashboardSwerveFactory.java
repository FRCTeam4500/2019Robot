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
                new WheelModule(new DashboardAngleSetterComponent("FL"),
                        new DashboardSpeedSetterComponent("FL")),
                new WheelModule(new DashboardAngleSetterComponent("FR"),
                        new DashboardSpeedSetterComponent("FR")),
                new WheelModule(new DashboardAngleSetterComponent("BL"),
                        new DashboardSpeedSetterComponent("BL")),
                new WheelModule(new DashboardAngleSetterComponent("BR"),
                        new DashboardSpeedSetterComponent("BR")),
                new DashboardAngleGetterComponent("Gyro"));
    }
}
