/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.components.dashboard;

import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.SendableBase;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.components.IAngleSetter;

/**
 * Add your docs here.
 */
public class DashboardAngleSetterComponent extends DashboardComponent implements IAngleSetter {

    private double angle = 0;

    public DashboardAngleSetterComponent(String name) {
        super(name + " " + "Angle");
        // TODO: Cleanup sendable functionality
        SmartDashboard.putData(name + " " + "(Gyro)", new SendableBase() {

            @Override
            public void initSendable(SendableBuilder builder) {
                builder.setSmartDashboardType(BuiltInWidgets.kGyro.name());
                builder.addDoubleProperty("Value", () -> -angle * 180 / Math.PI, null);
            }
        });
    }

    @Override
    public void setAngle(double angle) {
        putNumber(angle);
        this.angle = angle;
    }
}
