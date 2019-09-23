/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.vision;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 * Add your docs here.
 */
public abstract class Vision_BaseCommand extends InstantCommand {
    /**
     * Add your docs here.
     */
    protected Vision vision;

    public Vision_BaseCommand(Vision vision) {
        super();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(vision);
        this.vision = vision;
    }

    // Called once when the command executes
    @Override
    protected abstract void initialize();

}
