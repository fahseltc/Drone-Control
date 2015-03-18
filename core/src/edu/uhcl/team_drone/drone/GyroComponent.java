package edu.uhcl.team_drone.drone;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;

public class GyroComponent {
    
    //private final static float MAX_TILT = 0.5f;
    
    private final Drone owner;    
    
    private float currentPitch;
    private float currentYaw;
    private float currentRoll;
    
    private float desiredRoll;
    
    private boolean isMaxTilt;
    
    public GyroComponent(Drone ownerIn){
        this.owner = ownerIn; 
        currentPitch = currentYaw = currentRoll = desiredRoll = 0;
    }
    
    public void update(float dt){   
        //checkMaximums();
        findPitch();
        findRoll();
        findYaw();
    }

    private void findPitch() {
        // set Pitch
        currentPitch = (float) -Math.asin(owner.getDirection().y);
    }

    private void findYaw() { // must be called after FindPitch();         
        currentYaw = (float) Math.asin(owner.getDirection().x / Math.cos(currentPitch));
        currentYaw = 90 - MathUtils.radiansToDegrees * currentYaw;
        currentYaw = (currentYaw + 360) % 360;
    }

    private void findRoll() {       
        Vector3 dir = owner.getDirection();
        
        // project Y onto plane
        Vector3 yProj = new Vector3(
                -(dir.y * dir.x),
                1 - (dir.y * dir.y),
                -(dir.y * dir.z));
        yProj.nor();
        // find angle on the plane
        double absAngle = Math.acos(owner.getUp().nor().cpy().dot(yProj));
        if (Double.isNaN(absAngle)) { // ensure its not NaN because of acos(0) = NaN
            absAngle = 0;
        }
        Vector3 cross = owner.getUp().nor().cpy().crs(yProj);
        double dot = owner.getDirection().dot(cross);
        currentRoll = (dot >= 0) ? (float) absAngle : (float) -absAngle;

    }
    public boolean isMaxTilt(){
        return isMaxTilt;
    }

    public float getCurrentPitch() {
        return currentPitch;
    }

    public float getCurrentYaw() {
        return currentYaw;
    }

    public float getCurrentRoll() {
        return currentRoll;
    }


    

    

   
    

}