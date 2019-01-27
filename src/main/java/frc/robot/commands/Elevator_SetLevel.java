package frc.robot.commands;

import frc.robot.subsystems.Elevator;

public class Elevator_SetLevel extends Elevator_BaseCommand {
    int level;
    public Elevator_SetLevel(Elevator elevator, int level) {
        // Use requires() here to declare subsystem dependencies
        super(elevator);
        this.level = level;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        super.elevator.setLevel(level);
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