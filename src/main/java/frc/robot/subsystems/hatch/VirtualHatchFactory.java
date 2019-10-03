/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.hatch;

import frc.robot.components.dashboard.DoubleSolenoidDashboardDecorator;
import frc.robot.components.virtual.VirtualDoubleSolenoidComponent;

/**
 * Add your docs here.
 */
public class VirtualHatchFactory {
    public static Hatch MakeHatch() {
        return new Hatch(
                new DoubleSolenoidDashboardDecorator("Virtual Nail", "Hatch",
                        new VirtualDoubleSolenoidComponent()),
                new DoubleSolenoidDashboardDecorator("Virtual Panel", "Hatch",
                        new VirtualDoubleSolenoidComponent()),
                new DoubleSolenoidDashboardDecorator("Virtual Claw", "Hatch",
                        new VirtualDoubleSolenoidComponent()));
    }
}
