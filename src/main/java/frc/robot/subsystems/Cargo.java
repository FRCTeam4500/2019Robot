package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Cargo extends Subsystem {
     
    private TalonSRX leftGrab;
    private TalonSRX rightGrab;
    private TalonSRX topGrab;
    

    public Cargo() {
            leftGrab = new TalonSRX(RobotMap.LEFTGRAB);
            rightGrab = new TalonSRX(RobotMap.RIGHTGRAB);
            topGrab = new TalonSRX(RobotMap.TOPGRAB);
            
    }

    public void initDefaultCommand() {
        //Default Command for Subsystem
    }
    
    public void setMotors(double sideSpeed, double topSpeed){
        leftGrab.set(ControlMode.PercentOutput, sideSpeed);
        rightGrab.set(ControlMode.PercentOutput, -sideSpeed);
        topGrab.set(ControlMode.PercentOutput, topSpeed);
    }

    // public void setAngle(double angle){
    //     angleGrab.set(ControlMode.Position, angle);
    // }
}










