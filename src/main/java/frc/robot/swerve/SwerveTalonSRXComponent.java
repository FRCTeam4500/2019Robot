/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.swerve;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.components.hardware.TalonSRXComponent;

/**
 * Add your docs here.
 */
public class SwerveTalonSRXComponent extends TalonSRXComponent {

    public SwerveTalonSRXComponent(int deviceNumber) {
        super(deviceNumber);
    }

    @Override
    public void setAngle(double angle) {
        // https://stackoverflow.com/questions/1878907/the-smallest-difference-between-2-angles

        if (angle == -0) {
            angle = +0;
        }
        double currentAngle = getAngle();
        if (Math.abs(currentAngle) >= 2 * Math.PI) {
            SmartDashboard.putBoolean("hit", true);
        }

        double actualDifference = angle - currentAngle;
        double shortestDifference = customMod(actualDifference + Math.PI, 2 * Math.PI) - Math.PI;
        super.setAngle(currentAngle + shortestDifference);
    }

    private double customMod(double a, double n) {
        return a - Math.floor(a / n) * n;
    }
}
