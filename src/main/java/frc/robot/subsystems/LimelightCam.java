/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST and other WPILib contributors.                         */
/* Open Source Software; you can modify and/or share it under the terms of    */
/* the WPILib BSD license file in the root directory of this project.         */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

public class LimelightCam extends SubsystemBase {
  NetworkTable table;
  String camName;
 
  public LimelightCam(String camName) {
    table = NetworkTableInstance.getDefault().getTable(camName);
    this.camName = camName;
  }

  @Override
  public void periodic() {
  }

  public String getName() {
    return camName;
  }

  public double getV() {
    return table.getEntry("tv").getDouble(0.0);
  }
  
  public double getX() {
    return table.getEntry("tx").getDouble(0.0);
  }

  public double getY() {
    return table.getEntry("ty").getDouble(0.0);
  }

  public double getArea() {
    return table.getEntry("ta").getDouble(0.0);
  }

  public void setPipe(int pipe) {
    table.getEntry("pipeline").setNumber(pipe);
  }
}
