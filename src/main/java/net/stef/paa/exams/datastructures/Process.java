package net.stef.paa.exams.datastructures;

public class Process {
    int identifier;
    int priority;
    int elapsedTime;

    public Process(final int identifier, final int priority, final int elapsedTime) {
        this.identifier = identifier;
        this.priority = priority;
        this.elapsedTime = elapsedTime;
    }

    public int getIdentifier() {
        return identifier;
    }

    public int getPriority() {
        return priority;
    }

    public int getElapsedTime() {
        return elapsedTime;
    }

    @Override
    public String toString() {
        return identifier + " "  + priority + " " + elapsedTime;
    }

    public void execute(final int quantumNum){
        if(this.elapsedTime == 0){
            return;
        } else if(this.elapsedTime > quantumNum){
            this.elapsedTime = this.elapsedTime - quantumNum;
        } else {
            this.elapsedTime = 0;
        }
        this.priority--;
    }


    public boolean isExecutable() {
        return  elapsedTime > 0;
    }
}
