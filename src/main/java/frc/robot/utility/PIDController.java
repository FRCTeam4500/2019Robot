package frc.robot.utility;

import edu.wpi.first.wpilibj.Preferences;
import frc.robot.Robot;

public class PIDController {
    private String id;
    private double kP, kI, kD;
    private double allowableError, lastError = 0, sumOfErrors = 0;
    private PIDInputInterface<Double> pidInput;

    public PIDController(String id, double kP, double kI, double kD, double allowableError, PIDInputInterface<Double> pidInput) {
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
        
        if (Robot.pidChooser.getSelected()) {
            this.kP = Robot.pref.getDouble(id + "_kP", this.kP);
            this.kI = Robot.pref.getDouble(id + "_kI", this.kI);
            this.kD = Robot.pref.getDouble(id + "_kD", this.kD);
        }

        double output =  kP * error + 
                  kI * sumOfErrors +
                  kD * (error - lastError);

        sumOfErrors += error;
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