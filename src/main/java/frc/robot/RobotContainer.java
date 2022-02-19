// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
 
package frc.robot;
 
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;
import frc.robot.commands.*;
 
/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private XboxController joystick;
 
  private final SwerveDrive swerveDrive;
  private final WheelDrive fL;
  private final WheelDrive fR;
  private final WheelDrive bL;
  private final WheelDrive bR;
 
  public final LimelightCam cam;
 
  public final DriveJoystick driveJoystick;
  private final SubsystemBase[] subsystemList;
 
  private JoystickButton buttonB, buttonY;
  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer(XboxController controller) {
    // Configure the button bindings
    configureButtonBindings();
    joystick = controller;
 
    fL = new WheelDrive("FL", 5, 1, 15, 0.00, 2000, 1023, true);
    fR = new WheelDrive("FR", 6, 2, 15, 0.00, 20, 1023, true);
    bL = new WheelDrive("BL", 7, 3, 15, 0.00, 2000, 1023, true);
    bR = new WheelDrive("BR", 8, 4, 15, 0.00, 20, 1023, true);
    swerveDrive = new SwerveDrive(bR, bL, fR, fL, 27.0, 21.0);
    cam = new LimelightCam();
 
    driveJoystick = new DriveJoystick(swerveDrive, joystick);
 
    buttonB = new JoystickButton(joystick, 1);
    buttonY = new JoystickButton(joystick, 3);
  }
 
  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
   * it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    buttonB.whenPressed(new LimelightSteering(cam, swerveDrive, buttonB));
    buttonY.whenPressed(new LimelightDistance(cam, swerveDrive, buttonY));
  }
 
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
