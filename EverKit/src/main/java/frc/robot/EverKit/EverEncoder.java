package frc.robot.EverKit;

public interface EverEncoder {
    
    /**
     * @return current position
     */
    public double getPos();
    
    /**
     * Set position of encoder
     */
    public void setPos(double pos);

    /**
     * @return current velocity
     */
    public double getVel();
    
    /**
     * Set conversion factor of the position value that is returned from the {@link #getPos()} function.
     * This should be used when trying to switch between units of measure.
     */
    public void setPosConversionFactor(double factor);

    /**
     * Set conversion factor of the vel value that is returned from the {@link #getVel()}  function.
     * This should be used when trying to switch between units of measure.
     */
    public void setVelConversionFactor(double factor);    
}
