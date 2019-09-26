/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.components.dashboard;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;
import frc.robot.components.IGyro;

/**
 * Add your docs here.
 */
public class GyroDashboardDecorator extends DashboardDecorator implements IGyro {

    private IGyro gyro;

    public GyroDashboardDecorator(String name, String subsystem, IGyro gyro) {
        super(name, subsystem);
        this.gyro = gyro;
    }

    @Override
    public void reset() {
        gyro.reset();
    }

    @Override
    public double getAngle() {
        return gyro.getAngle();
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        builder.setSmartDashboardType(BuiltInWidgets.kGyro.getWidgetName());
        builder.addDoubleProperty("Value", this::getAngle, null);

    }
}