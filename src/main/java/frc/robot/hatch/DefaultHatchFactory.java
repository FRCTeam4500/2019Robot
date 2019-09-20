/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.hatch;

import frc.robot.RobotMap;
import frc.robot.components.DoubleSolenoidComponent;

/**
 * Add your docs here.
 */
public class DefaultHatchFactory {
    public static Hatch MakeHatch() {
        var panelPiston =
                new DoubleSolenoidComponent(0, RobotMap.HATCH_PANEL_SOLENOID_FORWARD_CHANNEL,
                        RobotMap.HATCH_PANEL_SOLENOID_REVERSE_CHANNEL);
        var nailPiston =
                new DoubleSolenoidComponent(0, RobotMap.HATCH_NAIL_SOLENOID_FORWARD_CHANNEL,
                        RobotMap.HATCH_NAIL_SOLENOID_REVERSE_CHANNEL);
        var clawPiston =
                new DoubleSolenoidComponent(1, RobotMap.HATCH_CLAW_SOLENOID_FORWARD_CHANNEL,
                        RobotMap.HATCH_CLAW_SOLENOID_REVERSE_CHANNEL);

        return new Hatch(nailPiston, panelPiston, clawPiston);
    }
}
