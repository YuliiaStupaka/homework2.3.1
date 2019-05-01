/*
Создайте класс, описывающий человека (создайте метод, выводящий информацию о человеке).
На его основе создайте класс Студент (переопределите метод вывода информации).
Создайте класс Группа, который содержит массив из 10 объектов класса Студент. 
Реализуйте методы добавления, удаления студента и метод поиска студента по фамилии. 
В случае  попытки добавления 11 студента, создайте собственное исключение и обработайте его. 
Определите метод toString() для группы так, что бы он выводил список студентов в алфавитном порядке. 
Усовершенствуйте класс Group добавив возможность интерактивного добавления объекта. 
Реализуйте возможность сортировки списка студентов по фамилии. 
Реализуйте возможность сортировки по параметру (Фамилия, успеваемость и т.д.). 
Реализуйте интерфейс Военком, который вернет из группы массив студентов - юношей, которым больше 18 лет. 
Протестируйте ее работу.
*/
package homework231;
public class Homework231 {
    public static void main(String[] args) {
        Group groupOne=new Group("Zpi-81");
        try{
            groupOne.addStudent(new Student(8102,"Zpi-81","Jeff","Bezos",true,19));
            groupOne.addStudent(new Student(8107,"Zpi-81","Bill","Gates",true,21));
            groupOne.addStudent(new Student(8109,"Zpi-81","Amancia","Ortega",false,19));
            groupOne.addStudent(new Student(8108,"Zpi-81","David","Koch",true,18));
            groupOne.addStudent(new Student(8105,"Zpi-81","Larry","Ellison",true,20));
            groupOne.addStudent(new Student(8103,"Zpi-81","Michael","Dell",false,18));
        }catch(FullGroupException e){
            System.out.println(e.getMessage());
        }
        System.out.println(groupOne);
        System.out.println();
        Student st=groupOne.search("Ortega");
        System.out.println(st);
        try{
           groupOne.addStudentInteractive();
        }catch(FullGroupException e){
            System.out.println(e.getMessage());
        }
        System.out.println(groupOne);
        System.out.println();
        Student[]recruterArray=groupOne.getRecruter();
        for(Student student:recruterArray){
            System.out.println("In the list of the military there is "+student);
        }
    }
}
