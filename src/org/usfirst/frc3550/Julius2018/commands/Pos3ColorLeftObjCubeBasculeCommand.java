
package org.usfirst.frc3550.Julius2018.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;


/**
 *
 */
public class Pos3ColorLeftObjCubeBasculeCommand extends CommandGroup {

    public Pos3ColorLeftObjCubeBasculeCommand() {
    	//System.out.println("Running Pos3ColorLeftObjCubeBasculeCommand");

    	addSequential(new HoldCubeCommand());
    	addSequential(new DriveDistanceCommand(60, DriveDistanceCommand.DRIVE_FORWARD));
    	//Not yet implemented: addSequential(new RotateController(90,   0));    // 0:Left     / 1:Right
    	addSequential(new DriveDistanceCommand(90, DriveDistanceCommand.DRIVE_FORWARD));
    	//Not yet implemented: addSequential(new RotateController(90,   1));
    	addSequential(new DriveDistanceCommand(80, DriveDistanceCommand.DRIVE_FORWARD));
    	addSequential(new DropCubeCommand());
    }

}
