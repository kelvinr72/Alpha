/*

Author: Kelvin David Rodriguez

Date: 3/7/2021

------------------------------------------------------------------------------
Summary
------------------------------------------------------------------------------
This program will ask the user to select a method in which they will display
or edit employee data that is stored in a database
*/

import java.util.*;

public class javaproject {

    // load* methods are for initial addition to the database. add* methods do the
    // samething as load* methods but can only perform one entry at a time while
    // load* methods have the option to do multiple at a time
    public static ArrayList<String> loadNames(ArrayList<String> names, String employeeName) {

        names.add(employeeName);
        return names;

    }

    public static ArrayList<String> loadID(ArrayList<String> id, String employeeID) {

        id.add(employeeID);
        return id;

    }

    public static ArrayList<String> loadSalary(ArrayList<String> salary, String employeeSalary) {

        salary.add(employeeSalary);
        return salary;

    }

    public static ArrayList<String> addNameData(ArrayList<String> names, String addEmployeeName) {

        names.add(addEmployeeName);
        return names;

    }

    public static ArrayList<String> addIDData(ArrayList<String> id, String addEmployeeID) {

        id.add(addEmployeeID);
        return id;

    }

    public static ArrayList<String> addSalaryData(ArrayList<String> salary, String addEmployeeSalary) {

        salary.add(addEmployeeSalary);
        return salary;
    }

    // will display all of the information in the database
    public static void displayData(ArrayList<String> names, ArrayList<String> id, ArrayList<String> salary) {

        System.out.println("Here is the current database");
        System.out.println("--------------------------------------------------------------");
        System.out.println("Names:          " + names);
        System.out.println("ID Numbers:     " + id);
        System.out.println("Employee Salary:" + salary + "\n");

    }

    // will get data(name, id, salary) based on an employee salary
    public static void getSpecificData(String retrieveInput, ArrayList<String> names, ArrayList<String> id,
            ArrayList<String> salary) {

        if (!id.contains(retrieveInput)) {

            System.out.println("\n*****ID not present in current database please go back and try again*****\n");
            return;

        }

        System.out.println("\n------------------------------");
        System.out.println("Employee ID: " + retrieveInput);
        System.out.println("Employee Name: " + names.get(id.indexOf(retrieveInput)));
        System.out.println("Employee Salary: " + salary.get(id.indexOf(retrieveInput)));
        System.out.println("------------------------------\n");

    }

    // will get data based on a range of salaries
    public static void getDataFromRange(Integer retrieveInput2, Integer retrieveInput3, ArrayList<String> names,
            ArrayList<String> id, ArrayList<String> salary) {

        int firstVal = Integer.parseInt(salary.get(0));
        int lastVal = Integer.parseInt(salary.get(salary.size() - 1));

        System.out.println("Here are the employees with a salary between " + retrieveInput2 + " - " + retrieveInput3);
        System.out.println("-------------------------------------------------------");

        for (int i = 0; i < salary.size(); i++) {

            int conSalaryVariable = Integer.parseInt(salary.get(i));

            if (conSalaryVariable >= retrieveInput2 && conSalaryVariable <= retrieveInput3) {

                String stSalaryVariable = String.valueOf(conSalaryVariable);

                System.out.println(names.get(salary.indexOf(stSalaryVariable)) + "\n");

            }

        }

    }

    public static void main(String[] args) {

        // the main data structure for this program are ArrayList. Three ArrayList are
        // made to contain each category of data
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> id = new ArrayList<String>();
        ArrayList<String> salary = new ArrayList<String>();

        Scanner input = new Scanner(System.in);

        final String MENUCHOICES = "Menu Choices\n-------------------------------------------------------------------\n1) Load employees' data\n2) Add new employee\n3) Display all employees\n4) Retrieve specific employee's data\n5) Retrieve employees with salaries based on range\n6) Exit Program\n";

        System.out.println();
        System.out.println(
                "Welcome to the database for all employee data for Company X.\nHere you can display and edit employee data that is stored here.\nPlease select from the menu choices below to get started\n");

        boolean willContinue = true;

        // Inital prompt which will ask the user for an choice to make
        while (willContinue == true) {

            System.out.println(MENUCHOICES);

            System.out.print("Enter a choice\n>>> ");

            String inputVariable1 = input.next();

            while (!inputVariable1.matches("[1-6]")) {
                System.out
                        .print("Invalid input please try again, only pick a number from the menu choices above\n>>> ");
                inputVariable1 = input.next();
            }

            int conInputVariable1 = Integer.parseInt(inputVariable1);

            System.out.println();

            // Everything below will be the choices themselves. They include some dialouge
            // and a prompt for the users choices. There is also input validation with regex
            // and ranges in while loops.
            if (conInputVariable1 == 1) {

                System.out.print(
                        "Data Entry Mode\n---------------------------------------------------------------------------------\nPlease enter how many employees you are going to be entering into the database\n>>> ");
                String inputVariable2 = input.next();

                while (!inputVariable2.matches("^[1-9][0-9]?$|^100$")) {
                    System.out.print("Invalid input please try again, enter only numbers between 1-100\n>>> ");
                    inputVariable2 = input.next();
                }

                int conInputVariable2 = Integer.parseInt(inputVariable2);
                int counter1 = 0;

                while (counter1 < conInputVariable2) {

                    System.out.print("Please enter the name of the employee\n>>> ");
                    String employeeInput = input.next();

                    while (!employeeInput.matches("[A-Za-z]+")) {
                        System.out.print(
                                "Invalid input please try again. Enter only letters for the employee name.\n>>> ");
                        employeeInput = input.next();
                    }

                    String employeeName = employeeInput;
                    loadNames(names, employeeName);

                    System.out.print("Please enter the 5 digit ID of the employee\n>>> ");
                    String employeeInput2 = input.next();

                    while (!employeeInput2.matches("(?!00000)[0-9]{5}")) {
                        System.out.print("Invalid employee ID, please only enter values from 00001-99999\n>>> ");
                        employeeInput2 = input.next();
                    }

                    String employeeID = employeeInput2;
                    loadID(id, employeeID);

                    System.out.print("Please enter the salary range of the employee\n>>> ");
                    int intEmployeeInput3 = input.nextInt();

                    while (intEmployeeInput3 < 1 || intEmployeeInput3 > 1000000) {
                        System.out.print(
                                "Invalid input, please only enter a range between 1-1000000 ***NO COMMAS OR DECIMALS\n>>> ");
                        intEmployeeInput3 = input.nextInt();
                    }

                    String employeeInput3 = String.valueOf(intEmployeeInput3);
                    String employeeSalary = employeeInput3;
                    loadSalary(salary, employeeSalary);

                    counter1++;
                }
                continue;

            } else if (conInputVariable1 == 2) {

                System.out.print(
                        "Add New Employee Mode\nPlease enter the employee data that you are going to be adding into the database\n>>> ");

                // boolean loopContinue = false;
                while (true) {

                    System.out.print("Please enter the name of the employee\n>>> ");
                    String addEmployeeInput = input.next();

                    while (!addEmployeeInput.matches("[A-Za-z]+")) {
                        System.out.print(
                                "Invalid input please try again. Enter only letters for the employee name.\n>>> ");
                        addEmployeeInput = input.next();
                    }

                    String addEmployeeName = addEmployeeInput;
                    addNameData(names, addEmployeeName);

                    System.out.print("Please enter the 5 digit ID of the employee\n>>> ");
                    String addEmployeeInput2 = input.next();

                    while (!addEmployeeInput2.matches("(?!00000)[0-9]{5}")) {
                        System.out.print("Invalid employee ID, please only enter values from 00001-99999\n>>> ");
                        addEmployeeInput2 = input.next();
                    }

                    String addEmployeeID = addEmployeeInput2;
                    addIDData(id, addEmployeeID);

                    System.out.print("Please enter the salary range of the employee\n>>> ");
                    int addIntEmployeeInput3 = input.nextInt();

                    while (addIntEmployeeInput3 < 1 || addIntEmployeeInput3 > 1000000) {
                        System.out.print(
                                "Invalid input, please only enter a number between 1-1000000 ***NO COMMAS OR DECIMALS\n>>> ");
                        addIntEmployeeInput3 = input.nextInt();
                    }

                    String addEmployeeInput3 = String.valueOf(addIntEmployeeInput3);
                    String addEmployeeSalary = addEmployeeInput3;
                    addSalaryData(salary, addEmployeeSalary);

                    break;
                }

                continue;

            } else if (conInputVariable1 == 3) {

                displayData(names, id, salary);
                continue;

            } else if (conInputVariable1 == 4) {

                System.out.print(
                        "Data Retrieval Mode\n--------------------------------------------------------------------------\nPlease enter the ID of the employee you are trying to see\n>>> ");
                String retrieveInput = input.next();

                while (!retrieveInput.matches("(?!00000)[0-9]{5}")) {
                    System.out.print("Invalid employee ID, please only enter values from 00001-99999\n>>> ");
                    retrieveInput = input.next();

                }

                getSpecificData(retrieveInput, names, id, salary);

                continue;

            } else if (conInputVariable1 == 5) {

                System.out.println(
                        "Data Retrieval Mode\n--------------------------------------------------------------------------\nPlease enter a minimun and maximum to create a range of salaries and see which employees fall under those salaries\n");
                System.out.print("Enter the minimum\n>>> ");
                int retrieveInput2 = input.nextInt();

                while (retrieveInput2 < 1 || retrieveInput2 > 1000000) {
                    System.out.print(
                            "Invalid input, please only enter a number between 1-1000000 ***NO COMMAS OR DECIMALS\n>>> ");
                    retrieveInput2 = input.nextInt();
                }

                System.out.print("Enter the maximum\n>>> ");
                int retrieveInput3 = input.nextInt();

                while (retrieveInput3 < 1 || retrieveInput3 > 1000000) {
                    System.out.print(
                            "Invalid input, please only enter a number between 1-1000000 ***NO COMMAS OR DECIMALS\n>>> ");
                    retrieveInput3 = input.nextInt();
                }

                getDataFromRange(retrieveInput2, retrieveInput3, names, id, salary);

                continue;

            } else if (conInputVariable1 == 6) {

                break;

            }

        }

    }

}