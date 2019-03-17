package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ColorBelt {
	public SimpleIntegerProperty iD;
	public SimpleStringProperty beltColor;

	
	public ColorBelt(int id, String beltcolor)
	{
		this.iD = new SimpleIntegerProperty(id);
		this.beltColor = new SimpleStringProperty(beltcolor);
	}
	
	
	public IntegerProperty getiD() {
		return iD;
	}
	public void setID(int ID)
	{
		this.iD.set(ID);
	}
	
	
	public StringProperty getBeltColor()
	{
		return beltColor;
	}
	
	public void setBeltColor(String str)
	{
		this.beltColor.set(str);
	}

}
