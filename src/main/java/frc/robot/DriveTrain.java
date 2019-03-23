package frc.robot;

import edu.wpi.first.wpilibj.PWMVictorSPX;

public class DriveTrain{
    public static PWMVictorSPX rightFront;
    public static PWMVictorSPX rightBack;
    public static PWMVictorSPX leftFront;
    public static PWMVictorSPX leftBack;

    public static DriveTrain instance;

    public DriveTrain(){
        rightFront = new PWMVictorSPX(4);
        rightBack = new PWMVictorSPX(3);
        leftFront = new PWMVictorSPX(2);
        leftBack = new PWMVictorSPX(1);
    }

    public static DriveTrain getInstance(){
        if(instance==null){
            instance = new DriveTrain();
        }
        return instance;
    }
    // Arcade drive code per Daniel Tian team 548 Robostangs
    public static void arcadeDrive(double fwd, double tur) {
        //Arcade Drive      
		drive(Utils.ensureRange(fwd + tur, -1d, 1d), Utils.ensureRange(fwd - tur, -1d, 1d));
    }

    public static void drive(double leftPower, double rightPower){
        double left = Utils.expoDeadzone(leftPower, .1, 2);
        double right = -Utils.expoDeadzone(rightPower,.1,2);
        rightFront.set(right);
        rightBack.set(right);
        leftFront.set(left);
        leftBack.set(left);
    }
    
}