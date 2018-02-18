
package org.usfirst.frc3550.Julius2018.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;


/**
 *
 */
public class Pos2ColorRightObjCubeBascule1Command extends CommandGroup {

	public void Pos2ColorRightObjBasculeCommand() {
		//System.out.println("Running Pos2ColorRightObjCubeBascule1Command.java");
		
		addSequential(new HoldCubeCommand());
		addSequential(new DriveDistanceCommand(50, DriveDistanceCommand.DRIVE_FORWARD));
		//Not yet implemented: addSequential(new RotateController(90, 0));    // 0:Left     / 1:Right
		addSequential(new DriveDistanceCommand(140, DriveDistanceCommand.DRIVE_FORWARD)); 
		addSequential(new DropCubeCommand());
	}
    
}
