package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.interfaces.IMotor;
import frc.robot.interfaces.wrappers.TalonSRXMotor;

public class Cargo extends Subsystem {
     
    private IMotor rightGrab;
    private IMotor leftGrab;
    private IMotor topGrab;
    private IMotor angleGrab;

    public Cargo() {
            leftGrab = new TalonSRXMotor(RobotMap.leftGrab);
            rightGrab = new TalonSRXMotor(RobotMap.rightGrab);
            topGrab = new TalonSRXMotor(RobotMap.topGrab);
            angleGrab = new TalonSRXMotor(RobotMap.angleGrab);
    }

    public void initDefaultCommand() {
        //Default Command for Subsystem
    }
    
    public void setMotors(double sideSpeed, double topSpeed){
        leftGrab.setSpeed(sideSpeed);
        rightGrab.setSpeed(-sideSpeed);
        topGrab.setSpeed(topSpeed);
    }

    public void setAngle(double angle){
        angleGrab.setPosition(angle);
    }
}










