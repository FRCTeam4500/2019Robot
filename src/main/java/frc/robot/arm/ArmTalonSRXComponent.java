/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.arm;

import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.components.IAngleSetter;
import frc.robot.components.hardware.TalonSRXComponent;

/**
 * Add your docs here.
 */
public class ArmTalonSRXComponent implements IAngleSetter {
    private TalonSRXComponent srx;

    public ArmTalonSRXComponent(TalonSRXComponent srx) {
        this.srx = srx;
    }

    @Override
    public void setAngle(double angle) {
        // TODO: CLEAN THIS UP!!!! The arm is currently using raw sensor units instead
        // of conforming
        // to radians.
        if (srx.getSelectedSensorPosition() < angle) {
            srx.configClosedLoopPeakOutput(0, .15);
        } else {
            srx.configClosedLoopPeakOutput(0, 1);
        }
        srx.set(ControlMode.Position, angle);
    }
}
