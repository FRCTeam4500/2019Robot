/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.compressor;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 * Add your docs here.
 */
public abstract class Compressor_BaseCommand extends InstantCommand {
    /**
     * Add your docs here.
     */
    protected Compressor compressor;

    public Compressor_BaseCommand(Compressor compressor) {
        super();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(compressor);
        this.compressor = compressor;
    }

    // Called once when the command executes
    @Override
    protected abstract void initialize();

}
