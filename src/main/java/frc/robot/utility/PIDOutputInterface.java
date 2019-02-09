package frc.robot.utility;

@FunctionalInterface
@Deprecated
public interface PIDOutputInterface<T> {
    public abstract T get(T error, T lastError, T sumOfErrors, T kP, T kI, T kD);
}