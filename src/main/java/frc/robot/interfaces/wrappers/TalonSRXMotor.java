/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.interfaces.wrappers;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.interfaces.IMotor;

/**
 * Add your docs here.
 */
public class TalonSRXMotor implements IMotor{

    private TalonSRX talonSRX;
    public TalonSRXMotor(int channel){
        talonSRX = new TalonSRX(channel);
    }
    @Override
    public void setSpeed(double speed) {
        talonSRX.set(ControlMode.PercentOutput,speed);
    }

    @Override
    public void setPosition(double position) {
        talonSRX.set(ControlMode.Position, position);
    }
}
