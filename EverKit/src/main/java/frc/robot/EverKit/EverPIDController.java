package frc.robot.Utils.EverKit;

public abstract class EverPIDController {

    public enum ControlType{
        kPos,
        kVel,
    }

    /**
     * @param kp - proportional coefficent
     * @param ki - integral coefficent
     * @param kd - derivative coefficent
     * @param kf - feedforward coefficent
     */
    public abstract void setPIDF(double kp, double ki, double kd, double kf);
    
    /**
     * @param kp - proportional coefficent
     * @param ki - integral coefficent
     * @param kd - derivative coefficent
     */
    public abstract void setPID(double kp, double ki, double kd);

    /**
     * reset I
     */
    public abstract void resetIAccum();

    /** 
     * activates the PID
     */
    public abstract void activate(double setpoint, ControlType type);    

    /**
     * stops the motor, notice that using {@link #activate(double setpoint, ControlType type)} will move the motor again
     */
    public abstract void stop();
} 
