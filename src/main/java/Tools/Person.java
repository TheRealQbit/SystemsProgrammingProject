package Tools;

import java.io.*;
import java.util.Scanner;

public class Person {
    String fitstName, lastName,email;
    int id;
    Person(){}
    Person(String FIRSTNAME, String LASTNAME, String EMAIL, int ID){
        try{
            setFitstName(FIRSTNAME);
            setLastName(LASTNAME);
            setEmail(EMAIL);
            setID(ID);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
    public void setID(int id) {
        if(id < 0) throw new IllegalArgumentException("ID must be positive");
        else this.id = id;
    }
    public void setFitstName(String fitstName) {
        if(fitstName == null) throw new IllegalArgumentException("First name must be defined");
        else this.fitstName = fitstName;
    }
    public void setLastName(String lastName) {
        if(lastName == null) throw new IllegalArgumentException("Last name must be defined");
        else this.lastName = lastName;
    }
    public void setEmail(String email) {
        if(email == null || email.indexOf('@') == 0 || email.indexOf(".com") == 0) throw new IllegalArgumentException("Email must be well defined");
        else this.email = email;
    }
    public String getFitstName() {
        return fitstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public int getId() {
        return id;
    }
    public void set(String[] personData) {
        try {
            setID(Integer.parseInt(personData[0]));
            setFitstName(personData[1]);
            setLastName(personData[2]);
            setEmail(personData[3]);
        } catch (IllegalArgumentException pe) {
            pe.printStackTrace();
            System.exit(1);
        }
    }
    public String toString() {
        return id + "|" + fitstName + "|" + lastName + "|" + email + "\n";
    }

    public void print() {
        System.out.println(this);
    }
    public static Person readFromFile(String file) {
        Person result = new Person();
        BufferedReader in = null;
        String line = null;
        if (file != null) {
            try {
                in = new BufferedReader(new FileReader(file));
                if ((line = in.readLine()) != null) {
                    String[] data = line.split("\\|");
                    result.set(data);
                    in.close();
                    return result;
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
                System.exit(1);
            }
        }
        return result;
    }
    public static Person readFromStdio() {
        System.out.println("Setting new Person");
        Person result = new Person();
        try {
            Scanner userInput = new Scanner(System.in);
            System.out.print("Id:");
            result.setID(Integer.parseInt(userInput.next()));
            System.out.print("First Name:");
            result.setFitstName(userInput.next());
            System.out.print("Last Name:");
            result.setLastName(userInput.next());
            System.out.print("email:");
            result.setEmail(userInput.next());
            userInput.close();
        } catch (IllegalArgumentException pe) {
            pe.printStackTrace();
            System.exit(1);
        }
        return result;
    }
    public void writeToFile(String file) {
        BufferedWriter out = null;
        try {
            if (file != null) {
                out = new BufferedWriter(new FileWriter(file, true));
                out.write(toString());
                out.flush();
                out.close();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace(); // to debug
            System.exit(1);
        }
    }
}
