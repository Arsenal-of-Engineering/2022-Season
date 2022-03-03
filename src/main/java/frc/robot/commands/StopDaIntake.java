// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.*;


// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class StopDaIntake extends InstantCommand {
  private Conveyor conveyor;

  public StopDaIntake(Conveyor conveyor) {
    addRequirements(conveyor);
    this.conveyor = conveyor;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    conveyor.setConveyor(0);
  }
}