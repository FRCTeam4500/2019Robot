package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Elevator extends Subsystem {
    private TalonSRX elevatorMotor;
    

    public Elevator() {
        elevatorMotor = new TalonSRX(RobotMap.ELEVATORMOTOR);
    }

    public void setLevel(int level) {
        elevatorMotor.set(ControlMode.Position, level);
    }

    @Override
    protected void initDefaultCommand() {

    }


}