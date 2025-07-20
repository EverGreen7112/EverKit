package frc.robot.Utils.EverKit;

public abstract class EverSensor {

    /**
     * Get the current state of the sensor.
     * 
     * @return true if the sensor is triggered, false otherwise.
     */
    public abstract boolean get();

    /**
     * Set the sensor to be reversed or not.
     * 
     * @param reversed true if the sensor should be reversed, false otherwise.
     */
    public abstract void setReversed(boolean reversed); 

    public abstract boolean isReversed(); // Check if the sensor is reversed

    public abstract boolean isConnected(); // Check if the sensor is connected
    
}
