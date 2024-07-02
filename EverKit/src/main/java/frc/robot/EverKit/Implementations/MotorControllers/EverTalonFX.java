package frc.robot.EverKit.Implementations.MotorControllers;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import frc.robot.EverKit.EverMotorController;

public class EverTalonFX implements EverMotorController{ 
    
    private TalonFX m_controller;
    
    public EverTalonFX(int id){
        m_controller = new TalonFX(id);
    }

    @Override
    public double get() {
        return m_controller.get();
    }

    @Override
    public void set(double value) {
        m_controller.set(value);
    }

    @Override
    public void setInverted(boolean isInverted) {
        m_controller.setInverted(isInverted);
    }

    @Override
    public boolean getInverted() {
        return m_controller.getInverted();
    }

    @Override
    public void stop() {
        m_controller.stopMotor();
    }

    @Override
    public void follow(EverMotorController motorController) {
        m_controller.setControl(new Follower(motorController.getId(), motorController.getInverted()));
    }

    @Override
    public int getId() {
        return m_controller.getDeviceID();
    }

    @Override
    public void setIdleMode(IdleMode idleMode) {
        switch (idleMode) {
            case kCoast:
                m_controller.setNeutralMode(NeutralModeValue.Coast);
                break;
            case kBrake:
                m_controller.setNeutralMode(NeutralModeValue.Brake);
                break;    
            default:
                break;
        }
    }

    @Override
    public double getTemperature() {
        return m_controller.getDeviceTemp().getValue();
    }

    @Override
    public void restoreFactoryDefaults() {
        m_controller.getConfigurator().apply(new TalonFXConfiguration());
    }

    @Override
    public TalonFX getControllerInstance() {
        return m_controller;
    }
    
}
