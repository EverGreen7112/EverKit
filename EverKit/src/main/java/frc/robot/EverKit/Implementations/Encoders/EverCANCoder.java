package frc.robot.Utils.EverKit.Implementations.Encoders;
import com.ctre.phoenix6.configs.MagnetSensorConfigs;
import com.ctre.phoenix6.hardware.CANcoder;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Utils.EverKit.EverAbsEncoder;


public class EverCANCoder extends EverAbsEncoder{

    private CANcoder m_encoder;
    private MagnetSensorConfigs m_configs;
    private double m_posFactor;
    private double m_velFactor;

    /**
     * @param id - id of encoder
     */
    public EverCANCoder(int id){
        m_encoder = new CANcoder(id);
        m_configs = new MagnetSensorConfigs();
        m_posFactor = 1;
        m_velFactor = 1;
    }

    /**
     * returns absolute position of encoder in units of rotations unless conversion factor was changed. 
     */
    @Override
    public double getAbsPos() {
        return m_encoder.getAbsolutePosition().getValueAsDouble() * m_posFactor;
    }

    /**
     * returns relative position of encoder in units of rotations unless conversion factor was changed. 
     */
    @Override
    public double getPos() {
       return m_encoder.getPositionSinceBoot().getValueAsDouble() * m_posFactor;
    }

    /**
     * @param pos - new position of encoder in units of rotations unless conversion factor was changed. .
     */
    @Override
    public void setPos(double pos) {
        m_encoder.setPosition(pos / m_posFactor);
    }

    /**
     * returns velocity in units of rotations per second unless conversion factor was changed. 
     */
    @Override
    public double getVel() {
        return m_encoder.getVelocity().getValueAsDouble() * m_velFactor;
    }

    @Override
    public double getOffset() {
        return m_configs.MagnetOffset * m_posFactor;
    }

    @Override
    public void setOffset(double offset) {
        m_configs.withMagnetOffset((m_posFactor - offset) / m_posFactor);
        m_encoder.getConfigurator().apply(m_configs);      
    }

    /**
     * convert units of measure of the encoder from rotations.
     */
    @Override
    public void setPosConversionFactor(double factor) {
        m_posFactor = factor;
    }

    /**
     * convert units of measure of the encoder from rotations per second.
     */
    @Override
    public void setVelConversionFactor(double factor) {
        m_velFactor = factor;
    }
    
}
