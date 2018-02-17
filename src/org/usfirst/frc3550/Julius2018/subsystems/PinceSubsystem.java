package org.usfirst.frc3550.Julius2018.subsystems;

import org.usfirst.frc3550.Julius2018.RobotMap;
import org.usfirst.frc3550.Julius2018.commands.PickupCubeCommand;
import org.usfirst.frc3550.Julius2018.commands.PinceStopCommand;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PinceSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private final SpeedController  m_PinceRight = RobotMap.m_PinceRight;
	private final SpeedController  m_PinceLeft = RobotMap.m_PinceLeft;
	private final DigitalInput CubeDetect = RobotMap.CubePresence;
	 
    public void initDefaultCommand() {
    	
    	
        // Set the default command for a subsystem here.
      // setDefaultCommand(new PickupCubeCommand());
    		 
    }
    public void Stop() {
    	m_PinceRight.set(0);
    	m_PinceLeft.set(0);
    }
    public void PickupCube(){
    	m_PinceRight.set(-0.75);
    	m_PinceLeft.set(0.75);
    }
    public void HoldCube(){
    	m_PinceLeft.set(0.07);
    	m_PinceLeft.set(0.07);
    }
    public void DropCube(){
    	m_PinceRight.set(0.9);
    	m_PinceLeft.set(-0.9);
    	
    }
    
    public boolean IsCubeHere(){
    	return CubeDetect.get();
    }
}

