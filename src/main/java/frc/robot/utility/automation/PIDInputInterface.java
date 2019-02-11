package frc.robot.utility.automation;

@FunctionalInterface
public interface PIDInputInterface<T> {
    public abstract T get();
}