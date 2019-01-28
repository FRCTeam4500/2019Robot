package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Elevator extends Subsystem {
    private TalonSRX elevatorMotor;
    

    public Elevator() {
        elevatorMotor = new TalonSRX(RobotMap.ELEVATORMOTOR);
        int absolutePosition = elevatorMotor.getSelectedSensorPosition(0);
		elevatorMotor.setSelectedSensorPosition(absolutePosition, 0, RobotMap.TIMEOUT);
		elevatorMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, RobotMap.TIMEOUT);
		
		elevatorMotor.configAllowableClosedloopError(0, 0, RobotMap.TIMEOUT);
		
		elevatorMotor.configForwardSoftLimitThreshold(4800, RobotMap.TIMEOUT);
		elevatorMotor.configReverseSoftLimitThreshold(-10, RobotMap.TIMEOUT);
		elevatorMotor.configForwardSoftLimitEnable(true, RobotMap.TIMEOUT);
		elevatorMotor.configReverseSoftLimitEnable(true, RobotMap.TIMEOUT);
		
		elevatorMotor.config_kP(0, 0.8, RobotMap.TIMEOUT);
		elevatorMotor.config_kI(0, 0.008, RobotMap.TIMEOUT);
		elevatorMotor.config_kD(0, 8, RobotMap.TIMEOUT);
		elevatorMotor.config_IntegralZone(0, 60, RobotMap.TIMEOUT);
		elevatorMotor.config_kF(0, 0, RobotMap.TIMEOUT);
	}
    }


    public void setLevel(int level) {
        elevatorMotor.set(ControlMode.Position, level);
    }

    @Override
    protected void initDefaultCommand() {

    }


}