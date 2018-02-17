package org.usfirst.frc3550.Julius2018.commands;

import org.usfirst.frc3550.Julius2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveRotateCommand extends Command {

	int m_Angle;
	int m_Direction;
	
	// Angle in degre
	// Direction = 0: Backward 1:Forward
    public DriveRotateCommand(int angle, int direction)
    {
    	// drivebase subsystem
        requires(Robot.driveTrain);
        
        m_Angle  = angle;
        m_Direction = direction;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.driveTrain.SetRotation(m_Angle, m_Direction);
    	
    	System.out.println("Running DriveRotateCommand for "+m_Angle+"deg");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	return;//Robot.driveTrain.RotationMove();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;//Robot.driveTrain.isRotationDone();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
