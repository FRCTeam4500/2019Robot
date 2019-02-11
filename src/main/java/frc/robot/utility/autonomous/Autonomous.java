package frc.robot.utility.autonomous;

import java.io.File;

import frc.robot.RobotMap;
import frc.robot.subsystems.Swerve;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.SwerveModifier;

public class Autonomous {
    private int temp = 0;

    private Swerve swerve;
    private SwerveModifier.Mode mode = SwerveModifier.Mode.SWERVE_DEFAULT;
    private Trajectory trajectory;

    // private EncoderFollower flFollower;
    // private EncoderFollower frFollower;
    private EncoderFollower blFollower;
    private EncoderFollower brFollower;

    private int[][] deltaP = new int[4][2];
    private boolean displayed = false;

    public Autonomous(Swerve swerve) {
        this.swerve = swerve;
        blFollower.configurePIDVA(.5, 0, 0, .28, .99);
        brFollower.configurePIDVA(.5, 0, 0, .28, .99);
        // Preferences prefs = Preferences.getInstance();
    }

    public void loadTrajectory(File f) {
        // Preferences prefs = Preferences.getInstance();
        trajectory = Pathfinder.readFromCSV(f);

        SwerveModifier modifier = new SwerveModifier(trajectory);
        // modifier.modify(RobotMap.wheelBaseWidth, RobotMap.wheelBaseDepth, mode);

        // modifier = new SwerveModifier(trajectory).modify(RobotMap.wheelBaseWidth,
        // RobotMap.wheelBaseDepth, SwerveModifier.Mode.SWERVE_DEFAULT);
        //
        // flFollower = new EncoderFollower(modifier.getFrontLeftTrajectory());
        // flFollower.configureEncoder(swerve.getBR().getDrivePosition(),
        // RobotMap.ticksPerRotation, RobotMap.wheelDiameter);
        // flFollower.configurePIDVA(prefs.getDouble("P", 0), prefs.getDouble("I", 0),
        // prefs.getDouble("I", 0), 1 / prefs.getDouble("V", 0), prefs.getDouble("A",
        // 0));
        //
        // frFollower = new EncoderFollower(modifier.getFrontRightTrajectory());
        // frFollower.configureEncoder(swerve.getBR().getDrivePosition(),
        // RobotMap.ticksPerRotation, RobotMap.wheelDiameter);
        // frFollower.configurePIDVA(prefs.getDouble("P", 0), prefs.getDouble("I", 0),
        // prefs.getDouble("I", 0), 1 / prefs.getDouble("V", 0), prefs.getDouble("A",
        // 0));
        //
        blFollower = new EncoderFollower(modifier.getBackLeftTrajectory());
        // blFollower.configureEncoder(swerve.getBL().getDrivePosition(), RobotMap.ticksPerRotation,
        //         RobotMap.wheelDiameter);

        brFollower = new EncoderFollower(modifier.getBackRightTrajectory());
        // brFollower.configureEncoder(swerve.getBR().getDrivePosition(), RobotMap.ticksPerRotation,
        //         RobotMap.wheelDiameter);

        deltaP[3][0] = swerve.getBL().getDrivePosition();
        deltaP[4][0] = swerve.getBR().getDrivePosition();
        displayed = false;
    }

    public void drive() {
        // double flOutput = flFollower.calculate(swerve.getBR().getDrivePosition());
        // double flHeading =
        // Pathfinder.boundHalfDegrees(Pathfinder.r2d(flFollower.getHeading())); //
        // Bound to -180..180 degrees

        //
        // double frOutput = frFollower.calculate(swerve.getBR().getDrivePosition());
        // double frHeading =
        // Pathfinder.boundHalfDegrees(Pathfinder.r2d(frFollower.getHeading())); //
        // Bound to -180..180 degrees
        double blOutput = blFollower.calculate(swerve.getBL().getDrivePosition()) + 3.56;
        double blHeading = Pathfinder.boundHalfDegrees(Pathfinder.r2d(blFollower.getHeading())); // Bound to -180..180
                                                                                                 // degrees

        if (!blFollower.isFinished()) {
            swerve.getBL().drive(blOutput / 12, blHeading);
            swerve.getFL().drive(blOutput / 12, blHeading);
        }

        double brOutput = brFollower.calculate(swerve.getBR().getDrivePosition()) + 3.56;
        double brHeading = Pathfinder.boundHalfDegrees(Pathfinder.r2d(brFollower.getHeading())); // Bound to -180..180
                                                                                                 // degrees

        if (!brFollower.isFinished()) {
            swerve.getBR().drive(brOutput / 12, brHeading);
            swerve.getFR().drive(brOutput / 12, brHeading);
        }

        if (blFollower.isFinished() && brFollower.isFinished() && !displayed) {
            deltaP[3][1] = swerve.getBL().getDrivePosition();
            deltaP[4][1] = swerve.getBR().getDrivePosition();

            System.out.println("BL Dist: " + distTraveled(deltaP[3]));
            System.out.println("BR Dist: " + distTraveled(deltaP[4]));

            displayed = true;
        } else if (!displayed) {
            // if(temp % 20 == 0) {
            // System.out.format("%-10s%-10s%-10s%-10s\n",
            // "blOut", "blHead", "brOut", "brHead");
            // }
            // temp++;
            // System.out.format("%-10.2f%-10.2f%-10.2f%-10.2f\n",
            // blOutput/12, blHeading, brOutput/12, brHeading);
        }
    }

    private double distTraveled(int[] deltaP) {
        int dist = Math.abs(deltaP[1] - deltaP[0]);
        double mDist = 0.000049 * dist;
        return mDist;
    }

}