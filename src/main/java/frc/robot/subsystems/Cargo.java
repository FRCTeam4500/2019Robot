package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.interfaces.IMotor;

public class Cargo extends Subsystem {
     
    private IMotor rightGrab;
    private IMotor leftGrab;
    private IMotor topGrab;
    private IMotor angleGrab;

    public Cargo(IMotor leftGrab, IMotor rightGrab, IMotor topGrab, IMotor angleGrab) {
        this.leftGrab = leftGrab;
        this.rightGrab = rightGrab;
        this.topGrab = topGrab;
        this.angleGrab = angleGrab;
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










