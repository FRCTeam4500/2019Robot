/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.lift;

import edu.wpi.first.wpilibj.command.Command;

public abstract class Lift_BaseCommand extends Command {
    protected Lift lift;

    public Lift_BaseCommand(Lift lift) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(lift);
        this.lift = lift;
    }

    // Called just before this Command runs the first time
    @Override
    protected abstract void initialize();

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
