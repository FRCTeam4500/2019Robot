/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.components.dashboard;

import frc.robot.components.IDoubleSolenoid;

/**
 * Add your docs here.
 */
public class DashboardDoubleSolenoidComponent extends DashboardComponent
        implements IDoubleSolenoid {

    private boolean _isExtended = false;

    public DashboardDoubleSolenoidComponent(String name) {
        super(name + " " + "Is Extended");
    }

    @Override
    public boolean isExtended() {
        return _isExtended;
    }

    @Override
    public void extend() {
        _isExtended = true;
        putBoolean(_isExtended);
    }

    @Override
    public void retract() {
        _isExtended = false;
        putBoolean(_isExtended);
    }
}
