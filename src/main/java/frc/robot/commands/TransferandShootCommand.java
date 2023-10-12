package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Transfer;

public class TransferandShootCommand extends CommandBase {
  /** Creates a new IntakeandShootCommand. */
  private final Shooter m_shooter;
  private final Transfer m_transfer;
 

  public TransferandShootCommand(Shooter shooter, Transfer transfer) {
    this.m_shooter = shooter;
    this.m_transfer = transfer;
    addRequirements(m_shooter, m_transfer);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      new TransferCommand(m_transfer).withTimeout(3).andThen(new ShootCommand(m_shooter));
      //
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
