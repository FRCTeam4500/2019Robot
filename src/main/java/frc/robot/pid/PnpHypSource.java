/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.pid;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.utility.automation.Vision;

/**
 * Add your docs here.
 */
public class PnpHypSource extends Vision implements PIDSource {

    @Override
    public void setPIDSourceType(PIDSourceType pidSource) {

    }

    @Override
    public PIDSourceType getPIDSourceType() {
        return PIDSourceType.kDisplacement;
    }

    @Override
    public double pidGet() {
        double[] xHistory = getHistory(Data.X);
        double[] zHistory = getHistory(Data.Z);
        // double[] yawHistory = getHistory(Data.YAW);
        double[] hypHistory =
                new double[] {Math.sqrt(Math.pow(xHistory[0], 2) + Math.pow(zHistory[0], 2)),
                        Math.sqrt(Math.pow(xHistory[1], 2) + Math.pow(zHistory[1], 2))};
        double deltaHyp = hypHistory[1] - hypHistory[0];
        double deltaT = 1 / RobotMap.LLFPS;
        double velocity = deltaHyp / deltaT;

        RobotMap.hypAngle = getTX();
        if (velocity < RobotMap.vMAX) {
            // SmartDashboard.putNumber("hypAngle", yawHistory[1]);
            SmartDashboard.putNumber("hypDist", hypHistory[1]);
            // RobotMap.hypAngle = yawHistory[1];
            return hypHistory[1] + 20;
        } else {
            // SmartDashboard.putNumber("hypAngle", yawHistory[0]);
            SmartDashboard.putNumber("hypDist", hypHistory[0]);
            // RobotMap.hypAngle = yawHistory[0];
            return hypHistory[0] + 20;
        }
        // return 0;
    }
}
