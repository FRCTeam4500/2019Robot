package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Cargo extends Subsystem {
     
    private TalonSRX leftGrab;
    private TalonSRX rightGrab;
    private TalonSRX topGrab;
    private TalonSRX angleGrab;

    public Cargo() {
            leftGrab = new TalonSRX(RobotMap.leftGrab);
            rightGrab = new TalonSRX(RobotMap.rightGrab);
            topGrab = new TalonSRX(RobotMap.topGrab);
            angleGrab = new TalonSRX(RobotMap.angleGrab);
    }

    public void initDefaultCommand() {
        //Default Command for Subsystem
    }
    
    public void setMotors(double sideSpeed, double topSpeed){
        leftGrab.set(ControlMode.PercentOutput, sideSpeed);
        rightGrab.set(ControlMode.PercentOutput, -sideSpeed);
        topGrab.set(ControlMode.PercentOutput, topSpeed);
    }

    public void setAngle(double angle){
        angleGrab.set(ControlMode.Position, angle);
    }
}










