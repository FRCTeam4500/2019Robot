/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.automation;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Automation_DriveSwerve extends Command {
    private double x,y,z;
  public Automation_DriveSwerve(double x, double y, double z) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.swerve);
    this.x = x;
    this.y = y;
    this.z = z;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
      Robot.swerve.calculateVectors(x, y, z);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
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
