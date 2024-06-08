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
        m_controller.getInternalPIDController().setP(kp);
        m_controller.getInternalPIDController().setI(ki);
        m_controller.getInternalPIDController().setD(kd);
        m_controller.getInternalPIDController().setFF(ff);
    }
    
    @Override
    public void setPID(double kp, double ki, double kd) {
        m_controller.getInternalPIDController().setP(kp);
        m_controller.getInternalPIDController().setI(ki);
        m_controller.getInternalPIDController().setD(kd);
    }
    
    @Override
    public void activate(double setpoint, ControlType type) {
        switch (type) {
            case kPos:
                m_controller.getInternalPIDController().setReference(setpoint, CANSparkBase.ControlType.kPosition);                
                break;
            case kVel:
                m_controller.getInternalPIDController().setReference(setpoint, CANSparkBase.ControlType.kVelocity);   
                break;
            default:
                break;
        }
    }

    @Override
    public void resetIAccum() {
        m_controller.getInternalPIDController().setIAccum(0);
    }

    @Override
    public void stop() {
        m_controller.stop();
    }

   
    
}
