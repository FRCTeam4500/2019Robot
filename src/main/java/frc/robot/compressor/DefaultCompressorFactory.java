/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.compressor;

import frc.robot.RobotMap;
import frc.robot.components.CompressorComponent;

/**
 * Add your docs here.
 */
public class DefaultCompressorFactory {
    public static Compressor MakeCompressor() {
        return new Compressor(new CompressorComponent(RobotMap.COMPRESSOR));
    }
}