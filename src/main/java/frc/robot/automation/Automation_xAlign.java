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

public class Automation_xAlign extends Command {

    private int errorSum = 0;

    public Automation_xAlign() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.swerve);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        setTimeout(3);

        // ??? setDriveEncPos

        double[] data = Robot.vision.getCenter();
        double XCM =
                ((data[0] - (RobotMap.imgW / 2)) * RobotMap.cameraHeight) / RobotMap.focalLength;
        double xTick =
                (XCM / (Math.PI * RobotMap.wheelDiameterCM)) * RobotMap.driveTicksPerRotation;

        Robot.swerve.setDrivePosition(xTick);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        double moduleError = Robot.swerve.getBR().getDriveError();
        errorSum += moduleError;
        boolean conditionA = errorSum > 0 && Math.abs(moduleError) < 5;
        boolean conditionB = this.isTimedOut();
        return conditionA || conditionB;
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
