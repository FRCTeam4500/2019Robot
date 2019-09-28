/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class PneumaticsCompressor extends Subsystem {

    Compressor compress = new Compressor(RobotMap.COMPRESSOR);

    public PneumaticsCompressor() {
        startCompressor();
    }

    public void initDefaultCommand() {
        // setDefaultCommand(new MySpecialCommand());
    }

    public void startCompressor() {
        compress.start();
    }

    public void stopCompressor() {
        compress.stop();
    }
}
