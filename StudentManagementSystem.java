package task;
import java.util.*;

class Student {
    int id;
    String name;
    double grade;

    Student(int id, String name, double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Grade: " + grade;
    }
}

class Student_Management_system {
    private ArrayList<Student> students = new ArrayList<>();
    private HashMap<Integer, Student> studentMap = new HashMap<>();
    private TreeSet<String> sortedNames = new TreeSet<>();

    void addStudent(int id, String name, double grade) {
        if (studentMap.containsKey(id)) {
            System.out.println("Student ID already exists.");
            return;
        }
        Student s = new Student(id, name, grade);
        students.add(s);
        studentMap.put(id, s);
        sortedNames.add(name);
    }

    void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }

    void searchById(int id) {
        System.out.println(studentMap.getOrDefault(id, null) != null ? studentMap.get(id) : "Student not found.");
    }

    void searchByName(String name) {
        for (Student s : students) {
            if (s.name.equalsIgnoreCase(name)) {
                System.out.println(s);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    void updateStudent(int id, String name, double grade) {
        if (!studentMap.containsKey(id)) {
            System.out.println("Student not found.");
            return;
        }
        Student s = studentMap.get(id);
        sortedNames.remove(s.name);
        s.name = name;
        s.grade = grade;
        sortedNames.add(name);
    }

    void removeStudent(int id) {
        if (!studentMap.containsKey(id)) {
            System.out.println("Student not found.");
            return;
        }
        Student s = studentMap.remove(id);
        students.remove(s);
        sortedNames.remove(s.name);
    }

    void sortStudents() {
        if (sortedNames.isEmpty()) {
            System.out.println("No students to sort.");
            return;
        }
        for (String name : sortedNames) {
            for (Student s : students) {
                if (s.name.equals(name)) {
                    System.out.println(s);
            }
       }
    }
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student_Management_system sm = new Student_Management_system();
        int choice;

        do {
            System.out.println("\n1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search by ID");
            System.out.println("4. Search by Name");
            System.out.println("5. Update Student");
            System.out.println("6. Remove Student");
            System.out.println("7. Sort Students by Name");
            System.out.println("8. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Grade: ");
                    double grade = sc.nextDouble();
                    sm.addStudent(id, name, grade);
                    break;
                case 2:
                    sm.viewAllStudents();
                    break;
                case 3:
                    System.out.print("Enter ID: ");
                    sm.searchById(sc.nextInt());
                    break;
                case 4:
                    System.out.print("Enter Name: ");
                    sm.searchByName(sc.nextLine());
                    break;
                case 5:
                    System.out.print("Enter ID: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Name: ");
                    String newName = sc.nextLine();
                    System.out.print("New Grade: ");
                    double newGrade = sc.nextDouble();
                    sm.updateStudent(updateId, newName, newGrade);
                    break;
                case 6:
                    System.out.print("Enter ID: ");
                    sm.removeStudent(sc.nextInt());
                    break;
                case 7:
                    sm.sortStudents();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 8);

        sc.close();
    }
}
