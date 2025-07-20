package frc.robot.Utils.EverKit.Implementations.MotorControllers;



import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.MAXMotionConfig;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;

import java.io.ObjectInputFilter.Config;

import com.revrobotics.spark.ClosedLoopSlot;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;

import frc.robot.Utils.EverKit.EverMotorController;
import frc.robot.Utils.EverKit.Implementations.Encoders.EverSparkInternalEncoder;


public class EverSparkMax extends EverMotorController{

    private SparkMax m_controller;
    private SparkMaxConfig m_config;


    public EverSparkMax(int id){
        m_controller = new SparkMax(id, MotorType.kBrushless);
        m_config = new SparkMaxConfig();
    
    }

    @Override
    public double get() {
        return m_controller.get();
    }

    @Override
    public void set(double value) {
        m_controller.set(value);
    }

    @Override
    public void setInverted(boolean isInverted) {
        m_config.inverted(isInverted);
        applyConfig();
    }

    @Override
    public boolean getInverted() {
        return m_controller.configAccessor.getInverted();
    }

    @Override
    public void stop() {
        m_controller.stopMotor();
    }

    @Override
    public int getId() {
       return m_controller.getDeviceId();
    }

    @Override
    public void setIdleMode(IdleMode idleMode) {
        switch (idleMode) {
            case kBrake:
                m_config.idleMode(com.revrobotics.spark.config.SparkBaseConfig.IdleMode.kBrake);
                applyConfig();
                break;
            case kCoast:
                m_config.idleMode(com.revrobotics.spark.config.SparkBaseConfig.IdleMode.kCoast);
                applyConfig();
                break;
            default:
                break;
        }
    }

    @Override
    public double getTemperature() {
        return m_controller.getMotorTemperature();
    }

    @Override
    public void restoreFactoryDefaults() {
        m_config = new SparkMaxConfig();
    }

    public EverSparkInternalEncoder getSparkInternalEncoder(){
        return new EverSparkInternalEncoder(this);
    }

    @Override
    public SparkMax getControllerInstance() {
        return m_controller;
    }

    public void setPIDF(double kp, double ki, double kd, double kf){
        m_config.closedLoop.pidf(kp, ki, kd, kf);
        applyConfig();
    }

    public void setP(double kp){
        m_config.closedLoop.p(kp);
        applyConfig();
    }

    public void setI(double ki){
        m_config.closedLoop.i(ki);
        applyConfig();
    }

    public void setD(double kd){
        m_config.closedLoop.d(kd);
        applyConfig();
    }

    public void setF(double kf){
        m_config.closedLoop.velocityFF(kf);
        applyConfig();
    }

    public void setPosConversionFactor(double factor){
        m_config.encoder.positionConversionFactor(factor);
        applyConfig();
    }

    public void setVelConversionFactor(double factor){
        m_config.encoder.velocityConversionFactor(factor);
        applyConfig();
    }
    
    private void applyConfig(){
        m_controller.configure(m_config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    /**
     * 
     * @param maxVel max velocity
     * @param maxAcc max acceleration in RPM but effected by the converion factor
     * @param allowedErr the allowed error from the set point
     * @param slot the pid slot that the setings will be used at
     */
    public void smartMotion(double maxVel, double maxAcc, double allowedErr, ClosedLoopSlot slot){
        m_config.closedLoop.maxMotion.
        maxVelocity(maxVel).
        maxAcceleration(maxAcc).
        allowedClosedLoopError(allowedErr, slot);
        applyConfig();
    }

        /**
     * 
     * @param maxVel max velocity
     * @param maxAcc max acceleration in RPM but effected by the converion factor
     * @param allowedErr the allowed error from the set point
     */
    public void smartMotion(double maxVel, double maxAcc, double allowedErr){
        m_config.closedLoop.maxMotion.
        maxVelocity(maxVel).
        maxAcceleration(maxAcc).
        allowedClosedLoopError(allowedErr);
        applyConfig();
    }


    @Override
    public boolean isConnected() {
        return m_controller.getMotorTemperature() > 0;
    }
}
