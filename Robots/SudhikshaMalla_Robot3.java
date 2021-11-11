package nsacba4a65.ns2e20.ns47e9.nsab3f.nse2276da708ff;
import robocode.*;
import robocode.util.Utils;
import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

public class SudhikshaMalla_Robot3 extends AdvancedRobot
{
    int c=0,moveDirection=1;
    double a,r,e1,v;
     public void run() {
        //setAdjustRadarForGunTurn(true);
        setAdjustGunForRobotTurn(true);
        setColors(Color.black,Color.black,Color.black,Color.orange,Color.red);
        while(true) {
            if(getRadarTurnRemaining()==0.0)
            {
                //setTurnRadarRightRadians(Double.POSITIVE_INFINITY);
                setTurnGunRightRadians(Double.POSITIVE_INFINITY);
                //turnRight(45);
            }
            execute();
            c=0;
        }
    }
    public void onScannedRobot(ScannedRobotEvent e) {
        /*if(e.getDistance()<50)
        fire(3);
        else
        fire(1);*/
        a = getHeadingRadians() + e.getBearingRadians();
        v=e.getVelocity() * Math.sin(e.getHeadingRadians()-a);
        //e1 = Math.min(Math.atan(36.0/e.getDistance()), Rules.RADAR_TURN_RATE_RADIANS);
        //r += (r < 0 ? -e1 : e1);
        //setTurnRadarRightRadians(r);
        //setTurnGunRightRadians(r);
        setTurnRadarLeftRadians(getRadarTurnRemainingRadians());
        //r = Utils.normalRelativeAngle(a - getGunHeadingRadians()+v/15);
        if(Math.random()>.9)
        {
            setMaxVelocity((12*Math.random())+12);
        }
        if(e.getDistance() > 150)
        {
            r = robocode.util.Utils.normalRelativeAngle(a - getGunHeadingRadians()+v/22);
            setTurnGunRightRadians(r);
            setTurnRightRadians(robocode.util.Utils.normalRelativeAngle(a-getHeadingRadians()+v/getVelocity()));
        }
        else
        {
            r = robocode.util.Utils.normalRelativeAngle(a - getGunHeadingRadians()+v/15);
            setTurnGunRightRadians(r);
            setTurnLeft(-90-e.getBearing());
        }
        setAhead((e.getDistance()-140)*moveDirection);
        if(e.getDistance()<400)
        setFire(3);
        else
        setFire(1);
        //turnRight(e.getBearing());
        //ahead(60);
        //ahead(e.getDistance()/2);
    }
    public void onHitByBullet(HitByBulletEvent e) {
    }
    public void onHitWall(HitWallEvent e) {
        //turnRight(90);
        moveDirection = -moveDirection;
    }
}
