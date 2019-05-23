/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.utility;

import edu.wpi.first.wpilibj.Preferences;

/**
 * Automatically adds the needed information to the network for tuning a PID controller without the
 * need to re-deploy
 */
public class PIDTuner {

    private Preferences prefs;
    private String pKey, iKey, dKey, spKey;
    private double pDefault, iDefault, dDefault, spDefault;

    public PIDTuner(Preferences prefs, String pKey, double pDefault, String iKey, double iDefault,
            String dKey, double dDefault, String spKey, double spDefault) {

        this.prefs = prefs;

        this.pKey = pKey;
        this.iKey = iKey;
        this.dKey = dKey;
        this.spKey = spKey;

        this.pDefault = pDefault;
        this.iDefault = iDefault;
        this.dDefault = dDefault;
        this.spKey = spKey;

        prefs.putDouble(pKey, pDefault);
        prefs.putDouble(iKey, iDefault);
        prefs.putDouble(dKey, dDefault);
        prefs.putDouble(spKey, spDefault);
    }

    public double getP() {
        return prefs.getDouble(pKey, pDefault);
    }

    public double getI() {
        return prefs.getDouble(iKey, iDefault);
    }

    public double getD() {
        return prefs.getDouble(dKey, dDefault);
    }

    public double getSetpoint() {
        return prefs.getDouble(spKey, spDefault);
    }
}
