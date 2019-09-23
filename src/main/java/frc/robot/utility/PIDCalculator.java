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

    public double getP() {
        return kP;
    }

    public double getI() {
        return kI;
    }

    public double getD() {
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
            return kP * error + kI * integral + kD * derivative;
        } else {
            hasRun = true;
            return kP * (setpoint - input);
        }
    }

    public boolean isWithinRange(double input) {
        if (Math.abs(setpoint - input) <= setpointDelta) {
            return true;
        } else {
            return false;
        }
    }
}
