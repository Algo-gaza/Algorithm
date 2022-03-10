import java.util.*;

class Task {
    int priority;
    int progress;
    int speed;

    public Task(int pr, int pro, int sp) {
        priority = pr;
        progress = pro;
        speed = sp;
    }
}

class 기능개발 {
    public List<Integer> solution(int[] progresses, int[] speeds) {

        Task[] tasks = new Task[progresses.length];
        boolean[] completed = new boolean[progresses.length];
        Stack<Task> stack = new Stack<>();
        List<Integer> answer = new ArrayList<>();

        for(int i=0; i<progresses.length; i++) {
            tasks[i] = new Task(i, progresses[i], speeds[i]);
        }

        while(!(check_end(completed))) {
            boolean changed=false;
            for(int i=0; i<tasks.length; i++) {
                if(completed[i]==true) continue;
                tasks[i].progress += tasks[i].speed;
                if(tasks[i].progress>=100) {
                    stack.push(tasks[i]);
                    completed[i] = true;
                    changed = true;
                }
            }
            if(!stack.isEmpty()&&changed==true) {
                int c_n = complete_num(stack, completed);
                if(c_n==0) continue;
                else answer.add(c_n);
            }
        }
        return answer;
    }

    public boolean check_end(boolean[] completed) {
        boolean e = true;
        for(boolean b : completed) {
            if(b==false) {
                e = false; break;
            }
        }
        return e;
    }

    public int complete_num(Stack<Task> stack, boolean[] completed) {
        Stack<Task> test = new Stack<>();
        int start_size = stack.size(), test_size;
        boolean check;
        for(int i=0; i<start_size; i++) {
            check = true;
            for(int j=stack.peek().priority-1; j>=0; j--) {
                if(completed[j]==false) {
                    check = false;
                    break;
                }
            }
            if(check==true) {
                stack.pop();
            }
            else {
                test.push(stack.pop());
            }
        }
        test_size = test.size();
        for(int i=0; i<test_size; i++) {
            stack.push(test.pop());
        }
        return start_size - stack.size();
    }
}
