package frc.robot.utility.automation;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.RobotMap;

public class Vision {

    private NetworkTableInstance nt;
    private NetworkTable table;
    private NetworkTableEntry camtran;
    private double[] camArray;

    public Vision() {
        nt = NetworkTableInstance.getDefault();
        table = nt.getTable("limelight");

        camtran = table.getEntry("camtran");
    }

    public double[] getTranslationalData() {
        return camtran.getDoubleArray(new double[6]);
    }

    public double getTranslationalX() {
        return getTranslationalData()[0];
    }

    public double getTranslationalY() {
        return getTranslationalData()[1];
    }

    public double getTranslationalZ() {
        return getTranslationalData()[2];
    }

    public double getTranslationalPitch() {
        return getTranslationalData()[3];
    }

    public double getTranslationalYaw() {
        return getTranslationalData()[4];
    }

    public double getTranslationalRoll() {
        return getTranslationalData()[5];
    }
}
