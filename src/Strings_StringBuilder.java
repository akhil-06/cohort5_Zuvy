public class Strings_StringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(1000);
        sb.capacity(); // 16
        sb.append("0123456789ABCDEF");
        System.out.println(sb.capacity()); // 16 still fits
        sb.append("X"); // 17th char!
        System.out.println(sb.capacity()); // 34 = 16*2 + 2
        sb.capacity(); // 34 = 16*2 + 2
        // replace
        sb.replace(0, 2, "hello");
        System.out.println(sb); // hello23456789ABCDEF
        System.out.println(sb.append("Y").append("akhil").reverse().toString()); // 17











        // String s = "Java";
        // s.concat(" Rocks"); // return value thrown away!
        // System.out.println(s); // Java

        // s = s.concat(" Rocks"); // now we keep the result
        // System.out.println(s); // Java Rocks
        // String s5 = s.substring(2,6);
        // System.out.println(s5); // Java Rocks

        // String a = "hello"; // pool
        // String c = new String("hello world"); // heap, separate object
        // String d = c.intern(); // returns the POOLED object

        // System.out.println(a == c); // false — heap vs pool
        // System.out.println(a == d); // true — both are the pool object

        // String s1 = "hello";
        // String s2 = "hello";
        // // String s = null;
        // String s3 = new String("hello");
        // String s4 = new String("Abc");
        // System.out.println(s1 == s2); // true, because both refer to the same string
        // literal in the string pool
        // System.out.println(s3.equals(s4)); // false, because s3 and s4 are new string
        // objects
        // System.out.println(s1.compareTo(s4)); // a negative value, because "hello"
        // comes before "Abc" alphabetically
    }
}
