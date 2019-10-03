/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.cargo;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import frc.robot.RobotMap;
import frc.robot.components.dashboard.SpeedSetterDashboardDecorator;
import frc.robot.components.hardware.TalonSRXComponent;
import frc.robot.components.hardware.VictorSPXComponent;

/**
 * Add your docs here.
 */
public class DefaultCargoFactory {
    private static String subsystem = "Cargo";

    public static Cargo MakeCargo() {
        var leftGrab = new VictorSPXComponent(RobotMap.LEFT_GRAB);
        var rightGrab = new VictorSPXComponent(RobotMap.RIGHT_GRAB);
        var topGrab = new TalonSRXComponent(RobotMap.TOP_GRAB);

        leftGrab.setNeutralMode(NeutralMode.Brake);
        rightGrab.setNeutralMode(NeutralMode.Brake);
        topGrab.setNeutralMode(NeutralMode.Brake);

        var decoratedLeft = new SpeedSetterDashboardDecorator("Left", subsystem, leftGrab);
        var decoratedRight = new SpeedSetterDashboardDecorator("Right", subsystem, rightGrab);
        var decoratedTop = new SpeedSetterDashboardDecorator("Top", subsystem, topGrab);

        return new Cargo(decoratedLeft, decoratedTop, decoratedRight);
    }
}
