package lab01;

import javax.swing.*;

public class PhuongTrinhBacMotDialog {
    public static void main(String[] args) {
        String strNum1, strNum2;
        JOptionPane.showMessageDialog(null,"Nhập vào hai số a và b để giải phương trình a x + b = 0");
        strNum1 = JOptionPane.showInputDialog(null, "Please input a: ",
                "Input a", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null, "Please input b: ",
                "Input b", JOptionPane.INFORMATION_MESSAGE);
        double a = Double.parseDouble(strNum1);
        double b = Double.parseDouble(strNum2);
        if (a == 0 && b == 0) {
            JOptionPane.showMessageDialog(null, "Phương trình có vô số nghiệm",
                    "Giải Phương trình " + a + "x + " + b + " = 0", JOptionPane.INFORMATION_MESSAGE);
        } else if (a == 0 && b != 0) {
            JOptionPane.showMessageDialog(null, "Phương trình không có nghiệm",
                    "Giải Phương trình " + a + "x + " + b + " = 0", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Phương trình có nghiệm là: "+(-b/a),
                    "Giải Phương trình " + a + "x + " + b + " = 0", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
