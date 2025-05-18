package frc.robot.Utils.EverKit.Implementations.PIDControllers;

import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Supplier;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import frc.robot.Utils.EverKit.EverMotorController;
import frc.robot.Utils.EverKit.EverPIDController;
import frc.robot.Utils.EverKit.Periodic;
import frc.robot.Utils.EverKit.Periodic.PeriodicTime;

public class EverExternalPIDController extends EverPIDController implements Periodic{

    private PIDController m_pidController;
    private double m_ff;
    private double m_maxOutput;
    private double m_setpoint;
    private Supplier<Double> m_currentState;
    private Consumer<Double> m_outputFunction;

    public EverExternalPIDController(Supplier<Double> currentState, Consumer<Double> outputFunction){
        m_pidController = new PIDController(0, 0, 0);
        m_ff = 0;
        m_maxOutput = 1;
        m_currentState = currentState;
        m_outputFunction = outputFunction;
    }


    @Override
    public void setPIDF(double kp, double ki, double kd, double ff) {
        m_pidController.setPID(kp, ki, kd);
        m_ff = ff;
    }

    public void setCurrentState(Supplier<Double> currentState){
        m_currentState = currentState;
    }

    @Override
    public void setPID(double kp, double ki, double kd) {
        m_pidController.setPID(kp, ki, kd);
        
    }

    @Override
    public void activate(double setpoint, ControlType type) {
        m_setpoint = setpoint;
        start(PeriodicTime.kTeleopPeriodic, PeriodicTime.kTestPeriodic, PeriodicTime.kAutonomousPeriodic);
    }

    @Override
    public void resetIAccum() {
        m_pidController.reset();
    }

    @Override
    public void stop() {
        resetIAccum();
        stop(PeriodicTime.kTeleopPeriodic, PeriodicTime.kTestPeriodic, PeriodicTime.kAutonomousPeriodic);
        m_outputFunction.accept(0.0);
    }

    @Override
    public void periodic() {
        double current = m_currentState.get();
        double output = m_pidController.calculate(current, m_setpoint);
        output +=  Math.signum(output) * m_ff;
        output = MathUtil.clamp(output, -m_maxOutput, m_maxOutput);
        m_outputFunction.accept(output);
    }
    


    
}
