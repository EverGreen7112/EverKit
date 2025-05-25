<<<<<<< HEAD
package frc.robot.Utils.EverKit.Implementations.Encoders;
import com.ctre.phoenix6.configs.MagnetSensorConfigs;
import com.ctre.phoenix6.hardware.CANcoder;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Utils.EverKit.EverAbsEncoder;


public class EverCANCoder extends EverAbsEncoder{
=======
package frc.robot.EverKit.Implementations.Encoders;
import com.ctre.phoenix6.configs.MagnetSensorConfigs;
import com.ctre.phoenix6.hardware.CANcoder;

import frc.robot.EverKit.EverAbsEncoder;

public class EverCANCoder implements EverAbsEncoder{
>>>>>>> origin/develop

    private CANcoder m_encoder;
    private MagnetSensorConfigs m_configs;
    private double m_posFactor;
    private double m_velFactor;

    /**
     * @param id - id of encoder
     */
    public EverCANCoder(int id){
        m_encoder = new CANcoder(id);
<<<<<<< HEAD
=======
        m_encoder.setPosition(0);
>>>>>>> origin/develop
        m_configs = new MagnetSensorConfigs();
        m_posFactor = 1;
        m_velFactor = 1;
    }

    /**
     * returns absolute position of encoder in units of rotations unless conversion factor was changed. 
     */
    @Override
    public double getAbsPos() {
<<<<<<< HEAD
        return m_encoder.getAbsolutePosition().getValueAsDouble() * m_posFactor;
=======
        return m_encoder.getAbsolutePosition().getValue() * m_posFactor;
>>>>>>> origin/develop
    }

    /**
     * returns relative position of encoder in units of rotations unless conversion factor was changed. 
     */
    @Override
    public double getPos() {
<<<<<<< HEAD
       return m_encoder.getPositionSinceBoot().getValueAsDouble() * m_posFactor;
=======
       return m_encoder.getPosition().getValue() * m_posFactor;
>>>>>>> origin/develop
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
<<<<<<< HEAD
        return m_encoder.getVelocity().getValueAsDouble() * m_velFactor;
=======
        return m_encoder.getVelocity().getValue() * m_velFactor;
>>>>>>> origin/develop
    }

    @Override
    public double getOffset() {
        return m_configs.MagnetOffset * m_posFactor;
    }

    @Override
    public void setOffset(double offset) {
<<<<<<< HEAD
        m_configs.withMagnetOffset((m_posFactor - offset) / m_posFactor);
        m_encoder.getConfigurator().apply(m_configs);      
=======
        m_configs.withMagnetOffset(1 * m_posFactor - offset / m_posFactor);
        m_encoder.getConfigurator().apply(m_configs);        
>>>>>>> origin/develop
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
