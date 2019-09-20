/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.swerve;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import frc.robot.RobotMap;
import frc.robot.components.TalonSRXComponent;

/**
 * Add your docs here.
 */
public class DefaultSwerveFactory {
    public static Swerve MakeSwerve() {
        var bl = MakeWheelModule(RobotMap.BL_ANGLE_PORT, RobotMap.BL_SPEED_PORT, false, true);
        var br = MakeWheelModule(RobotMap.BR_ANGLE_PORT, RobotMap.BR_SPEED_PORT, false, false);
        var fl = MakeWheelModule(RobotMap.FL_ANGLE_PORT, RobotMap.FL_SPEED_PORT, false, true);
        var fr = MakeWheelModule(RobotMap.FR_ANGLE_PORT, RobotMap.FR_SPEED_PORT, false, false);

        return new Swerve(1, 1, fl, fr, bl, br);
    }

    private static WheelModule MakeWheelModule(int anglePort, int speedPort, boolean angleInverted,
            boolean speedInverted) {

        var angleMotor = new TalonSRXComponent(anglePort);
        var speedMotor = new TalonSRXComponent(speedPort);

        speedMotor.configPeakOutputForward(1);
        speedMotor.configPeakOutputReverse(-1);
        speedMotor.setInverted(speedInverted);

        angleMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0,
                RobotMap.TIMEOUT);

        angleMotor.setSensorPhase(false);
        angleMotor.configAllowableClosedloopError(0, 0, RobotMap.TIMEOUT);
        angleMotor.config_kP(0, RobotMap.ANGLE_P, RobotMap.TIMEOUT); // 0.8
        angleMotor.config_kI(0, RobotMap.ANGLE_I, RobotMap.TIMEOUT);
        angleMotor.config_kD(0, RobotMap.ANGLE_D, RobotMap.TIMEOUT); // 80
        angleMotor.config_kF(0, RobotMap.ANGLE_F, RobotMap.TIMEOUT);
        angleMotor.config_IntegralZone(0, 50, RobotMap.TIMEOUT);
        angleMotor.configMotionCruiseVelocity(RobotMap.ANGLE_V, RobotMap.TIMEOUT);
        angleMotor.configMotionAcceleration(RobotMap.ANGLE_A, RobotMap.TIMEOUT); // 1800
        angleMotor.setInverted(angleInverted);

        return new WheelModule(angleMotor, speedMotor);
    }
}
