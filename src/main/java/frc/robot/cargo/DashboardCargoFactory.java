/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.cargo;

import frc.robot.components.dashboard.DashboardSpeedSetterComponent;

/**
 * Add your docs here.
 */
public class DashboardCargoFactory {
    public static Cargo MakeCargo() {
        return new Cargo(new DashboardSpeedSetterComponent("Left Grab", "Cargo"),
                new DashboardSpeedSetterComponent("Top Grab", "Cargo"),
                new DashboardSpeedSetterComponent("Right Grab", "Cargo"));
    }
}
