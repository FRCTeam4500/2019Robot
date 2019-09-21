/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.components.dashboard;

import frc.robot.components.ICompressor;

/**
 * Add your docs here.
 */
public class DashboardCompressorComponent extends DashboardComponent implements ICompressor {

    private boolean isCompressing = false;

    public DashboardCompressorComponent(String name) {
        super(name + " " + "Is Compressing");
    }

    @Override
    public void start() {
        isCompressing = true;
        putBoolean(isCompressing);
    }

    @Override
    public void stop() {
        isCompressing = false;
        putBoolean(isCompressing);
    }
}
