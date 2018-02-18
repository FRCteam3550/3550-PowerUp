
package org.usfirst.frc3550.Julius2018.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;


/**
 *
 */
public class PosXColorXObjAutolineCommand extends CommandGroup {

    public PosXColorXObjAutolineCommand() {
    	//System.out.println("Running PosXColorXObjAutolineCommand");
    	
    	addSequential(new DriveDistanceCommand(120, DriveDistanceCommand.DRIVE_FORWARD));
    }

}
