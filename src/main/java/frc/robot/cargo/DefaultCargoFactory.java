/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.cargo;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import frc.robot.RobotMap;
import frc.robot.components.hardware.TalonSRXComponent;
import frc.robot.components.hardware.VictorSPXComponent;

/**
 * Add your docs here.
 */
public class DefaultCargoFactory {
    public static Cargo MakeCargo() {
        var leftGrab = new VictorSPXComponent(RobotMap.LEFT_GRAB);
        var rightGrab = new VictorSPXComponent(RobotMap.RIGHT_GRAB);
        var topGrab = new TalonSRXComponent(RobotMap.TOP_GRAB);

        leftGrab.setNeutralMode(NeutralMode.Brake);
        rightGrab.setNeutralMode(NeutralMode.Brake);
        topGrab.setNeutralMode(NeutralMode.Brake);

        return new Cargo(leftGrab, topGrab, rightGrab);
    }
}
