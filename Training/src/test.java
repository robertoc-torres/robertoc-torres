import java.util.*;

public class test {

    public static void main(String[] args) {

        SortedSet<Integer> s = new TreeSet<>();
        s.add(10);
        s.add(20);
        s.add(30);
        s.add(30);
        s.add(1);
        s.add(2);
        s.add(-1000);


        Iterator it = s.iterator();
        s.subSet(3,3);
        while(it.hasNext())
        {
            Object elemento = it.next();
            System.out.println(elemento.toString());
        }

    }

}

