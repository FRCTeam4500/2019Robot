/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.lift;

import frc.robot.components.dashboard.DoubleSolenoidDashboardDecorator;
import frc.robot.components.virtual.VirtualDoubleSolenoidComponent;

/**
 * Add your docs here.
 */
public class VirtualLiftFactory {
    public static Lift MakeLift() {
        return new Lift(
                new DoubleSolenoidDashboardDecorator("Virtual Front", "Lift",
                        new VirtualDoubleSolenoidComponent()),
                new DoubleSolenoidDashboardDecorator("Virtual Middle", "Lift",
                        new VirtualDoubleSolenoidComponent()),
                new DoubleSolenoidDashboardDecorator("Virtual Back", "Lift",
                        new VirtualDoubleSolenoidComponent()));
    }
}
