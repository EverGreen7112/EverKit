package frc.robot.EverKit.Implementations.PIDControllers;

import java.util.function.Supplier;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import frc.robot.EverKit.EverMotorController;
import frc.robot.EverKit.EverPIDController;
import frc.robot.EverKit.Periodic;

public class EverExternalPIDController implements EverPIDController, Periodic{
    private PIDController m_pidController;
    private double m_ff;
    private double m_maxOutput;
    private double m_setpoint;
    private Supplier<Double> m_currentState;
    private EverMotorController m_controller;

    public EverExternalPIDController(EverMotorController controller, double kp, double ki, double kd, double ff, double maxOutput){
        m_pidController = new PIDController(kp, ki, kd);
        m_ff = ff;
        m_controller = controller;
        m_maxOutput = maxOutput;
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
        start(periodicTime.kTeleopPeriodic, periodicTime.kTestPeriodic, periodicTime.kAutonomousPeriodic);
    }

    @Override
    public void resetIAccum() {
        m_pidController.reset();
    }

    @Override
    public void stop() {
        m_controller.stop();
        resetIAccum();
        stop();
    }

    @Override
    public void periodic() {
        double current = m_currentState.get();
        double output = m_pidController.calculate(current, m_setpoint);
        output +=  Math.signum(output) * m_ff;
        output = MathUtil.clamp(output, -m_maxOutput, m_maxOutput);
        m_controller.set(output);
    }
    


}
