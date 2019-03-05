package gov.paymentCenter.run;

public class Save_StudentApplicationForm {


    public static void main(String[] args) {

        StudentApplicationForm studentForm1 = new StudentApplicationForm();

        studentForm1.husbandFirstName = "Алксей";

        studentForm1.husbandLastName = "Иванов";

        studentForm1.wifeFirstName = "Наталья";
        studentForm1.wifeLastName = "Иванова";

        StudentApplicationForm studentForm2 = new StudentApplicationForm();

        studentForm2.husbandFirstName = "Николай";
        studentForm2.husbandLastName = "Петров";

        studentForm2.wifeFirstName ="Инна";
        studentForm2.wifeLastName = "Петрова";

        long ans = save_StudentApplicationForm(studentForm1);
        //System.out.println(ans);

        long ans1 = save_StudentApplicationForm(studentForm2);
        //System.out.println(ans1);



    }

    static  long save_StudentApplicationForm (StudentApplicationForm
                                                      studentApplicationForm){
        long answer;
        answer = 199;
        System.out.println("save StudentApplicationForm: "
                + studentApplicationForm.husbandLastName);
        return answer;
    }




}
