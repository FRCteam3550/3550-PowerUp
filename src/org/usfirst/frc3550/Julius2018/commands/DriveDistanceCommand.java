package org.usfirst.frc3550.Julius2018.commands;

import org.usfirst.frc3550.Julius2018.Robot;

import edu.wpi.first.wpilibj.command.Command;


/**
 *
 */
public class DriveDistanceCommand extends Command {

	static final int DRIVE_FORWARD  = 1;
	static final int DRIVE_BACKWARD = 0;

	int m_Distance;
	int m_Direction;
	
	// Distance in mm
	// Direction = 0: Backward 1:Forward
    public DriveDistanceCommand(int distance, int direction)
    {
    	// drivebase subsystem
        requires(Robot.driveTrain);
        
        m_Distance  = distance;
        m_Direction = direction;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//System.out.println("Running DriveDistanceCommand for "+m_Distance+"mm");
    	
    	//Not yet implemented: Robot.driveTrain.SetDistance(m_Distance);
    }
	
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Not yet implemented: Robot.driveTrain.DistanceMove();
    	
    	// TMP to test action
    	Robot.driveTrain.tankDrive(0.5, 0.5);
    }
	
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false; //Not yet implemented: return Robot.driveTrain.isDistanceDone();
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
