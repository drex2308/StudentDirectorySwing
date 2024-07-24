import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
/**
 * Program for a student directory application.
 * @author DHANUSH VENKATARAMU.
 */
public class Directory {
/**
 * static variable andrewMap for Directory class.
 */
    private Map<String, Student> andrewMap;
/**
 * static variable firstNameMap for Directory class.
 */
    private Map<String, List<Student>> firstNameMap;
/**
 * static variable lastNameMap for Directory class.
 */
    private Map<String, List<Student>> lastNameMap;
/**
 * constructor for Directory Class.
 */
    public Directory() {
        andrewMap = new HashMap<String, Student>();
        firstNameMap = new HashMap<String, List<Student>>();
        lastNameMap = new HashMap<String, List<Student>>();
    }
/**
 * instance method addStudent for class Directory.
 * @param s Specifies the student to be added.
 */
    public void addStudent(final Student s) {
        Student.checkObject(s);
        if (andrewMap.containsKey(s.getAndrewId())) {
            throw new IllegalArgumentException("duplicate instance");
        }
        Student copy = new Student(s);
        andrewMap.put(copy.getAndrewId(), copy);
        Student.checkString(copy.getFirstName());
        addToList(firstNameMap, copy, copy.getFirstName());
        Student.checkString(copy.getLastName());
        addToList(lastNameMap, copy, copy.getLastName());
    }
/**
 * instance method deleteStudent for class Directory.
 * @param andrewId Specifies the andrewid of student to be deleted.
 */
    public void deleteStudent(final String andrewId) {
        Student.checkString(andrewId);
        if (!andrewMap.containsKey(andrewId)) {
            throw new IllegalArgumentException("andrewid not present");
        }
        Student s = andrewMap.remove(andrewId);
        removefromLists(s);
    }
/**
 * instance method addStudent for class Directory.
 * @param andrewId Specifies the andrewid student to be searched.
 * @return   Instance Student of andrewId or null if empty.
 */
    public Student searchByAndrewId(final String andrewId) {
        Student.checkString(andrewId);
        if (andrewMap.containsKey(andrewId)) {
            return new Student(andrewMap.get(andrewId));
        } else {
            return null;
        }
    }
/**
 * instance method searchByFirstName for class Directory.
 * @param firstName Specifies the firstname of student to be searched.
 * @return   List of Instances Student of firstName or empty list if not found.
 */
    public List<Student> searchByFirstName(final String firstName) {
        Student.checkString(firstName);
        if (firstNameMap.containsKey(firstName)) {
            return copyList(firstNameMap.get(firstName));
        } else {
            return new ArrayList<Student>();
        }
    }
/**
 * instance method searchBylastName for class Directory.
 * @param lastName Specifies the lastname of student to be searched.
 * @return   List of Instances Student of lastName or empty list if not found.
 */
    public List<Student> searchByLastName(final String lastName) {
        Student.checkString(lastName);
        if (lastNameMap.containsKey(lastName)) {
            return copyList(lastNameMap.get(lastName));
        } else {
            return new ArrayList<Student>();
        }
    }
/**
 * instance method size for class Directory.
 * @return   Number of studens in directory.
 */
    public int size() {
        return andrewMap.size();
    }
/**
 * instance method searchBylastName for class Directory.
 * @param mp Specifies the hashmap to  be used.
 * @param s Student to be added.
 * @param mapKey Key fro the mapping to be created in hashmap.
 */
    public void addToList(Map<String, List<Student>> mp, Student s, String mapKey) {
        if (mp.get(mapKey) == null) {
            List<Student> ls = new ArrayList<Student>();
            ls.add(s);
            mp.put(mapKey, ls);
            return;
        } else {
            mp.get(mapKey).add(s);
        }
    }
/**
 * instance method searchBylastName for class Directory.
 * @param s Specifies the student object to be deleted from lists in maps
 */
    public void removefromLists(final Student s) {
        List<Student> ls = firstNameMap.get(s.getFirstName());
        ls.remove(s);
        if (ls.size() == 0) {
            firstNameMap.remove(s.getFirstName());
        }
        ls = lastNameMap.get(s.getLastName());
        ls.remove(s);
        if (ls.size() == 0) {
            lastNameMap.remove(s.getLastName());
        }
    }
/**
 * instance method copyList to deep copy a returning list of student instances.
 * @param org Specifies the list to be copied.
 * @return   A copied list of the original list.
 */
    public List<Student> copyList(final List<Student> org) {
        if (!(org instanceof ArrayList)) {
            throw new IllegalArgumentException("wrong list");
        }
        List<Student> copy = new ArrayList<Student>();
        for (Student s: org) {
            copy.add(new Student(s));
        }
        return copy;
    }
}
