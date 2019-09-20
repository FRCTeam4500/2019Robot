/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.components;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI.Port;

/**
 * Add your docs here.
 */
public class AHRSAngleGetterComponent extends AHRS implements IAngleGetter {

    public AHRSAngleGetterComponent(Port serial_port_id) {
        super(serial_port_id);
    }
}
