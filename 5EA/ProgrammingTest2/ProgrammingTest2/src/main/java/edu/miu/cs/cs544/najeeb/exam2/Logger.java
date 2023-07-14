package edu.miu.cs.cs544.najeeb.exam2;

public class Logger {

    private String logDestination= "file";

    public Logger(String logDestination) {
        this.logDestination = logDestination;
    }

    public void log() {
        System.out.println("log to "+logDestination);
    }

}
