package frc.robot.EverKit;

public interface EverPIDController {

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
    public void setPIDF(double kp, double ki, double kd, double kf);
    
    /**
     * @param kp - proportional coefficent
     * @param ki - integral coefficent
     * @param kd - derivative coefficent
     */
    public void setPID(double kp, double ki, double kd);

    /**
     * reset I
     */
    public void resetIAccum();

    /** 
     * activates the PID
     */
    public void activate(double setpoint, ControlType type);    

    /**
     * stops the motor, notice that using {@link #activate(double setpoint, ControlType type)} will move the motor again
     */
    public void stop();
} 
