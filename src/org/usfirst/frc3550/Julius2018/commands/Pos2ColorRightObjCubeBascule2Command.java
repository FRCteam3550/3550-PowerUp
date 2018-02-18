
package org.usfirst.frc3550.Julius2018.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;


/**
 *
 */
public class Pos2ColorRightObjCubeBascule2Command extends CommandGroup {

    public Pos2ColorRightObjCubeBascule2Command() {
    	//System.out.println("Running Pos2ColorRightObjCubeBascule2Command.java");
        
    	addSequential(new HoldCubeCommand());
    	addSequential(new DriveDistanceCommand(60, DriveDistanceCommand.DRIVE_FORWARD));
    	//Not yet implemented: addSequential(new RotateController(90, 1));    // 0:Left     / 1:Right
    	addSequential(new DriveDistanceCommand(50, DriveDistanceCommand.DRIVE_FORWARD));
    	//Not yet implemented: addSequential(new RotateController(90, 0));
    	addSequential(new DriveDistanceCommand(80, DriveDistanceCommand.DRIVE_FORWARD));
    	addSequential(new DropCubeCommand());
    }

}
