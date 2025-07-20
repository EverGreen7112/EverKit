package frc.robot.Utils.EverKit.Implementations.Sensors;

import edu.wpi.first.wpilibj.DigitalSource;
import edu.wpi.first.wpilibj.DutyCycle;
import frc.robot.Utils.EverKit.EverSensor;

public class EverWPMSensor extends EverSensor {

    private DutyCycle m_pwmSensor;
    private int m_threshold = 0; 
    private DigitalSource m_pwmChannel;
    private boolean m_reversed = false;
    

    public EverWPMSensor(DigitalSource channel) {
        m_pwmSensor = new DutyCycle(channel); 
        m_pwmChannel = channel; 
    }

    @Override
    public boolean get() {
        return m_pwmSensor.getOutput() >= m_threshold ^  m_reversed;
    }

    public double getDutyCycle() {
        return m_pwmSensor.getOutput();
    }
    
    public void setThreshold(int threshold) {
        m_threshold = threshold; 
    }

    @Override
    public void setReversed(boolean reversed) {
        m_reversed = reversed;
    }

    @Override
    public boolean isReversed() {
        return m_reversed;
    }

    @Override
    public boolean isConnected() {
        return m_pwmChannel != null && m_pwmChannel.getChannel() >= 0 && m_pwmChannel.getChannel() < 10; // Assuming valid channels are 0-9
    }
    
}
