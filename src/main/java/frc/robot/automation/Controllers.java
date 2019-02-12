package frc.robot.automation;

import frc.robot.Robot;
import frc.robot.utility.automation.PIDController;

public class Controllers {
    public static frc.robot.utility.automation.PIDController rotationalAlignmentController = null;
    public static PIDController xAlignmentController = null;

    public static void createControllers() {
        rotationalAlignmentController = new PIDController("rotational", 0.000625, 0, 0, 30, () -> { // 0.01
            return (double) Robot.swerve.getFR().getDrivePosition();
            //return Robot.swerve.getLeftSonic() - Robot.swerve.getRightSonic();
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