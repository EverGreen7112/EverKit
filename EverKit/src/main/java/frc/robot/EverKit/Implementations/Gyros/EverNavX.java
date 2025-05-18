package frc.robot.Utils.EverKit.Implementations.Gyros;



import com.studica.frc.AHRS;
import com.studica.frc.AHRS.NavXComType;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;
import frc.robot.Utils.EverKit.EverGyro;

public class EverNavX implements EverGyro{

    private AHRS m_navx;
    //offset to zero
    private double m_pitchOffset;
    private double m_rollOffset;

    

    public EverNavX(NavXComType port){
        m_navx = new AHRS(port);
        m_pitchOffset = 0;
        m_rollOffset = 0;
    }

    @Override
    public double getYaw() {
        return m_navx.getYaw();
    }

    @Override
    public double getPitch() {
        return m_navx.getPitch() - m_pitchOffset;
    }

    @Override
    public double getRoll() {
        return m_navx.getRoll() - m_rollOffset;
    }

    @Override
    public void resetYaw() {
        m_navx.zeroYaw();
    }

    @Override
    public void resetPitch() {
        m_pitchOffset = getPitch();
    }

    @Override
    public void resetRoll() {
        m_rollOffset = getRoll();
    }
    
}
