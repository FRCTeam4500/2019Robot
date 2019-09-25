/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.components.dashboard;

import edu.wpi.first.wpilibj.SendableBase;

/**
 * Add your docs here.
 */
public abstract class DashboardDecorator extends SendableBase {

    public DashboardDecorator(String name, String subsystem) {
        setName(name);
        setSubsystem(subsystem);
    }
}
