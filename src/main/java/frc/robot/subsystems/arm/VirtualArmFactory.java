/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.arm;

import frc.robot.components.dashboard.AngleSetterDashboardDecorator;
import frc.robot.components.virtual.VirtualAngleComponent;

/**
 * Add your docs here.
 */
public class VirtualArmFactory {
    public static Arm MakeArm() {
        return new Arm(new AngleSetterDashboardDecorator("Virtual Motor", "Arm",
                new VirtualAngleComponent()));
    }
}