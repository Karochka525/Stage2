package stage2.practice.one;

import java.util.BitSet;
import java.util.stream.IntStream;

public class Archivator {

    public static BitSet compress(String str) {
        BitSet result = new BitSet(str.length() * 2);
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
           switch (chars[i]) {
               case 'A' -> {}
               case 'B' -> result.set(i*2+1, true);
               case 'C' -> result.set(i*2, true);
               case 'D' -> result.set(i*2, i*2+2, true);
               default -> {throw new IllegalArgumentException();}
           }
        }
        final StringBuilder buffer = new StringBuilder(chars.length);
        IntStream.range(0, chars.length*2)
                .mapToObj(i -> result.get(i) ? '1' : '0')
                .forEach(buffer::append);
        System.out.println(buffer);
        return result;
    }

    public static String decompress(BitSet bits) {
        final StringBuilder buffer = new StringBuilder(bits.length()/2);
        for (int i = 0; i < bits.length(); i+=2) {
            if (!bits.get(i) && !bits.get(i+1)) buffer.append('A');
            if (!bits.get(i) && bits.get(i+1)) buffer.append('B');
            if (bits.get(i) && !bits.get(i+1)) buffer.append('C');
            if (bits.get(i) && bits.get(i+1)) buffer.append('D');
        }
        return buffer.toString();
    }

}
