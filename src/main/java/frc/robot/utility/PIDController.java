package frc.robot.utility;

public class PIDController {
    
    private double kP, kI, kD;
    private double allowableError, lastError = 0, sumOfErrors = 0;
    private PIDInputInterface<Double> pidInput;

    public PIDController(double kP, double kI, double kD, double allowableError, PIDInputInterface<Double> pidInput) {
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