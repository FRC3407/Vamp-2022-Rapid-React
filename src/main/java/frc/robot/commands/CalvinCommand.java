// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.Constants;
// import frc.robot.subsystems.Shooter;

public class CalvinCommand extends CommandBase {
  public static String text;
  public int time=120;

  /** Creates a new CalvinCommand. 
  */
  public CalvinCommand(String message) {
    text=message;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (time%5==0) {
      // System.out.printf("%s: %d\n",text,time);
      SmartDashboard.putString("CalvinCommand status", String.format("%s: %d", text, time));
    }
    time--;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // System.out.println("\nBye!");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return time<0; // stop when time is zero
  }
}
