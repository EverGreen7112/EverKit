package frc.robot.Utils.EverKit.Implementations.Sensors;

import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.Utils.EverKit.EverSensor;

public class EverDIOSnsor extends EverSensor {

    private DigitalInput m_dioSensor;
    private int m_channel;
    private boolean m_reversed = false;


    public EverDIOSnsor(int channel) {
        m_channel = channel;
        m_dioSensor = new DigitalInput(channel);
    }

    @Override
    public boolean get() {
        return m_dioSensor.get() ^ m_reversed; 
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
        return m_dioSensor.getChannel() >= 0 && m_dioSensor.getChannel() < 10; // Assuming valid channels are 0-9
    }
    
}
