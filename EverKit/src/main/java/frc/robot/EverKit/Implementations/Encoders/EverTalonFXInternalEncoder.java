package frc.robot.Utils.EverKit.Implementations.Encoders;

import com.ctre.phoenix6.configs.CustomParamsConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.configs.TalonFXConfigurator;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Utils.EverKit.EverEncoder;
import frc.robot.Utils.EverKit.Implementations.MotorControllers.EverTalonFX;

public class EverTalonFXInternalEncoder extends EverEncoder{

    private TalonFX m_controller;
    private EverTalonFX m_everController;
    
    public EverTalonFXInternalEncoder(EverTalonFX controller){
        m_controller = controller.getControllerInstance();
        m_everController = controller;
    }

    @Override
    public double getPos() {
        double posConversionFactor = m_everController.getPosConversionFactor();
        return m_controller.getPosition().getValueAsDouble() * posConversionFactor;
    }

    @Override
    public void setPos(double pos) {
        double posConversionFactor = m_everController.getPosConversionFactor();
        m_controller.setPosition(pos / posConversionFactor);
    }

    @Override
    public double getVel() {
        double velConversionFactor = m_everController.getVelConversionFactor();
        return m_controller.getVelocity().getValueAsDouble() * velConversionFactor;
    }

    @Override
    public void setPosConversionFactor(double factor) {
        m_everController.setPosConversionFactor(factor);
    }

    @Override
    public void setVelConversionFactor(double factor) {
        m_everController.setVelConversionFactor(factor);
    }


}
