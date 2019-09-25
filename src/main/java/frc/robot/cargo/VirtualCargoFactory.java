/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.cargo;

import frc.robot.components.dashboard.SpeedSetterDashboardDecorator;
import frc.robot.components.virtual.VirtualSpeedComponent;

/**
 * Add your docs here.
 */
public class VirtualCargoFactory {
    public static Cargo MakeCargo() {
        return new Cargo(
                new SpeedSetterDashboardDecorator("Virtual Left Grab", "Cargo",
                        new VirtualSpeedComponent()),
                new SpeedSetterDashboardDecorator("Virtual Top Grab", "Cargo",
                        new VirtualSpeedComponent()),
                new SpeedSetterDashboardDecorator("Virtual Right Grab", "Cargo",
                        new VirtualSpeedComponent()));
    }
}
