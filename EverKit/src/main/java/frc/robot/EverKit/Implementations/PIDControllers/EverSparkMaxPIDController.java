package frc.robot.EverKit.Implementations.PIDControllers;

import com.revrobotics.CANSparkBase;

import frc.robot.EverKit.EverPIDController;
import frc.robot.EverKit.Implementations.MotorControllers.EverSparkMax;

public class EverSparkMaxPIDController implements EverPIDController{
    private EverSparkMax m_controller;

    public EverSparkMaxPIDController(EverSparkMax controller){
        m_controller = controller;
    }

    @Override
    public void setPIDF(double kp, double ki, double kd, double ff) {
        m_controller.getPIDController().setP(kp);
        m_controller.getPIDController().setI(ki);
        m_controller.getPIDController().setD(kd);
        m_controller.getPIDController().setFF(ff);
    }
    
    @Override
    public void setPID(double kp, double ki, double kd) {
        m_controller.getPIDController().setP(kp);
        m_controller.getPIDController().setI(ki);
        m_controller.getPIDController().setD(kd);
    }
    
    @Override
    public void activate(double setpoint, ControlType type) {
        switch (type) {
            case kPos:
                m_controller.getPIDController().setReference(setpoint, CANSparkBase.ControlType.kPosition);                
                break;
            case kVel:
                m_controller.getPIDController().setReference(setpoint, CANSparkBase.ControlType.kVelocity);   
                break;
            default:
                break;
        }
    }

    @Override
    public void resetIAccum() {
        m_controller.getPIDController().setIAccum(0);
    }

    @Override
    public void stop() {
        m_controller.stop();
    }

   
    
}
