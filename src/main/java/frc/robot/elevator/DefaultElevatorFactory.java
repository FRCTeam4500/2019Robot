/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.elevator;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import frc.robot.RobotMap;
import frc.robot.components.hardware.TalonSRXComponent;

/**
 * Add your docs here.
 */
public class DefaultElevatorFactory {
    public static Elevator MakeElevator() {
        var srx = new TalonSRXComponent(RobotMap.ELEVATOR_MOTOR);

        srx.setSelectedSensorPosition(0, 0, RobotMap.TIMEOUT);
        srx.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0,
                RobotMap.TIMEOUT);
        srx.setNeutralMode(NeutralMode.Brake);

        srx.configForwardSoftLimitEnable(true);
        srx.configForwardSoftLimitThreshold(RobotMap.ELEVATOR_MAX - 200, RobotMap.TIMEOUT);
        srx.configReverseSoftLimitEnable(true);
        srx.configReverseSoftLimitThreshold(0, RobotMap.TIMEOUT);

        srx.configAllowableClosedloopError(0, 50, RobotMap.TIMEOUT);
        srx.config_kP(0, 4, RobotMap.TIMEOUT);
        srx.config_kI(0, 0, RobotMap.TIMEOUT);
        srx.config_kD(0, 0, RobotMap.TIMEOUT);

        return new Elevator(new ElevatorTalonSRXComponent(srx));
    }
}
