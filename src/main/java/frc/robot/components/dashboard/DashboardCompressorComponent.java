/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.components.dashboard;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;
import frc.robot.components.ICompressor;

/**
 * Add your docs here.
 */
public class DashboardCompressorComponent extends DashboardComponent implements ICompressor {

    protected boolean isCompressing = false;

    public DashboardCompressorComponent(String name, String subsystem) {
        super(name + " " + "Compressor Component", subsystem);
    }

    @Override
    public void start() {
        isCompressing = true;
    }

    @Override
    public void stop() {
        isCompressing = false;
    }

    @Override
    public boolean enabled() {
        return isCompressing;
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        builder.setSmartDashboardType(BuiltInWidgets.kBooleanBox.getWidgetName());
        builder.addBooleanProperty("IsCompressing", () -> isCompressing,
                value -> isCompressing = value);
    }
}
