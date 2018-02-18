
package org.usfirst.frc3550.Julius2018.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;


/**
 *
 */
public class Pos2ColorLeftObjCubeBascule1Command extends CommandGroup {
    
    public Pos2ColorLeftObjCubeBascule1Command() {
    	//System.out.println("Running Pos2ColorLeftObjCubeBascule1Command");
    	
    	addSequential(new HoldCubeCommand());
    	addSequential(new DriveDistanceCommand(60,  DriveDistanceCommand.DRIVE_BACKWARD));
    	//Not yet implemented: addSequential(new RotateController(90, 0));    // 0:Left     / 1:Right
    	addSequential(new DriveDistanceCommand(140, DriveDistanceCommand.DRIVE_FORWARD));
    	addSequential(new DropCubeCommand());
    }
}
