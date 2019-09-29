/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.swerve;

import frc.robot.components.dashboard.AngleGetterDashboardDecorator;
import frc.robot.components.dashboard.AngleSetterDashboardDecorator;
import frc.robot.components.dashboard.GyroDashboardDecorator;
import frc.robot.components.dashboard.SpeedSetterDashboardDecorator;
import frc.robot.components.virtual.VirtualGyroComponent;
import frc.robot.components.virtual.VirtualPIDAngleComponent;
import frc.robot.components.virtual.VirtualSpeedComponent;
import frc.robot.utility.PIDValues;

/**
 * Add your docs here.
 */
public class VirtualPIDSwerveFactory {
    private static String subsystem = "Swerve";

    public static Swerve MakeSwerve() {
        return new Swerve(1, 1, MakeWheelModule("FL"), MakeWheelModule("FR"), MakeWheelModule("BL"),
                MakeWheelModule("BR"),
                new GyroDashboardDecorator("Gyro", subsystem, new VirtualGyroComponent()));
    }

    private static WheelModule MakeWheelModule(String wheelModule) {
        var motor = new VirtualPIDAngleComponent(new PIDValues(0.1, 0, 0, 0));
        var getter = new AngleGetterDashboardDecorator(wheelModule + " Virtual PID Actual Angle",
                subsystem, motor);
        var angleSetter = new AngleSetterDashboardDecorator(
                wheelModule + " Virtual PID Angle Setter", subsystem, motor);
        var speedSetter = new SpeedSetterDashboardDecorator(wheelModule + " Virtual Speed Setter",
                subsystem, new VirtualSpeedComponent());

        return new DashboardWheelModule(wheelModule, angleSetter, speedSetter, getter);
    }
}
