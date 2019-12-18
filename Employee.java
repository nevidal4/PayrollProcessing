import java.io.*;
/**
 * Employee class containing employee info
 * @author Andrews Samuel
 * @version 23/4/17
 */
public class Employee implements Comparable{
    private String lastName,firstName;
    private char gender,rate;
    private int tenure;
    private double salary;
    /**
     * Constructor that designed to assign info for last and first names only
     * @param String ln for the last name of employee
     * @param String fn for the first name of employee
     */
    public Employee(String ln,String fn){
        lastName=ln;
        firstName=fn;
        gender='M';
        rate='H';
        tenure=0;
        salary=0;
    }
    /**
     * Constructor that populates all info regarding employee
     * @param String ln for last name of employee
     * @param String fn for first name of employee
     * @char g for gender of employee
     * @char r for the rate at which the employee is paid, whether it be hourly or weekly
     * @int t for tenure, or number of years employee has been with the company
     * @double s for the current salary of employee
     */
    public Employee(String ln,String fn,char g,char r,int t,double s){
        lastName=ln;
        firstName=fn;
        gender=g;
        rate=r;
        tenure=t;
        salary=s;
    }
    /**
     * Adjusts payrate for employee from houly to weekly, or vise versa
     * @param rate to which payrate is to be changed
     * @param salary adjustment
     */
    public void setRate(char r,double s){
        rate=r;
        salary=s;
    }
    /**
     * Increments the number of years employee has been with company
     */
    public void addTenure(){
        ++tenure;
    }
    /**
     * Adjusts salary of employee
     * @param the new salary of this employee
     */
    public void setSalary(double s){
        salary=s;
    }
    /**
     * Returns the last name of employee
     * @return String this employee's last name
     */
    public String getLastName(){
        return lastName;
    }
    /**
     * Returns the first name of employee
     * @return String this employee's first name
     */
    public String getFirstName(){
        return firstName;
    }
    /**
     * Returns charicter representation of employee's gender
     * @return char this emplooyee's gender
     */
    public char getGender(){
        return gender;
    }
    /**
     * Returns current pay rate of employee
     * @return char this employee's current pay rate
     */
    public char getRate(){
        return rate;
    }
    /**
     * Returns the number of years current employee has been with company
     * @return int the number of years employee has been with company
     */
    public int getTenure(){
        return tenure;
    }
    /**
     * Returns employee's current salary
     * @return double employee's salary
     */
    public double getSalary(){
        return salary;
    }
    /**
     * Implementation of compare method used in linked list class
     * @param Object to be compared with others with regard to last and then first name in lexigraphical order
     * @return int positive if object o is lexigraphically greater, negative if less, and 0 if names are identical
     */
    public int compareTo(Object o){
        Employee e=(Employee)o;
        if(lastName.compareTo(e.getLastName())==0)
            return firstName.compareTo(e.getFirstName());
        else
            return lastName.compareTo(e.getLastName());
    }
    /**
     * Displays first and last names in format
     */
    public void displayInfo(PrintWriter pw){
        System.out.printf("%9s%11s%7c%5c%7d%8.2f\n",lastName,firstName,gender,rate,tenure,salary);
        pw.printf("%9s%11s%7c%5c%7d%8.2f\n",lastName,firstName,gender,rate,tenure,salary);
    }
    /**
     * Displays all info in format
     */
        public void displayName(PrintWriter pw){
        System.out.printf("%9s%11s\n",lastName,firstName);
        pw.printf("%9s%11s\n",lastName,firstName);
    }
}