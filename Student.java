/**
 * Program for a student directory application.
 * @author DHANUSH VENKATARAMU.
 */
public class Student {
/**
 * instance variable firstName for Student class objects.
 */
    private String firstName;
/**
 * instance variable lastName for Student class objects.
 */
    private String lastName;
/**
 * instance variable andrewId for Student class objects.
 */
    private String andrewId;
/**
 * instance variable phone for Student class objects.
 */
    private String phone;
/**
 * constructor for Student Class.
 * @param  id the andrewid to be assigned.
 */
    public Student(String id) {
        checkString(id);
        andrewId = id;
    }
/**
 * Copy constructor for Student Class.
 * @param  s instance to be copied
 */
    public Student(Student s) {
        checkObject(s);
        andrewId = new String(s.andrewId);
        firstName = new String(s.firstName);
        lastName = new String(s.lastName);
        phone = new String(s.phone);
    }
/**
 * constructor for Student Class.
 * @param  id the andrewid to be assigned.
 * @param fName the firstName to be assigned.
 * @param lName the lastName to be assigned.
 * @param phoneno the phone to be assigned.
 */
    public Student(String id, String fName, String lName, String phoneno) {
        if (phoneno == null) {
            throw new IllegalArgumentException("Null string object");
        }
        checkString(id);
        andrewId = id;
        checkString(fName);
        firstName = fName;
        checkString(lName);
        lastName = lName;
        phone = phoneno;
    }
/**
 * instance method getAndrewId to fetch andrewId.
 * @return   fetched andrewId of instance.
 */
    public String getAndrewId() {
        return andrewId;
    }
/**
 * instance method getFirstName to fetch firstname.
 * @return   fetched FirstName of student of instance.
 */
    public String getFirstName() {
        return firstName;
    }
/**
 * instance method getLastName to fetch lastname.
 * @return   fetched lastname of instance.
 */
    public String getLastName() {
        return lastName;
    }
/**
 * instance method getPhoneNumber to fetch phonenumber.
 * @return   fetched lastname of instance.
 */
    public String getPhoneNumber() {
        return phone;
    }
/**
 * instance method setFirstName for class Student.
 * @param s Specifies the string firstname.
 */
    public void setFirstName(String s) {
        checkString(s);
        firstName = s;
        return;
    }
/**
 * instance method setLastName for class Student.
 * @param s Specifies the string lastname.
 */
    public void setLastName(String s) {
        checkString(s);
        lastName = s;
        return;
    }
/**
 * instance method setPhoneNumber for class Student.
 * @param s Specifies the string phonenumber.
 */
    public void setPhoneNumber(String s) {
        if (s == null) {
            throw new IllegalArgumentException("null string for phone");
        }
        phone = s;
        return;
    }
/**
 * instance method toString to print Student Details.
 * @return   String output of Student instance details.
 */
    public String toString() {
        if (this != null) {
            return new StringBuilder().append(this.firstName)
                                      .append(" ")
                                      .append(this.lastName)
                                      .append(" (Andrew ID: ")
                                      .append(this.andrewId)
                                      .append(", Phone Number: ")
                                      .append(this.phone)
                                      .append(")")
                                      .toString();
        }
        throw new IllegalArgumentException(String.valueOf(this));
    }
/**
 * static method checkString to check if string is empty.
 * @param s Specifies the string to be checked.
 */
    public static void checkString(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Null string Object");
        }
        if (s.equals("")) {
            throw new IllegalArgumentException("Empty String");
        }
        return;
    }
/**
 * static method checkObject to check if object is null.
 * @param s Specifies the object to be checked.
 */
    public static void checkObject(Student s) {
        if (s == null) {
            throw new IllegalArgumentException("Null object");
        }
        return;
    }
}
