package frc.robot.Utils.EverKit.Implementations.PIDControllers;

import com.revrobotics.spark.SparkClosedLoopController;

import frc.robot.Utils.EverKit.EverPIDController;
import frc.robot.Utils.EverKit.Implementations.MotorControllers.EverSparkMax;


public class EverSparkMaxPIDController extends EverPIDController{

    private EverSparkMax m_controller;
    private SparkClosedLoopController m_internalPIDController;

    public EverSparkMaxPIDController(EverSparkMax controller){
        m_controller = controller;
        m_internalPIDController = m_controller.getControllerInstance().getClosedLoopController();
    }

    @Override
    public void setPIDF(double kp, double ki, double kd, double ff) {
        m_controller.setPIDF(kp, ki, kd, ff);
    }
    
    @Override
    public void setPID(double kp, double ki, double kd) {
        m_controller.setP(kp);
        m_controller.setI(ki);
        m_controller.setD(kd);
    }
    
    @Override
    public void activate(double setpoint, ControlType type) {
        switch (type) {
            case kPos:
                m_internalPIDController.setReference(setpoint, com.revrobotics.spark.SparkBase.ControlType.kPosition);                
                break;
            case kVel:
                m_internalPIDController.setReference(setpoint, com.revrobotics.spark.SparkBase.ControlType.kVelocity);   
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
