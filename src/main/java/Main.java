import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> part1List = Resources.readLines(new File("part1.txt").toURI().toURL(), Charsets.UTF_8);
        List<String> part2List = Resources.readLines(new File("part2.txt").toURI().toURL(), Charsets.UTF_8);

        for (int i = 1; i <= 1000; i++) {
            String a = getRandom(part1List, "");
            String b = getRandom(part2List, "");
            log(a + " " + b);
            if(i % 5 == 0) {
                System.out.println("");
            }
        }

    }

    private static String getRandom(List<String> names, String excludeName) {
        int pos = new Random().nextInt(names.size());
        String result = names.get(pos).trim();
        if(result.length() == 0 || excludeName.equals(result)) {
            return getRandom(names, excludeName);
        }
        return result;
    }

    private static void log(String string) {
        String paddedString = String.format("%1$-" + 25 + "s", string);
        System.out.print(paddedString);
    }
}
