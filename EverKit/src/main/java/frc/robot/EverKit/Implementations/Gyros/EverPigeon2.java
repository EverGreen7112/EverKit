package frc.robot.Utils.EverKit.Implementations.Gyros;

import com.ctre.phoenix6.hardware.Pigeon2;

import frc.robot.Utils.EverKit.EverGyro;

public class EverPigeon2 implements EverGyro{

    private Pigeon2 m_pigeon;
    //offset to zero
    private double m_pitchOffset;
    private double m_rollOffset;

    public EverPigeon2(int id){
        m_pigeon = new Pigeon2(id);
        m_pitchOffset = 0;
        m_rollOffset = 0;
    }

    @Override
    public double getYaw() {
        return m_pigeon.getYaw().getValueAsDouble();
    }

    @Override
    public void resetYaw() {
        m_pigeon.setYaw(0);
    }

    @Override
    public double getPitch() {
        return m_pigeon.getPitch().getValueAsDouble() - m_pitchOffset;

    }

    @Override
    public void resetPitch() {
        m_pitchOffset = getPitch();
    }

    @Override
    public double getRoll() {
        return m_pigeon.getRoll().getValueAsDouble() - m_rollOffset;
    }

    @Override
    public void resetRoll() {
        m_rollOffset = getRoll();
    }
    
}
