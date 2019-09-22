/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.compressor;

/**
 * Add your docs here.
 */
public class Compressor_ToggleCommand extends Compressor_BaseCommand {

    public Compressor_ToggleCommand(Compressor compressor) {
        super(compressor);
    }

    @Override
    protected void initialize() {
        compressor.toggle();
    }
}
