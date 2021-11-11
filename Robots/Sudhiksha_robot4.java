package ns33abc41f.nsd6e2.ns4fdf.ns9c51.nsc58472baa45b;
import robocode.*;
import robocode.util.Utils;
import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * Sudhiksha_robot4 - a robot by Sudhiksha Malla
 */
public class Sudhiksha_robot4 extends AdvancedRobot
{
    //SUPER_TRACKER
    int moveDirection=1;
    public void run() {
		setAdjustRadarForRobotTurn(true);
		setBodyColor(new Color(128, 128, 50));
		setGunColor(new Color(50, 50, 20));
		setRadarColor(new Color(200, 200, 70));
		setScanColor(Color.white);
		setBulletColor(Color.blue);
		setAdjustGunForRobotTurn(true); 
		turnRadarRightRadians(Double.POSITIVE_INFINITY);
	}
	public void onScannedRobot(ScannedRobotEvent e) {
		double absBearing=e.getBearingRadians()+getHeadingRadians();
		double latVel=e.getVelocity() * Math.sin(e.getHeadingRadians() -absBearing);
		double gunTurnAmt;
		setTurnRadarLeftRadians(getRadarTurnRemainingRadians());
		if(Math.random()>.9){
			setMaxVelocity((12*Math.random())+12);
		}
		if (e.getDistance() > 150) 
		{
			gunTurnAmt = robocode.util.Utils.normalRelativeAngle(absBearing- getGunHeadingRadians()+latVel/22);
			setTurnGunRightRadians(gunTurnAmt);
			setTurnRightRadians(robocode.util.Utils.normalRelativeAngle(absBearing-getHeadingRadians()+latVel/getVelocity()));
			setAhead((e.getDistance() - 140)*moveDirection);
			setFire(3);
		}
		else
		{
			gunTurnAmt = robocode.util.Utils.normalRelativeAngle(absBearing- getGunHeadingRadians()+latVel/15);
			setTurnGunRightRadians(gunTurnAmt);
			setTurnLeft(-90-e.getBearing()); 
			setAhead((e.getDistance() - 140)*moveDirection);
			setFire(3);
		}	
	}
	public void onHitWall(HitWallEvent e){
		moveDirection=-moveDirection;
	}
}
