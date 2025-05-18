package frc.robot.Utils.EverKit;

public abstract class EverEncoder {
    
    /**
     * @return current position
     */
    public abstract double getPos();
    
    /**
     * Set position of encoder
     */
    public abstract void setPos(double pos);

    /**
     * @return current velocity
     */
    public abstract double getVel();

    /**
     * Set conversion factor of the position value that is returned from the {@link #getPos()} function.
     * This should be used when trying to switch between units of measure.
     */
    public abstract void setPosConversionFactor(double factor);

    /**
     * Set conversion factor of the vel value that is returned from the {@link #getVel()}  function.
     * This should be used when trying to switch between units of measure.
     */
    public abstract void setVelConversionFactor(double factor);    

    
}
