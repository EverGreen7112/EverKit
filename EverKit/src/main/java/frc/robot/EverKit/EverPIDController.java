package frc.robot.EverKit;

public interface EverPIDController {

    public enum ControlType{
        kPos,
        kVel, kPosition
    }

    /**
     * @param kp - proportional coefficent
     * @param ki - integral coefficent
     * @param kd - derivative coefficent
     * @param kf - feedforward coefficent
     */
    public void setPIDF(double kp, double ki, double kd, double kf);

    /** 
     * activates the PID
     */
    public void activate(double setpoint, ControlType type);    
} 
