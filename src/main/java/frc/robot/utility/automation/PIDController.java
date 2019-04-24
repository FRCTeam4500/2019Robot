package frc.robot.utility.automation;

import edu.wpi.first.wpilibj.Preferences;
import frc.robot.Robot;

public class PIDController {
    private String id;
    private double kP, kI, kD;
    private double allowableError, lastError = 0, sumOfErrors = 0;
    private PIDInputInterface<Double> pidInput;

    public PIDController(String id, double kP, double kI, double kD, double allowableError,
            PIDInputInterface<Double> pidInput) {
        this.id = id;
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
        this.allowableError = allowableError;
        this.pidInput = pidInput;
    }

    private double getPIDInput() {
        return pidInput.get();
    }

    public double getPIDOutput(double target) {
        double error = target - getPIDInput();
        double D = ((error - lastError) / 0.02);
        System.out.println("Error is " + error);
        System.out.println("dX is " + (error - lastError));
        System.out.println("I is " + sumOfErrors + " kI is " + kI);

        double output = kP * error + kI * sumOfErrors + kD * D;

        sumOfErrors += error * 0.02;
        lastError = error;
        return output;
    }

    public void reset() {
        lastError = 0;
        sumOfErrors = 0;
    }

    public boolean targetReached(double target) {
        return Math.abs(target - getPIDInput()) < allowableError ? true : false;
    }
}
