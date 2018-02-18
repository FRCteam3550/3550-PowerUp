
package org.usfirst.frc3550.Julius2018.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;


/**
 *
 */
public class Pos1ColorRightObjCubeBasculeCommand extends CommandGroup {

    public Pos1ColorRightObjCubeBasculeCommand() {
    	//System.out.println("Running Pos1ColorRightObjCubeBasculeCommand");
    	
    	addSequential(new HoldCubeCommand());
    	addSequential(new DriveDistanceCommand(200, DriveDistanceCommand.DRIVE_FORWARD));
    	//Not yet implemented: addSequential(new RotateController(90, 0));    // 0:Left     / 1:Right
    	addSequential(new DriveDistanceCommand(180,  DriveDistanceCommand.DRIVE_FORWARD));
    	//Not yet implemented: addSequential(new RotateController(90, 0));
    	addSequential(new DropCubeCommand());
    }

}
