/*
Mathew Buck
CIS 27 Lab 2
 */
package driverscheduling;

import java.util.Random;

public class Jobs implements Comparable<Jobs> {
    public static int totJobNum = 1;
    public final int jobNum = totJobNum;
    private int runTime;
    private Random rand = new Random();
    private int turnTime = 0;
    private int waitTime = 0;
   
    
    Jobs(){
        //Increment running total of jobs.
        totJobNum++;
        this.runTime = rand.nextInt(100);
        this.turnTime = 0;
        this.waitTime = 0;
    }
    
    public String toString(){
        String s = "Job#" + this.jobNum + " runTime:" + runTime 
                + " waitTime:" + waitTime + " turnTime:" + turnTime;    
        return s;
    }
    
    public void setWaitTime(int wt){
        waitTime = wt;
    }
    
    public int getTurnTime(){
        return turnTime;
    }
    
    public void setTurnTime(int tt){
        turnTime = tt;
    }
    
    public int getRunTime(){
        return runTime;
    }
    
    public void SetRunTime(int rt){
        runTime = rt;
    }
    
    //compares based on alphabetical order
        public int compareTo(Jobs otherJob){
            if (runTime < otherJob.runTime){
                return -1;
            }
            if (runTime == otherJob.runTime){
                return 0;
            }
            else
                return 1;
        }

}
