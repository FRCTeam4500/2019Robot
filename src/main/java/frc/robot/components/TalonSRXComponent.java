/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.components;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 * Add your docs here.
 */
public class TalonSRXComponent extends TalonSRX implements ISpeedSetter, IAngleSetter {

    public TalonSRXComponent(int deviceNumber) {
        super(deviceNumber);
    }

    @Override
    public void setSpeed(double speed) {
        set(ControlMode.PercentOutput, speed);
    }

    @Override
    public void setAngle(double angle) {
        set(ControlMode.Position, angle);
    }
}