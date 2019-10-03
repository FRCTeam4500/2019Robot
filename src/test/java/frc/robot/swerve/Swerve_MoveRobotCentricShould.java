package frc.robot.swerve;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import frc.robot.subsystems.swerve.Swerve;

public class Swerve_MoveRobotCentricShould {

    private Swerve swerve;
    private MockWheelModule fl, fr, bl, br;
    private final double MAX_DOUBLE_DELTA = 0.001;

    public Swerve_MoveRobotCentricShould() {
        fl = new MockWheelModule();
        fr = new MockWheelModule();
        bl = new MockWheelModule();
        br = new MockWheelModule();

        swerve = new Swerve(1, 1, fl, fr, bl, br, null);
    }

    @Test
    public void TurnCCW() {
        swerve.moveRobotCentric(0, 0, 1);

        assertAtAngles(WheelFace.BACKWARD_LEFT, WheelFace.FORWARD_LEFT, WheelFace.BACKWARD_RIGHT,
                WheelFace.FORWARD_RIGHT);
        assertAtFullSpeed();
    }

    @Test
    public void MoveForward() {
        swerve.moveRobotCentric(0, 1, 0);

        assertAllAtAngle(WheelFace.FORWARD);
        assertAtFullSpeed();
    }

    @Test
    public void MoveBackward() {
        swerve.moveRobotCentric(0, -1, 0);

        assertWithDelta(WheelFace.BACKWARD, Math.abs(fl.getLastSetAngle()));
        assertWithDelta(WheelFace.BACKWARD, Math.abs(fr.getLastSetAngle()));
        assertWithDelta(WheelFace.BACKWARD, Math.abs(bl.getLastSetAngle()));
        assertWithDelta(WheelFace.BACKWARD, Math.abs(br.getLastSetAngle()));
        assertAtFullSpeed();
    }

    @Test
    public void MoveLeft() {
        swerve.moveRobotCentric(-1, 0, 0);

        assertAllAtAngle(WheelFace.LEFT);
        assertAtFullSpeed();
    }

    @Test
    public void MoveRight() {
        swerve.moveRobotCentric(1, 0, 0);

        assertAllAtAngle(WheelFace.RIGHT);
        assertAtFullSpeed();
    }

    @Test
    public void MoveCW() {
        swerve.moveRobotCentric(0, 0, -1);

        assertAtAngles(WheelFace.FORWARD_RIGHT, WheelFace.BACKWARD_RIGHT, WheelFace.FORWARD_LEFT,
                WheelFace.BACKWARD_LEFT);
        assertAtFullSpeed();
    }

    @Test
    public void NotMove() {
        swerve.moveRobotCentric(0, 0, 0);

        assertWithDelta(0, fl.getLastSetSpeed());
        assertWithDelta(0, fr.getLastSetSpeed());
        assertWithDelta(0, bl.getLastSetSpeed());
        assertWithDelta(0, br.getLastSetSpeed());
    }

    @Test
    public void MoveForwardLeft() {
        swerve.moveRobotCentric(-1, 1, 0);

        assertAllAtAngle(WheelFace.FORWARD_LEFT);
        assertAtFullSpeed();
    }

    @Test
    public void MoveBackwardLeft() {
        swerve.moveRobotCentric(-1, -1, 0);

        assertAllAtAngle(WheelFace.BACKWARD_LEFT);
        assertAtFullSpeed();
    }

    @Test
    public void MoveForwardRight() {
        swerve.moveRobotCentric(1, 1, 0);

        assertAllAtAngle(WheelFace.FORWARD_RIGHT);
        assertAtFullSpeed();
    }

    @Test
    public void MoveBackwardRight() {
        swerve.moveRobotCentric(1, -1, 0);

        assertAllAtAngle(WheelFace.BACKWARD_RIGHT);
        assertAtFullSpeed();
    }

    private void assertAtAngles(double flAngle, double frAngle, double blAngle, double brAngle) {
        assertWithDelta(flAngle, fl.getLastSetAngle());
        assertWithDelta(frAngle, fr.getLastSetAngle());
        assertWithDelta(blAngle, bl.getLastSetAngle());
        assertWithDelta(brAngle, br.getLastSetAngle());
    }

    private void assertAllAtAngle(double angle) {
        assertAtAngles(angle, angle, angle, angle);
    }

    private void assertAtFullSpeed() {
        assertWithDelta(1, fl.getLastSetSpeed());
        assertWithDelta(1, fr.getLastSetSpeed());
        assertWithDelta(1, bl.getLastSetSpeed());
        assertWithDelta(1, br.getLastSetSpeed());
    }

    private void assertWithDelta(double expected, double actual) {
        assertEquals(expected, actual, MAX_DOUBLE_DELTA);
    }
}
