/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.components.dashboard;

import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;
import frc.robot.components.IDoubleSolenoid;

/**
 * Add your docs here.
 */
public class DoubleSolenoidDashboardDecorator extends DashboardDecorator
        implements IDoubleSolenoid {

    private boolean lastIsExtended = false;
    private IDoubleSolenoid ds;

    public DoubleSolenoidDashboardDecorator(String name, String subsystem, IDoubleSolenoid ds) {
        super(name, subsystem);
        this.ds = ds;
    }

    public boolean getLastIsExtended() {
        return lastIsExtended;
    }

    @Override
    public boolean isExtended() {
        return ds.isExtended();
    }

    @Override
    public void extend() {
        lastIsExtended = true;
        ds.extend();
    }

    @Override
    public void retract() {
        lastIsExtended = false;
        ds.retract();
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        builder.addBooleanProperty("Last Is Extended", this::getLastIsExtended, null);
        builder.addBooleanProperty("Real Is Extended", this::isExtended, null);
    }
}
