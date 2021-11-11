package ns8693c88c.nsf720.ns4a97.nsa3d2.ns41d1c9447d63;
import robocode.*;
import robocode.util.Utils;
import java.awt.Color;
//import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * SudhikshaMalla_Robot7 - a robot by Sudhiksha Malla
 */
public class SudhikshaMalla_Robot7 extends AdvancedRobot
{
    /**
     * run: Robot6's default behavior
     */
     // code on aug3
    int c=0,moveDirection=1;
    double a,r,e1,v;
     public void run() {
        setAdjustRadarForRobotTurn(true);
        setColors(Color.black,Color.black,Color.black,Color.orange,Color.red);
        setAdjustGunForRobotTurn(true);
        turnGunRightRadians(Double.POSITIVE_INFINITY);
        /*while(true) {
            if(getRadarTurnRemaining()==0.0)
            {
                setTurnGunRightRadians(Double.POSITIVE_INFINITY);
            }
            execute();
            c=0;
        }*/
    }
    public void onScannedRobot(ScannedRobotEvent e) {
        a = getHeadingRadians() + e.getBearingRadians();
        v=e.getVelocity() * Math.sin(e.getHeadingRadians()-a);
        r = Utils.normalRelativeAngle(a - getGunHeadingRadians()+v/22);
        if(e.getDistance() > 150)
        {
            setTurnGunRightRadians(r);
            setTurnRightRadians(robocode.util.Utils.normalRelativeAngle(a-getHeadingRadians()+v/getVelocity()));
        }
        else
        {
            setTurnGunRightRadians(r);
            setTurnLeft(-90-e.getBearing());
        }
        setAhead((e.getDistance()-140)*moveDirection);
        if(e.getDistance()<400)
        setFire(3);
        else
        setFire(1);
    }
    public void onHitByBullet(HitByBulletEvent e) {
    }
    public void onHitWall(HitWallEvent e) {
        moveDirection = -moveDirection;
    }
}
