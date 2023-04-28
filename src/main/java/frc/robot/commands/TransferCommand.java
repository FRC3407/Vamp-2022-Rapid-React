// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Transfer;

public class TransferCommand extends CommandBase {
  private final Transfer m_transfer;
  /** Creates a new TransferCommand. */
  public TransferCommand(Transfer m_transfer) {
    this.m_transfer = m_transfer;
    addRequirements(m_transfer);
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    m_transfer.runTransfer();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_transfer.runTransfer();
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
