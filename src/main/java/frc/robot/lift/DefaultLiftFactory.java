/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.lift;

import frc.robot.RobotMap;
import frc.robot.components.hardware.DoubleSolenoidComponent;

/**
 * Add your docs here.
 */
public class DefaultLiftFactory {
    public static Lift MakeLift() {
        var back = new DoubleSolenoidComponent(0, RobotMap.FRONT_LIFT_SOLENOID_FORWARD_CHANNEL,
                RobotMap.FRONT_LIFT_SOLENOID_REVERSE_CHANNEL);
        var front = new DoubleSolenoidComponent(0, RobotMap.BACK_LIFT_SOLENOID_FORWARD_CHANNEL,
                RobotMap.BACK_LIFT_SOLENOID_REVERSE_CHANNEL);
        var middle = new DoubleSolenoidComponent(1, RobotMap.MIDDLE_LIFT_SOLENOID_FORWARD_CHANNEL,
                RobotMap.MIDDLE_LIFT_SOLENOID_REVERSE_CHANNEL);
        return new Lift(front, middle, back);
    }
}
