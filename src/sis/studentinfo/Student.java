package sis.studentinfo;
import java.util.*;
import java.util.logging.Logger;
public class Student {
	public enum Grade {
		A(4), 
		B(3), 
		C(2), 
		D(1), 
		F(0);
	
		private int points;
		
		Grade(int points) {
			this.points = points;
		}
	
		int getPoints() {
			return points;
		}
	}
	
	static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
	static final String IN_STATE = "CO";
    private String name;
    public int credits;
    private String state = "";
    private String firstName = "";
    private String middleName = "";
    private String lastName;
    private String id;
    static final int MAX_NAME_PARTS = 3;
    static final String TOO_MANY_NAME_PARTS_MSG = "Student name '%s' contains more than %d parts";
    static final Logger logger = Logger.getLogger(Student.class.getName());
    private List<Grade> grades = new ArrayList<Grade>();
    private List<Integer> charges = new ArrayList<Integer>();
    private GradingStrategy gradingStrategy = new BasicGradingStrategy();
    public Student(String fullName) {
        this.name = fullName;
        credits = 0;
        List<String> nameParts = split(fullName);
        if (nameParts.size() > MAX_NAME_PARTS) {
        	String message = String.format(TOO_MANY_NAME_PARTS_MSG, fullName, MAX_NAME_PARTS);
        	Student.logger.info(message);
        	throw new StudentNameFormatException(message);
        }
        setName(nameParts);
    }
//    private void log(String message) {
//    	Logger logger = Logger.getLogger(getClass().getName());
//    	logger.info(message);
//    }
    private void setName(List<String> nameParts) {
    	this.lastName = removeLast(nameParts);
    	String name = removeLast(nameParts);
    	if (nameParts.isEmpty())
    		this.firstName = name;
    	else {
    		this.middleName = name;
    		this.firstName = removeLast(nameParts);
    	}
    }
    private String removeLast(List<String> list ) {
    	if (list.isEmpty()) 
    		return "";
    	return list.remove(list.size() - 1);
    }
    private List<String> split(String fullName) {
    	List<String> results = new ArrayList<String>();
    	
    	for (String name: fullName.split(" "))
    		results.add(name);
    	return results;
    }
    public void addCharge(int charge) {
    	charges.add(charge);
    }
    public int totalCharges() {
    	int total = 0;
    	for(int charge: charges) {
    		total += charge;
    	}
    	return total;
    }
    public String getName() {
       return this.name;
    }
    public String getFirstName() {
    	return firstName;
    }
    public String getMiddleName() {
    	return middleName;
    }
    public String getLastName() {
    	return lastName;
    }
    public void setId(String id) {
    	this.id = id;
    }
    public String getId() {
    	return id;
    }
    boolean isFullTime() {
    	return credits >= CREDITS_REQUIRED_FOR_FULL_TIME;
    }
    int getCredits() {
    	return credits;
    }
    void addCredits(int credits) {
    	this.credits += credits;
    }
    void setState(String state) {
    	this.state = state.toUpperCase();
    }
    boolean isInState() {
    	return state.equals(Student.IN_STATE);
    }
    void addGrade(Grade grade) {
        grades.add(grade);
     }
    double getGpa() {
        if (grades.isEmpty())
           return 0.0;
        double total = 0.0;
        for (Grade grade: grades)
           total += gradingStrategy.getGradePointsFor(grade);
        return total / grades.size();
     }
    void setGradingStrategy(GradingStrategy gradingStrategy) {
        this.gradingStrategy = gradingStrategy;
     }
}
