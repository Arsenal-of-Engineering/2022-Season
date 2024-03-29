/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST and other WPILib contributors.                         */
/* Open Source Software; you can modify and/or share it under the terms of    */
/* the WPILib BSD license file in the root directory of this project.         */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;

public class LimelightSteering extends CommandBase {
  double Kp;
  double min_command;
  double tx;
  double heading_error;
  double steering_adjust;
  LimelightCam cam;
  SwerveDrive swerveDrive;
  JoystickButton button;
  boolean upsideDown;

  public LimelightSteering(LimelightCam cam, SwerveDrive swerveDrive, JoystickButton button, boolean upsideDown) {
    addRequirements(cam);
    addRequirements(swerveDrive);
    this.cam = cam;
    Kp = -0.03;
    min_command = 0.08;
    tx = cam.getX();
    heading_error = upsideDown ? tx : -tx;
    steering_adjust = 0.0;
    this.swerveDrive = swerveDrive;
    this.button = button;
    this.upsideDown = upsideDown;
  }
 
  @Override
  public void initialize() {
  }
 
  @Override
  public void execute() {
    tx = cam.getX();

    if (tx > 1.0) {
      steering_adjust = Kp * tx - min_command;
    } else if (tx < 1.0) {
      steering_adjust = Kp * tx + min_command;
    }

    System.out.println("steering_adjust: " + steering_adjust);

    if (steering_adjust > 0.4)
      steering_adjust = 0.4;

    swerveDrive.drive(0, 0, -steering_adjust);
  }
   
  @Override
  public void end(boolean interrupted) {
    System.out.println("ending limelightsteering");
  }
 
  @Override
  public boolean isFinished() {
    return !button.get();
  }
}
