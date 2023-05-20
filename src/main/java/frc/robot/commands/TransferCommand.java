// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.io.Console;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Transfer;
import frc.robot.RobotContainer;
public class TransferCommand extends CommandBase {
  private final Transfer m_transfer;
  private Timer timer = new Timer();
  /** Creates a new TransferCommand. 
   * @param m_transfer The subsystem used by this command.
  */
  public TransferCommand(Transfer m_transfer) {
    this.m_transfer = m_transfer;
    addRequirements(m_transfer);
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    timer.reset();
    timer.start();
    //Sets rumble
    RobotContainer.m_controller.getHID().setRumble(RumbleType.kLeftRumble, 0.2);
    RobotContainer.m_controller.getHID().setRumble(RumbleType.kLeftRumble, 0.2);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //After the kTransferDelay has elapsed, runs the transfer
    if(timer.hasElapsed(Constants.kTransferDelay)){
    m_transfer.runTransfer();
    //Sets rumble
    RobotContainer.m_controller.getHID().setRumble(RumbleType.kLeftRumble, 1);
    RobotContainer.m_controller.getHID().setRumble(RumbleType.kLeftRumble, 1);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_transfer.stopTransfer();
    //Sets rumble
    RobotContainer.m_controller.getHID().setRumble(RumbleType.kLeftRumble, 0);
    RobotContainer.m_controller.getHID().setRumble(RumbleType.kLeftRumble, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
