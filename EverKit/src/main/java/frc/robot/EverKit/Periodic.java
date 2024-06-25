package frc.robot.EverKit;

import frc.robot.Robot;

public interface Periodic {

    public enum periodicTime{
        kRobotPeriodic,
        kTeleopPeriodic,
        kTestPeriodic,
        kAutonomousPeriodic,
        kSimulationPeriodic,
    }

    /**
     * This function adds a copy of the periodic(do not run this more than once) 
     * @param times - periodic times(robot, teleop, test, autonomous...)
     */
    public default void start(periodicTime...times){
        for (periodicTime periodicTime : times) {
            switch (periodicTime) {
                case kRobotPeriodic:
                    Robot.robotPeriodicFuncs.add(this);
                    break;
                case kTeleopPeriodic:
                    Robot.teleopPeriodicFuncs.add(this);
                    break;
                case kTestPeriodic:
                    Robot.testPeriodicFuncs.add(this);
                    break;
                case kAutonomousPeriodic:
                    Robot.autonomousPeriodicFuncs.add(this);
                    break;
                case kSimulationPeriodic:
                    Robot.simulationPeriodicFuncs.add(this);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * stops the periodic function in specified periodic times
     * @param times - periodic times
     */
    public default void stop(periodicTime...times){
        for (periodicTime periodicTime : times) {
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


    public void periodic();

}
