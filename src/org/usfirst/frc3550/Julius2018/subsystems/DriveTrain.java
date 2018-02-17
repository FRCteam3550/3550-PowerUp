package org.usfirst.frc3550.Julius2018.subsystems;

import java.nio.channels.FileChannel;

import org.usfirst.frc3550.Julius2018.RobotMap;
import org.usfirst.frc3550.Julius2018.commands.ArcadeDrive;
import org.usfirst.frc3550.Julius2018.commands.TankDriveWithJoystick;

//import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
//import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DoubleSolenoid;
//import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveTrain extends Subsystem {

	private final SpeedController rearLeft = RobotMap.RearLeft;
	private final SpeedController rearRight = RobotMap.RearRight;
	private final SpeedController frontLeft = RobotMap.FrontLeft;
	private final SpeedController frontRight = RobotMap.FrontRight;
	private final DifferentialDrive robotDrive41 = RobotMap.m_drive;
	private final Encoder LeftEncoder = RobotMap.m_leftEncoder;
	private final Encoder RightEncoder = RobotMap.m_rightEncoder;
	private final DoubleSolenoid LeftMotorSolenoid = RobotMap.LeftMotorSolenoid;
	//private TrapezSpeedProfile trapez;
	    
	public DriveTrain() {
		
		LeftEncoder.setMaxPeriod(.1);
		LeftEncoder.setMinRate(0.1);
		LeftEncoder.setDistancePerPulse(0.0166);
		LeftEncoder.setReverseDirection(false);
		LeftEncoder.setSamplesToAverage(7);

		RightEncoder.setMaxPeriod(.1);
		RightEncoder.setMinRate(0.1);
		RightEncoder.setDistancePerPulse(0.0166);// pi*6inches/(4.41*256)
		RightEncoder.setReverseDirection(true);
		RightEncoder.setSamplesToAverage(7);

		addChild("Right Encoder", RightEncoder);
		addChild("Left Encoder", LeftEncoder);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new TankDriveWithJoystick());
		setDefaultCommand(new ArcadeDrive());
	}

	/**
	 * Tank drive using individual joystick axes.
	 *
	 * @param leftAxis
	 *            Left sides value
	 * @param rightAxis
	 *            Right sides value
	 */
	public void tankDrive(double leftAxis, double rightAxis) {
		robotDrive41.tankDrive(leftAxis, rightAxis);
	}

	/**
	 * Arcade drive using individual joystick axes.
	 *
	 * @param leftAxis
	 *            Left sides value
	 * @param rightAxis
	 *            Right sides value
	 */
	public void arcadeDrive(Joystick stick) {
		robotDrive41.arcadeDrive(stick.getX(), -stick.getY());
	}

	/**
	 * Interface to Trapez.
	 */
//	public void SetDistance(int distance, double vmax, double a) {
//		trapez.SetDistance(distance, vmax, a);
//	}
//	
//	public double DistanceMove() {
//		double curSpeed = trapez.DistanceMove();
//		robotDrive41.arcadeDrive(curSpeed, 0.0);
//	}
//	
//	public boolean isDistanceDone() {
//		return trapez.isDistanceDone();
//	}
		
	/**
	 * Stop the drivetrain from moving.
	 */
	public void stop() {
		robotDrive41.tankDrive(0, 0);
	}

	public void reset() {
		LeftEncoder.reset();
		RightEncoder.reset();
	}

	public double getLeftDistance() {
		return LeftEncoder.getDistance();
	}

	public double getRightDistance() {
		return RightEncoder.getDistance();
	}

	public double getLeftRate() {
		return LeftEncoder.getDistance();
	}

	public double getRightRate() {
		return RightEncoder.getDistance();
	}

	public double getDistance() {
		return (LeftEncoder.getDistance() + RightEncoder.getDistance()) / 2;
	}

	public void speedUp() {
		LeftMotorSolenoid.set(DoubleSolenoid.Value.kForward);
	}

	public void slowDown() {
		LeftMotorSolenoid.set(DoubleSolenoid.Value.kReverse);
	}
}
	


