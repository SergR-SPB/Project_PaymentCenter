package gov.paymentCenter.run;


import gov.paymentCenter.ansver.Ansver_CityRegisterDepartment;
import gov.paymentCenter.ansver.Answer_ChildRegisterDepartment;
import gov.paymentCenter.ansver.Answer_MariaggeRegisterDepartment;
import gov.paymentCenter.ansver.Answer__UniversityRegisterDepartment;
import gov.paymentCenter.validator.Validator_ChildRegisterDepartment;
import gov.paymentCenter.validator.Validator_CityRegisterDepartment;
import gov.paymentCenter.validator.Validator_MariaggeRegisterDepartment;
import gov.paymentCenter.validator.Validator_UniversityRegisterDepartment;

public class Validator_StudentApplicationForm {

    public static void main(String[] args) {
        check_All();
    }

    static void check_All() {


        //Считать заявку
        StudentApplicationForm studentApplicationForm =
                read_StudentApplicationForm();

        if (studentApplicationForm == null) {
            return;
        } else {

            //Проверка анкеты в департаментах

            Ansver_CityRegisterDepartment ansverCityRegisterDepartment
                    = check_CityRegisterDepartment(studentApplicationForm);

            Answer_MariaggeRegisterDepartment answerMariaggeRegisterDepartment
                    = check_MariaggeRegisterDepartment(studentApplicationForm);

            Answer_ChildRegisterDepartment answerChildRegisterDepartment
                    = check_ChildRegisterDepartment(studentApplicationForm);

            Answer__UniversityRegisterDepartment answerUniversityRegisterDepartment
                    = check_UniversityRegisterDepartment(studentApplicationForm);


            //Отправить сообщение
            sendMail(studentApplicationForm);
        }

    }


    static StudentApplicationForm read_StudentApplicationForm() {
        StudentApplicationForm studentApplicationForm = new StudentApplicationForm();

        return studentApplicationForm;
    }

    static Ansver_CityRegisterDepartment check_CityRegisterDepartment(StudentApplicationForm studentForm) {

        Validator_CityRegisterDepartment validatorCityRegisterDepartment1=
                new Validator_CityRegisterDepartment();
        validatorCityRegisterDepartment1.hostName= "Host1";
        validatorCityRegisterDepartment1.login = "login1";
        validatorCityRegisterDepartment1.password ="password1";

        Validator_CityRegisterDepartment validatorCityRegisterDepartment2=
                new Validator_CityRegisterDepartment();
        validatorCityRegisterDepartment2.hostName = "Host2";
        validatorCityRegisterDepartment2.login = "login2";
        validatorCityRegisterDepartment2.password ="password2";

        Ansver_CityRegisterDepartment ans1 = validatorCityRegisterDepartment1.check_CityRegisterDepartment(studentForm);
        Ansver_CityRegisterDepartment ans2 = validatorCityRegisterDepartment2.check_CityRegisterDepartment(studentForm);

        return ans1;
    }

    static Answer_MariaggeRegisterDepartment check_MariaggeRegisterDepartment(StudentApplicationForm studentForm) {
        Validator_MariaggeRegisterDepartment validatorMariaggeRegisterDepartment =
                new Validator_MariaggeRegisterDepartment();
        validatorMariaggeRegisterDepartment.hostName = "hostName";
        validatorMariaggeRegisterDepartment.login = "login" ;
        validatorMariaggeRegisterDepartment.password = "password";

        return (Answer_MariaggeRegisterDepartment) validatorMariaggeRegisterDepartment.check_MariaggeRegisterDepartment(studentForm);
    }

    static Answer_ChildRegisterDepartment check_ChildRegisterDepartment(StudentApplicationForm studentForm) {
        return Validator_ChildRegisterDepartment.check_ChildRegisterDepartament(studentForm);
    }

    static Answer__UniversityRegisterDepartment check_UniversityRegisterDepartment(StudentApplicationForm studentForm) {
       return Validator_UniversityRegisterDepartment.check_UniversityRegisterDepartment(studentForm);
    }

    static void sendMail(StudentApplicationForm studentForm) {

    }

}
