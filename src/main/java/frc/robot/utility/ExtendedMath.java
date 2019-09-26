/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.utility;

/**
 * Add your docs here.
 */
public class ExtendedMath {
    public static double clamp(double min, double max, double output) {
        return Math.min(max, Math.max(min, output));
    }
}
