package frc.robot.automation;

import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.utility.PIDController;

public class Controllers {
    public static PIDController ultrasonicAlignmentController = null;
    public static PIDController xAlignmentController = null;

    public static void createControllers() {
        ultrasonicAlignmentController = new PIDController("ultra", 0, 0, 0, 5, () -> {
            return Robot.swerve.getLeftSonic() - Robot.swerve.getRightSonic();
        });

        xAlignmentController = new PIDController("vision", 0, 0, 0, 5, () -> {
            return (double) Robot.swerve.getFL().getDrivePosition();
           
            // double[] data = Robot.vision.getCenter();
            // // In mm
            // double Z = (Robot.swerve.getLeftSonic() + Robot.swerve.getRightSonic()) / 2;
            // double X = Z * ((data[0] - RobotMap.imgCenterW) / RobotMap.focalLength);
            // double XTicks = X * (RobotMap.ticksPerRotation / (Math.PI * RobotMap.wheelDiameterMM));
            // System.out.println("X: " + X);
            // System.out.println("XTicks: " + XTicks);
            // return XTicks;
        });
    }
}