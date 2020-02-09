package team.gif.robot.commands.shooter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import team.gif.robot.Globals;
import team.gif.robot.Robot;

public class calculations extends CommandBase {

    public static boolean endthing = false;
    public static double[] c = {0,0,0,0,0,0};
    public calculations(){}

    @Override
    public void initialize() {
        endthing = false;
        /*
        System.out.println("calculations init");
        // calculating the speed of the flywheel

        //FOR down towards target

        double yoffset = Robot.limelight.getYOffset();
        if(yoffset>1.8){
            yoffset = yoffset*-1;
        }
        Globals.shooterSpeed = yoffset*Globals.m +Globals.k;
        SmartDashboard.putNumber("shooterspeed",Globals.shooterSpeed);
        System.out.println(Globals.shooterSpeed);
    */
    }
    public static int t = 4;
    public static int r =0;
    @Override
    public void execute(){

        for(int j=0;j<c.length;j++){
            c[j] = c[j] + Robot.limelight.getCamTran()[j];
        }
        if(r==t){
            endthing = true;
        }else{
            r++;
        }

    }

    @Override
    public boolean isFinished() {
        return endthing;
    }


    @Override
    public void end(boolean interrupted) {
        for (int j= 0;j<c.length;j++){
            c[j]= c[j]/t;
            SmartDashboard.putNumber("c "+j,c[j]);
            SmartDashboard.putNumber("c error "+j,c[j]-Robot.limelight.getCamTran()[j]/c[j]);
        }
    }
}