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
public class PnpXSource extends Vision implements PIDSource {

    @Override
    public void setPIDSourceType(PIDSourceType pidSource) {

    }

    @Override
    public PIDSourceType getPIDSourceType() {
        return PIDSourceType.kDisplacement;
    }

    @Override
    public double pidGet() {
        double[] history = getHistory(Data.X);
        double deltaX = history[1] - history[0];
        double deltaT = 1 / RobotMap.LLFPS;
        double velocity = deltaX / deltaT;
        SmartDashboard.putNumber("xVel", velocity);
        RobotMap.pidXCurrent = velocity < RobotMap.vMAX ? history[1] : history[0];
        return velocity < RobotMap.vMAX ? history[1] : history[0];
    }
}
