package frc.robot.EverKit;

import java.util.function.Consumer;

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
    public default void initialize(periodicTime...times){
        for (periodicTime periodicTime : times) {
            switch (periodicTime) {
                case kRobotPeriodic:
                    Robot.robotPeriodicFuncs.add(new Consumer<Object>() {
                        @Override
                        public void accept(Object t) {
                            periodic();
                        }
                    });
                    break;
                case kTeleopPeriodic:
                    Robot.teleopPeriodicFuncs.add(new Consumer<Object>() {
                        @Override
                        public void accept(Object t) {
                            periodic();
                        }
                    });
                    break;
                case kTestPeriodic:
                    Robot.testPeriodicFuncs.add(new Consumer<Object>() {
                        @Override
                        public void accept(Object t) {
                            periodic();
                        }
                    });
                    break;
                case kAutonomousPeriodic:
                    Robot.autonomousPeriodicFuncs.add(new Consumer<Object>() {
                        @Override
                        public void accept(Object t) {
                            periodic();
                        }
                    });
                    break;
                case kSimulationPeriodic:
                    Robot.simulationPeriodicFuncs.add(new Consumer<Object>() {
                        @Override
                        public void accept(Object t) {
                            periodic();
                        }
                    });
                    break;
                default:
                    break;
            }
        }
    }


    public void periodic();

}
