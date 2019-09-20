package frc.robot.learning;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Math_Atan2Should {
    private final double MAX_DOUBLE_DELTA = 0.000001;

    @Test
    public void ReturnZeroWithPositiveX() {
        var result = Math.atan2(0, 1);

        assertWithDelta(0, result);
    }

    @Test
    public void ReturnHalfPiWithPositiveY() {
        var result = Math.atan2(1, 0);

        assertWithDelta(Math.PI / 2, result);
    }

    @Test
    public void ReturnPiWithNegativeX() {
        var result = Math.atan2(0, -1);

        assertWithDelta(Math.PI, result);
    }

    @Test
    public void ReturnNegativeHalfPiWithNegativeY() {
        var result = Math.atan2(-1, 0);

        assertWithDelta(-Math.PI / 2, result);
    }

    private void assertWithDelta(double expected, double actual) {
        assertEquals(expected, actual, MAX_DOUBLE_DELTA);
    }
}
