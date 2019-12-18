import java.util.Scanner;
import java.io.*;
/**
 * Payroll class
 * @author Andrews Samuel
 * @version 23/4/17
 */
public class Payroll{
    private ObjectList payroll;
    PrintWriter pw;
    /**
     * Constructor for Payroll object
     * @param File to retrieve Employee object info
     * @param PrintWriter object for file output
     */
    public Payroll(File fp,PrintWriter pwArg)throws IOException{
        pw=pwArg;
        payroll=new ObjectList();
        readFile(fp);
    }
    /**
     * Returns the list of the payroll class
     */
    public ObjectList getList(){
        return payroll;
    }
    /**
     * Helper method to read the input file provided in constructor
     * @param File fp pointing to the file from which info is to be obtained
     */
    private void readFile(File fp)throws IOException{
        Scanner in=new Scanner(fp);
        String line,s[];
        while(in.hasNext()){
            line=in.nextLine();
            s=line.split("[ ]+");
            if(s.length<3){
                payroll.addLast(new ObjectListNode(new Employee(s[1],s[0])));
            }
            else{
                payroll.addLast(new ObjectListNode(new Employee(s[1],s[0],s[2].charAt(0),s[4].charAt(0),
                                Integer.parseInt(s[3]),Double.parseDouble(s[5]))));
            }
        }
    }
    /**
     * Helper method to output the header for output info
     */
    private void outputHeader(){
        System.out.printf("\n%9s%11s%7s%5s%7s%8s\n","Last Name","First Name","Gender","Rate","Tenure","Salary");
        pw.printf("\n%9s%11s%7s%5s%7s%8s\n","Last Name","First Name","Gender","Rate","Tenure","Salary");
    }
    /**
     * Outputs formatted Emplooyee info and number of employees
     */
    public void outputInfo(){
        outputHeader();
        ObjectListNode p=payroll.getFirstNode();
        while(p!=null){
            ((Employee)p.getInfo()).displayInfo(pw);
            p=p.getNext();
        }
        System.out.print("\nNumber of Employees: "+payroll.size()+"\n");
        pw.print("\nNumber of Employees: "+payroll.size()+"\n");
    }
    /**
     * Outputs formatted last and first names as well as number of employees
     */
        public void outputNames(){
        System.out.printf("\n%9s%11s\n","Last Name","First Name");
        pw.printf("\n%9s%11s","Last Name","First Name");
        ObjectListNode p=payroll.getFirstNode();
        while(p!=null){
            ((Employee)p.getInfo()).displayName(pw);
            p=p.getNext();
        }
        System.out.print("\nNumber of Employees: "+payroll.size()+"\n");
        pw.print("\nNumber of Employees: "+payroll.size()+"\n");
    }
    /**
     * Displays names of gender
     * @param char g being the letter 'm' to display male names, or 'f' for female names
     */
    public void displayGenderFirstNames(char g){
        g=Character.toUpperCase(g);
        ObjectListNode p;
        p=payroll.getFirstNode();
        Employee e;
                if(g=='M'){
            System.out.print("\nAll Men:\n");
            pw.print("\nAll Men:\n");
        }
        if(g=='F'){
            System.out.print("\nAll Women:\n");
            pw.print("\nAll Women:\n");
        }
        while(p!=null){
            e=(Employee)p.getInfo();
            if(e.getGender()==g){
                System.out.print(e.getFirstName()+"\n");
                pw.print(e.getFirstName()+"\n");
            }
            p=p.getNext();
        }
    }
    /**
     * Displays all employees with all specifications equal to or greater than: payrate r, tenure t, and salary s
     * @param char r to display pay rate whether it be 'w' for weekly, or 'h' for hourly
     * @param int t to display emplyees with a certain tenure greater than or equal to value t
     * @param int double s to diplay employees with a certain salary greater than or equal to value s
     */
    public void displayAmount(char r,int t,double s){
        ObjectListNode p=payroll.getFirstNode();
        Employee e;
        r=Character.toUpperCase(r);
        System.out.printf("\nEmployees of %d or more years with a %s salary of %.2f or greater:\n",t,r=='H'?"hourly":"weekly",s);
        pw.printf("\nEmployees of %d or more years with a %s salary of %.2f or greater:\n",t,r=='H'?"hourly":"weekly",s);
        while(p!=null){
            e=(Employee)p.getInfo();
            if(e.getTenure()<t&&e.getRate()==r&&
                s<=(e.getSalary())){
                System.out.printf("\n%s %s %.2f\n",e.getLastName(),e.getFirstName(),e.getSalary());
                pw.printf("\n%s %s %.2f\n",e.getLastName(),e.getFirstName(),e.getSalary());
            }
            p=p.getNext();
        }
    }
    /**
     * Increases salary of select indavdidual employees
     * @param double hIncrease increased salary amount for hourly employees
     * @param double hThreshold the maximum hourly salary worthy of increase
     * @param double wIncrease increased salary amount for weekly employees
     * @param double wThreshold the maximum weekly salary worthy of increase
     */
    public void increaseSalary(double hIncrease,double hThreshold,double wIncrease,double wThreshold){
        ObjectListNode p=payroll.getFirstNode();
        Employee e;
        System.out.print("\nIncreased Salaries:\n");
        pw.print("\nIncreased Salaries:\n");
        while(p!=null){
            e=(Employee)p.getInfo();
            if(e.getRate()=='H'&&e.getSalary()<hThreshold){
                e.setSalary(e.getSalary()+hIncrease);
                System.out.printf("%s %s %.2f\n",e.getLastName(),e.getFirstName(),e.getSalary());
                pw.printf("\n%s %s %.2f\n",e.getLastName(),e.getFirstName(),e.getSalary());
            }
            else if(e.getRate()=='W'&&e.getSalary()<wThreshold){
                e.setSalary(e.getSalary()+wIncrease);
                System.out.printf("%s %s %.2f\n",e.getLastName(),e.getFirstName(),e.getSalary());
                pw.printf("\n%s %s %.2f\n",e.getLastName(),e.getFirstName(),e.getSalary());
            }
            p=p.getNext();
        }
    }
    /**
     * Merges arguement payroll list with this sorted payroll list
     * @param payroll to have its members added to this payroll
     */
    public void merge(Payroll pr){
        while(!pr.getList().isEmpty())
            payroll.insert(new ObjectListNode(pr.getList().removeFirst()));
    }
    /**
     * Finds and removes the intersection of two payroll lists
     * @param payroll with a copy of the members to be terminted (by name) from this list
     */
    public void terminate(Payroll pr){
        while(!pr.getList().isEmpty()){
            payroll.remove(pr.getList().removeFirst());
        }
    }
}