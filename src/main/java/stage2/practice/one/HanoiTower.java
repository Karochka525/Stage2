package stage2.practice.one;

import java.util.Stack;

public class HanoiTower {
    static private final Stack<Integer> first=new Stack<>();
    static private final Stack<Integer> second =new Stack<>();
    static private final Stack<Integer> third=new Stack<>();

    public static void exchange(int size){
        for (int i = 0; i < size; i++) {
            first.push(i+1);
        }
        System.out.println(first +"; "+ second +";"+ third );
        popBrick(first, second);
        popBrick(second, third);
    }
    private static void popBrick(Stack<Integer> tower1, Stack<Integer> tower2) {
        while (!tower1.isEmpty()) {
            tower2.push(tower1.pop());
            System.out.println(first +"; "+ second +";"+ third );
        }
    }
}
