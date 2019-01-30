package frc.robot.utility;

@FunctionalInterface
public interface PIDOutputInterface<T> {
    public abstract T get(T error, T lastError, T sumOfErrors, T kP, T kI, T kD);
}