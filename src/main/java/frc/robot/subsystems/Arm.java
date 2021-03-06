/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Arm extends Subsystem {

    private TalonSRX rotationalMotor;

    public Arm() {
        rotationalMotor = new TalonSRX(RobotMap.ROTATIONALMOTOR);
        rotationalMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0,
                RobotMap.TIMEOUT);
        rotationalMotor.setNeutralMode(NeutralMode.Brake);

        rotationalMotor.configForwardSoftLimitEnable(true);
        rotationalMotor.configForwardSoftLimitThreshold(RobotMap.ARM_MAX, RobotMap.TIMEOUT);
        rotationalMotor.configReverseSoftLimitEnable(true);
        rotationalMotor.configReverseSoftLimitThreshold(RobotMap.ARM_MIN, RobotMap.TIMEOUT);

        rotationalMotor.config_kP(0, 4, RobotMap.TIMEOUT); // 4
        rotationalMotor.config_kI(0, 0, RobotMap.TIMEOUT);
        rotationalMotor.config_kD(0, 0, RobotMap.TIMEOUT); // 10
        rotationalMotor.configAllowableClosedloopError(0, 10, RobotMap.TIMEOUT);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    public void setRotation(double angle) {
        if (getArmPosition() < angle) {
            rotationalMotor.configClosedLoopPeakOutput(0, .15);
        } else {
            rotationalMotor.configClosedLoopPeakOutput(0, 1);
        }
        rotationalMotor.set(ControlMode.Position, angle);
    }

    public void fullspeed() {
        rotationalMotor.set(ControlMode.PercentOutput, -1);
    }

    public int getArmPosition() {
        return rotationalMotor.getSelectedSensorPosition();
    }

    public int getArmVelocity() {
        return rotationalMotor.getSelectedSensorVelocity();
    }

    public int getArmError() {
        return rotationalMotor.getClosedLoopError();
    }
}
