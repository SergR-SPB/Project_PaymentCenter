package gov.UniversityRegisterDepartment.students.logic;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class ManagementSystemOne {

    private  List<Group> groups;
    private Collection<Student> students;

    /*1/=====================================================*/

    // Для шаблона Singletone статическая переменная
    private static ManagementSystemOne instance;


    //Эакрытый конструктор
    private ManagementSystemOne() {
        loadGroups();       // Внести группы
        loadStudents();     // Внести студентов
    }

    //проверка инициализации instance
    public static synchronized ManagementSystemOne getInstance() {
        if (instance == null) {
            instance = new ManagementSystemOne();
        }

        return instance;
    }
    public static void printString(Object s) {
        try {
            System.out.println(new String(s.toString().getBytes("UTF-8"), "UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
    }

    public static void printString() {
        System.out.println();
    }

    /*2/1=============================================================*/

    //Добавить группу
    public void insertGroup(Group group){ groups.add(group ); }
    //Удаление групп
    public void clearGroup(Group group1) {groups.clear();}


    // Подготовка листа для групп
    public  void loadGroups() {
        if (groups == null) {
            groups = new ArrayList<Group>();
        } else {
            groups.clear();
        }
    }
    //Получить список групп
    public List<Group>getGroups(){
        return groups;
    }


     /*2/2=============================================================*/

     //Добавить студента
    public void insertStudent(Student student){students.add(student);}

    //Изменить данные студента
    public void updateStudent(Student student){
        Student updStudent = null;
        for (Student si : students){
           if(si.getStudentId() == student.getStudentId()){
               updStudent = si;
               break;
           }
        }
        updStudent.setFirstName(student.getFirstName());
        updStudent.setSurName(student.getSurName());
        updStudent.setStudentId(student.getStudentId());
        updStudent.setGroupId(student.getGroupId());
        updStudent.setDateOfBirth(student.getDateOfBirth());
        updStudent.setEducationYear(student.getEducationYear());

    }



    //Удалить конкретного студента
    public void deliteStudent(Student student){
        Student delStudent = null;
        for (Student si : students){
            if(si.getStudentId() == student.getStudentId()){
                delStudent = si;
                break;
            }
        }
        students.remove(delStudent);
    }

    //Удалить всех студентов
    public void clearStudent(Student student) {students.clear();}

    //Перевод студентов из группы в группу
    public void moveStudentToGroup
          (Group oldGroup,  Group newGroup){
        for (Student student:students){
            if(student.getGroupId()==oldGroup.getGroupId()){
                student.setGroupId(newGroup.getGroupId());
            }
        }
    }
    //Удаление студентов из определенной группы
    public void removeStudentsFromGroup(Group group){
        Collection<Student>tmp = new TreeSet<Student>();
        for (Student student:students){
            if(student.getGroupId() != group.getGroupId()){
                tmp.add(student);
            }
        }students = tmp;
    }

    //Подготовка листа для студентов
    public void loadStudents(){
        if (students == null){
            students = new TreeSet<Student>();
        }else {
            students.clear();
        }
        //Student s = null;
       // Calendar calendar = Calendar.getInstance();
    }

    //Получить список студентов
    public Collection<Student> getStudents(){
        return students;
    }

    //Получить список студентов для опр. группы
    public Collection<Student>getStudentForGroup (Group group,int idGroup){
       Collection<Student> stFG = new TreeSet<Student>();
       for (Student st:students){
           if (st.getGroupId()==group.getGroupId()&&st.getGroupId()==idGroup){
               stFG.add(st);
           }
       }
       return stFG;
    }




//******************************************************************************

    public static void main(String[] args) {

        //метод вывода печати в файл list.txt
        try {
            System.setOut(new PrintStream("list.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        ManagementSystemOne managementSystem = ManagementSystemOne.getInstance();

        // Добавление группы
        managementSystem.loadGroups();

        Group group = new Group();
        group.setGroupId(1);
        group.setNameGroup("Первая");
        group.setCurator("доктор Перов");
        group.setSpeciality("Химия1");
        managementSystem.insertGroup(group);

        // managementSystem.clearGroup(group);

        group = new Group();

        group.setGroupId(2);
        group.setNameGroup("Вторая");
        group.setCurator("доктор Иванов");
        group.setSpeciality("Физика1");
        managementSystem.insertGroup(group);

        group = new Group();
        group.setGroupId(3);
        group.setNameGroup("Третья");
        group.setCurator("доктор Павлов");
        group.setSpeciality("Зоология1");

        managementSystem.insertGroup(group);


        // Просмотр списка групп
        printString("Полный список групп");
        printString("====================");

        List<Group>allGroups = managementSystem.getGroups();

        for(Group gr1 : allGroups){
            printString(gr1);
        }
        printString();

        //Добавить студентов в группы

        Calendar calendar = Calendar.getInstance();

        managementSystem.loadStudents();
        //1 группа
        Student student = new Student();
        student.setFirstName("Иванов 1");
        calendar.set(1990,3,20);
        student.setDateOfBirth(calendar.getTime());
        student.setStudentId(1);
        student.setGroupId(1);
        student.setEducationYear(2018);

        managementSystem.insertStudent(student);

        student = new Student();
        student.setFirstName("Петров 1");
        calendar.set(1990,3,20);
        student.setDateOfBirth(calendar.getTime());
        student.setStudentId(2);
        student.setGroupId(1);
        student.setEducationYear(2018);

        managementSystem.insertStudent(student);

        student = new Student();
        student.setFirstName("Баширов 1");
        calendar.set(1990,3,20);
        student.setDateOfBirth(calendar.getTime());
        student.setStudentId(3);
        student.setGroupId(1);
        student.setEducationYear(2018);

        managementSystem.insertStudent(student);

        //2 группа
        student = new Student();
        student.setFirstName("Иванов 2");
        calendar.set(1990,3,20);
        student.setDateOfBirth(calendar.getTime());
        student.setStudentId(4);
        student.setGroupId(2);
        student.setEducationYear(2018);

        managementSystem.insertStudent(student);

        student = new Student();
        student.setFirstName("Петров 2");
        calendar.set(1990,3,20);
        student.setDateOfBirth(calendar.getTime());
        student.setStudentId(5);
        student.setGroupId(2);
        student.setEducationYear(2018);

        managementSystem.insertStudent(student);

        student = new Student();
        student.setFirstName("Баширов 2");
        calendar.set(1990,3,20);
        student.setDateOfBirth(calendar.getTime());
        student.setStudentId(6);
        student.setGroupId(2);
        student.setEducationYear(2018);

        managementSystem.insertStudent(student);

        //3 группа
        student = new Student();
        student.setFirstName("Иванов 3");
        calendar.set(1990,3,20);
        student.setDateOfBirth(calendar.getTime());
        student.setStudentId(7);
        student.setGroupId(3);
        student.setEducationYear(2018);

        managementSystem.insertStudent(student);

        student = new Student();
        student.setFirstName("Петров 3");
        calendar.set(1990,3,20);
        student.setDateOfBirth(calendar.getTime());
        student.setStudentId(8);
        student.setGroupId(3);
        student.setEducationYear(2018);

        managementSystem.insertStudent(student);

        student = new Student();
        student.setFirstName("Баширов 3");
        calendar.set(1990,3,20);
        student.setDateOfBirth(calendar.getTime());
        student.setStudentId(9);
        student.setGroupId(3);
        student.setEducationYear(2018);

        managementSystem.insertStudent(student);


        // Просмотр списка студентов по всем группам
        printString("Полный список студентов");
        printString("====================");

        Collection<Student>allStudents= managementSystem.getStudents();

        for(Student st : allStudents){
            printString(st);
        }
        printString();

        // Просмотр списка студентов по определенным группам


        printString("Список студентов по группам ");
        printString("====================");
        List<Group> groups = managementSystem.getGroups();
        for (Group gi:groups){
            Collection<Student>students = managementSystem.
                    getStudentForGroup(gi,2);
            printString("Группа: "+gi.getNameGroup());

            for (Student st:students){

                printString(st);
            }
            printString();

        }

        //Внести изменения по студенту
        student = new Student();

        student.setFirstName("Петровичус 2.1");
        calendar.set(1990,3,20);
        student.setDateOfBirth(calendar.getTime());
        student.setStudentId(5);
        student.setGroupId(2);
        student.setEducationYear(2018);

        managementSystem.updateStudent(student);

        printString("Список студентов после внесения изменений ");
        printString("====================");
        groups = managementSystem.getGroups();
        for (Group gi:groups){
            Collection<Student>students = managementSystem.
                    getStudentForGroup(gi,2);
           for (Student st:students){
                printString(st);
            }
            printString();
          }

        //Удаление студента
        student = new Student();
        student.setStudentId(4);
        student.setFirstName("Иванов 2");
        printString("Список студентов после удаления студента "+student);
        printString("====================");
        managementSystem.deliteStudent(student);


        groups = managementSystem.getGroups();
        for (Group gi:groups){
            Collection<Student>students = managementSystem.
                    getStudentForGroup(gi,2);
            for (Student st:students){
                printString(st);
            }
            printString();
        }

        //Перевод студентов из одной группы в другую

        Group group1 = groups.get(0);
        Group group2 = groups.get(2);
        printString("Перевод студентов из первой в третю группу");
        printString("=========================================");
        managementSystem.moveStudentToGroup (group1,group2);
        allStudents = managementSystem.getStudents();
        for (Student student1:allStudents){
            printString(student1);
        }
        printString();

        //Удаление студентов второй группы

        Group g2 = groups.get(1);
        printString("Удаление студентов из группы:" + g2 );
        printString("====================================");
        managementSystem.removeStudentsFromGroup(g2);
        allStudents = managementSystem.getStudents();
        for (Student si : allStudents) {
            printString(si);
        }
        printString();






























    }




}