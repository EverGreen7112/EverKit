<<<<<<< HEAD
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
=======
package frc.robot.EverKit;

public interface EverMotorController {
    
    public enum IdleMode{
        kCoast,
        kBrake
    }

    /**
     * get current speed(precentage (-1 - 1))
     */
    public double get();

  
    /**
     * set current speed(precentage (-1 - 1))
     */
    public void set(double value);   

    /**
     * Invert directions of motor;
     */
    public void setInverted(boolean isInverted);
    
    /**
     * @return if the directions of the motors are inverted.
     */
    public boolean getInverted();
    
    /**
     * stop motor
     */
    public void stop();

    /**
     * follow a given motor controller. 
     * output = target's output
     * @param motorController - target mottor
     */
    public void follow(EverMotorController motorController);

    /**
     * @return this motor controller's id.
     */
    public int getId();

    /**
     * Set idle mode.
     * @param idleMode - coast or brake.
     */
    public void setIdleMode(IdleMode idleMode);

    /**
     * @return current temperature of motor.
     */
    public double getTemperature();

    /**
     * Restore factory default.
     */
    public void restoreFactoryDefaults();

    /**
     * @return the original instance of the motor controller
     */
    public Object getControllerInstance();
    
}
>>>>>>> origin/develop
