/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.pid;

import edu.wpi.first.wpilibj.PIDOutput;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class PnpYawOutput implements PIDOutput {

    @Override
    public void pidWrite(double output) {
        // SmartDashboard.putNumber("yawControllerOutput", output);
        // Robot.swerve.driveWithoutPID(45, output);
        RobotMap.pidZTarget = output;
    }
}
