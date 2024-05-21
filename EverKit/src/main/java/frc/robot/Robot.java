// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.function.Consumer;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.EverKit.Periodic.periodicTime;

public class Robot extends TimedRobot {
  public static ArrayList<Consumer<Object>> robotPeriodicFuncs = new ArrayList<Consumer<Object>>();
  public static ArrayList<Consumer<Object>> teleopPeriodicFuncs = new ArrayList<Consumer<Object>>();
  public static ArrayList<Consumer<Object>> testPeriodicFuncs = new ArrayList<Consumer<Object>>();
  public static ArrayList<Consumer<Object>> autonomousPeriodicFuncs = new ArrayList<Consumer<Object>>();
  public static ArrayList<Consumer<Object>> simulationPeriodicFuncs = new ArrayList<Consumer<Object>>();


  private Command m_autonomousCommand;
  private RobotContainer m_robotContainer;

  @Override
  public void robotInit() {
    m_robotContainer = new RobotContainer();
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
    for (Consumer<Object> method : robotPeriodicFuncs) {
      try {
        method.accept(null);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void disabledExit() {}

  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {
    for (Consumer<Object> method : autonomousPeriodicFuncs) {
      try {
        method.accept(null);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public void autonomousExit() {}

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
    for (Consumer<Object> method : teleopPeriodicFuncs) {
      try {
        method.accept(null);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public void teleopExit() {}

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {
    for (Consumer<Object> method : testPeriodicFuncs) {
      try {
        method.accept(null);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public void testExit() {}  

  @Override
  public void simulationPeriodic() {
    for (Consumer<Object> method : simulationPeriodicFuncs) {
      try {
        method.accept(null);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
  
}
