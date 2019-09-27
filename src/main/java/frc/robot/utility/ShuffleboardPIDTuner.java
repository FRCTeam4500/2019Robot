/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.utility;

import edu.wpi.first.wpilibj.SendableBase;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;

/**
 * A custom tuner for {@link PIDCalculator}. Must be in test mode to tune.
 */
public class ShuffleboardPIDTuner extends SendableBase {
    private PIDCalculator calculator;

    public ShuffleboardPIDTuner(PIDCalculator calculator, String subsystem, String name) {
        super(true);
        setName(subsystem, name);
        this.calculator = calculator;
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        builder.setSmartDashboardType("RobotPreferences");
        builder.addDoubleProperty("__kP", calculator::getkP, calculator::setkP);
        builder.addDoubleProperty("_kI", calculator::getkI, calculator::setkI);
        builder.addDoubleProperty("kD", calculator::getkD, calculator::setkD);
        builder.addDoubleProperty("maxOutput", calculator::getMaxOutput, calculator::setMaxOutput);
        builder.addDoubleProperty("minOutput", calculator::getMinOutput, calculator::setMaxOutput);
        builder.addDoubleProperty("setpointDelta", calculator::getSetpointDelta,
                calculator::setSetpointDelta);
    }

}
