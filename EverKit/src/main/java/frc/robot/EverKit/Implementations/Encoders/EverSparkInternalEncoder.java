package frc.robot.Utils.EverKit.Implementations.Encoders;

import com.revrobotics.RelativeEncoder;

import frc.robot.Utils.EverKit.EverEncoder;
import frc.robot.Utils.EverKit.Implementations.MotorControllers.EverSparkMax;

public class EverSparkInternalEncoder extends EverEncoder{

    private RelativeEncoder m_encoder;
    private EverSparkMax m_controller;

    public EverSparkInternalEncoder(EverSparkMax controller){
        m_encoder = controller.getControllerInstance().getEncoder();
        m_controller = controller;
    }

    @Override
    public double getPos() {
       return m_encoder.getPosition();
    }

    @Override
    public void setPos(double pos) {
        m_encoder.setPosition(pos);
    }

    @Override
    public double getVel() {
        return m_encoder.getVelocity();
    }

    @Override
    public void setPosConversionFactor(double factor) {
        m_controller.setPosConversionFactor(factor);
    }

    @Override
    public void setVelConversionFactor(double factor) {
        m_controller.setVelConversionFactor(factor);
    }
    
    
}
