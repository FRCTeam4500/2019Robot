/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.components.dashboard;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.components.IAngleGetter;

/**
 * Add your docs here.
 */
public class DashboardAngleGetterComponent extends DashboardComponent implements IAngleGetter {
    public DashboardAngleGetterComponent(String name) {
        super(name + " " + "Measured Angle");
    }

    @Override
    public double getAngle() {
        return SmartDashboard.getNumber(name, 0.0);
    }
}
