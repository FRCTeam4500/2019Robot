package main.java.frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4500.robot.RobotMap;

public class Cargo extends Subsystem {
     
    private TalonSRX leftGrab;
    private TalonSRX rightGrab;
    private TalonSRX topGrab;
    private TalonSRX angleGrab;

    public Cargo() {
            leftGrab = new TalonSRX(RobotMap.LEFTGRAB);
            rightGrab = new TalonSRX(RobotMap.RIGHTGRAB);
            topGrab = new TalonSRX(RobotMap.TOPGRAB);
            angleGrab = new TalonSRX(RobotMap.ANGLEGRAB);
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










