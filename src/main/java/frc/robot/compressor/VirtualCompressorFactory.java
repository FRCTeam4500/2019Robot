/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.compressor;

import frc.robot.components.dashboard.CompressorDashboardDecorator;
import frc.robot.components.virtual.VirtualCompressorComponent;

/**
 * Add your docs here.
 */
public class VirtualCompressorFactory {
    public static Compressor MakeCompressor() {
        return new Compressor(new CompressorDashboardDecorator("Virtual Compressor", "Compressor",
                new VirtualCompressorComponent()));
    }
}
