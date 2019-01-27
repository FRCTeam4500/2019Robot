package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.interfaces.IMotor;
import frc.robot.interfaces.wrappers.TalonSRXMotor;

public class Elevator extends Subsystem {
    private IMotor elevatorMotor;
    

    public Elevator() {
        elevatorMotor = new TalonSRXMotor(RobotMap.ELEVATORMOTOR);
    }

    public void setLevel(int level) {
        elevatorMotor.setPosition(level);
    }

    @Override
    protected void initDefaultCommand() {

    }


}