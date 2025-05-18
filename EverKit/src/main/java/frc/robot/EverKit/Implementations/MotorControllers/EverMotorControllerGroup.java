package frc.robot.Utils.EverKit.Implementations.MotorControllers;

import java.util.ArrayList;
import java.util.Arrays;

import frc.robot.Utils.EverKit.EverMotorController;

public class EverMotorControllerGroup extends EverMotorController{

    private ArrayList<EverMotorController> m_motorControllers;

    public EverMotorControllerGroup(EverMotorController... motorControllers){
        m_motorControllers = new ArrayList<EverMotorController>(Arrays.asList(motorControllers));
        
    }

    public void add(EverMotorController motorController){
        m_motorControllers.add(motorController);
    }

    @Override
    public double get() {
        if(m_motorControllers.size() == 0)
            return 0;
        return m_motorControllers.get(0).get();
    }

    @Override
    public void set(double value) {
        for (EverMotorController motorController : m_motorControllers) {
            motorController.set(value);
        }
    }

    @Override
    public void setInverted(boolean isInverted) {
        for (EverMotorController motorController : m_motorControllers) {
            motorController.setInverted(isInverted);
        }
    }

    @Override
    public boolean getInverted() {
        if(m_motorControllers.size() == 0)
            return false;
        return m_motorControllers.get(0).getInverted();
    }

    @Override
    public void stop() {
        for (EverMotorController motorController : m_motorControllers) {
            motorController.stop();
        }
    }

    @Override
    public int getId() {
        if(m_motorControllers.size() == 0)
            return 0;
        return m_motorControllers.get(0).getId();
    }

    @Override
    public void setIdleMode(IdleMode idleMode) {
        for (EverMotorController motorController : m_motorControllers) {
            motorController.setIdleMode(idleMode);
        }
    }

    @Override
    public double getTemperature() {
        if(m_motorControllers.size() == 0)
            return 0;
        return m_motorControllers.get(0).getTemperature();
    }

    @Override
    public void restoreFactoryDefaults() {
        for (EverMotorController motorController : m_motorControllers) {
            motorController.restoreFactoryDefaults();
        }
    }

    @Override
    public Object getControllerInstance() {
        if(m_motorControllers.size() == 0)
            return null;
        return m_motorControllers.get(0);
    }
    
}
