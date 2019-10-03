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
public class Arm_DriveCommand extends Arm_BaseCommand {

    private IArmOI oi;
    private double lastAngle;
    private int count;

    public Arm_DriveCommand(Arm arm, IArmOI oi) {
        super(arm);
        this.oi = oi;
    }

    @Override
    protected void initialize() {
        count = 0;
    }

    @Override
    protected void execute() {
        double currentAngle = oi.getArmAngle();
        if (currentAngle != lastAngle) {
            arm.setAngle(currentAngle);
            lastAngle = currentAngle;
            count++;
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

}
