package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {
	public SimpleIntegerProperty iD;
	public SimpleStringProperty firstName;
	public SimpleStringProperty lastName;
	public SimpleStringProperty guardianName;
	public SimpleStringProperty age;
	public SimpleStringProperty testingDate;
	public SimpleIntegerProperty attendance;
	public SimpleStringProperty adress;
	public SimpleStringProperty phoneNumber;
	public SimpleStringProperty email;
	
	
	public Student(int id, String fname, String lname, String guardian, String agee, String testingDate1, int attendance1, String adress1, String phoneNumber, String email1)
	{
		this.iD = new SimpleIntegerProperty(id);
		this.firstName = new SimpleStringProperty(fname);
		this.lastName = new SimpleStringProperty(lname);
		this.guardianName = new SimpleStringProperty(guardian);
		this.age = new SimpleStringProperty(agee);
		this.testingDate = new SimpleStringProperty(testingDate1);
		this.attendance = new SimpleIntegerProperty(attendance1);
		this.adress = new SimpleStringProperty(adress1);
		this.phoneNumber = new SimpleStringProperty(phoneNumber);
		this.email = new SimpleStringProperty(email1);
		
		
	}

	public IntegerProperty getiD() {
		return iD;
	}
	public void setID(int ID)
	{
		this.iD.set(ID);
	}


	public StringProperty getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String fname) {
		this.firstName.set(fname);
	}


	public StringProperty getLastName() {
		return lastName;
	}
	
	public void setLastName(String lname)
	{
		this.lastName.set(lname);
	}


	public StringProperty getGuardianName() {
		return guardianName;
	}
	public void setGuardianName(String gName)
	{
		this.guardianName.set(gName);
	}

	public StringProperty getAge() {
		return age;
	}
	public void setAge(String newage)
	{
		this.age.set(newage);
	}

	public StringProperty getTestingDate() {
		return testingDate;
	}
	public void setTestingDate(String testingDATE)
	{
		this.testingDate.set(testingDATE);
	}

	public IntegerProperty getAttendance() {
		return attendance;
	}
	public void setAttendance(int att)
	{
		this.attendance.set(att);
	}

	public SimpleStringProperty getAdress() {
		return adress;
	}

	public void setAdress(String addr)
	{
		this.adress.set(addr);
	}

	public StringProperty getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String newNum)
	{
		this.phoneNumber.set(newNum);
	}

	public StringProperty getEmail() {
		return email;
	}
	public void setEmail(String email1)
	{
		this.email.set(email1);
	}

}
