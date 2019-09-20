package frc.robot.swerve;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import frc.robot.components.MockAngleSetter;
import frc.robot.components.MockSpeedSetter;
import frc.robot.swerve.Swerve;
import frc.robot.swerve.WheelModule;

public class Swerve_MoveRobotCentricShould {

    private Swerve swerve;
    private MockAngleSetter fla, fra, bla, bra;
    private MockSpeedSetter fls, frs, bls, brs;
    private final double MAX_DOUBLE_DELTA = 0.001;

    public Swerve_MoveRobotCentricShould() {
        fla = new MockAngleSetter();
        fra = new MockAngleSetter();
        bla = new MockAngleSetter();
        bra = new MockAngleSetter();

        fls = new MockSpeedSetter();
        frs = new MockSpeedSetter();
        bls = new MockSpeedSetter();
        brs = new MockSpeedSetter();

        swerve = new Swerve(1, 1, new WheelModule(fla, fls), new WheelModule(fra, frs),
                new WheelModule(bla, bls), new WheelModule(bra, brs));
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

        assertWithDelta(WheelFace.BACKWARD, Math.abs(fla.getAngle()));
        assertWithDelta(WheelFace.BACKWARD, Math.abs(fra.getAngle()));
        assertWithDelta(WheelFace.BACKWARD, Math.abs(bla.getAngle()));
        assertWithDelta(WheelFace.BACKWARD, Math.abs(bra.getAngle()));
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

        assertWithDelta(0, fls.getSpeed());
        assertWithDelta(0, frs.getSpeed());
        assertWithDelta(0, bls.getSpeed());
        assertWithDelta(0, brs.getSpeed());
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
        assertWithDelta(flAngle, fla.getAngle());
        assertWithDelta(frAngle, fra.getAngle());
        assertWithDelta(blAngle, bla.getAngle());
        assertWithDelta(brAngle, bra.getAngle());
    }

    private void assertAllAtAngle(double angle) {
        assertAtAngles(angle, angle, angle, angle);
    }

    private void assertAtFullSpeed() {
        assertWithDelta(1, fls.getSpeed());
        assertWithDelta(1, frs.getSpeed());
        assertWithDelta(1, bls.getSpeed());
        assertWithDelta(1, brs.getSpeed());
    }

    private void assertWithDelta(double expected, double actual) {
        assertEquals(expected, actual, MAX_DOUBLE_DELTA);
    }
}
