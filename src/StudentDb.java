import java.util.Map;
import java.util.HashMap;

// Student class represents one student record.
// It stores the student's roll number, name, and CGPA.
class Student {
    int roll;      // unique roll number for each student
    String name;   // name of the student
    double cgpa;   // academic score

    // Constructor to initialize a student object
    Student(int r, String n, double c) {
        roll = r;
        name = n;
        cgpa = c;
    }
}

// StudentDb stores all students in a map using roll number as the key.
// This makes searching by roll number fast and easy.
public class StudentDb {
    // Map where key = roll number, value = student object
    Map<Integer, Student> byRoll = new HashMap<>();

    // Adds a new student only if the roll number is not already present.
    // Returns true if the student was added successfully, else false.
    boolean add(int roll, String name, double cgpa) {
        return byRoll.putIfAbsent(roll, new Student(roll, name, cgpa)) == null;
    }

    // Finds a student by roll number.
    // Returns the Student object if found, otherwise null.
    Student find(int roll) {
        return byRoll.get(roll);
    }

    // Updates the CGPA of a student whose roll number exists.
    // Returns true if update is successful, else false.
    boolean update(int roll, double cgpa) {
        Student s = byRoll.get(roll);
        if (s == null) return false;   // no such student exists
        s.cgpa = cgpa;                 // update the value
        return true;
    }

    // Deletes a student by roll number.
    // Returns true if the removal was successful, else false.
    boolean delete(int roll) {
        return byRoll.remove(roll) != null;
    }

    // Counts how many students have CGPA greater than or equal to the given value.
    long countAbove(double c) {
        return byRoll.values().stream()
                .filter(s -> s.cgpa >= c)
                .count();
    }

    // Main method used to test the database operations.
    public static void main(String[] args) {
        // Test case 1: add a student and verify it can be found.
        StudentDb db1 = new StudentDb();
        boolean test1 = db1.add(101, "Amit", 8.7)
                && db1.find(101) != null
                && db1.find(101).name.equals("Amit")
                && db1.find(101).cgpa == 8.7;
        System.out.println("Test 1: add + find = " + (test1 ? "PASS" : "FAIL"));

        // Test case 2: update a student and count how many students are above a threshold.
        StudentDb db2 = new StudentDb();
        db2.add(201, "Neha", 9.2);
        db2.add(202, "Rohit", 7.8);
        db2.add(203, "Sia", 8.9);
        boolean updated = db2.update(201, 9.8);
        long countAbove = db2.countAbove(8.5);
        boolean test2 = updated && countAbove == 2;
        System.out.println("Test 2: update + countAbove = " + (test2 ? "PASS" : "FAIL"));

        // Test case 3: delete one student and check that invalid updates fail.
        StudentDb db3 = new StudentDb();
        db3.add(301, "Karan", 7.5);
        db3.add(302, "Priya", 8.1);
        boolean deleted = db3.delete(301);
        boolean invalidUpdate = !db3.update(999, 9.0);
        boolean test3 = deleted && db3.find(301) == null && invalidUpdate;
        System.out.println("Test 3: delete + invalid update = " + (test3 ? "PASS" : "FAIL"));
    }
}
