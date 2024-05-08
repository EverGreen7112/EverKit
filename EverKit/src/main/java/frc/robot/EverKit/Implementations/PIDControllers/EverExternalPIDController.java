package frc.robot.EverKit.Implementations.PIDControllers;

import java.lang.reflect.Method;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import frc.robot.Robot;
import frc.robot.EverKit.EverMotorController;
import frc.robot.EverKit.EverPIDController;
import pabeles.concurrency.IntOperatorTask.Max;

public class EverExternalPIDController implements EverPIDController{
    private PIDController m_pidController;
    private double m_ff;
    private double m_maxOutput;
    private Supplier<Double> currentState;
    private EverMotorController m_controller;
    private Consumer<Object> applyOutput;

    public EverExternalPIDController(EverMotorController controller, double kp, double ki, double kd, double ff, double maxOutput){
        m_pidController = new PIDController(kp, ki, kd);
        m_ff = ff;
        m_controller = controller;
        Robot.periodicFuncs.add(applyOutput);
    }

    public EverExternalPIDController(EverMotorController controller, double kp, double ki, double kd, double maxOutput){
        this(controller, kp, ki, kd, 0, maxOutput);
    }

    public EverExternalPIDController(EverMotorController controller, double kp, double ki, double kd){
        this(controller, kp, ki, kd, 0, 1);
    }
    
    public EverExternalPIDController(EverMotorController controller){
        this(controller, 0, 0, 0, 0, 1);
    }

    @Override
    public void setPIDF(double kp, double ki, double kd, double ff) {
        m_pidController.setPID(kp, ki, kd);
        m_ff = ff;
    }

    @Override
    public void setPID(double kp, double ki, double kd) {
        m_pidController.setPID(kp, ki, kd);
        
    }

    @Override
    public void activate(double setpoint, ControlType type) {
        applyOutput = new Consumer<Object>() {
            @Override
            public void accept(Object t) {
                double current = currentState.get();
                double output = m_pidController.calculate(current, setpoint);
                output +=  Math.signum(output) * m_ff;
                output = MathUtil.clamp(output, -m_maxOutput, m_maxOutput);
                m_controller.set(output);
            }
        };
    }

    @Override
    public void resetIAccum() {
        m_pidController.reset();
    }

    @Override
    public void stop() {
        applyOutput = new Consumer<Object>() {
            @Override
            public void accept(Object t) {}
        };
        m_controller.stop();
        resetIAccum();
    }
    


}
