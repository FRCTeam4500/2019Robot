package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Cargo extends Subsystem {

    private VictorSPX leftGrab;
    private VictorSPX rightGrab;
    private TalonSRX topGrab;
    
    public Cargo() {
        leftGrab = new VictorSPX(RobotMap.LEFTGRAB);
        rightGrab = new VictorSPX(RobotMap.RIGHTGRAB);
        topGrab = new TalonSRX(RobotMap.TOPGRAB);
        leftGrab.setNeutralMode(NeutralMode.Brake);
        rightGrab.setNeutralMode(NeutralMode.Brake);
        topGrab.setNeutralMode(NeutralMode.Brake);
    }
    
    @Override
    public void initDefaultCommand() {
        //Default Command for Subsystem
    }
    
    public void setMotors(double sideSpeed, double topSpeed){
        leftGrab.set(ControlMode.PercentOutput, sideSpeed);
        rightGrab.set(ControlMode.PercentOutput, -sideSpeed);
        topGrab.set(ControlMode.PercentOutput, topSpeed);
    }
    
}










