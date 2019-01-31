package frc.robot.automation;

import frc.robot.Robot;
import frc.robot.utility.PIDController;

public class Controllers {
    public static PIDController ultrasonicAlignmentController;
    public static PIDController xAlignmentController;

    public static void createControllers() {
        ultrasonicAlignmentController = new PIDController(0, 0, 0, 5, () -> {
            return Robot.swerve.getLeftSonic() - Robot.swerve.getRightSonic();
        });

        xAlignmentController = new PIDController(0, 0, 0, 5, () -> {
            double[] data = Robot.vision.getCvData();
            double Z = (Robot.swerve.getLeftSonic() + Robot.swerve.getRightSonic()) / 2;
            return 0.0;
        });
    }
}