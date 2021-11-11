package nsad71acfd.nsb180.ns420b.nsbaa8.ns85533f2a854f;
import robocode.*;
import robocode.util.Utils;
import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * SudhikshaMalla_Robot2 - a robot by Sudhiksha Malla
 */
public class SudhikshaMalla_Robot2 extends AdvancedRobot
{
    /*THIS CODE TARGETS THE ROBOT BUT FAILS TO FOLLOW IT*/
    /* THIS ROBOT IS CURRENTLY PARTICIPATING IN THE TOURNAMENT */
    int c=0,moveDirection=1;
    double a,r,e1;
     public void run() {
        setAdjustRadarForRobotTurn(true);
        setColors(Color.black,Color.black,Color.black,Color.orange,Color.red);
        setAdjustGunForRobotTurn(true);
        turnRadarRightRadians(Double.POSITIVE_INFINITY);
    }
    public void onScannedRobot(ScannedRobotEvent e) {
        a = getHeadingRadians() + e.getBearingRadians();
        setTurnRadarLeftRadians(getRadarTurnRemainingRadians());
        r = robocode.util.Utils.normalRelativeAngle(a - getGunHeadingRadians());
        setTurnGunRightRadians(r);
        if(Math.random()>.9)
        {
            setMaxVelocity((12*Math.random())+12);
        }
        if(e.getDistance() > 150)
        {
            setTurnRightRadians(robocode.util.Utils.normalRelativeAngle(a-getHeadingRadians()));
        }
        else
        {
            setTurnLeft(-90-e.getBearing());
        }
        setAhead((e.getDistance()-140)*moveDirection);
        setFire(3);
    }
    public void onHitByBullet(HitByBulletEvent e) {
    }
    public void onHitWall(HitWallEvent e) {
        //turnRight(90);
        moveDirection = -moveDirection;
    }
}
