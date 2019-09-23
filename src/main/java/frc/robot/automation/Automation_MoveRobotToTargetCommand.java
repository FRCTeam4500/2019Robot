/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.automation;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.components.IVision;
import frc.robot.swerve.Swerve;
import frc.robot.utility.PIDCalculator;
import frc.robot.utility.PIDValues;
import frc.robot.vision.Vision;

public class Automation_MoveRobotToTargetCommand extends Command {

    private PIDCalculator xCalculator, yCalculator, wCalculator;
    private Vision vision;
    private Swerve swerve;
    private double lastTime;

    public Automation_MoveRobotToTargetCommand(Vision vision, Swerve swerve,
            PIDValues xCalculatorValues, PIDValues yCalculatorValues, PIDValues wCalculatorValues) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(vision);
        requires(swerve);
        this.vision = vision;
        this.swerve = swerve;
        xCalculator = new PIDCalculator(xCalculatorValues);
        yCalculator = new PIDCalculator(yCalculatorValues);
        wCalculator = new PIDCalculator(wCalculatorValues);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        vision.setCameraMode(IVision.CameraMode.VisionProcessor);
        xCalculator.reset();
        yCalculator.reset();
        wCalculator.reset();
        lastTime = Timer.getFPGATimestamp();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double time = Timer.getFPGATimestamp();
        double deltaTime = time - lastTime;
        swerve.moveAngleCentric(
                xCalculator.getOutput(vision.getHorizontalOffsetFromCrosshair(), deltaTime),
                yCalculator.getOutput(vision.getVerticalOffsetFromCrosshar(), deltaTime),
                wCalculator.getOutput(vision.getSkew(), deltaTime), vision.getSkew());
        lastTime = time;
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return xCalculator.isWithinRange(vision.getHorizontalOffsetFromCrosshair())
                && yCalculator.isWithinRange(vision.getVerticalOffsetFromCrosshar())
                && wCalculator.isWithinRange(vision.getSkew());
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
