package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.interfaces.IMotor;

public class Elevator extends Subsystem {
    private IMotor elevatorMotor;
    

    public Elevator(IMotor elevatorMotor) {
        this.elevatorMotor = elevatorMotor;
    }

    public void setLevel(int level) {
        elevatorMotor.setPosition(level);
    }

    @Override
    protected void initDefaultCommand() {

    }


}