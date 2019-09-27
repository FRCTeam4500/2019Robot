/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.utility;

/**
 * Add your docs here.
 */
public class PIDCalculator {
    private double kP, kI, kD;
    private double integral;
    private double previousError;
    private double setpoint;
    private double setpointDelta;
    private boolean hasRun;
    private double maxOutput = 1;
    private double minOutput = -1;

    /**
     * @param maxOutput the maxOutput to set
     */
    public void setMaxOutput(double maxOutput) {
        this.maxOutput = maxOutput;
    }

    /**
     * @return the maxOutput
     */
    public double getMaxOutput() {
        return maxOutput;
    }

    /**
     * @return the minOutput
     */
    public double getMinOutput() {
        return minOutput;
    }

    /**
     * @param minOutput the minOutput to set
     */
    public void setMinOutput(double minOutput) {
        this.minOutput = minOutput;
    }

    public PIDCalculator(double kP, double kI, double kD) {
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
    }

    public PIDCalculator(PIDValues values) {
        kP = values.P;
        kI = values.I;
        kD = values.D;
        setpointDelta = values.SetpointDelta;
    }

    public void reset() {
        integral = previousError = 0;
        hasRun = false;
    }

    public void setSetpoint(double setpoint) {
        reset();
        this.setpoint = setpoint;
    }

    public void setSetpointDelta(double setpointDelta) {
        this.setpointDelta = setpointDelta;
    }

    public double getSetpointDelta() {
        return setpointDelta;
    }

    public double getSetpoint() {
        return setpoint;
    }

    public double getkP() {
        return kP;
    }

    public double getkI() {
        return kI;
    }

    public double getkD() {
        return kD;
    }

    public double getIntegral() {
        return integral;
    }

    public double getPreviousError() {
        return previousError;
    }

    public double getOutput(double input, double deltaTime) {
        if (hasRun) {
            double error = setpoint - input;
            integral += error * deltaTime;
            double derivative = (error - previousError) / deltaTime;
            double output = kP * error + kI * integral + kD * derivative;
            return ExtendedMath.clamp(minOutput, maxOutput, output);
        } else {
            hasRun = true;
            double output = kP * (setpoint - input);
            return ExtendedMath.clamp(minOutput, maxOutput, output);
        }
    }

    public boolean isWithinRange(double input) {
        if (Math.abs(setpoint - input) <= setpointDelta) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param kP the kP to set
     */
    public void setkP(double kP) {
        this.kP = kP;
    }

    /**
     * @param kI the kI to set
     */
    public void setkI(double kI) {
        this.kI = kI;
    }

    /**
     * @param kD the kD to set
     */
    public void setkD(double kD) {
        this.kD = kD;
    }

}
