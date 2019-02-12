package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Elevator extends Subsystem {
	
	private TalonSRX elevatorMotor;
    
    public Elevator() {
		elevatorMotor = new TalonSRX(RobotMap.ELEVATORMOTOR);
		elevatorMotor.setSelectedSensorPosition(0, 0, RobotMap.TIMEOUT);
		elevatorMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, RobotMap.TIMEOUT);
		elevatorMotor.setNeutralMode(NeutralMode.Brake);

		elevatorMotor.configForwardSoftLimitEnable(true);
		elevatorMotor.configForwardSoftLimitThreshold(RobotMap.ELEVATORMAX-200, RobotMap.TIMEOUT);
		elevatorMotor.configReverseSoftLimitEnable(true);
		elevatorMotor.configReverseSoftLimitThreshold(0, RobotMap.TIMEOUT);
		
		elevatorMotor.config_kP(0, 1.25908, RobotMap.TIMEOUT);
		elevatorMotor.config_kI(0, 0.016, RobotMap.TIMEOUT);
		elevatorMotor.config_kD(0, 0, RobotMap.TIMEOUT);//12.5908
		//elevatorMotor.config_kF(0, 0.429832, RobotMap.TIMEOUT);
		elevatorMotor.config_IntegralZone(0, 50, RobotMap.TIMEOUT);
		elevatorMotor.configMotionCruiseVelocity(4500); // 1190
		elevatorMotor.configMotionAcceleration(4500);
	}
	
	@Override
	protected void initDefaultCommand() {

	}

    public void setLevel(int level) {
        elevatorMotor.set(ControlMode.Position, level);
	}
	
	public TalonSRX getElevatorMotor() {
		return elevatorMotor;
	}



}