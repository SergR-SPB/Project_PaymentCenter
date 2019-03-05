package gov.UniversityRegisterDepartment.students.logic;

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
        student.setEducationYear(2019);
        calendar.set(1990, 6, 4);
        student.setDateOfBirth(calendar.getTime());
        students.add(student);

        student = new Student();
        student.setSurName("Петров");
        student.setStudentId(2);
        student.setGroupId(1);
        student.setEducationYear(2019);
        calendar.set(1991, 6, 4);
        student.setDateOfBirth(calendar.getTime());
        students.add(student);

        student = new Student();
        student.setSurName("Сидоров");
        student.setStudentId(3);
        student.setGroupId(1);
        student.setEducationYear(2019);
        calendar.set(1992, 6, 4);
        student.setDateOfBirth(calendar.getTime());
        students.add(student);


        student = new Student();
        student.setSurName("Баширов");
        student.setStudentId(4);
        student.setGroupId(1);
        student.setEducationYear(2019);
        calendar.set(1989, 6, 4);
        student.setDateOfBirth(calendar.getTime());
        students.add(student);


        //Группа2
        student = new Student();
        student.setSurName("Иванов2");
        student.setStudentId(5);
        student.setGroupId(2);
        student.setEducationYear(2018);
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

//Группа2
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
}