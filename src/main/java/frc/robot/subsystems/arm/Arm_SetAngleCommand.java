/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.arm;

/**
 * Add your docs here.
 */
public class Arm_SetAngleCommand extends Arm_BaseCommand {

    private double angle;

    public Arm_SetAngleCommand(Arm arm, double angle) {
        super(arm);
        this.angle = angle;
    }

    @Override
    protected void initialize() {
        arm.setAngle(angle);
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void execute() {
    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
    }
}
