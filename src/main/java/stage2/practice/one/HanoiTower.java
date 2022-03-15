package stage2.practice.one;

import java.util.Stack;
import java.util.stream.IntStream;

public class HanoiTower {
    static private final Stack<Integer> first=new Stack<>();
    static private final Stack<Integer> second =new Stack<>();
    static private final Stack<Integer> third=new Stack<>();

    public static void exchange(int size) {
        IntStream.range(1, size+1).forEach(first::push);
        System.out.println("START: "+first +"; "+ second +";"+ third +"\na");
        moveBrick(size, first, third, second);
        System.out.println("\nEND: "+first +"; "+ second +";"+ third );

    }

    public static void moveBrick(
            int num,
            Stack<Integer> from,
            Stack<Integer> to,
            Stack<Integer> spare
    ) {
        if (num == 1) {
            to.push(from.pop());
            System.out.println("Move: " + first + "; " + second + ";" + third);
            return;
        }
        moveBrick(num - 1, from, spare, to);
        moveBrick(1, from, to, spare);
        moveBrick(num - 1, spare, to, from);
    }
}
