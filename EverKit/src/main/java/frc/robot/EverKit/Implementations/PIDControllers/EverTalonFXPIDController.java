<<<<<<< HEAD
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
=======
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
>>>>>>> origin/develop
    }

    @Override
    public void setPIDF(double kp, double ki, double kd, double kf) {
        var slot0Configs = new Slot0Configs();
        slot0Configs.kP = kp; 
        slot0Configs.kI = ki;
        slot0Configs.kD = kd;
        slot0Configs.kS = kf;
<<<<<<< HEAD
        m_everController.setPidConfig(slot0Configs);     
=======
        m_controller.getConfigurator().apply(slot0Configs);
>>>>>>> origin/develop
    }

    @Override
    public void setPID(double kp, double ki, double kd) {
        var slot0Configs = new Slot0Configs();
        slot0Configs.kP = kp; 
        slot0Configs.kI = ki;
        slot0Configs.kD = kd;
<<<<<<< HEAD
        slot0Configs.kV = 0;
        m_everController.setPidConfig(slot0Configs);
    }

    public void setPID(Slot0Configs config){
        m_everController.setPidConfig(config);     
=======
        m_controller.getConfigurator().apply(slot0Configs);
>>>>>>> origin/develop
    }

    @Override
    public void resetIAccum() {
<<<<<<< HEAD
=======
        // TODO Auto-generated method stub
>>>>>>> origin/develop
        throw new UnsupportedOperationException("Unimplemented method 'resetIAccum'");
    }

    @Override
    public void activate(double setpoint, ControlType type) {
<<<<<<< HEAD

        switch (type) {
            case kPos:
                double posConversionFactor = m_everController.getPosConversionFactor();
                m_controller.setControl(m_posControlRequest.withPosition(setpoint / posConversionFactor));
                break;
            case kVel:
                double velConversionFactor = m_everController.getVelConversionFactor();
                m_controller.setControl(m_velocityControlRequest.withVelocity(setpoint / velConversionFactor));
=======
        switch (type) {
            case kPos:
                m_controller.setControl(new PositionVoltage(setpoint).withSlot(0));
                break;
            case kVel:
                m_controller.setControl(new VelocityVoltage(setpoint).withSlot(0));
>>>>>>> origin/develop
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
