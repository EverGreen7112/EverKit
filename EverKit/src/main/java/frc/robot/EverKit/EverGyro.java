package frc.robot.Utils.EverKit;

public interface EverGyro {
    
    /**
     * @return current yaw angle in degrees
     */
    public double getYaw();

    /**
     * reset origin yaw(change current angle to zero)
     */
    public void resetYaw();

    /**
     * @return current pitch angle in degrees
     */
    public double getPitch();
    
    /**
     * reset origin pitch(change current angle to zero)
     */
    public void resetPitch();
    
    /**
     * @return current roll angle in degrees
     */
    public double getRoll();
    
    /**
    * reset origin roll(change current angle to zero)
    */
    public void resetRoll();



}
