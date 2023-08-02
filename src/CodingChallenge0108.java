
//Given a list of tasks with deadlines and total profit earned on completing a task,
// find the maximum profit earned by executing the tasks within the specified deadlines.
// Assume that each task takes one unit of time to complete,
// and a task can’t execute beyond its deadline. Also, only a single task will be executed at a time.
//
// For example, consider the following set of tasks with a deadline and the profit associated with it.
//  If we choose tasks 1, 3, 4, 5, 6, 7, 8, and 9, we can achieve a maximum profit of 109.
//  Note that task 2 and task 10 are left out.
//
//
//        Tasks	Deadlines	        Profit
//        1	       9	               15
//        2	       2	                2
//        3	       5	               18
//        4	       7	                1
//        5	       4	               25
//        6	       2	               20
//        7	       5	                8
//        8	       7	               10
//        9	       4	               12
//        10	   3	                5
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CodingChallenge0108 {

    public static void maximumProfit(List<DeadlineProfitTask> list) {
        int maximumProfit = 0;
        int maximumDeadline = Integer.MIN_VALUE;
        for (DeadlineProfitTask deadlineProfitTask: list) {      //max deadline value
            if (deadlineProfitTask.deadline > maximumDeadline)
                maximumDeadline = deadlineProfitTask.deadline;
        }

        int[] tasksList = new int[maximumDeadline];
        Collections.sort(list);
        for (int i = 0; i <= tasksList.length; i++) {
            DeadlineProfitTask deadlineProfitTask = list.get(i);
            if (tasksList[deadlineProfitTask.deadline - 1] == 0) {
                tasksList[deadlineProfitTask.deadline - 1] = deadlineProfitTask.tasks;
                maximumProfit  = deadlineProfitTask.profit+maximumProfit;
            }
            else if (tasksList[deadlineProfitTask.deadline - 1] != 0) {
                for (int j = deadlineProfitTask.deadline - 1; j >= 0 ; j--) {
                    if (tasksList[j] == 0) {
                        tasksList[j] = deadlineProfitTask.tasks;
                        maximumProfit = deadlineProfitTask.profit+maximumProfit;
                        break;
                    }
                }
            }
        }
        System.out.println("maximum profit is : " + maximumProfit);
    }

    public static void main(String[] args) {
        List<DeadlineProfitTask> list = new ArrayList<>();
        list.add(new DeadlineProfitTask(9, 1, 15));
        list.add(new DeadlineProfitTask(2, 2, 2));
        list.add(new DeadlineProfitTask(5, 3, 18));
        list.add(new DeadlineProfitTask(7, 4, 1));
        list.add(new DeadlineProfitTask(4, 5, 25));
        list.add(new DeadlineProfitTask(2, 6, 20));
        list.add(new DeadlineProfitTask(5, 7, 8));
        list.add(new DeadlineProfitTask(7, 8, 10));
        list.add(new DeadlineProfitTask(4, 9, 12));
        list.add(new DeadlineProfitTask(3, 10, 5));
        CodingChallenge0108.maximumProfit(list);
    }

    static class DeadlineProfitTask implements Comparable<DeadlineProfitTask> {
        public int deadline;
        public int tasks;
        public int profit;

        DeadlineProfitTask(int deadline, int tasks, int profit) {
            this.deadline = deadline;
            this.profit = profit;
            this.tasks = tasks;
        }
        @Override
        public int compareTo(DeadlineProfitTask list) {
            return list.profit - this.profit;
        }
    }
}

