/*
Mathew Buck
CIS 27  Lab 2
 */
package driverscheduling;

public class DriverScheduling {

    //Driver for Que tests.
    public static void main(String[] args) {

        int numJobs = 100;
        int timeSlice = 20;//Adjust to match numJobs and RR works like FIFO.
        DeQue fifo = new DeQue();//First in First Out
        MinPriorityQue sjf = new MinPriorityQue(100);//Shortes Job First
        DeQue rr = new DeQue();//Round Robin
        Jobs[] jobs = new Jobs[100];
        int waitTime = 0;//Running total for time spent in Que.
        int turnTime = 0;//Turnaround time = processing time + wait time.
        int totJobsTime = 0;//Total time to process all jobs in the Que.
        Jobs j = null;
        double totTurnTime = 0;

        //Load 3 data strucures with the same jobs. 
        for (int i = 0; i < numJobs; i++) {
            jobs[i] = new Jobs();
            fifo.addLast(jobs[i]);
            sjf.insert(jobs[i]);
            rr.addLast(jobs[i]);
            totJobsTime += jobs[i].getRunTime();
        }
        System.out.println("Time Slice = " + timeSlice);
        System.out.println(numJobs + " jobs are loaded into 3 seperate "
                + "data structures.");
        System.out.println("There is a total of " + totJobsTime
                + " time units worth of work to complete "
                        + "in each one.");

        //Process First In First Out.
        //No member data in jobs is changed.
        for (int i = 0; i < numJobs; i++) {
            j = (Jobs) fifo.getFirstData();
            fifo.removeFirst();
            turnTime = j.getRunTime();
            turnTime += waitTime;
            totTurnTime += turnTime;
            waitTime += j.getRunTime();
            turnTime = 0;
        }
        System.out.println("Average turnaround time for FIFO = "
                + (totTurnTime / numJobs) + " time units.");
        waitTime = 0;
        totTurnTime = 0;
        turnTime = 0;

        //Process Shortest Job First.
        //No member data in Jobs is changed.
        //Works fastest here. 
        while (sjf.getHeapSize() > 0) {
            j = (Jobs) sjf.getMin();
            sjf.delMin();
            turnTime = j.getRunTime();
            turnTime += waitTime;
            totTurnTime += turnTime;
            waitTime += j.getRunTime();
            turnTime = 0;
        }
        System.out.println("Average turnaround time for SJF = "
                + (totTurnTime / numJobs) + " time units.");
        waitTime = 0;
        totTurnTime = 0;
        turnTime = 0;

        //Process Round Robin.
        //Member data is used to store progress.
        //Works slowest. The larger the time Slice the better it performs. 
        do {
            j = (Jobs) rr.getFirstData();
            //Job can be completed within the allotted slice of time.
            if (j.getRunTime() <= timeSlice) {
                rr.removeFirst();
                turnTime += j.getTurnTime();//Work done previously.
                turnTime += j.getRunTime();//Work left to do.
                turnTime += waitTime;
                totTurnTime += turnTime;
                waitTime += j.getRunTime();
                turnTime = 0;
            } //Job can't be completed in the allotted time slice.
            else {
                rr.moveEnd(1);
                j.setTurnTime(j.getTurnTime() + timeSlice);
                j.SetRunTime(j.getRunTime() - timeSlice);
                waitTime += timeSlice;
            }
        } 
        while (!rr.isEmpty());
        System.out.println("Average turnaround time for RR with a "
                + "time slice of " + timeSlice + " = " 
                + (totTurnTime / numJobs) + " time units.");

        //end main
    }

//end class
}

/*
OUTPUT

run:
Time Slice = 5
100 jobs are loaded into 3 seperate data structures.
There is a total of 5177 time units worth of work to complete in each one.
Average turnaround time for FIFO = 2619.9 time units.
Average turnaround time for SJF = 1803.83 time units.
Average turnaround time for RR with a time slice of 5 = 3574.42 time units.
BUILD SUCCESSFUL (total time: 0 seconds)

run:
Time Slice = 10
100 jobs are loaded into 3 seperate data structures.
There is a total of 5098 time units worth of work to complete in each one.
Average turnaround time for FIFO = 2490.46 time units.
Average turnaround time for SJF = 1783.28 time units.
Average turnaround time for RR with a time slice of 10 = 3491.65 time units.
BUILD SUCCESSFUL (total time: 0 seconds)

Time Slice = 15
100 jobs are loaded into 3 seperate data structures.
There is a total of 5047 time units worth of work to complete in each one.
Average turnaround time for FIFO = 2458.19 time units.
Average turnaround time for SJF = 1763.31 time units.
Average turnaround time for RR with a time slice of 15 = 3472.49 time units.
BUILD SUCCESSFUL (total time: 0 seconds)

run:
Time Slice = 20
100 jobs are loaded into 3 seperate data structures.
There is a total of 4718 time units worth of work to complete in each one.
Average turnaround time for FIFO = 2449.4 time units.
Average turnaround time for SJF = 1671.03 time units.
Average turnaround time for RR with a time slice of 20 = 3278.66 time units.
BUILD SUCCESSFUL (total time: 0 seconds)

run:
Time Slice = 50
100 jobs are loaded into 3 seperate data structures.
There is a total of 4977 time units worth of work to complete in each one.
Average turnaround time for FIFO = 2402.43 time units.
Average turnaround time for SJF = 1648.82 time units.
Average turnaround time for RR with a time slice of 50 = 2947.78 time units.
BUILD SUCCESSFUL (total time: 0 seconds)

run:
Time Slice = 100
100 jobs are loaded into 3 seperate data structures.
There is a total of 5015 time units worth of work to complete in each one.
Average turnaround time for FIFO = 2505.03 time units.
Average turnaround time for SJF = 1701.96 time units.
Average turnaround time for RR with a time slice of 100 = 2505.03 time units.
BUILD SUCCESSFUL (total time: 0 seconds)




*/
