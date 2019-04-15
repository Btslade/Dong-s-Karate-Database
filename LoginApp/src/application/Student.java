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
	public SimpleIntegerProperty age;
	public SimpleStringProperty testingDate;
	public SimpleIntegerProperty attendance;
	public SimpleStringProperty adress;
	public SimpleStringProperty phoneNumber;
	public SimpleStringProperty email;
	public SimpleStringProperty colorOfBelt;
	public SimpleIntegerProperty degreeNum;
	public SimpleIntegerProperty starNum;
	public SimpleStringProperty colorOfStripe;
	
	
	public Student(int id, String fname, String lname, String guardian, int agee, String testingDate1, int attendance1, String adress1, String phoneNumber, String email1, String colorr, int dgree, int starNUm, String stripeColor)
	{
		this.iD = new SimpleIntegerProperty(id);
		this.firstName = new SimpleStringProperty(fname);
		this.lastName = new SimpleStringProperty(lname);
		this.guardianName = new SimpleStringProperty(guardian);
		this.age = new SimpleIntegerProperty(agee);
		this.testingDate = new SimpleStringProperty(testingDate1);
		this.attendance = new SimpleIntegerProperty(attendance1);
		this.adress = new SimpleStringProperty(adress1);
		this.phoneNumber = new SimpleStringProperty(phoneNumber);
		this.email = new SimpleStringProperty(email1);
		this.colorOfBelt = new SimpleStringProperty(colorr);
		this.degreeNum = new SimpleIntegerProperty(dgree);
		this.starNum = new SimpleIntegerProperty(starNUm);
		this.colorOfStripe = new SimpleStringProperty(stripeColor);
		
		
		
	}
	public Student()
	{
		
	}
	
//////////////////////////ID///////////////////////////////	
	public IntegerProperty getiDProperty() 
	{
		return iD;
	}
	
	public int getId()
	{
		return this.iD.get();
	}
	
	
	public void setID(int ID)
	{
		this.iD.set(ID);
	}
/////////////////////////////////////////////////////////////
	
	
////////////////////////////////FIRST NAME////////////////////////////////////////
	public StringProperty getFirstNameProperty() 
	{
		return firstName;
	}
	
	public String getFirstName() 
	{
		return this.firstName.get();
	}
	
	
	public void setFirstName(String fname) 
	{
		this.firstName.set(fname);
	}
//////////////////////////////////////////////////////////////////////////////////

	
	
	
	
	
////////////////////////////////LAST NAME/////////////////////////////////////////	
	public StringProperty getLastNameProperty() 
	{
		return lastName;
	}
	
	public String getLastName() 
	{
		return this.lastName.get();
	}
	public void setLastName(String lname)
	{
		this.lastName.set(lname);
	}
///////////////////////////////////////////////////////////////////////////////////
	
////////////////////////////GUARDIAN NAME/////////////////////////////////////////
	public StringProperty getGuardianNameProperty() 
	{
		return guardianName;
	}
	
	public String getGuardianName()
	{
		return this.guardianName.get();
	}

	public void setGuardianName(String gName)
	{
		this.guardianName.set(gName);
	}
//////////////////////////////////////////////////////////////////////////////
	
//////////////////////GET AGE////////////////////////////////////////////////
	public IntegerProperty getAgeProperty() 
	{
		return age;
	}
	
	public int getAge()
	{
		return this.age.get();
	}
	
	public void setAge(int newage)
	{
		this.age.set(newage);
	}
////////////////////////////////////////////////////////////////////////////
	
///////////////////////////TESTING DATE////////////////////////////////////
	public StringProperty getTestingDateProperty() 
	{
		return testingDate;
	}
	public String getTestingDate()
	{
		return this.testingDate.get();
	}
	public void setTestingDate(String testingDATE)
	{
		this.testingDate.set(testingDATE);
	}
//////////////////////////////////////////////////////////////////////////
	
//////////////////////ATTENDANCE//////////////////////////////////////////
	public IntegerProperty getAttendanceProperty() 
	{
		return attendance;
	}
	
	public int getAttendance()
	{
		return this.attendance.get();
	}
	public void setAttendance(int att)
	{
		this.attendance.set(att);
	}
/////////////////////////////////////////////////////////////////////////
	
///////////////////////////ADDRESS////////////////////////////////////////	
	public SimpleStringProperty getAdressProperty()
	{
		return adress;
	}

	public String getAdress()
	{
		return this.adress.get();
	}
	public void setAdress(String addr)
	{
		this.adress.set(addr);
	}
/////////////////////////////////////////////////////////////////////////
	
/////////////////////////////////PHONE NUMBER////////////////////////////	
	public StringProperty getPhoneNumberProperty() 
	{
		return phoneNumber;
	}

	public String getPhoneNumber()
	{
		return this.phoneNumber.get();
	}
	
	public void setPhoneNumber(String newNum)
	{
		this.phoneNumber.set(newNum);
	}
/////////////////////////////////////////////////////////////////////////
	
////////////////////////EMAIL////////////////////////////////////////////
	public StringProperty getEmailProperty() 
	{
		return email;
	}
	
	public String getEmail()
	{
		return this.email.get();
	}
	public void setEmail(String email1)
	{
		this.email.set(email1);
	}
////////////////////////////////////////////////////////////////////////
//////////////////////////BELT COLOR
	public StringProperty colorOfBeltProperty()
	{
		return colorOfBelt;
	}
	public String getcolorOfBelt()
	{
		return this.colorOfBelt.get();
	}
	public void setBeltColor(String beltColor)
	{
		this.colorOfBelt.set(beltColor);
	}
	
	
////////////////////////DEGREE
	public IntegerProperty degreeNumProperty()
	{
		return degreeNum;
	}
	public int getDegree()
	{
       return this.degreeNum.get();	
	}
	public void setDegreeNum(int dgree)
	{
		this.degreeNum.set(dgree);
	}
////////////////////////STARS
	public IntegerProperty starNumProperty()
	{
		return starNum;
	}
	public int getStars()
	{
       return this.starNum.get();	
	}
	public void setStarNum(int star)
	{
		this.starNum.set(star);
	}
	
/////////////STRIPE
	public StringProperty colorOfStripeProperty()
	{
		return colorOfStripe;
	}
	public String getStripeColor()
	{
		return this.colorOfStripe.get();
	}
	public void setStripeColor(String stripeColor)
	{
		this.colorOfStripe.set(stripeColor);
	}
	
	
	

}
