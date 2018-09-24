package com.seabookchen.toyrobot;

import com.seabookchen.toyrobot.exception.ToyRobotException;
import com.seabookchen.toyrobot.simulator.SquareBoard;
import com.seabookchen.toyrobot.simulator.ToyRobot;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        if (scanner == null) {
            System.err.println("No scanner.");
            System.exit(1);
        }

        SquareBoard squareBoard = new SquareBoard(4, 4);
        ToyRobot robot = new ToyRobot();
        Game game = new Game(squareBoard, robot);

        System.out.println("Toy Robot Simulator");
        System.out.println("Enter a command, Valid commands are:");
        System.out.println("\'PLACE X,Y,NORTH|SOUTH|EAST|WEST\', MOVE, LEFT, RIGHT, REPORT or EXIT");

        boolean keepRunning = true;
        while (keepRunning) {
            String inputString = scanner.nextLine();
            if ("EXIT".equals(inputString)) {
                keepRunning = false;
            } else {
                try {
                    String outputVal = game.eval(inputString);
                    System.out.println(outputVal);
                } catch (ToyRobotException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}