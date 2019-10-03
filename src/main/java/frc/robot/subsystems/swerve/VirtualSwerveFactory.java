/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.swerve;

import frc.robot.components.dashboard.AngleSetterDashboardDecorator;
import frc.robot.components.dashboard.GyroDashboardDecorator;
import frc.robot.components.dashboard.SpeedSetterDashboardDecorator;
import frc.robot.components.virtual.VirtualAngleComponent;
import frc.robot.components.virtual.VirtualGyroComponent;
import frc.robot.components.virtual.VirtualSpeedComponent;

/**
 * Add your docs here.
 */
public class VirtualSwerveFactory {
    public static Swerve MakeSwerve() {
        return new Swerve(1, 1,
                new WheelModule(
                        new AngleSetterDashboardDecorator("FL Virtual Angle Motor", "Swerve",
                                new VirtualAngleComponent()),
                        new SpeedSetterDashboardDecorator("FL Virtual Speed Motor", "Swerve",
                                new VirtualSpeedComponent())),
                new WheelModule(
                        new AngleSetterDashboardDecorator("FR Virtual Angle Motor", "Swerve",
                                new VirtualAngleComponent()),
                        new SpeedSetterDashboardDecorator("FR Virtual Speed Motor", "Swerve",
                                new VirtualSpeedComponent())),
                new WheelModule(
                        new AngleSetterDashboardDecorator("BL Virtual Angle Motor", "Swerve",
                                new VirtualAngleComponent()),
                        new SpeedSetterDashboardDecorator("BL Virtual Speed Motor", "Swerve",
                                new VirtualSpeedComponent())),
                new WheelModule(
                        new AngleSetterDashboardDecorator("BR Virtual Angle Motor", "Swerve",
                                new VirtualAngleComponent()),
                        new SpeedSetterDashboardDecorator("BR Virtual Speed Motor", "Swerve",
                                new VirtualSpeedComponent())),
                new GyroDashboardDecorator("Virtual Gyro", "Swerve", new VirtualGyroComponent()));
    }
}
