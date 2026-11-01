
// https://docs.google.com/presentation/d/121MWXJ1zSs169aeK-CyMb-iSLtzzPJPr1G0P5TjrPk0/edit?slide=id.p1#slide=id.p1
import java.util.HashSet;
import java.util.Set;

public class Hashset {
    public static void main(String args[]) {

        Set<String> set = new HashSet<>();
        set.add("apple"); // true (added)
        set.add("apple"); // false (duplicate, ignored)
        set.add("mango");

        set.contains("apple"); // true O(1)
        set.remove("x"); // false (wasn't there)
        set.remove("mango"); // true
        set.size(); // 1
        set.isEmpty(); // false

        for (String f : set) // iterate (order NOT guaranteed)
            System.out.println(f);

        set.forEach(System.out::println);

        // set.clear();
        set.isEmpty(); // true

    }
}

// stroing unique elemets
// 5,3,5,1,3:-- 1,3,5