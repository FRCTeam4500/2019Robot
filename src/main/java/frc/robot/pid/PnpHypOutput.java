/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.pid;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class PnpHypOutput implements PIDOutput {

    @Override
    public void pidWrite(double output) {
        // double x = output * Math.cos(RobotMap.deg2rad(RobotMap.hypAngle));
        // double y = output * Math.sin(RobotMap.deg2rad(RobotMap.hypAngle));
        // // System.out.println("x : y");
        // // SmartDashboard.putString("hypControllerOutput", output + ":" +
        // // RobotMap.hypAngle);
        // Robot.swerve.driveWithoutPID(RobotMap.hypAngle, -output);
        // Robot.swerve.calculateVisionVectors(output);
    }
}
