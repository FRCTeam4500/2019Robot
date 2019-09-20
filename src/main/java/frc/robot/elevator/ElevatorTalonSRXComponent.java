/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.elevator;

import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.components.IPositionSetter;
import frc.robot.components.TalonSRXComponent;

/**
 * Add your docs here.
 */
public class ElevatorTalonSRXComponent implements IPositionSetter {
    private TalonSRXComponent srx;

    public ElevatorTalonSRXComponent(TalonSRXComponent srx) {
        this.srx = srx;
    }

    @Override
    public void setPosition(double position) {
        if (srx.getSelectedSensorPosition() > position) {
            srx.configClosedLoopPeakOutput(0, .25);
        } else {
            srx.configClosedLoopPeakOutput(0, .8);
        }
        srx.set(ControlMode.Position, position);
    }
}
