/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.automation;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class Swerve_Controller extends Command {
    public Swerve_Controller() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.swerve);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double tX = Robot.vision.getTranslationalX();
        double tZ = Robot.vision.getTranslationalZ();
        double yaw = Robot.swerve.getYaw();

        double x = tX / RobotMap.transXMax;
        double y = tZ / RobotMap.transZMax;
        double z = Math.abs(yaw - RobotMap.targetYaw) / RobotMap.yawMax;

        Robot.swerve.calculateVectors(x, y, z);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        boolean conditionA = Robot.vision.getHypotenuse() <= 20;
        boolean conditionB = Math.abs(Robot.swerve.getYaw() - RobotMap.targetYaw) < 5;
        return conditionA && conditionB;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
