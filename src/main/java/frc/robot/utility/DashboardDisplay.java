/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.utility;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.automation.Automation_xAlign;
import frc.robot.automation.Automation_zAlign;

/**
 * This class should contain all the code for displaying information to the Shuffleboard
 */
public class DashboardDisplay {

    /**
     * Contains the calls to SmartDashboard that are for putting information onto the Shuffleboard
     */
    public static void displayText() {
        SmartDashboard.putNumber("gyro", Robot.swerve.getGyro());
        SmartDashboard.putNumber("Elevator Position",
                Robot.elevator.getElevatorMotor().getSelectedSensorPosition());
        SmartDashboard.putNumber("Elevator Position from Subsystem",
                Robot.elevator.getElevatorPosition());
        SmartDashboard.putNumber("Elevator Error",
                Robot.elevator.getElevatorMotor().getClosedLoopError());
        SmartDashboard.putNumber("ArmPosition", Robot.arm.getArmPosition());
        SmartDashboard.putNumber("ArmVelocity", Robot.arm.getArmVelocity());
        SmartDashboard.putNumber("ArmError", Robot.arm.getArmError());

        SmartDashboard.putNumber("TranslationalX", Robot.vision.getTranslationalX());
        SmartDashboard.putNumber("TranslationalY", Robot.vision.getTranslationalY());
        SmartDashboard.putNumber("TranslationalZ", Robot.vision.getTranslationalZ());
        SmartDashboard.putNumber("TranslationalPitch", Robot.vision.getTranslationalPitch());
        SmartDashboard.putNumber("TranslationalYaw", Robot.vision.getTranslationalYaw());
        SmartDashboard.putNumber("TranslationalRoll", Robot.vision.getTranslationalRoll());
    }

    /**
     * Contains any code that involves the Shuffleboard and needs to be run once (such as
     * initializers)
     */
    public static void initRun() {
        SmartDashboard.putData(new Automation_xAlign());
        SmartDashboard.putData(new Automation_zAlign());
    }
}
