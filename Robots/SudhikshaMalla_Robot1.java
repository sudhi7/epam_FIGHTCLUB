package ns7064c91a.ns4d95.ns40b9.nsbd27.ns98da26095a74;
import robocode.*;
import robocode.util.Utils;
import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * SudhikshaMalla_Robot1 - a robot by Sudhiksha Malla
 */
public class SudhikshaMalla_Robot1 extends AdvancedRobot
{
    int moveDirection=1;
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
    public void onHitWall(HitWallEvent e) {
        moveDirection = -moveDirection;
    }
}
