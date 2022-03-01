package fr.jaroddeveloppement.mareu.model;

public class Users {


   private String name;
   private String firstname;
   private String department;
   private String mail;

    /**
     * Constructor
     * @param name
     * @param firstname
     * @param department
     * @param mail
     */
    public Users(String name, String firstname, String department, String mail) {
        this.name = name;
        this.firstname = firstname;
        this.department = department;
        this.mail = mail;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
