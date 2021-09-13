package com.company;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class App extends JFrame {
    private JButton loginButton;
    private JPanel panel1;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton customersButton;
    private JTable tTable;
    private JButton employeesButton;
    private JButton medicinesButton;
    private JButton ordersButton;
    private JButton prescriptionsButton;
    private JButton addButton;
    private JButton editButton;
    private JButton removeButton;
    private JTextField cSurname;
    private JTextField cName;
    private JTextField cFathername;
    private JTextField cBirthday;
    private JTextField cStreet;
    private JTextField cBuilding;
    private JTextField cApartments;
    private JTextField cPhonenumber;
    private JButton cbackButton;
    private JButton csaveButton;
    private JTextField cCity;
    private JTextField eSurname;
    private JTextField eName;
    private JTextField eFathername;
    private JTextField ePosition;
    private JTextField eBirthday;
    private JTextField ePhonenumber;
    private JTextField eSalary;
    private JButton ebackButton;
    private JButton esaveButton;
    private JButton mbackButton;
    private JButton msaveButton;
    private JCheckBox mPrescriptionIsNeeded;
    private JTextField mTitle;
    private JTextField mSize;
    private JTextField mMeasure;
    private JTextField mPurchasePrice;
    private JTextField mSellingPrice;
    private JButton obackButton;
    private JButton osaveButton;
    private JTextField oMedicineIDs;
    private JTextField oEmployeeID;
    private JTextField oCustomerID;
    private JTextField oOrderDate;
    private JTextField pMedicineIDs;
    private JTextField pCustomerID;
    private JTextField pPrescriptionDate;
    private JButton pbackButton;
    private JButton psaveButton;


    Connection con;
    PreparedStatement pst;
    String customerID = "1";
    String employeeID = "1";
    String medicineID = "1";
    String orderID = "1";
    String prescriptionID = "1";
    CardLayout cl = (CardLayout) panel1.getLayout();


    private void connectDB() throws SQLException {

        String url = "jdbc:mysql://localhost:3306/harniuk";
        String username = "root";
        String password = "111111";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void viewCustomers() {
        try {
            pst = con.prepareStatement("select * from customers");
            ResultSet rs = pst.executeQuery();
            tTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void viewEmployees() {
        try {
            pst = con.prepareStatement("select * from employees");
            ResultSet rs = pst.executeQuery();
            tTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void viewMedicines() {
        try {
            pst = con.prepareStatement("select * from medicines");
            ResultSet rs = pst.executeQuery();
            tTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void viewOrders() {
        try {
            pst = con.prepareStatement("select * from orders");
            ResultSet rs = pst.executeQuery();
            tTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void viewPrescriptions() {
        try {
            pst = con.prepareStatement("select * from prescriptions");
            ResultSet rs = pst.executeQuery();
            tTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void addCustomer() {
        String surname, name, fathername, birthday, street, building, apartments, city, phonenumber;
        surname = cSurname.getText();
        name = cName.getText();
        fathername = cFathername.getText();
        birthday = cBirthday.getText();
        street = cStreet.getText();
        building = cBuilding.getText();
        apartments = cApartments.getText();
        city = cCity.getText();
        phonenumber = cPhonenumber.getText();

        try {
            pst = con.prepareStatement("insert into customers(csurname,cname,cfathername,cbirtday,cstreet,cbuilding,cappartments,ccity,cphonenumber)values(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, surname);
            pst.setString(2, name);
            pst.setString(3, fathername);
            pst.setString(4, birthday);
            pst.setString(5, street);
            pst.setString(6, building);
            pst.setString(7, apartments);
            pst.setString(8, city);
            pst.setString(9, phonenumber);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Customers are updated!");
            cSurname.setText("");
            cName.setText("");
            cFathername.setText("");
            cBirthday.setText("");
            cStreet.setText("");
            cBuilding.setText("");
            cApartments.setText("");
            cCity.setText("");
            cPhonenumber.setText("");
        } catch (SQLException e1) {

            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error! You entered incorrect value(s). Please, check and try again");
        }

    }

    private void addEmployee() {
        String surname, name, fathername, position, birthday, phonenumber, salary;
        surname = eSurname.getText();
        name = eName.getText();
        fathername = eFathername.getText();
        position = ePosition.getText();
        birthday = eBirthday.getText();
        phonenumber = ePhonenumber.getText();
        salary = eSalary.getText();

        try {
            pst = con.prepareStatement("insert into employees(esurname,ename,efathername,eposition,ebirtday,ephonenumber,esalary)values(?,?,?,?,?,?,?)");
            pst.setString(1, surname);
            pst.setString(2, name);
            pst.setString(3, fathername);
            pst.setString(4, position);
            pst.setString(5, birthday);
            pst.setString(6, phonenumber);
            pst.setString(7, salary);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Employees are updated!");
            cSurname.setText("");
            cName.setText("");
            cFathername.setText("");
            cBirthday.setText("");
            cStreet.setText("");
            cBuilding.setText("");
            cApartments.setText("");
            cCity.setText("");
            cPhonenumber.setText("");
        } catch (SQLException e1) {

            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error! You entered incorrect value(s). Please, check and try again");
        }

    }

    private void addMedicine() {
        String title, size, measure, purchasePrice, sellingPrice, prescriptionIsNeeded = "0";
        title = mTitle.getText();
        size = mSize.getText();
        measure = mMeasure.getText();
        purchasePrice = mPurchasePrice.getText();
        sellingPrice = mSellingPrice.getText();
        boolean prescription = mPrescriptionIsNeeded.isSelected();
        if (prescription){
            prescriptionIsNeeded = "1";
        } else {
            prescriptionIsNeeded = "0";
        }

        try {
            pst = con.prepareStatement("insert into medicines(mtitle,msize,mmeasure,mpurchasePrice,msellingPrice,mprescriptionIsNeeded)values(?,?,?,?,?,?)");
            pst.setString(1, title);
            pst.setString(2, size);
            pst.setString(3, measure);
            pst.setString(4, purchasePrice);
            pst.setString(5, sellingPrice);
            pst.setString(6, prescriptionIsNeeded);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Medicines are updated!");
            mTitle.setText("");
            mSize.setText("");
            mMeasure.setText("");
            mPurchasePrice.setText("");
            mSellingPrice.setText("");
            mPrescriptionIsNeeded.setText("");
        } catch (SQLException e1) {

            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error! You entered incorrect value(s). Please, check and try again");
        }

    }

    private void addOrder() {
        String medicineIDs, eID, cID, oDate;
        medicineIDs = oMedicineIDs.getText();
        eID = oEmployeeID.getText();
        cID = oCustomerID.getText();
        oDate = oOrderDate.getText();

        try {
            pst = con.prepareStatement("insert into orders(omedicineIDs,employeeID,customerID,orderDate)values(?,?,?,?)");
            pst.setString(1, medicineIDs);
            pst.setString(2, eID);
            pst.setString(3, cID);
            pst.setString(4, oDate);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Orders are updated!");
            oMedicineIDs.setText("");
            oEmployeeID.setText("");
            oCustomerID.setText("");
            oOrderDate.setText("");
        } catch (SQLException e1) {

            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error! You entered incorrect value(s). Please, check and try again");
        }

    }

    private void addPrescription() {
        String medicineIDs, cID, pDate;
        medicineIDs = pMedicineIDs.getText();
        cID = pCustomerID.getText();
        pDate = pPrescriptionDate.getText();

        try {
            pst = con.prepareStatement("insert into prescriptions(pmedicineIDs,customerID,prescriptionDate)values(?,?,?)");
            pst.setString(1, medicineIDs);
            pst.setString(2, cID);
            pst.setString(3, pDate);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Prescriptions are updated!");
            pMedicineIDs.setText("");
            pCustomerID.setText("");
            pPrescriptionDate.setText("");

        } catch (SQLException e1) {

            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error! You entered incorrect value(s). Please, check and try again");

        }

    }

    private void searchCustomer() {
        try {
            pst = con.prepareStatement("select csurname,cname,cfathername,cbirtday,cstreet,cbuilding,cappartments,ccity,cphonenumber from customers where customerID = ?");
            pst.setString(1, customerID);
            ResultSet rs = pst.executeQuery();

            if(rs.next())
            {
                String surname = rs.getString(1);
                String name = rs.getString(2);
                String fathername = rs.getString(3);
                String birttday = rs.getString(4);
                String street = rs.getString(5);
                String building = rs.getString(6);
                String apartments = rs.getString(7);
                String city = rs.getString(8);
                String phonenumber = rs.getString(9);

                cSurname.setText(surname);
                cName.setText(name);
                cFathername.setText(fathername);
                cBirthday.setText(birttday);
                cStreet.setText(street);
                cBuilding.setText(building);
                cApartments.setText(apartments);
                cCity.setText(city);
                cPhonenumber.setText(phonenumber);
                cl.show(panel1, "CustomersCard");

            }
            else
            {
                JOptionPane.showMessageDialog(null,"Invalid Customer ID");

            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    private void searchEmployee() {
        try {
            pst = con.prepareStatement("select esurname,ename,efathername,eposition,ebirtday,ephonenumber,esalary from employees where employeeID = ?");
            pst.setString(1, employeeID);
            ResultSet rs = pst.executeQuery();

            if(rs.next())
            {
                String surname = rs.getString(1);
                String name = rs.getString(2);
                String fathername = rs.getString(3);
                String position = rs.getString(4);
                String birthday = rs.getString(5);
                String phonenumber = rs.getString(6);
                String salary = rs.getString(7);

                eSurname.setText(surname);
                eName.setText(name);
                eFathername.setText(fathername);
                ePosition.setText(position);
                eBirthday.setText(birthday);
                ePhonenumber.setText(phonenumber);
                eSalary.setText(salary);
                cl.show(panel1, "EmployeesCard");

            }
            else
            {
                JOptionPane.showMessageDialog(null,"Invalid Employee ID");

            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    private void searchMedicine() {
        try {
            pst = con.prepareStatement("select mtitle,msize,mmeasure,mpurchasePrice,msellingPrice,mprescriptionIsNeeded from medicines where medicineID = ?");
            pst.setString(1, medicineID);
            ResultSet rs = pst.executeQuery();

            if(rs.next())
            {
                String title = rs.getString(1);
                String size = rs.getString(2);
                String measure = rs.getString(3);
                String purchasePrice = rs.getString(4);
                String sellingPrice = rs.getString(5);
                String prescriptionIsNeeded = rs.getString(6);
                boolean prescription;
                prescription = !prescriptionIsNeeded.equals("0");

                mTitle.setText(title);
                mSize.setText(size);
                mMeasure.setText(measure);
                mPurchasePrice.setText(purchasePrice);
                mSellingPrice.setText(sellingPrice);
                mPrescriptionIsNeeded.setSelected(prescription);
                cl.show(panel1, "MedicinesCard");

            }
            else
            {
                    JOptionPane.showMessageDialog(null,"Invalid Medicine ID");

            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    private void searchOrder() {
        try {
            pst = con.prepareStatement("select omedicineIDs,employeeID,customerID,orderDate from orders where orderID = ?");
            pst.setString(1, orderID);
            ResultSet rs = pst.executeQuery();

            if(rs.next())
            {
                String medicineIDs = rs.getString(1);
                String employeeID = rs.getString(2);
                String customerID = rs.getString(3);
                String orderDate = rs.getString(4);

                oMedicineIDs.setText(medicineIDs);
                oEmployeeID.setText(employeeID);
                oCustomerID.setText(customerID);
                oOrderDate.setText(orderDate);
                cl.show(panel1, "OrdersCard");

            }
            else
            {
                JOptionPane.showMessageDialog(null,"Invalid Order ID");

            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    private void searchPrescription() {
        try {
            pst = con.prepareStatement("select pmedicineIDs,customerID,prescriptionDate from prescriptions where prescriptionID = ?");
            pst.setString(1, prescriptionID);
            ResultSet rs = pst.executeQuery();

            if(rs.next()==true)
            {
                String medicineIDs = rs.getString(1);
                String customerID = rs.getString(2);
                String prescriptionDate = rs.getString(3);

                pMedicineIDs.setText(medicineIDs);
                pCustomerID.setText(customerID);
                pPrescriptionDate.setText(prescriptionDate);
                cl.show(panel1, "PrescriptionsCard");

            }
            else
            {
                JOptionPane.showMessageDialog(null,"Invalid Prescription ID");

            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }



    private void editCustomer() {
        String surname, name, fathername, birthday, street, building, apartments, city, phonenumber;
        surname = cSurname.getText();
        name = cName.getText();
        fathername = cFathername.getText();
        birthday = cBirthday.getText();
        street = cStreet.getText();
        building = cBuilding.getText();
        apartments = cApartments.getText();
        city = cCity.getText();
        phonenumber = cPhonenumber.getText();

        try {
            pst = con.prepareStatement("update customers set csurname = ?,cname = ?,cfathername = ?, cbirtday = ?, cstreet = ?, cbuilding = ?, cappartments = ?, ccity = ?, cphonenumber = ? where customerID = ?");
            pst.setString(1, surname);
            pst.setString(2, name);
            pst.setString(3, fathername);
            pst.setString(4, birthday);
            pst.setString(5, street);
            pst.setString(6, building);
            pst.setString(7, apartments);
            pst.setString(8, city);
            pst.setString(9, phonenumber);
            pst.setString(10, customerID);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Customer is updated!");
            cSurname.setText("");
            cName.setText("");
            cFathername.setText("");
            cBirthday.setText("");
            cStreet.setText("");
            cBuilding.setText("");
            cApartments.setText("");
            cCity.setText("");
            cPhonenumber.setText("");
        }

        catch (SQLException e1)
        {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error! You entered incorrect value(s). Please, check and try again");
        }
    }

    private void editEmployee() {
        String surname, name, fathername, position, birthday, phonenumber, salary;
        surname = eSurname.getText();
        name = eName.getText();
        fathername = eFathername.getText();
        position = ePosition.getText();
        birthday = eBirthday.getText();
        phonenumber = ePhonenumber.getText();
        salary = eSalary.getText();

        try {
            pst = con.prepareStatement("update employees set esurname = ?,ename = ?,efathername = ?,eposition = ?,ebirtday = ?,ephonenumber = ?,esalary = ? where employeeID = ?");
            pst.setString(1, surname);
            pst.setString(2, name);
            pst.setString(3, fathername);
            pst.setString(4, position);
            pst.setString(5, birthday);
            pst.setString(6, phonenumber);
            pst.setString(7, salary);
            pst.setString(8, employeeID);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Employee is updated!");
            eSurname.setText("");
            eName.setText("");
            eFathername.setText("");
            ePosition.setText("");
            eBirthday.setText("");
            ePhonenumber.setText("");
            eSalary.setText("");
        }

        catch (SQLException e1)
        {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error! You entered incorrect value(s). Please, check and try again");
        }
    }

    private void editMedicine() {
        String title, size, measure, purchasePrice, sellingPrice, prescriptionIsNeeded = "0";
        title = mTitle.getText();
        size = mSize.getText();
        measure = mMeasure.getText();
        purchasePrice = mPurchasePrice.getText();
        sellingPrice = mSellingPrice.getText();
        boolean prescription = mPrescriptionIsNeeded.isSelected();

        if (prescription){
            prescriptionIsNeeded = "1";
        } else {
            prescriptionIsNeeded = "0";
        }

        try {
            pst = con.prepareStatement("update medicines set mtitle = ?,msize = ?,mmeasure = ?,mpurchasePrice = ?,msellingPrice = ?,mprescriptionIsNeeded = ? where medicineID = ?");
            pst.setString(1, title);
            pst.setString(2, size);
            pst.setString(3, measure);
            pst.setString(4, purchasePrice);
            pst.setString(5, sellingPrice);
            pst.setString(6, prescriptionIsNeeded);
            pst.setString(7, medicineID);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Medicine is updated!");
            mTitle.setText("");
            mSize.setText("");
            mMeasure.setText("");
            mPurchasePrice.setText("");
            mSellingPrice.setText("");
            mPrescriptionIsNeeded.setText("");
        }

        catch (SQLException e1)
        {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error! You entered incorrect value(s). Please, check and try again");
        }
    }

    private void editOrder() {
        String medicineIDs, eID, cID, oDate;
        medicineIDs = oMedicineIDs.getText();
        eID = oEmployeeID.getText();
        cID = oCustomerID.getText();
        oDate = oOrderDate.getText();

        try {
            pst = con.prepareStatement("update orders set omedicineIDs = ?,employeeID = ?,customerID = ?,orderDate = ? where orderID = ?");
            pst.setString(1, medicineIDs);
            pst.setString(2, eID);
            pst.setString(3, cID);
            pst.setString(4, oDate);
            pst.setString(5, orderID);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Order is updated!");

            oMedicineIDs.setText("");
            oEmployeeID.setText("");
            oCustomerID.setText("");
            oOrderDate.setText("");
        }

        catch (SQLException e1)
        {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error! You entered incorrect value(s). Please, check and try again");
        }
    }

    private void editPrescription() {
        String medicineIDs, cID, pDate;
        medicineIDs = pMedicineIDs.getText();
        cID = pCustomerID.getText();
        pDate = pPrescriptionDate.getText();

        try {
            pst = con.prepareStatement("update prescriptions set pmedicineIDs = ?,customerID = ?,prescriptionDate = ? where prescriptionID = ?");
            pst.setString(1, medicineIDs);
            pst.setString(2, cID);
            pst.setString(3, pDate);
            pst.setString(4, prescriptionID);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Prescription is updated!");

            pMedicineIDs.setText("");
            pCustomerID.setText("");
            pPrescriptionDate.setText("");
        }

        catch (SQLException e1)
        {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error! You entered incorrect value(s). Please, check and try again");
        }
    }
    private void removeCustomer() {
        try {
            pst = con.prepareStatement("delete from customers  where customerID = ?");

            pst.setString(1, customerID);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Customer is removed!");
            cSurname.setText("");
            cName.setText("");
            cFathername.setText("");
            cBirthday.setText("");
            cStreet.setText("");
            cBuilding.setText("");
            cApartments.setText("");
            cCity.setText("");
            cPhonenumber.setText("");
        }

        catch (SQLException e1)
        {

            e1.printStackTrace();
        }
    }

    private void removeEmployee() {
        try {
            pst = con.prepareStatement("delete from employees  where employeeID = ?");

            pst.setString(1, employeeID);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Employee is removed!");

            eSurname.setText("");
            eName.setText("");
            eFathername.setText("");
            ePosition.setText("");
            eBirthday.setText("");
            ePhonenumber.setText("");
            eSalary.setText("");
        }

        catch (SQLException e1)
        {

            e1.printStackTrace();
        }
    }

    private void removeMedicine() {
        try {
            pst = con.prepareStatement("delete from medicines  where medicineID = ?");

            pst.setString(1, medicineID);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Medicine is removed!");

            mTitle.setText("");
            mSize.setText("");
            mMeasure.setText("");
            mPurchasePrice.setText("");
            mSellingPrice.setText("");
            mPrescriptionIsNeeded.setText("");
        }

        catch (SQLException e1)
        {

            e1.printStackTrace();
        }
    }

    private void removeOrder() {
        try {
            pst = con.prepareStatement("delete from orders  where orderID = ?");

            pst.setString(1, orderID);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Order is removed!");

            oMedicineIDs.setText("");
            oEmployeeID.setText("");
            oCustomerID.setText("");
            oOrderDate.setText("");
        }

        catch (SQLException e1)
        {

            e1.printStackTrace();
        }
    }

    private void removePrescription() {
        try {
            pst = con.prepareStatement("delete from prescriptions  where prescriptionID = ?");

            pst.setString(1, prescriptionID);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Prescription is removed!");

            pMedicineIDs.setText("");
            pCustomerID.setText("");
            pPrescriptionDate.setText("");
        }

        catch (SQLException e1)
        {

            e1.printStackTrace();
        }
    }


    public App() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = passwordField.getText();
                loginButton.setFocusPainted(false);
                if (username.equals("admin") && password.equals("111111")) {
                    cl.show(panel1, "TableCard");
                    customersButton.setBackground(new Color(103, 34, 97));
                    try {
                        connectDB();
                        viewCustomers();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Login is unsuccessful. Access denied.");
                }
            }
        });

        customersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customersButton.setFocusPainted(false);
                employeesButton.setBackground(new Color(156, 78, 151));
                medicinesButton.setBackground(new Color(156, 78, 151));
                ordersButton.setBackground(new Color(156, 78, 151));
                prescriptionsButton.setBackground(new Color(156, 78, 151));
                customersButton.setBackground(new Color(103, 34, 97));
                try {
                    connectDB();
                    viewCustomers();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });

        employeesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                employeesButton.setFocusPainted(false);
                customersButton.setBackground(new Color(156, 78, 151));
                medicinesButton.setBackground(new Color(156, 78, 151));
                ordersButton.setBackground(new Color(156, 78, 151));
                prescriptionsButton.setBackground(new Color(156, 78, 151));
                employeesButton.setBackground(new Color(103, 34, 97));
                try {
                    connectDB();
                    viewEmployees();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });

        medicinesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                medicinesButton.setFocusPainted(false);
                customersButton.setBackground(new Color(156, 78, 151));
                employeesButton.setBackground(new Color(156, 78, 151));
                ordersButton.setBackground(new Color(156, 78, 151));
                prescriptionsButton.setBackground(new Color(156, 78, 151));
                medicinesButton.setBackground(new Color(103, 34, 97));
                try {
                    connectDB();
                    viewMedicines();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });

        ordersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ordersButton.setFocusPainted(false);
                customersButton.setBackground(new Color(156, 78, 151));
                medicinesButton.setBackground(new Color(156, 78, 151));
                employeesButton.setBackground(new Color(156, 78, 151));
                prescriptionsButton.setBackground(new Color(156, 78, 151));
                ordersButton.setBackground(new Color(103, 34, 97));
                try {
                    connectDB();
                    viewOrders();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });

        prescriptionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prescriptionsButton.setFocusPainted(false);
                customersButton.setBackground(new Color(156, 78, 151));
                medicinesButton.setBackground(new Color(156, 78, 151));
                ordersButton.setBackground(new Color(156, 78, 151));
                employeesButton.setBackground(new Color(156, 78, 151));
                prescriptionsButton.setBackground(new Color(103, 34, 97));
                try {
                    connectDB();
                    viewPrescriptions();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addButton.setFocusPainted(false);
                if (customersButton.getBackground().equals(new Color(103, 34, 97))) {
                    csaveButton.setText("Add");
                    cl.show(panel1, "CustomersCard");
                } else if (employeesButton.getBackground().equals(new Color(103, 34, 97))) {
                    esaveButton.setText("Add");
                    cl.show(panel1, "EmployeesCard");
                } else if (medicinesButton.getBackground().equals(new Color(103, 34, 97))) {
                    msaveButton.setText("Add");
                    cl.show(panel1, "MedicinesCard");
                } else if (ordersButton.getBackground().equals(new Color(103, 34, 97))) {
                    osaveButton.setText("Add");
                    cl.show(panel1, "OrdersCard");
                } else {
                    psaveButton.setText("Add");
                    cl.show(panel1, "PrescriptionsCard");
                }
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editButton.setFocusPainted(false);
                if (customersButton.getBackground().equals(new Color(103, 34, 97))) {
                    customerID = JOptionPane.showInputDialog(
                            "Enter ID of the customer you want to edit:",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    searchCustomer();
                    csaveButton.setText("Save");
                } else if (employeesButton.getBackground().equals(new Color(103, 34, 97))) {
                    employeeID = JOptionPane.showInputDialog(
                            "Enter ID of the customer you want to edit:",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    searchEmployee();
                    esaveButton.setText("Save");
                } else if (medicinesButton.getBackground().equals(new Color(103, 34, 97))) {
                    medicineID = JOptionPane.showInputDialog(
                            "Enter ID of the customer you want to edit:",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    searchMedicine();
                    msaveButton.setText("Save");
                } else if (ordersButton.getBackground().equals(new Color(103, 34, 97))) {
                    orderID = JOptionPane.showInputDialog(
                            "Enter ID of the customer you want to edit:",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    searchOrder();
                    osaveButton.setText("Save");
                } else {
                    prescriptionID = JOptionPane.showInputDialog(
                            "Enter ID of the customer you want to edit:",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    searchPrescription();
                    psaveButton.setText("Save");
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeButton.setFocusPainted(false);
                if (customersButton.getBackground().equals(new Color(103, 34, 97))) {
                    customerID = JOptionPane.showInputDialog(
                            "Enter ID of the customer you want to remove:",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    searchCustomer();
                    csaveButton.setText("Remove");
                } else if (employeesButton.getBackground().equals(new Color(103, 34, 97))) {
                    employeeID = JOptionPane.showInputDialog(
                            "Enter ID of the employee you want to remove:",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    searchEmployee();
                    esaveButton.setText("Remove");
                } else if (medicinesButton.getBackground().equals(new Color(103, 34, 97))) {
                    medicineID = JOptionPane.showInputDialog(
                            "Enter ID of the medicine you want to remove:",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    searchMedicine();
                    msaveButton.setText("Remove");
                } else if (ordersButton.getBackground().equals(new Color(103, 34, 97))) {
                    orderID = JOptionPane.showInputDialog(
                            "Enter ID of the order you want to remove:",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    searchOrder();
                    osaveButton.setText("Remove");
                } else {
                    prescriptionID = JOptionPane.showInputDialog(
                            "Enter ID of the prescription you want to remove:",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    searchPrescription();
                    psaveButton.setText("Remove");
                }
                esaveButton.setText("Remove");
                msaveButton.setText("Remove");
                osaveButton.setText("Remove");
                psaveButton.setText("Remove");

            }
        });

        cbackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cbackButton.setFocusPainted(false);
                int result = JOptionPane.showConfirmDialog(null,
                        "If you quit now, your changes won't be saved. Do you want to quit?",
                        "Unsaved Changes",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    cl.show(panel1, "TableCard");
                    cSurname.setText("");
                    cName.setText("");
                    cFathername.setText("");
                    cBirthday.setText("");
                    cStreet.setText("");
                    cBuilding.setText("");
                    cApartments.setText("");
                    cCity.setText("");
                    cPhonenumber.setText("");
                }
            }
        });

        csaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                csaveButton.setFocusPainted(false);
                if (csaveButton.getText().equals("Add")) {
                    addCustomer();
                } else if (csaveButton.getText().equals("Save")) {
                        editCustomer();
                } else {
                    removeCustomer();
                }
                cl.show(panel1, "TableCard");
                try {
                    connectDB();
                    viewCustomers();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        ebackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ebackButton.setFocusPainted(false);
                int result = JOptionPane.showConfirmDialog(null,
                        "If you quit now, your changes won't be saved. Do you want to quit?",
                        "Unsaved Changes",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    cl.show(panel1, "TableCard");
                    eSurname.setText("");
                    eName.setText("");
                    eFathername.setText("");
                    ePosition.setText("");
                    eBirthday.setText("");
                    ePhonenumber.setText("");
                    eSalary.setText("");

                }
            }
        });

        esaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                esaveButton.setFocusPainted(false);
                if (esaveButton.getText().equals("Add")) {
                    addEmployee();
                } else if (esaveButton.getText().equals("Save")) {
                    editEmployee();
                } else {
                    removeEmployee();
                }
                cl.show(panel1, "TableCard");
                try {
                    connectDB();
                    viewEmployees();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        mbackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mbackButton.setFocusPainted(false);
                int result = JOptionPane.showConfirmDialog(null,
                        "If you quit now, your changes won't be saved. Do you want to quit?",
                        "Unsaved Changes",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    cl.show(panel1, "TableCard");
                    mTitle.setText("");
                    mSize.setText("");
                    mMeasure.setText("");
                    mPurchasePrice.setText("");
                    mSellingPrice.setText("");
                    mPrescriptionIsNeeded.setText("");

                }
            }
        });

        msaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                msaveButton.setFocusPainted(false);
                if (msaveButton.getText().equals("Add")) {
                    addMedicine();
                } else if (msaveButton.getText().equals("Save")) {
                    editMedicine();
                } else {
                    removeMedicine();
                }
                cl.show(panel1, "TableCard");
                try {
                    connectDB();
                    viewMedicines();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        obackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obackButton.setFocusPainted(false);
                int result = JOptionPane.showConfirmDialog(null,
                        "If you quit now, your changes won't be saved. Do you want to quit?",
                        "Unsaved Changes",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    cl.show(panel1, "TableCard");
                    oMedicineIDs.setText("");
                    oEmployeeID.setText("");
                    oCustomerID.setText("");
                    oOrderDate.setText("");

                }
            }
        });

        osaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                osaveButton.setFocusPainted(false);
                if (osaveButton.getText().equals("Add")) {
                    addOrder();
                } else if (osaveButton.getText().equals("Save")) {
                    editOrder();
                } else {
                    removeOrder();
                }
                cl.show(panel1, "TableCard");
                try {
                    connectDB();
                    viewOrders();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        pbackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pbackButton.setFocusPainted(false);
                int result = JOptionPane.showConfirmDialog(null,
                        "If you quit now, your changes won't be saved. Do you want to quit?",
                        "Unsaved Changes",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    cl.show(panel1, "TableCard");
                    pMedicineIDs.setText("");
                    pCustomerID.setText("");
                    pPrescriptionDate.setText("");

                }
            }
        });

        psaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                psaveButton.setFocusPainted(false);
                if (psaveButton.getText().equals("Add")) {
                    addPrescription();
                } else if (psaveButton.getText().equals("Save")) {
                    editPrescription();
                } else {
                    removePrescription();
                }
                cl.show(panel1, "TableCard");
                try {
                    connectDB();
                    viewPrescriptions();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JFrame frame = new JFrame("DrugstoreDB");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cl.show(panel1, "LoginCard");
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }

        frame.pack();
        frame.setVisible(true);
    }
}
