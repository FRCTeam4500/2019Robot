package frc.robot.automation;

import frc.robot.Robot;
import frc.robot.utility.PIDController;
import frc.robot.utility.PIDInputInterface;
import frc.robot.utility.PIDOutputInterface;

public class Controllers {
    public static PIDController ultrasonicAlignmentController;
    private static PIDOutputInterface<Double> ultrasonicAlignmentOutput;
    private static PIDInputInterface<Double> ultrasonicAlignmentInput;

    public static void createControllers() {
        ultrasonicAlignmentInput = () -> {
            return Robot.swerve.getLeftSonic() - Robot.swerve.getRightSonic();
        };
        ultrasonicAlignmentOutput = (Double error, Double lastError, Double sumOfErrors, Double kP, Double kI, Double kD) -> {
            return kP * error + 
                   kI * sumOfErrors +
                   kD * (error - lastError);
        };
        ultrasonicAlignmentController = new PIDController(0, 0, 0, 5, ultrasonicAlignmentInput, ultrasonicAlignmentOutput);
    }
}