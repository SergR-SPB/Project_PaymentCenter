package gov.UniversityRegisterDepartment.students.logic;

import java.io.UnsupportedEncodingException;
import java.util.*;

public class ManagementSystem {

    private List<Group> groups;
    private Collection<Student> students;

    // Для шаблона Singletone статическая переменная
    private static ManagementSystem instance;


    //Эакрытый конструктор
    private ManagementSystem() {
        loadGroups();       // Внести группы
        loadStudents();     // Внести студентов
    }

    //проверка инициализации instance
    public static synchronized ManagementSystem getInstance() {
        if (instance == null) {
            instance = new ManagementSystem();
        }

        return instance;
    }

    // Внести группы
    public void loadGroups() {
        if (groups == null) {
            groups = new ArrayList<Group>();
        } else {
            groups.clear();
        }
        Group group = null;

        group = new Group();

        group.setGroupId(1);
        group.setNameGroup("Первая");
        group.setCurator("доктор Перов");
        group.setSpeciality("Химия");
        groups.add(group);

        group = new Group();

        group.setGroupId(2);
        group.setNameGroup("Вторая");
        group.setCurator("доктор Иванов");
        group.setSpeciality("Физика");
        groups.add(group);
    }

    // Внести студентов
    public void loadStudents() {
        if (students == null) {
            students = new TreeSet<Student>();
        } else {
            students.clear();
        }
        Student student = null;
        Calendar calendar = Calendar.getInstance();

//Группа1
        student = new Student();
        student.setSurName("Иванов");
        student.setStudentId(1);
        student.setGroupId(1);
        student.setEducationYear(2016);
        calendar.set(1990, 6, 4);
        student.setDateOfBirth(calendar.getTime());
        students.add(student);

        student = new Student();
        student.setSurName("Петров");
        student.setStudentId(2);
        student.setGroupId(1);
        student.setEducationYear(2016);
        calendar.set(1991, 6, 4);
        student.setDateOfBirth(calendar.getTime());
        students.add(student);

        student = new Student();
        student.setSurName("Сидоров");
        student.setStudentId(3);
        student.setGroupId(1);
        student.setEducationYear(2016);
        calendar.set(1992, 6, 4);
        student.setDateOfBirth(calendar.getTime());
        students.add(student);


        student = new Student();
        student.setSurName("Баширов");
        student.setStudentId(4);
        student.setGroupId(1);
        student.setEducationYear(2016);
        calendar.set(1989, 6, 4);
        student.setDateOfBirth(calendar.getTime());
        students.add(student);


        //Группа2
        student = new Student();
        student.setSurName("Иванов2");
        student.setStudentId(5);
        student.setGroupId(2);
        student.setEducationYear(2019);
        calendar.set(1990, 6, 14);
        student.setDateOfBirth(calendar.getTime());
        students.add(student);

        student = new Student();
        student.setSurName("Петров2");
        student.setStudentId(6);
        student.setGroupId(2);
        student.setEducationYear(2019);
        calendar.set(1991, 6, 14);
        student.setDateOfBirth(calendar.getTime());
        students.add(student);

        student = new Student();
        student.setSurName("Сидоров2");
        student.setStudentId(7);
        student.setGroupId(2);
        student.setEducationYear(2019);
        calendar.set(1992, 6, 14);
        student.setDateOfBirth(calendar.getTime());
        students.add(student);


        student = new Student();
        student.setSurName("Баширов2");
        student.setStudentId(8);
        student.setGroupId(2);
        student.setEducationYear(2019);
        calendar.set(1989, 6, 14);
        student.setDateOfBirth(calendar.getTime());
        students.add(student);

//Группа3
        student = new Student();
        student.setSurName("Иванов3");
        student.setStudentId(9);
        student.setGroupId(3);
        student.setEducationYear(2017);
        calendar.set(1990, 6, 24);
        student.setDateOfBirth(calendar.getTime());
        students.add(student);

        student = new Student();
        student.setSurName("Петров3");
        student.setStudentId(10);
        student.setGroupId(3);
        student.setEducationYear(2017);
        calendar.set(1991, 6, 24);
        student.setDateOfBirth(calendar.getTime());
        students.add(student);

        student = new Student();
        student.setSurName("Сидоров3");
        student.setStudentId(11);
        student.setGroupId(3);
        student.setEducationYear(2017);
        calendar.set(1992, 6, 24);
        student.setDateOfBirth(calendar.getTime());
        students.add(student);


        student = new Student();
        student.setSurName("Баширов3");
        student.setStudentId(12);
        student.setGroupId(3);
        student.setEducationYear(2017);
        calendar.set(1989, 6, 24);
        student.setDateOfBirth(calendar.getTime());
        students.add(student);
    }
    //Получить список групп
    public List<Group>getGroups(){
        return groups;
    }
    //Получить список студентов
    public Collection<Student> getAllStudents() {
        return students;
    }
    //Получаем список студентов по группе и году поступления

    public Collection<Student> getStudentsFromGroup(Group group, int year) {
        Collection<Student> studentCollection = new TreeSet<Student>();

           for (Student si:students) {
               if (si.getGroupId() == group.getGroupId() && si.getEducationYear()==year ) {
                   studentCollection.add(si);
               }
        }
        return studentCollection;
    }

    //Перевод студентов из группы в группу

    public void moveStudentToGroup (Group oldGroup, int oldYear, Group newGroup, int newYear){
        for (Student si : students){
            if (si.getGroupId() == oldGroup.getGroupId() && si.getEducationYear()==oldYear ) {
            si.setGroupId(newGroup.getGroupId());
            si.setEducationYear(newYear);
            }
        }
    }
    // Удалить всех студентов из группы

    public void removeStudentForGroup (Group group, int year){
        Collection<Student> tmp = new TreeSet<Student>();
        for (Student si:students ){
            if( si.getGroupId() != group.getGroupId() || si.getEducationYear() !=year){
                tmp.add(si);
            }
        }students = tmp;
    }

    // Добавить студента
    public void insertStudent(Student student) {
        // Просто добавляем объект в коллекцию
        students.add(student);
    }

    // Обновить данные о студенте
    public void updateStudent(Student student) {
        Student updStudent = null;
        for (Student si : students) {
            if (si.getStudentId() == student.getStudentId()) {
                updStudent = si;
                break;
            }
        }
        updStudent.setFirstName(student.getFirstName());
        updStudent.setLastName(student.getLastName());
        updStudent.setSurName(student.getSurName());
        updStudent.setSex(student.getSex());
        updStudent.setDateOfBirth(student.getDateOfBirth());
        updStudent.setGroupId(student.getGroupId());
        updStudent.setEducationYear(student.getEducationYear());
    }

    // Удалить студента
    public void deleteStudent(Student student) {
        Student delStudent = null;
        for (Student si : students) {
            if (si.getStudentId() == student.getStudentId()) {
                delStudent = si;
                break;
            }
        }
        students.remove(delStudent);
    }


    public static void printString(Object s) {
        try {
            System.out.println(new String(s.toString().getBytes("windows-1251"), "windows-1252"));
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }

    }

    public static void printString() {
        System.out.println();
    }


}