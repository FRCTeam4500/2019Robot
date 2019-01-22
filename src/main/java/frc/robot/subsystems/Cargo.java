package main.java.frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4500.robot.RobotMap;

public class Cargo extends Subsystem {
     
    private TalonSRX leftGrab;
    private TalonSRX rightGrab;
    private TalonSRX topGrab;

    public Cargo() {
            leftGrab = new TalonSRX(RobotMap.LEFTGRAB)
            rightGrab = new TalonSRX(RobotMap.RIGHTGRAB)
            topGrab = new TalonSRX(RobotMap.TOPGRAB)
    }
    
}










