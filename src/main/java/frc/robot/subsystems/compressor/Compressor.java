/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.compressor;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.components.ICompressor;

/**
 * Add your docs here.
 */
public class Compressor extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private ICompressor compressor;

    public Compressor(ICompressor compressor) {
        this.compressor = compressor;
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    public void start() {
        compressor.start();
    }

    public void stop() {
        compressor.stop();
    }

    public void toggle() {
        compressor.toggle();
    }
}
