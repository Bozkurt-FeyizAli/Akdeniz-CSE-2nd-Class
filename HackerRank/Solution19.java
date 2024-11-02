import java.io.File;
import java.util.*;
public class Solution19{
    public static void main(String[] args) {
        File f= new File("deneme.txt");
        try{
        Scanner s= new Scanner(f);
        
        int pr=s.nextInt();
        s.nextLine();
        Priorities priorities= new Priorities();
        for (int i = 0; i < pr; i++) {
            String decision=s.next();
            if(decision.equals("ENTER")){
            String name=s.next();
            double cgpa=s.nextDouble();
            int id=s.nextInt();
            Student stu=new Student(id, name, cgpa);
            priorities.add(stu);
            }
            else if(decision.equals("SERVED"))
                priorities.remove();
            System.out.println(priorities.getStudents().size());


        }
        System.out.println(priorities.getStudents()==null);
        for (Student student : priorities.getStudents()) {
            System.out.println(student);
        }
    }
    catch(Exception e){
        System.out.println(e.getMessage());
    }
    }
}


class Student implements Comparable<Student>{
    int id;
    double cgpa;
    String name;
    Student(int id, String name, double cgpa){
        this.id=id;
        this.name=name;
        this.cgpa=cgpa;
    }
    public double getCgpa() {
        return cgpa;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return name+" "+Double.toString(cgpa)+" "+Integer.toString(id);
    }
    @Override
    public int compareTo(Student stu) {
        if(cgpa>stu.getCgpa()){
            return 1;
        }
        else if(cgpa==stu.getCgpa()){
            if(name.compareTo(stu.getName())<0)
                return 1;
            else if(name.compareTo(stu.getName())==0)
                return 0;
            else return -1;
        }
        else return -1;
    }

    
    
}

class Priorities{
    List<Student> students;
    int size;
    public Priorities(){
        students=new ArrayList<>();
        size=0;
    }

    public void add(Student student){
        if(size==0)
            students.add(student);
        else{
            for (int i = 0; i < size; i++) {
                if(student.compareTo(students.get(i))>0){
                    if(i==0)
                        students.addFirst(student);
                    else 
                        students.add(i-1, student);
                    break;
                    }
                    else{
                        if((i+1)!=size-1)
                            if(students.get(i+1).compareTo(student)<0)
                                students.add(i+1, student); 
                                break;
                            
                    }
      
            }
            if(!students.contains(student))
                students.add(student);
        }
        size++;
    }

    public Student remove(){
        Student s=students.getFirst();
        students.remove(0);
        size--;
        return s;
    }

    public List<Student> getStudents() {
        return students;
    }
}


