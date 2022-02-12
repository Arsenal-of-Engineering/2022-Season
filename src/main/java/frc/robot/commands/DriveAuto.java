// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;

public class DriveAuto extends CommandBase {
  /** Creates a new DriveJoystick. */

  private SwerveDrive swerveDrive;
  private int x1,y1,x2;

  public DriveAuto(int x1, int y1, int x2, SwerveDrive swerveDrive) {
    addRequirements(swerveDrive);
    this.swerveDrive = swerveDrive;
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    swerveDrive.drive(x1, y1, x2);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
