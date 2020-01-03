package net.stef.paa.exams.september2016;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    private static Map<String, Integer> vars = new HashMap<>();
    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args){
        if(args.length != 1){
            throw new RuntimeException("You must specify one and only one parameter.");
        }

        parseInputFile(args[0]);

    }

    private static void parseInputFile(final String pathInputFile) {
        try {
            final File f = new File(pathInputFile);
            final Scanner fileScanner = new Scanner(f);

            while (fileScanner.hasNextLine()) {
                final String currentLine = fileScanner.nextLine();
                final String[] splitLine = currentLine.split("\\s+");
                switch (splitLine[0]){
                    case "DEF":{
                        throwExceptionIfDifferent(splitLine.length, 3);
                        //todo check is not a number the variable name
                        vars.put(splitLine[1], Integer.parseInt(splitLine[2]));
                        break;
                    }
                    case "PUSH":{
                        throwExceptionIfDifferent(splitLine.length, 2);
                        final Integer currentValue = vars.get(splitLine[1]);
                        if(currentValue != null){
                            //it is a variable
                            stack.push(currentValue);
                        } else{
                            //it is either a number or un undefined variable
                            final int numberToPush;
                            try {
                                numberToPush = Integer.parseInt(splitLine[1]);
                            } catch (NumberFormatException e){
                                throw new IllegalArgumentException(splitLine[2] + " is not defined.");
                            }
                            stack.push(numberToPush);
                        }
                        break;
                    }
                    case "POP":{
                        throwExceptionIfDifferent(splitLine.length, 1);
                        throwExceptionIfStackHasMinSize(0);
                        System.out.println(stack.pop());
                        break;
                    }
                    case "TOP":{
                        throwExceptionIfDifferent(splitLine.length, 1);
                        throwExceptionIfStackHasMinSize(0);
                        System.out.println(stack.peek());
                        break;
                    }
                    case "ADD":{
                        throwExceptionIfDifferent(splitLine.length, 1);
                        throwExceptionIfStackHasMinSize(2);
                        final int a = stack.pop();
                        final int b = stack.pop();
                        stack.push(a + b);
                        break;
                    }
                    case "SUB":{
                        throwExceptionIfDifferent(splitLine.length, 1);
                        throwExceptionIfStackHasMinSize(2);
                        final int a = stack.pop();
                        final int b = stack.pop();
                        stack.push(a - b);
                        break;
                    }
                    case "MUL":{
                        throwExceptionIfDifferent(splitLine.length, 1);
                        throwExceptionIfStackHasMinSize(2);
                        final int a = stack.pop();
                        final int b = stack.pop();
                        stack.push(a * b);
                        break;
                    }
                    case "DIV":{
                        throwExceptionIfDifferent(splitLine.length, 1);
                        throwExceptionIfStackHasMinSize(2);
                        final int a = stack.pop();
                        final int b = stack.pop();
                        stack.push(a / b);
                        break;
                    }
                    default:{
                        throw new IllegalArgumentException(splitLine[0] + " not recognized.");
                    }
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void throwExceptionIfDifferent(final int actualParams, final int expectedParams) {
        if(actualParams != expectedParams){
            throw new IllegalArgumentException(expectedParams +
                    " parameters are expected, but " + actualParams + " found.");
        }
    }

    private static void throwExceptionIfStackHasMinSize(final int minSize) {
        if(stack.size() < minSize){
            throw new IllegalStateException("The stack is " + stack.size() + " but " + minSize + " is expected.");
        }
    }
}
