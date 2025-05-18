 package frc.robot.Utils.EverKit;

public abstract class EverAbsEncoder extends EverEncoder{
    
    /**
     * @return current absolute position
     */
    public abstract double getAbsPos();
    
    /**
     * @return the offset of the encoder from origin
     * This value is set by user, using the {@link #setOffset(double)} function.
     */
    public abstract double getOffset();
    
    /**
     * Set offset of encoder from origin.
     */
    public abstract void setOffset(double offset);
    
}
