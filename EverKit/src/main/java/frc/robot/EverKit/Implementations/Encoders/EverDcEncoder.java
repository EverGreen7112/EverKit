package frc.robot.EverKit.Implementations.Encoders;

import edu.wpi.first.wpilibj.DutyCycleEncoder;
import frc.robot.EverKit.EverAbsEncoder;

public class EverDcEncoder implements EverAbsEncoder{

    private DutyCycleEncoder m_encoder;

    /**
     * @param id - port of encoder in DIO
     */
    public EverDcEncoder(int id){
        m_encoder = new DutyCycleEncoder(id);
        m_encoder.reset();
    }

    @Override
    public double getPos() {
        return m_encoder.getDistance();
    }

    @Override
    public void setPos(double pos) {
        throw new UnsupportedOperationException("Unimplemented method 'setPos'");
    }

    @Override
    public double getVel() {
        throw new UnsupportedOperationException("Unimplemented method 'setVel'");
    }

    @Override
    public void setPosConversionFactor(double factor) {
        m_encoder.setDistancePerRotation(factor);
    }

    @Override
    public void setVelConversionFactor(double factor) {
        throw new UnsupportedOperationException("Unimplemented method 'setVelConversionFactor'");
    }

    @Override
    public double getAbsPos() {
        return m_encoder.getAbsolutePosition();
    }

    @Override
    public double getOffset() {
        return m_encoder.getPositionOffset();
    }

    @Override
    public void setOffset(double offset) {
        m_encoder.setPositionOffset(offset);
    }

    
}
