package test.SuppClasses;
import java.util.ArrayList;
//���� � ���� �� ��
public class Floor {
	
private int numOfFloor;
private int amountOfAwaiting;
public ArrayList <User> awaiting;
public int GetNumOfFloor()
{
	return numOfFloor;
}
public int GetAmountOfAwaiting()
{
	return amountOfAwaiting;
}

public boolean WhereToGo()//��� ���������� "�������������" ������������ ����������, ����������� � �����, ����� ��� ����������� ������� ����������� ����������� ��������. ��� ������ true - �����, false - ����.
{
	int count=0;
	for(int i=0;i<awaiting.size();i++)
	{
		if(awaiting.get(i).WantToDir()==true)
			count++;
		
		else
			count--;
	}
	if(count<0)
		return false;
	return true;
}
public void AwaitingLog()// ���������� ������� ����� ����� �����, ������� ����
{
	int up=0;
	int down=0;
	if(awaiting!=null)
	{
		for(int i=0;i<awaiting.size();i++)
		{
			if(awaiting.get(i).WantToDir()==true)
				up++;
			else
				down++;
		}
	}
	System.out.println("�� ����� ��������� "+up+" �������, ������� ����� ����� � "+down+", ������� ����� ����");
}
public Floor(int numOfFloor,int storeys) 
{
	awaiting=new ArrayList<User>();
	this.numOfFloor=numOfFloor;	
	amountOfAwaiting=(int)(Math.random()*11);	
	if(amountOfAwaiting!=0)//��� ������� ��������� ������ ����������, ���� �� ��� �� ���� �����. 
	{
		for(int i=0;i<amountOfAwaiting;i++)
		{
			awaiting.add(i,new User(numOfFloor, storeys));
			
		}
		
	}
	
}
}


