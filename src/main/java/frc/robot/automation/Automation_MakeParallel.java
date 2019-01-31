/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.automation;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Automation_MakeParallel extends Command {
  
  public Automation_MakeParallel() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.swerve);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Controllers.ultrasonicAlignmentController.reset();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double output = Controllers.ultrasonicAlignmentController.getPIDOutput(0);
    Robot.swerve.calculateVectors(0, 0, output);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Controllers.ultrasonicAlignmentController.targetReached(0);
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
