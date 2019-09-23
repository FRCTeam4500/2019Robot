/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.utility;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;

/**
 * Add your docs here.
 */
public class PIDValues {
    public final double P;
    public final double I;
    public final double D;
    public final double F;

    public PIDValues(double p, double i, double d, double f) {
        P = p;
        I = i;
        D = d;
        F = f;
    }

    public PIDValues(double p, double i, double d) {
        this(p, i, d, 0);
    }

    public PIDController toPidController(PIDSource source, PIDOutput output) {
        return new PIDController(P, I, D, F, source, output);
    }
}
