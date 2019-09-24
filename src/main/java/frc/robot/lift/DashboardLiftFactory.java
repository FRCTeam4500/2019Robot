/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.lift;

import frc.robot.components.dashboard.DashboardDoubleSolenoidComponent;

/**
 * Add your docs here.
 */
public class DashboardLiftFactory {
    public static Lift MakeLift() {
        return new Lift(new DashboardDoubleSolenoidComponent("Front", "Lift"),
                new DashboardDoubleSolenoidComponent("Middle", "Lift"),
                new DashboardDoubleSolenoidComponent("Back", "Lift"));
    }
}
