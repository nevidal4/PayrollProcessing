import java.io.*;
/**
 * Driver for Payroll
 * @author Andrews Samuel
 * @version 23/4/17
 */
public class PayrollDriver{
    /**
     * main function for Payroll    
     */
    public static void main(String args[])throws IOException{
        //Andrews Samuel
        //008559913
        PrintWriter pw=new PrintWriter("csci.txt");
        Payroll payroll=new Payroll(new File("payfile.txt"),pw);
        payroll.outputInfo();
        payroll.displayGenderFirstNames('f');
        payroll.displayAmount('w',5,673);//Please note that there are 52 weeks in a year and 35000/52=673 rounded down
        payroll.increaseSalary(.75,10,50,350);
        payroll.getList().sort();
        System.out.print("\nSorted\n");
        pw.print("\nSorted\n");
        payroll.outputInfo();
        Payroll hires=new Payroll(new File("hirefile.txt"),pw);
        payroll.merge(hires);
        System.out.print("\nUpdated Payroll\n");
        pw.print("\nUpdated Payroll\n");
        payroll.outputNames();
        Payroll fires=new Payroll(new File("firefile.txt"),pw);
        payroll.terminate(fires);
        System.out.print("\nAfter terminations:\n");
        pw.print("\nAfter terminations:\n");
        payroll.outputNames();
        pw.close();
    }
}