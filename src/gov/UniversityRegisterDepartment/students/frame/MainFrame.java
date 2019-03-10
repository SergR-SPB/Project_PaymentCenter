package gov.UniversityRegisterDepartment.students.frame;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        setBounds(100, 100, 600, 400);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                MainFrame mainFrame = new MainFrame();
                mainFrame.setVisible(true);//Видимость формы
                mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);//Поведение формы при закрытии


                                       }
                                   }
        );
    }
}
