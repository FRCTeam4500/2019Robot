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

public class Automation_zAlign extends Command {
    public Automation_zAlign() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.swerve);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        Controllers.zController.setP(Robot.zTuner.getP());
        Controllers.zController.setI(Robot.zTuner.getI());
        Controllers.zController.setD(Robot.zTuner.getD());

        setTimeout(5);
        Controllers.zController.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        Controllers.zController.setSetpoint(0);
        SmartDashboard.putNumber("zError", Controllers.xController.getError());

    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        if (Controllers.zController.onTarget() || isTimedOut()) {
            Controllers.zController.disable();
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
