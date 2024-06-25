package frc.robot.EverKit.Implementations.PIDControllers;

import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import frc.robot.EverKit.EverPIDController;

public class EverTalonFXPIDController implements EverPIDController{

    private TalonFX m_controller;
    
    public EverTalonFXPIDController(TalonFX controller){
        m_controller = controller;
    }

    @Override
    public void setPIDF(double kp, double ki, double kd, double kf) {
        var slot0Configs = new Slot0Configs();
        slot0Configs.kP = kp; 
        slot0Configs.kI = ki;
        slot0Configs.kD = kd;
        slot0Configs.kS = kf;
        m_controller.getConfigurator().apply(slot0Configs);
    }

    @Override
    public void setPID(double kp, double ki, double kd) {
        var slot0Configs = new Slot0Configs();
        slot0Configs.kP = kp; 
        slot0Configs.kI = ki;
        slot0Configs.kD = kd;
        m_controller.getConfigurator().apply(slot0Configs);
    }

    @Override
    public void resetIAccum() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resetIAccum'");
    }

    @Override
    public void activate(double setpoint, ControlType type) {
        switch (type) {
            case kPos:
                m_controller.setControl(new PositionVoltage(setpoint).withSlot(0));
                break;
            case kVel:
                m_controller.setControl(new VelocityVoltage(setpoint).withSlot(0));
                break;    
            default:
                break;
        }
    }

    @Override
    public void stop() {
        m_controller.stopMotor();
    }

    
}
