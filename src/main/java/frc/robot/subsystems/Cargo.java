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
    
    public void setMotors(){
        leftGrab.set(ControlMode.PercentOutput, speed);
        rightGrab.set(ControlMode.PercentOutput, -speed);
        topGrab.set(ControlMode.PercentOutput, speed);
    }

    public void setAngle(){
        angleGrab.set(ControlMode.Position, position);
    }
}










