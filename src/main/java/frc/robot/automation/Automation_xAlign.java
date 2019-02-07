/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.automation;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class Automation_xAlign extends Command {

  private double xTicks;
  
  public Automation_xAlign() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.swerve);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Controllers.xAlignmentController.reset();

    double[] data = Robot.vision.getCenter();
    double Z = (Robot.swerve.getLeftSonic() + Robot.swerve.getRightSonic()) / 2;
    double X = Z * ((data[0] - RobotMap.imgCenterW) / RobotMap.focalLength);
    this.xTicks = X * (RobotMap.ticksPerRotation / (Math.PI * RobotMap.wheelDiameterMM));
    System.out.println("X: " + X);
    System.out.println("XTicks: " + xTicks);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double output = Controllers.xAlignmentController.getPIDOutput(this.xTicks);
    Robot.swerve.setSpeed(output);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Controllers.xAlignmentController.targetReached(this.xTicks);
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
