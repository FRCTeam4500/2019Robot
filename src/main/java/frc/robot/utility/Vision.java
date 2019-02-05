package frc.robot.utility;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.RobotMap;

public class Vision {

    private NetworkTableInstance nt;
    private NetworkTable table;
    private NetworkTableEntry centerX, centerY;

    public Vision() {
        nt = NetworkTableInstance.getDefault();
        table = nt.getTable("SmartDashboard");
        centerX = table.getEntry("centerX");
        centerY = table.getEntry("centerY");
        
        RobotMap.imgW = table.getEntry("imgW").getDouble(0);
        RobotMap.imgCenterW = RobotMap.imgW / 2;
        RobotMap.imgH = table.getEntry("imgH").getDouble(0);
        RobotMap.imgCenterH = RobotMap.imgH / 2;

        RobotMap.focalLength = RobotMap.imgW / (2 * Math.tan((RobotMap.FOV*Math.PI/180)/2));
    }

    public double[] getCenter() {
        return new double[] {centerX.getDouble(0), centerY.getDouble(0)};
    }
}