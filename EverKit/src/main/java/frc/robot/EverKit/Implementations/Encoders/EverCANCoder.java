package frc.robot.EverKit.Implementations.Encoders;
import com.ctre.phoenix6.configs.MagnetSensorConfigs;
import com.ctre.phoenix6.hardware.CANcoder;

import frc.robot.EverKit.EverAbsEncoder;

public class EverCANCoder implements EverAbsEncoder{

    private CANcoder m_encoder;
    private MagnetSensorConfigs m_configs;
    private double m_posFactor;
    private double m_velFactor;

    public EverCANCoder(int id){
        m_encoder = new CANcoder(id);
        m_encoder.setPosition(0);
        m_configs = new MagnetSensorConfigs();
        m_posFactor = 1;
        m_velFactor = 1;
    }

    @Override
    public double getAbsPos() {
        return m_encoder.getAbsolutePosition().getValue() * m_posFactor;
    }

    @Override
    public double getPos() {
       return m_encoder.getPosition().getValue() * m_posFactor;
    }

    @Override
    public void setPos(double pos) {
        m_encoder.setPosition(pos);
    }

    @Override
    public double getVel() {
        return m_encoder.getVelocity().getValue() * m_velFactor;
    }

    @Override
    public double getOffset() {
        return m_configs.MagnetOffset;
    }

    @Override
    public void setOffset(double offset) {
        m_configs.withMagnetOffset(offset);
        m_encoder.getConfigurator().apply(m_configs);
    }

    @Override
    public void setPosConversionFactor(double factor) {
        m_posFactor = factor;
    }

    @Override
    public void setVelConversionFactor(double factor) {
        m_velFactor = factor;
    }
    
}
