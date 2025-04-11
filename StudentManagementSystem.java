import java.util.*;                         /* Student Management System */

class Student {
    int roll;
    String name;
    String branch;

    Student(int roll, String name, String branch) {
        this.roll = roll;
        this.name = name;
        this.branch = branch;
    }
}
  

public class StudentManagementSystem {

    static ArrayList<Student> stuList = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice = 0;

        System.out.println("\n===== Welcome to Student Management App =====");

        do {
            System.out.println("\n1. Add Student");
            System.out.println("2. Show All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent(sc);
                    break;
                case 2:
                    showAll();
                    break;
                case 3:
                    searchStudent(sc);
                    break;
                case 4:
                    deleteStudent(sc);
                    break;
                case 5:
                    System.out.println("Exiting... Bye!");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

    }

    public static void addStudent(Scanner sc) {
        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();
        sc.nextLine(); // clear buffer
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Branch: ");
        String branch = sc.nextLine();

        stuList.add(new Student(roll, name, branch));
        System.out.println("Student Added Successfully!");
    }

    public static void showAll() {
        if (stuList.isEmpty()) {
            System.out.println("No Record Found!");
            return;
        }

        System.out.println("\n----- Student List -----");
        for (Student s : stuList) {
            System.out.println("Roll: " + s.roll + ", Name: " + s.name + ", Branch: " + s.branch);
        }
    }

    public static void searchStudent(Scanner sc) {
        System.out.print("Enter Roll No to Search: ");
        int roll = sc.nextInt();
        boolean found = false;

        for (Student s : stuList) {
            if (s.roll == roll) {
                System.out.println("Record Found: Roll: " + s.roll + ", Name: " + s.name + ", Branch: " + s.branch);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student Not Found!");
        }
    }

    public static void deleteStudent(Scanner sc) {
        System.out.print("Enter Roll No to Delete: ");
        int roll = sc.nextInt();

        Iterator<Student> itr = stuList.iterator();
        boolean removed = false;

        while (itr.hasNext()) {
            Student s = itr.next();
            if (s.roll == roll) {
                itr.remove();
                removed = true;
                System.out.println("Student Deleted!");
                break;
            }
        }

        if (!removed) {
            System.out.println("Student Not Found!");
        }
    }
}
