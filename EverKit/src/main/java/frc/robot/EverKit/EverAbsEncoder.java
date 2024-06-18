package frc.robot.EverKit;

public interface EverAbsEncoder {
    
    /**
     * @return current absolute position
     */
    public double getAbsPos();

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
     * @return the offset of the encoder from origin
     * This value is set by user, using the {@link #setOffset(double)} function.
     */
    public double getOffset();
    
    /**
     * Set offset of encoder from origin.
     */
    public void setOffset(double offset);
    
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
