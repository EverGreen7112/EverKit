package frc.robot.Utils.EverKit.Implementations.Sensors;

import com.revrobotics.spark.config.LimitSwitchConfig;
import com.revrobotics.spark.config.SparkMaxConfig;

import frc.robot.Utils.EverKit.EverSensor;
import frc.robot.Utils.EverKit.Implementations.MotorControllers.EverSparkMax;

public class EverSparkLS extends EverSensor {

    private EverSparkMax m_motor;
    private boolean m_reversed = false;
    SparkMaxConfig m_config = new SparkMaxConfig();
    LimitSwitchConfig m_limitSwitchConfig = new LimitSwitchConfig();

    public EverSparkLS(EverSparkMax motor) {
        m_motor = motor;
    }

    @Override
    public boolean get() {
        return getForwardLS() || getReverseLS(); //placeholder now
    }

    public boolean getForwardLS(){
        return m_motor.getControllerInstance().getReverseLimitSwitch().isPressed() ^ m_reversed;
    }

    public boolean getReverseLS(){
        return m_motor.getControllerInstance().getReverseLimitSwitch().isPressed() ^ m_reversed;
    }

    public void enableForwardLS(boolean enable) {
        m_limitSwitchConfig.forwardLimitSwitchEnabled(false);
        m_config.apply(m_limitSwitchConfig);
        m_motor.getControllerInstance().configure(m_config, null, null);
    }

    public void enableReversLS(boolean enable) {
        m_limitSwitchConfig.reverseLimitSwitchEnabled(enable);
        m_config.apply(m_limitSwitchConfig);
        m_motor.getControllerInstance().configure(m_config, null, null);
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
        return true; //palceholder now
    }
    
}
