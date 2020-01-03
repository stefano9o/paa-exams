package net.stef.paa.exams.january2015;

import net.stef.paa.exams.datastructures.Process;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    private static PriorityQueue<Process> processes = new PriorityQueue<>((o1, o2) -> {
        if(o1.getPriority() == o2.getPriority()){
            return o1.getIdentifier() - o2.getIdentifier();
        }
        return o2.getPriority() - o1.getPriority();
    });

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 1) {
            throw new RuntimeException("Something went wrong.");
        }

        parseInputFile(args[0]);
        executeProcesses();
    }

    private static void parseInputFile(final String pathInputFile) throws FileNotFoundException {
            final File f = new File(pathInputFile);
            final Scanner fileScanner = new Scanner(f);

            while (fileScanner.hasNextLine()) {
                final String currentLine = fileScanner.nextLine();
                final String[] splitLine = currentLine.split("\\s+");
                final Process p = new Process(
                        Integer.parseInt(splitLine[0]),Integer.parseInt(splitLine[1]),Integer.parseInt(splitLine[2]));
                processes.add(p);
            }
            fileScanner.close();
        }
    private static void executeProcesses () {
        while (!processes.isEmpty()) {
            final Process first = processes.remove();
            if (first.isExecutable()) {
                final int id = first.getIdentifier();
                final int initialPriority = first.getPriority();
                first.execute(10);
                final int finalPriority = first.getPriority();
                final int elapsedTime = first.getElapsedTime();
                System.out.println(id + " " + initialPriority + " " + finalPriority + " " + elapsedTime);
                processes.add(first);
            }
        }
    }
}