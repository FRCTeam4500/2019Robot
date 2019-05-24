/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.pid;

import edu.wpi.first.wpilibj.PIDController;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class Controllers {

    private static PnpHypOutput hypOutput;
    private static PnpHypSource hypSource;

    private static PnpXOutput xOutput;
    private static PnpXSource xSource;

    private static PnpYawOutput yawOutput;
    private static PnpYawSource yawSource;


    public static PIDController xController, hypController, yawController;

    public static void initialize() {
        xSource = new PnpXSource();
        xOutput = new PnpXOutput();
        xController = new PIDController(Robot.xTuner.getP(), Robot.xTuner.getI(),
                Robot.xTuner.getD(), xSource, xOutput);
        xController.setInputRange(-30, 30);
        xController.setOutputRange(-0.5, 0.5);
        xController.setPercentTolerance(0.5);

        hypSource = new PnpHypSource();
        hypOutput = new PnpHypOutput();
        hypController = new PIDController(Robot.hypTuner.getP(), Robot.hypTuner.getI(),
                Robot.hypTuner.getD(), hypSource, hypOutput);
        hypController.setInputRange(0, 100);
        hypController.setOutputRange(-0.25, 0.25);
        hypController.setPercentTolerance(10);

        yawSource = new PnpYawSource();
        yawOutput = new PnpYawOutput();
        yawController = new PIDController(0, 0, 0, yawSource, yawOutput);
        yawController.setInputRange(-120, 120);
        yawController.setOutputRange(-0.5, 0.5);
        yawController.setPercentTolerance(5);
    }
}
