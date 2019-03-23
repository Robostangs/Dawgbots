/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * Add your docs here.
 */
public class Utils {
    public static double expoDeadzone(double input, double deadzone, double exponent){
		//http://www.mimirgames.com/articles/games/joystick-input-and-using-deadbands/
		if(Math.abs(input)<=deadzone)
			return 0;
		double deadzoned = (input - Math.signum(input) * deadzone)/(1-deadzone);
		//System.out.println(deadzoned);
		double expoed = Math.pow(Math.abs(deadzoned), exponent) * Math.signum(deadzoned);

		return expoed;
	
	}
	public static double ensureRange(double v, double min, double max) {
		return Math.min(Math.max(v, min), max);
	}
}

