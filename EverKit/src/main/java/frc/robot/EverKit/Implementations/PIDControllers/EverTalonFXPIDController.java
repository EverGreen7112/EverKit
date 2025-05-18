package frc.robot.Utils.EverKit.Implementations.PIDControllers;

import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionDutyCycle;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.controls.VelocityDutyCycle;
import com.ctre.phoenix6.controls.VelocityTorqueCurrentFOC;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Utils.EverKit.EverPIDController;
import frc.robot.Utils.EverKit.Implementations.MotorControllers.EverTalonFX;

public class EverTalonFXPIDController extends EverPIDController{

    private TalonFX m_controller;
    private EverTalonFX m_everController;
    private PositionVoltage m_posControlRequest;
    private VelocityVoltage m_velocityControlRequest;

    public EverTalonFXPIDController(EverTalonFX controller){
        m_controller = controller.getControllerInstance();
        m_everController = controller;
        m_posControlRequest = new PositionVoltage(0).withSlot(0);
        m_velocityControlRequest = new VelocityVoltage(0).withSlot(0);
    }

    @Override
    public void setPIDF(double kp, double ki, double kd, double kf) {
        var slot0Configs = new Slot0Configs();
        slot0Configs.kP = kp; 
        slot0Configs.kI = ki;
        slot0Configs.kD = kd;
        slot0Configs.kS = kf;
        m_everController.setPidConfig(slot0Configs);     
    }

    @Override
    public void setPID(double kp, double ki, double kd) {
        var slot0Configs = new Slot0Configs();
        slot0Configs.kP = kp; 
        slot0Configs.kI = ki;
        slot0Configs.kD = kd;
        slot0Configs.kV = 0;
        m_everController.setPidConfig(slot0Configs);
    }

    public void setPID(Slot0Configs config){
        m_everController.setPidConfig(config);     
    }

    @Override
    public void resetIAccum() {
        throw new UnsupportedOperationException("Unimplemented method 'resetIAccum'");
    }

    @Override
    public void activate(double setpoint, ControlType type) {

        switch (type) {
            case kPos:
                double posConversionFactor = m_everController.getPosConversionFactor();
                m_controller.setControl(m_posControlRequest.withPosition(setpoint / posConversionFactor));
                break;
            case kVel:
                double velConversionFactor = m_everController.getVelConversionFactor();
                m_controller.setControl(m_velocityControlRequest.withVelocity(setpoint / velConversionFactor));
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
