package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context=new ClassPathXmlApplicationContext("ormConfig.xml");
       StudentDao studentDao=context.getBean("studentDao", StudentDao.class);
       System.out.println("student object"+studentDao);
  /*     Student student=new Student(25,"Adhiraj", "Canada");
       int r=studentDao.insert(student);
       System.out.println("Done"+r);*/
       
       boolean go=true;
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       
       while(go)
       {
       System.out.println("press 1 for add new srudent");
       System.out.println("press 2 for display all students");
       System.out.println("press 3 for get details of single students ");
       System.out.println("press 4 for delete student");
       System.out.println("press 5 for updating students");
       System.out.println("press 6 for Exit");
       
       try {
    	   Integer input=Integer.parseInt(br.readLine());
    	   
    	   switch (input) {
    	   		case 1:
    	   			Student student=new Student();
    	   			student.setStudentId(11);
    	   			student.setStudentName("Prachi");
    	   			student.setStudentCity("Pune");
    	   			int recordIdInserted = studentDao.insert(student);
    	   			System.out.println("record Id inserted....:"+recordIdInserted);
    	   				break;
    	   		case 2:
    	   			
    	   			List<Student> allStudent = studentDao.getAllStudent();
    	   			System.out.println("get all students:"+allStudent);
    	   				break;
    	   		case 3:
    	   			Student student2 = studentDao.getStudent(10);
    	   			System.out.println("to get single student:"+student2);
    	   				break;
    	   		case 4:
    	   			studentDao.deleteStudent(10);
    	   				break;
    	   		case 5:
    	   			
    	   			Student student3=new Student();
    	   			student3.setStudentId(11);
    	   			student3.setStudentName("Adhi");
    	   			student3.setStudentCity("Chikhali");
    	   			studentDao.upadateStudent(student3);
    	   				break;
    	   		case 6:
    	   				go=false;
    	   				break;
    	   				
    	   default :
    		   System.out.println("Invalid choice....");
    		   break;

			} 
       }catch (Exception e) {
				
				System.out.println(e.getMessage());
			}
       }System.out.println("thanks for using my application .....");
    }
 }