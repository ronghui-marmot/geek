package kimmking;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import kimmking.aop.ISchool;

import javax.annotation.Resource;

@Data
public class School implements ISchool {
    
    // Resource 
    @Autowired(required = true) //primary
    Klass class1;
    
    @Resource(name = "student1")
    Student student1;
    
    public void ding(){
    
        System.out.println("Class1 have " + this.class1.getStudents().size() + " students and one is " + this.student1);
        
    }
    
    public String ding2() {
    	return new String("Class1 have " + this.class1.getStudents().size() + " students and one is " + this.student1);
    }
    
}
