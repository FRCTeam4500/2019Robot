/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.swerve;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import edu.wpi.first.wpilibj.SPI.Port;
import frc.robot.RobotMap;
import frc.robot.components.hardware.TalonSRXComponent;
import frc.robot.components.dashboard.AngleGetterDashboardDecorator;
import frc.robot.components.dashboard.AngleSetterDashboardDecorator;
import frc.robot.components.dashboard.SpeedSetterDashboardDecorator;
import frc.robot.components.hardware.AHRSAngleGetterComponent;

/**
 * Add your docs here.
 */
public class DefaultSwerveFactory {
    public static Swerve MakeSwerve() {
        var bl = MakeWheelModule(RobotMap.BL_ANGLE_PORT, RobotMap.BL_SPEED_PORT, true, false,
                "BL Wheel Module");
        var br = MakeWheelModule(RobotMap.BR_ANGLE_PORT, RobotMap.BR_SPEED_PORT, true, false,
                "BR Wheel Module");
        var fl = MakeWheelModule(RobotMap.FL_ANGLE_PORT, RobotMap.FL_SPEED_PORT, true, false,
                "FL Wheel Module");
        var fr = MakeWheelModule(RobotMap.FR_ANGLE_PORT, RobotMap.FR_SPEED_PORT, true, false,
                "FR Wheel Module");

        return new Swerve(1, 1, fl, fr, bl, br, new AngleGetterDashboardDecorator("Gyro", "Swerve",
                new AHRSAngleGetterComponent(Port.kMXP)));
    }

    private static WheelModule MakeWheelModule(int anglePort, int speedPort, boolean angleInverted,
            boolean speedInverted, String subsystem) {

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

        var sentAngle = new AngleSetterDashboardDecorator("Sent Angle", subsystem, angleMotor);
        var sentSpeed = new SpeedSetterDashboardDecorator("Sent Speed", subsystem, speedMotor);
        // The constructor automatically adds to live window, so while this is not used by the
        // swerve, it is used by the live window
        @SuppressWarnings("unused")
        var actualAngle = new AngleGetterDashboardDecorator("Actual Angle", subsystem, angleMotor);

        return new WheelModule(sentAngle, sentSpeed);
    }
}
