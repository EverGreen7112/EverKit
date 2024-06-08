package frc.robot.EverKit.Implementations.MotorControllers;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import frc.robot.EverKit.EverMotorController;

public class EverSparkMax implements EverMotorController{

    private CANSparkMax m_controller;

    public EverSparkMax(int id){
        m_controller = new CANSparkMax(id, MotorType.kBrushless);
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
    public void follow(MotorController motorController) {
        
        if(motorController instanceof CANSparkBase){
            CANSparkBase controller = (CANSparkBase) motorController;
            m_controller.follow(controller);
        }
        else{
            throw new RuntimeException("A spark max cannot follow a non-spark based motor controller");
        }
    }

    @Override
    public int getId() {
       return m_controller.getDeviceId();
    }

    @Override
    public void setIdleMode(IdleMode idleMode) {
        switch (idleMode) {
            case kBrake:
                m_controller.setIdleMode(com.revrobotics.CANSparkBase.IdleMode.kBrake);
                break;
            case kCoast:
                m_controller.setIdleMode(com.revrobotics.CANSparkBase.IdleMode.kCoast);
                break;
            default:
                break;
        }
    }

    @Override
    public double getTemperature() {
        return m_controller.getMotorTemperature();
    }

    @Override
    public void restoreFactoryDefaults() {
        m_controller.restoreFactoryDefaults();
    }

    public SparkPIDController getInternalPIDController(){
        return m_controller.getPIDController();
    }
}
