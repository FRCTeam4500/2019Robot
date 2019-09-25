/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.components.dashboard;

import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;
import frc.robot.components.ICompressor;

/**
 * Add your docs here.
 */
public class CompressorDashboardDecorator extends DashboardDecorator implements ICompressor {

    private boolean lastIsCompressing = false;
    private ICompressor compressor;

    public CompressorDashboardDecorator(String name, String subsystem, ICompressor compressor) {
        super(name + " " + "Compressor Component", subsystem);
        this.compressor = compressor;
    }

    @Override
    public void start() {
        lastIsCompressing = true;
        compressor.start();
    }

    @Override
    public void stop() {
        lastIsCompressing = false;
        compressor.stop();
    }

    public boolean getLastIsCompressing() {
        return lastIsCompressing;
    }

    @Override
    public boolean enabled() {
        return compressor.enabled();
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        builder.addBooleanProperty("Last Is Compressing", this::getLastIsCompressing, null);
        builder.addBooleanProperty("Real Is Compressing", this::enabled, null);
    }
}
