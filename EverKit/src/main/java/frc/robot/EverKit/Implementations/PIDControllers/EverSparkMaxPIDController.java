package frc.robot.EverKit.Implementations.PIDControllers;

import com.revrobotics.CANSparkBase;
import com.revrobotics.SparkPIDController;

import frc.robot.EverKit.EverPIDController;
import frc.robot.EverKit.Implementations.MotorControllers.EverSparkMax;

public class EverSparkMaxPIDController implements EverPIDController{

    private EverSparkMax m_controller;
    private SparkPIDController m_internalPIDController;

    public EverSparkMaxPIDController(EverSparkMax controller){
        m_controller = controller;
        m_internalPIDController = m_controller.getControllerInstance().getPIDController();
    }

    @Override
    public void setPIDF(double kp, double ki, double kd, double ff) {
        m_internalPIDController.setP(kp);
        m_internalPIDController.setI(ki);
        m_internalPIDController.setD(kd);
        m_internalPIDController.setFF(ff);
    }
    
    @Override
    public void setPID(double kp, double ki, double kd) {
        m_internalPIDController.setP(kp);
        m_internalPIDController.setI(ki);
        m_internalPIDController.setD(kd);
    }
    
    @Override
    public void activate(double setpoint, ControlType type) {
        switch (type) {
            case kPos:
                m_internalPIDController.setReference(setpoint, CANSparkBase.ControlType.kPosition);                
                break;
            case kVel:
                m_internalPIDController.setReference(setpoint, CANSparkBase.ControlType.kVelocity);   
                break;
            default:
                break;
        }
    }

    @Override
    public void resetIAccum() {
        m_internalPIDController.setIAccum(0);
    }

    @Override
    public void stop() {
        m_controller.stop();
    }

   
    
}
