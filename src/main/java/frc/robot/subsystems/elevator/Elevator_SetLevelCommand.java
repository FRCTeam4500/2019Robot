/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.elevator;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 * Add your docs here.
 */
public class Elevator_SetLevelCommand extends InstantCommand {
    /**
     * Add your docs here.
     */
    private Elevator elevator;
    private int level;

    public Elevator_SetLevelCommand(Elevator elevator, int level) {
        super();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(elevator);
        this.elevator = elevator;
        this.level = level;
    }

    // Called once when the command executes
    @Override
    protected void initialize() {
        elevator.setLevel(level);
    }

}
