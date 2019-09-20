/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.arm;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import frc.robot.RobotMap;
import frc.robot.components.hardware.TalonSRXComponent;

/**
 * Add your docs here.
 */
public class DefaultArmFactory {
    public static Arm MakeArm() {
        var srx = new TalonSRXComponent(RobotMap.ROTATIONAL_MOTOR);
        srx.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0,
                RobotMap.TIMEOUT);
        srx.setNeutralMode(NeutralMode.Brake);

        srx.configForwardSoftLimitEnable(true);
        srx.configForwardSoftLimitThreshold(RobotMap.ARM_MAX, RobotMap.TIMEOUT);
        srx.configReverseSoftLimitEnable(true);
        srx.configReverseSoftLimitThreshold(RobotMap.ARM_MIN, RobotMap.TIMEOUT);

        srx.config_kP(0, 4, RobotMap.TIMEOUT); // 4
        srx.config_kI(0, 0, RobotMap.TIMEOUT);
        srx.config_kD(0, 0, RobotMap.TIMEOUT); // 10
        srx.configAllowableClosedloopError(0, 10, RobotMap.TIMEOUT);

        return new Arm(new ArmTalonSRXComponent(srx));
    }
}
