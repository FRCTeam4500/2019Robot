package frc.robot.utility;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Vision {

    private NetworkTableInstance nt;
    private NetworkTable table;
    private NetworkTableEntry cvData;

    public Vision() {
        nt = NetworkTableInstance.getDefault();
        table = nt.getTable("Smartdashboard");
        cvData = table.getEntry("CVData");
    }

    public double[] getCvData() {
        return cvData.getDoubleArray(new double[] {0, 0});
    }
}