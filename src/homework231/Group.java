package homework231;
import java.util.Arrays;
import java.lang.NullPointerException;
import java.lang.String;
import javax.swing.JOptionPane;
public class Group implements Voencom{
    private Student[] studentArray = new Student[10];
    private String groupName;
        
    public Group() {
        super();
        this.groupName = "unknow";
    }

    public Group(String groupName) {
        super();
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    public void addStudentInteractive()throws FullGroupException{
        try{
            String name=getName("Input student name: ");
            String surname=getSurname("Input student surname: ");
            int age=getAge();
            boolean sex=getSex("Input sex(man or women): ");
            long recordBookNumber=getRecordBookNumber("Input recordbook number: ");
            String group=this.groupName;
            Student stud=new Student(recordBookNumber, group, name, surname, sex, age);
            this.addStudent(stud);
        }catch(NullPointerException e){
            System.out.println("Error");
            return;
        }
    }
    private String getName(String message)throws NullPointerException{
        boolean done=false;
        String name="";
        for(;!done;){
            try{
                name=JOptionPane.showInputDialog(message);
                done=true;
            } catch(NumberFormatException e){
                JOptionPane.showInternalMessageDialog(null, "Wrong format");
            }
        }
        return name;
    }
    private String getSurname(String message)throws NullPointerException{
        boolean done=false;
        String surname="";
        for(;!done;){
            try{
                surname=JOptionPane.showInputDialog(message);
                done=true;
            } catch(NumberFormatException e){
                JOptionPane.showInternalMessageDialog(null, "Wrong format");
            }
        }
        return surname;
    }
    private int getAge()throws NullPointerException{
        boolean done=false;
        int age=0;
        for(;!done;){
            try{
                age=Integer.valueOf(JOptionPane.showInputDialog("Input student age: "));
                done=true;
            } catch(NumberFormatException e){
                JOptionPane.showInternalMessageDialog(null, "Wrong format");
            }
        } 
        return age;
    }
    private boolean getSex(String message)throws NullPointerException{
        boolean done=false;
        boolean sex=false;
        for(;!done;){
            try{
                sex=JOptionPane.showInputDialog(message).equals("man");
                done=true;
            } catch(NumberFormatException e){
                JOptionPane.showInternalMessageDialog(null, "Wrong format");
            }
        }
        return sex;
    }
    private long getRecordBookNumber(String message)throws NullPointerException{
        boolean done=false;
        long recordBookNumber=0;
        for(;!done;){
            try{
                recordBookNumber=Long.valueOf(JOptionPane.showInputDialog(message));
                done=true;
            } catch(NumberFormatException e){
                JOptionPane.showInternalMessageDialog(null, "Wrong format");
            }
        }
        return recordBookNumber;
    }
    
    public void addStudent(Student student) throws FullGroupException{
       if(student==null){
           throw new IllegalArgumentException("Null Student");
       }
       for(int i=0; i<studentArray.length;i++){
           if(studentArray[i]==null){
               student.setGroup(this.groupName);
               studentArray[i]=student;
               return;
           }
       }
       throw new FullGroupException();
    }
    public boolean deleteStudent(long number){
        for(int i=0; i<studentArray.length; i++){
            if(studentArray[i]!=null && studentArray[i].getRecordBookNumber()==number){
                studentArray[i]=null;
                return true;
            }
        }
        return false;
    }
    public Student search (String surname){
        for(Student student:studentArray){
            if (student !=null && student.getSurname().equals(surname)){
                return student;
            }
        }
        return null;
    }
    private void sortStudent(){
        for(int i=0; i<studentArray.length-1;i++){
            for(int j=i+1; j<studentArray.length; j++){
                if(compareStudent(studentArray[i],studentArray[j])>0){
                    Student t=studentArray[i];
                    studentArray[i]=studentArray[j];
                    studentArray[j]=t;
                }
            }
        }
    }
    private int compareStudent(Student a, Student b){
        if(a!=null && b==null){
            return 1;
        }
        if(a==null && b!=null){
            return -1;
        }
        if(a==null && b==null){
            return 0;
        }
        return a.getSurname().compareTo(b.getSurname());
    }
    
    public void sortParameter(int i){
        Arrays.sort(this.studentArray,new StudentComparator(i));
    }
    public void sortParametr(int i, boolean following){
        Arrays.sort(this.studentArray,new StudentComparator(i,following));
    }
    
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append("Group: "+this.groupName).append(System.lineSeparator());
        int i=0;
        sortStudent();
        for(Student student:studentArray){
            if(student!=null){
                sb.append((++i)+") ").append(student);
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
    @Override
    public Student[] getRecruter(){
       int n=0;
       for(Student student:studentArray){
           if(student !=null && student.isSex()&&student.getAge()>=18){
               n+=1;
           }
       }
       Student[]recruterArray = new Student[n];
        int i=0;
        for(Student student:studentArray){
            if(student !=null && student.isSex()&&student.getAge()>=18){
                recruterArray[i++]=student;
            }
        }
        return recruterArray;
    }
}
