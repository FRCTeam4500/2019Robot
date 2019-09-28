/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.automation;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.components.IVision.CameraMode;
import frc.robot.swerve.ISwerveOI;
import frc.robot.swerve.Swerve;
import frc.robot.utility.ExtendedMath;
import frc.robot.vision.Vision;

public class Automation_VisionAssistedDriveCommand extends Command {
    private Vision vision;
    private Swerve swerve;
    private ISwerveOI oi;
    private NetworkTableEntry entry;

    public Automation_VisionAssistedDriveCommand(Vision vision, Swerve swerve, ISwerveOI oi) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(vision);
        requires(swerve);
        this.vision = vision;
        this.swerve = swerve;
        this.oi = oi;
        entry = NetworkTableInstance.getDefault().getEntry("Swerve Assist Value");
        entry.setNumber(0.1);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        vision.setCameraMode(CameraMode.VisionProcessor);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        swerve.moveRobotCentric(oi.getX(), oi.getY(),
                ExtendedMath.clamp(-1, 1, -vision.getHorizontalOffsetFromCrosshair()) * 0.05);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return !vision.hasValidTargets() || oi.getZ() != 0;
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
