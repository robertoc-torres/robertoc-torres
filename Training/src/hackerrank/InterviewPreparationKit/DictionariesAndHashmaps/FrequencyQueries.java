package hackerrank.InterviewPreparationKit.DictionariesAndHashmaps;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/*

    Frequency Queries
    src:https://www.hackerrank.com/challenges/frequency-queries/problem

 */

public class FrequencyQueries {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        HashMap<Integer, Integer> f = new HashMap<>();
        List<Integer> r = new ArrayList<>();
        Set<Integer> s = new HashSet<>();

        for (List<Integer> q : queries) {
            int v = q.get(1);
            int freq = 1;
            if(v == 9)
                System.out.println(q.get(0));
            if (q.get(0) == 1) {
                if (f.containsKey(v)) {
                    freq = f.get(v);
                    f.put(v, freq + 1);
                    s.add(freq + 1);
                    if (!f.containsValue(freq)) {
                        s.remove(freq);
                    }
                } else {
                    f.put(v, freq);
                    s.add(freq);
                }
            }
            if (q.get(0) == 2) {
                if (f.containsKey(v)) {
                    freq = f.get(v);
                    if(freq > 0) {
                        f.put(v, freq - 1);
                        s.add(freq - 1);
                    }
                    if (!f.containsValue(freq)) {
                        s.remove(freq);
                    }
                }
            }
            if (q.get(0) == 3) {
                r.add(s.contains(v) ? 1 : 0);
            }
        }
        return r;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }

}
