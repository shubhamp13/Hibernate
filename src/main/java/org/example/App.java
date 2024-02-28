package org.example;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App
{
    public static void main( String[] args ) throws Exception
    {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Choice:");
        System.out.println("1.Insert The Data");
        System.out.println("2.Update The Student Information");
        System.out.println("3.Deleter The Student Information");
        System.out.println("4 Display The Student Information");
        System.out.println("5 Display All the records Present");
        System.out.println("6 Exit");
        int ch=Integer.parseInt(bufferedReader.readLine());
        StudentDao studentDao=new StudentDao();
        switch (ch)
        {
            case 1:
            {
                System.out.println("Enter Student Name");
                String name=bufferedReader.readLine();
                System.out.println("Enter Student Roll Number");
                int id=Integer.parseInt(bufferedReader.readLine());
                System.out.println("Enter Student Address");
                String address=bufferedReader.readLine();
                System.out.println("Enter Student Contact Number");
                String phNo=bufferedReader.readLine();
                Student student=new Student();
                student.setName(name);
                student.setRollNo(id);
                student.setPhNo(phNo);
                student.setAddress(address);
                studentDao.saveUser(student);
                System.out.println("Data Saved Successfully");
                System.out.println("Thank You!!!!!!!!!!!!1");
            }
            break;
            case 2:
            {
                System.out.println("Enter Roll Number of Student");
                int id= Integer.parseInt(bufferedReader.readLine());
                System.out.println("Enter The Updated Name of Student");
                String newName=bufferedReader.readLine();
                studentDao.updateUser(id,newName);
                System.out.println("Data Updated Successfully");
            }
            break;
            case 3:
            {
                System.out.println("Enter Roll Number Of Student To be Deleted");
                int id=Integer.parseInt(bufferedReader.readLine());
                studentDao.deleteUser(id);
                System.out.println("Data Deleted Successfully");
            }
            break;
            case 4:
            {
                System.out.println("Enter Roll Number");
                int id=Integer.parseInt(bufferedReader.readLine());
                studentDao.fetchData(id);
            }
            break;
            case 5:
            {
                 studentDao.display();
            }
            break;
            case 6:
            {
                System.out.println("Thanks!!!!!!!!!!!");
            }
            break;
        }
        bufferedReader.close();

    }
}
