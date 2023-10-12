package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  //The speed at which the transfer motor runs
  public static double kTransferSpeed = 1.0;
  public static double kShooterSpeed;
  // kShooterSpeedSlow is when the wrong color ball is detected
  public static double kShooterSpeedSlow;

  public static class OperatorConstants {
    public static final int kDriverControllerPort = 2;
  }
  //Ids for all talon motor controllers
  public static class IDTalon {
    public static final int kLeftFront = 0;
    public static final int kLeftBack = 1;
    public static final int kRightBack = 2;
    public static final int kRightFront = 3;
  }
  //Ids for all victor motor controllers
  public static class IDVictor {
    public static final int kShooter = 0;
    public static final int kTransfer = 1;
    public static final int kIntake = 2;
  }
}
