package frc.robot.Utils.EverKit;

import frc.robot.Robot;

public interface Periodic {

    public enum PeriodicTime{
        kRobotPeriodic,
        kTeleopPeriodic,
        kTestPeriodic,
        kAutonomousPeriodic,
        kSimulationPeriodic,
    }

    public void periodic();

    /**
     * This function adds a copy of the periodic(do not run this more than once) 
     * @param times - periodic times(robot, teleop, test, autonomous...)
     */
    public default void start(PeriodicTime...times){
        for (PeriodicTime periodicTime : times) {
            if(periodicTime == PeriodicTime.kRobotPeriodic && !Robot.robotPeriodicFuncs.contains(this))
                Robot.robotPeriodicFuncs.add(this);
            if(periodicTime == PeriodicTime.kTeleopPeriodic && !Robot.teleopPeriodicFuncs.contains(this))
                Robot.teleopPeriodicFuncs.add(this);
            if(periodicTime == PeriodicTime.kTestPeriodic && !Robot.testPeriodicFuncs.contains(this))
                Robot.testPeriodicFuncs.add(this);
            if(periodicTime == PeriodicTime.kAutonomousPeriodic && !Robot.autonomousPeriodicFuncs.contains(this))
                Robot.autonomousPeriodicFuncs.add(this);
            if(periodicTime == PeriodicTime.kSimulationPeriodic && !Robot.simulationPeriodicFuncs.contains(this))
                Robot.simulationPeriodicFuncs.add(this);    
        }
    }

    /**
     * stops the periodic function in specified periodic times
     * @param times - periodic times
     */
    public default void stop(PeriodicTime...times){
        for (PeriodicTime periodicTime : times) {
            switch (periodicTime) {
                case kRobotPeriodic:
                    Robot.robotPeriodicFuncs.remove(this);
                    break;
                case kTeleopPeriodic:
                    Robot.teleopPeriodicFuncs.remove(this);
                    break;
                case kTestPeriodic:
                    Robot.testPeriodicFuncs.remove(this);
                    break;
                case kAutonomousPeriodic:
                    Robot.autonomousPeriodicFuncs.remove(this);
                    break;
                case kSimulationPeriodic:
                    Robot.simulationPeriodicFuncs.remove(this);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * stops the periodic function in all periodic times
     */
    public default void stop(){
        Robot.robotPeriodicFuncs.remove(this);
        Robot.teleopPeriodicFuncs.remove(this);
        Robot.testPeriodicFuncs.remove(this);
        Robot.autonomousPeriodicFuncs.remove(this);
        Robot.simulationPeriodicFuncs.remove(this);
    }



}
