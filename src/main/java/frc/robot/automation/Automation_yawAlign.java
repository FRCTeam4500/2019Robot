/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.automation;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.pid.Controllers;

public class Automation_yawAlign extends Command {
    public Automation_yawAlign() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.swerve);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        Controllers.yawController.setP(Robot.yawTuner.getP());
        Controllers.yawController.setI(Robot.yawTuner.getI());
        Controllers.yawController.setD(Robot.yawTuner.getD());

        setTimeout(1000);
        Controllers.yawController.setSetpoint(90);
        Controllers.yawController.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        Controllers.yawController.setSetpoint(90);
        SmartDashboard.putNumber("yawError", Controllers.yawController.getError());
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        if (Controllers.yawController.onTarget() || isTimedOut()) {
            Controllers.yawController.disable();
            return true;
        }
        return false;
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
