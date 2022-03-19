/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST and other WPILib contributors.                         */
/* Open Source Software; you can modify and/or share it under the terms of    */
/* the WPILib BSD license file in the root directory of this project.         */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class GoinBackWithDaIntake extends CommandBase {
  private Conveyor conveyor;
  private JoystickButton button;

  public GoinBackWithDaIntake(Conveyor conveyor, JoystickButton button) {
    addRequirements(conveyor);
    this.conveyor = conveyor;
    this.button = button;
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    conveyor.setConveyor(-0.5);
  }

  @Override
  public void end(boolean interrupted) {
    
  }

  @Override
  public boolean isFinished() {
    return !button.get();
  }
}
