/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.cargo;

import edu.wpi.first.wpilibj.command.Command;

public class Cargo_DriveCommand extends Command {
    private Cargo cargo;
    private ICargoOI oi;

    public Cargo_DriveCommand(Cargo cargo, ICargoOI oi) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(cargo);
        this.cargo = cargo;
        this.oi = oi;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        cargo.setMotors(oi.getCargoSideSpeed(), oi.getCargoTopSpeed());
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
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
