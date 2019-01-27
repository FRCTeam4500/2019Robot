package frc.robot.subsystems;

import TalonSRX;

public class Elevator extends Subsystems {
    private TalonSRX elevatorMotor;
    

    public Elevator() {
        elevatorMotor = new TalonSRX(RobotMap.ELEVATORMOTOR);
    }

    public void setLevel(int level) {
        elevatorMotor.set(ControlMode.Position, level);
    }


}