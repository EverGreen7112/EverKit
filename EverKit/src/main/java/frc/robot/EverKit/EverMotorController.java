package frc.robot.Utils.EverKit;

public abstract class EverMotorController {
    
    public enum IdleMode{
        kCoast,
        kBrake
    }

    /**
     * get current speed(precentage (-1 - 1))
     */
    public abstract double get();

  
    /**
     * set current speed(precentage (-1 - 1))
     */
    public abstract void set(double value);   

    /**
     * Invert directions of motor;
     */
    public abstract void setInverted(boolean isInverted);
    
    /**
     * @return if the directions of the motors are inverted.
     */
    public abstract boolean getInverted();
    
    /**
     * stop motor
     */
    public abstract void stop();

    /**
     * @return this motor controller's id.
     */
    public abstract int getId();

    /**
     * Set idle mode.
     * @param idleMode - coast or brake.
     */
    public abstract void setIdleMode(IdleMode idleMode);

    /**
     * @return current temperature of motor.
     */
    public abstract double getTemperature();

    /**
     * Restore factory default.
     */
    public abstract void restoreFactoryDefaults();

    /**
     * @return the original instance of the motor controller
     */
    public abstract Object getControllerInstance();
    
}
