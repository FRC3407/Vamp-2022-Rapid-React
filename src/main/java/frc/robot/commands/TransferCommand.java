// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.io.Console;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Transfer;

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
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(timer.hasElapsed(Constants.kTransferDelay)){
    m_transfer.runTransfer();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_transfer.stopTransfer();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
