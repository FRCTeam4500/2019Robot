package frc.robot.swerve;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import frc.robot.components.MockAngleSetter;
import frc.robot.components.MockSpeedSetter;
import frc.robot.swerve.Swerve;
import frc.robot.swerve.WheelModule;

public class Swerve_MoveRobotCentricShould {

    private Swerve swerve;
    private MockAngleSetter fla, fra, bla, bra;
    private MockSpeedSetter fls, frs, bls, brs;

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
    public void DriveForward() {
        swerve.moveRobotCentric(1, 0, 0);

        assertTrue(fla.getAngle() == 5 * Math.PI / 4);
        assertTrue(fra.getAngle() == 3 * Math.PI / 4);
        assertTrue(bla.getAngle() == 7 * Math.PI / 4);
        assertTrue(bra.getAngle() == 1 * Math.PI / 4);

        assertTrue(fls.getSpeed() == 1);
        assertTrue(frs.getSpeed() == 1);
        assertTrue(bls.getSpeed() == 1);
        assertTrue(brs.getSpeed() == 1);
    }
}
