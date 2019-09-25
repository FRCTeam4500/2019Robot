/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.components.virtual;

import frc.robot.components.ICompressor;

/**
 * Add your docs here.
 */
public class VirtualCompressorComponent implements ICompressor {
    private boolean isEnabled;

    @Override
    public void start() {
        isEnabled = true;
    }

    @Override
    public void stop() {
        isEnabled = false;
    }

    @Override
    public boolean enabled() {
        return isEnabled;
    }
}
