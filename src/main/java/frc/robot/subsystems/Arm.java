/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
* Add your docs here.
*/
public class Arm extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private TalonSRX rotationalMotor;
    
    public Arm(){
        rotationalMotor = new TalonSRX(RobotMap.ROTATIONALMOTOR);
        rotationalMotor.setSelectedSensorPosition(0, 0, RobotMap.TIMEOUT);
        rotationalMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, RobotMap.TIMEOUT);
        rotationalMotor.setNeutralMode(NeutralMode.Brake);
        
        // rotationalrMotor.configForwardSoftLimitEnable(true);
        // rotationalrMotor.configForwardSoftLimitThreshold(RobotMap.rotationalRMAX-200, RobotMap.TIMEOUT);
        // rotationalrMotor.configReverseSoftLimitEnable(true);
        // rotationalrMotor.configReverseSoftLimitThreshold(0, RobotMap.TIMEOUT);
        
        rotationalMotor.config_kP(0, 0, RobotMap.TIMEOUT);
        rotationalMotor.config_kI(0, 0, RobotMap.TIMEOUT);
        rotationalMotor.config_kD(0, 0, RobotMap.TIMEOUT);
        rotationalMotor.config_kF(0, 0, RobotMap.TIMEOUT);
        rotationalMotor.config_IntegralZone(0, 0, RobotMap.TIMEOUT);
        rotationalMotor.configMotionCruiseVelocity(0);
        rotationalMotor.configMotionAcceleration(0);
    }
    
    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    public void setRotation(double angle){
        rotationalMotor.set(ControlMode.Position, angle);
    }
}
