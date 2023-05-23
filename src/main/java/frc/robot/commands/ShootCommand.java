// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Shooter;

public class ShootCommand extends CommandBase {
  private final Shooter m_shooter;
  private Timer timer = new Timer();
  private double variableSpeed = 0.1;
  private DoubleSupplier targetSpeed;
  /** Creates a new ShooterCommand. 
   * @param m_shooter The subsystem used by this command.
  */
  public ShootCommand(Shooter m_shooter, DoubleSupplier speed) {
    this.m_shooter = m_shooter;
    addRequirements(m_shooter);
    targetSpeed = speed;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_shooter.setShooter(variableSpeed);
    //m_shooter.resetCounter();
    timer.reset();
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(timer.hasElapsed(1.0))
    {
      setRate();
      timer.reset();
      timer.start();
      // if(m_shooter.getRate()<Constants.kShooterSpeed){
      //   variableSpeed+=0.1;
      // }
      // else if (m_shooter.getRate()>Constants.kShooterSpeed)
      // {
      //   variableSpeed-=0.1;
      // }
      m_shooter.resetCounter();
    }
    m_shooter.setShooter(targetSpeed.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_shooter.setShooter(0);
    timer.stop();
    timer.reset();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

  public void setRate()
  {
    m_shooter.setRate(m_shooter.getCounts()/timer.get());
  }
}
