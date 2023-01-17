package job;
import job.model.Student;
import job.model.StudentGroup;
import job.view.attandance.AttendanceGroup;
import job.view.attandance.AttendanceVisit;
import job.view.controller.*;

public class MainMvpClass {

    public static void main(String[] args) {
        // Создание объектов студентов
        Student Jon = new Student("Jon", 1);
        Student Sara = new Student("Sara", 1);
        Student Bill = new Student("Bill", 1);
        // Создание объекта группы студентов
        StudentGroup studentGroupOneCourse = new StudentGroup();
        // Добавление студентов в группу студентов
        studentGroupOneCourse.addStudentInGroup(Jon);
        studentGroupOneCourse.addStudentInGroup(Sara);
        studentGroupOneCourse.addStudentInGroup(Bill);
        // System.out.println(studentGroupOneCourse);


        // Создание объекта о посищении студентов
        AttendanceVisit attendanceVisitingJon = new AttendanceVisit(Jon);
        AttendanceVisit attendanceVisitingSara = new AttendanceVisit(Sara);
        AttendanceVisit attendanceVisitingBill = new AttendanceVisit(Bill);
        // список посищений студентов
        attendanceVisitingSara.addVisiting("01-01-2023", true);
        attendanceVisitingSara.addVisiting("02-01-2023", true);
        attendanceVisitingSara.addVisiting("03-01-2023", true);
        attendanceVisitingSara.addVisiting("04-01-2023", true);
        attendanceVisitingSara.addVisiting("05-01-2023", true);
        attendanceVisitingSara.addVisiting("06-01-2023", true);
        attendanceVisitingSara.addVisiting("07-01-2023", true);

        attendanceVisitingBill.addVisiting("01-01-2023", false);
        attendanceVisitingBill.addVisiting("02-01-2023", false);
        attendanceVisitingBill.addVisiting("03-01-2023", false);
        attendanceVisitingBill.addVisiting("04-01-2023", false);
        attendanceVisitingBill.addVisiting("05-01-2023", false);
        attendanceVisitingBill.addVisiting("06-01-2023", false);
        attendanceVisitingBill.addVisiting("07-01-2023", true);
        
        attendanceVisitingJon.addVisiting("01-01-2023", true);
        attendanceVisitingJon.addVisiting("02-01-2023", false);
        attendanceVisitingJon.addVisiting("03-01-2023", true);
        attendanceVisitingJon.addVisiting("04-01-2023", true);
        attendanceVisitingJon.addVisiting("05-01-2023", true);
        attendanceVisitingJon.addVisiting("06-01-2023", false);
        attendanceVisitingJon.addVisiting("07-01-2023", true);
        // Спсиок группы студентов и их посещаемость
        AttendanceGroup attendanceGroupOneCourse = new AttendanceGroup();
        attendanceGroupOneCourse.addAttendanceVisit(attendanceVisitingJon);
        attendanceGroupOneCourse.addAttendanceVisit(attendanceVisitingBill);
        attendanceGroupOneCourse.addAttendanceVisit(attendanceVisitingSara);
        // Создание объекта контроллера посищения группы 
        ControllerAttendanceGroup controllerGroup = new ControllerAttendanceGroup(attendanceGroupOneCourse);
        
        controllerGroup.PrintStudentsVisitingPercent(studentGroupOneCourse);
        controllerGroup.PrintStudentsVisitingLess25Persent(studentGroupOneCourse);
        controllerGroup.PrintSortStudentsVisiting(studentGroupOneCourse);
    }
}