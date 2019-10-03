/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.automation;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.components.IVision.CameraMode;
import frc.robot.subsystems.swerve.ISwerveOI;
import frc.robot.subsystems.swerve.Swerve;
import frc.robot.utility.PIDCalculator;
import frc.robot.subsystems.vision.Vision;

public class Automation_AlignRobotWithTargetCommand extends Command {
    private Swerve swerve;
    private Vision vision;
    private PIDCalculator xCalculator, yCalculator, wCalculator;
    private double lastTime;
    private ISwerveOI oi;

    public Automation_AlignRobotWithTargetCommand(Swerve swerve, Vision vision,
            PIDCalculator xCalculator, PIDCalculator yCalculator, PIDCalculator wCalculator,
            ISwerveOI oi) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(swerve);
        requires(vision);
        this.swerve = swerve;
        this.vision = vision;
        this.xCalculator = xCalculator;
        this.yCalculator = yCalculator;
        this.wCalculator = wCalculator;
        this.oi = oi;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        vision.setCameraMode(CameraMode.VisionProcessor);
        xCalculator.reset();
        yCalculator.reset();
        wCalculator.reset();
        lastTime = Timer.getFPGATimestamp();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double currentTime = Timer.getFPGATimestamp();
        double deltaTime = currentTime - lastTime;

        double xOffset = vision.getHorizontalOffsetFromCrosshair();
        double yOffset = vision.getVerticalOffsetFromCrosshar();
        double wOffset = vision.getSkew();

        double xOutput = xCalculator.getOutput(xOffset, deltaTime);
        double yOutput = yCalculator.getOutput(yOffset, deltaTime);
        double wOutput = wCalculator.getOutput(wOffset, deltaTime);

        swerve.moveRobotCentric(-xOutput, -yOutput, -wOutput);

        lastTime = currentTime;
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return oi.getX() != 0 || oi.getZ() != 0 || oi.getY() != 0 || !vision.hasValidTargets();
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
