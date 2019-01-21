package frc.robot.utility;

@FunctionalInterface
public interface PIDInputInterface<T> {
    public abstract T get();
}