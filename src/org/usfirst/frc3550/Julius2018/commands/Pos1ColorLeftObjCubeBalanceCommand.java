
package org.usfirst.frc3550.Julius2018.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;


/**
 *
 */
public class Pos1ColorLeftObjCubeBalanceCommand extends CommandGroup {

    public Pos1ColorLeftObjCubeBalanceCommand() {
    	//System.out.println("Running Pos1ColorLeftObjCubeBalanceCommand");
    	
    	addSequential(new HoldCubeCommand());
    	addSequential(new DriveDistanceCommand(325, DriveDistanceCommand.DRIVE_FORWARD));
    	//Not yet implemented: addSequential(new RotateController(90, RotateController.ROTATE_RIGHT));
    	addSequential(new DriveDistanceCommand(7, 1));
    	addSequential(new DropCubeCommand());
    }

}
