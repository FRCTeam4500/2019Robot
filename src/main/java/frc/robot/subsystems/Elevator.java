package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Elevator extends Subsystem {

    private TalonSRX elevatorMotor;

    private DigitalInput limitSwitch;
    private Counter counter;
    private int countAmount;

    public Elevator() {
        elevatorMotor = new TalonSRX(RobotMap.ELEVATORMOTOR);

        elevatorMotor.setSelectedSensorPosition(0, 0, RobotMap.TIMEOUT);
        elevatorMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0,
                RobotMap.TIMEOUT);
        elevatorMotor.setNeutralMode(NeutralMode.Brake);

        elevatorMotor.configForwardSoftLimitEnable(true);
        elevatorMotor.configForwardSoftLimitThreshold(RobotMap.ELEVATORMAX - 200, RobotMap.TIMEOUT);
        elevatorMotor.configReverseSoftLimitEnable(true);
        elevatorMotor.configReverseSoftLimitThreshold(0, RobotMap.TIMEOUT);

        elevatorMotor.configAllowableClosedloopError(0, 50, RobotMap.TIMEOUT);
        elevatorMotor.config_kP(0, 4, RobotMap.TIMEOUT);
        elevatorMotor.config_kI(0, 0, RobotMap.TIMEOUT);
        elevatorMotor.config_kD(0, 0, RobotMap.TIMEOUT);

        limitSwitch = new DigitalInput(RobotMap.LIMIT_SWITCH_CHANNEL);
        counter = new Counter(limitSwitch);
    }

    @Override
    protected void initDefaultCommand() {

    }

    // Unfortunately neither the counter nor the limit switch has an onPressed
    // event, so we have to rely on the robot to reset.
    public boolean requiresReset() {
        if (counter.getDirection() == false) {
            countAmount++;
        }
        return countAmount > 0;
    }

    public void resetElevatorPosition() {
        counter.reset();
        countAmount = 0;
        elevatorMotor.setSelectedSensorPosition(0);
    }

    public void setLevel(int level) {
        if (getElevatorPosition() > level) {
            elevatorMotor.configClosedLoopPeakOutput(0, .25);
        } else {
            elevatorMotor.configClosedLoopPeakOutput(0, .8);
        }
        elevatorMotor.set(ControlMode.Position, level);
    }

    public TalonSRX getElevatorMotor() {
        return elevatorMotor;
    }

    public int getElevatorPosition() {
        return elevatorMotor.getSelectedSensorPosition();
    }

}
