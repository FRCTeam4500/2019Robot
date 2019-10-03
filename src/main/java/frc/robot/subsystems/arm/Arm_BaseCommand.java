/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.arm;

import edu.wpi.first.wpilibj.command.Command;

public abstract class Arm_BaseCommand extends Command {
    protected Arm arm;

    public Arm_BaseCommand(Arm arm) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(arm);
        this.arm = arm;
    }

    // Called just before this Command runs the first time
    @Override
    protected abstract void initialize();

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected abstract void execute();

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected abstract boolean isFinished();

    // Called once after isFinished returns true
    @Override
    protected abstract void end();

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected abstract void interrupted();
}
