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

    private static PnpZOutput zOutput;
    private static PnpZSource zSource;

    private static PnpXOutput xOutput;
    private static PnpXSource xSource;

    private static PnpYawOutput yawOutput;
    private static PnpYawSource yawSource;


    public static PIDController xController, zController, yawController;

    public static void initialize() {
        xSource = new PnpXSource();
        xOutput = new PnpXOutput();
        xController = new PIDController(Robot.xTuner.getP(), Robot.xTuner.getI(),
                Robot.xTuner.getD(), xSource, xOutput);
        xController.setInputRange(-20, 20);
        xController.setOutputRange(-1, 1);
        xController.setPercentTolerance(0);

        zSource = new PnpZSource();
        zOutput = new PnpZOutput();
        zController = new PIDController(0, 0, 0, zSource, zOutput);
        zController.setInputRange(0, 20);
        zController.setOutputRange(-1, 1);
        zController.setPercentTolerance(15.0);

        // yawController = new PIDController(0, 0, 0, yawSource, yawOutput);
        // yawController.setInputRange(-180, 180);
        // yawController.setOutputRange(-180, 180);
        // yawController.setPercentTolerance(15.0);
    }
}
