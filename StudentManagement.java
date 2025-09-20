import java.lang.*;
import java.util.Scanner;
import java.util.ArrayList;

class Student
{
    private String name;
    private String rollno;
    private int marks;

    String getname()
    {
        return name;
    }
    String getrollno()
    {
        return rollno;
    }
    int getmarks()
    {
        return marks;
    }
    void setmarks(int marks)
    {
        this.marks=marks;
    }
    public Student(String name,String rollno,int marks)
    {
        this.name=name;
        this.rollno=rollno;
        this.marks=marks;
    }
    public String getGrade() 
    {
    if (marks >= 90) return "A+";
    else if (marks >= 70 && marks < 90) return "A";
    else if (marks >= 60 && marks < 70) return "B+";
    else if (marks >= 40 && marks < 60) return "B";
    else if (marks >= 30 && marks < 40) return "C";
    else return "FAIL";
    }
    public void displayInfo()
    {
        System.out.println("Student name :"+ name);
        System.out.println("Roll no :"+ rollno);
        System.out.println("Marks :"+marks);
        System.out.println("Grade :"+ getGrade());
    }

}
class StudentManagement
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        while(true)
        {
            System.out.println("Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Display all students");
            System.out.println("3. Search by Rollno");
            System.out.println("4. Delete by roll no");
            System.out.println("5. Exit");
            System.out.print("Enter your choice:");
            int choice=sc.nextInt();
            sc.nextLine();
            switch (choice) 
            {
                case 1:
                System.out.print("Enter name: ");
                String name = sc.nextLine();

                System.out.print("Enter roll number: ");
                String rollNo = sc.nextLine();

                System.out.print("Enter marks: ");
                int marks = sc.nextInt();
                sc.nextLine(); // clear the buffer

                Student s = new Student(name, rollNo, marks);
                students.add(s); // 👈 this adds to the ArrayList

                System.out.println("Student added successfully.");
                break;
                case 2:
                if(students.isEmpty())
                {
                    System.out.println("No student to display!");
                }else
                {
                    System.out.println("The list of students");
                    for(Student newstudent:students)
                    {
                        System.out.println("--------------");
                        newstudent.displayInfo();
                    }
                }
                break;
                case 3:
                System.out.println("Enter the roll no to search:");
                String rollno1=sc.nextLine();
                boolean found = false;

                for(Student student:students)
                {
                    if(student.getrollno().equalsIgnoreCase(rollno1))
                    {
                        System.out.println("Student found:");
                        student.displayInfo();
                        found=true;
                        break;
                    }
                }
                if(!found)
                    {
                        System.out.println("Roll no not found");
                    }
                break;
                case 4:
                System.out.print("Enter the roll no to delete:");
                String deleteroll=sc.nextLine();
                boolean found1=false;

                for(int i=0;i<students.size();i++)
                {
                    if(students.get(i).getrollno().equalsIgnoreCase(deleteroll))
                    {
                        students.remove(i);
                        System.out.println("Student with roll no "+deleteroll+" removed");
                        found1=true;
                        break;
                    }
                    if(!found1)
                    {
                        System.out.println("No student found");
                    }
                }
                break;
                case 5:
                  System.out.println("Exiting program...");
                return;
                default:
                 System.out.println("Invalid choice.");
            }
        }
    }
}