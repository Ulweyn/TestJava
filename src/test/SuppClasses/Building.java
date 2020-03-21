package test.SuppClasses;
import java.util.ArrayList;
import java.util.Scanner;

//����������� �����. ��� ��� � ��� ��������� ���� � �����, � ����� ������������ ��������� - ������ ��� "������"
public class Building {
private int storeys;
public Elevator elevator;
public ArrayList<Floor> floors;
boolean flag=true;//���������� ���� ������������ ����
public int GetStoreys()
{
	return storeys;
}

public Building()
{
	floors=new ArrayList<Floor>();
	storeys=(int)(Math.random()*16+5);
	for(int i=0;i<storeys;i++)
	{
		floors.add(i,new Floor(i,storeys));
		
	}
	elevator=new Elevator();
	System.out.println("� ������ " +storeys+" ������");
}

public void PassengeresTransaction()//�����, ������������ ��������� � ���� � �� �����. ����� �������� ���� �� �������� �� ������������ ����.
{
	ArrayList<User> tPassengers= new ArrayList<User>();
	
	if(elevator.passengers.size()!=0)
	{
		for(int j=0;j<elevator.passengers.size();j++)//������� �� �����
		{
		
			if(elevator.passengers.get(j).GetWantTo()==elevator.currentFloor)
			{
				elevator.passengers.get(j).SetWantToRand(elevator.currentFloor, storeys);//�������� ���������� ��������� ����� ��������� ����
				elevator.passengers.get(j).SetPlacedAt(elevator.currentFloor);
				floors.get(elevator.currentFloor).awaiting.add(elevator.passengers.get(j));
				elevator.currentCapacity++;
				System.out.println("������� ����� �� �����. � ����� " + elevator.currentCapacity+" �����");				
			}
			else
				tPassengers.add(elevator.passengers.get(j));
		}
		elevator.passengers=new ArrayList<User>();
		elevator.passengers.addAll(0,tPassengers);
		
	}
	//
	ArrayList<User> tAwaiting= new ArrayList<User>();
	if(floors.get(elevator.currentFloor).awaiting!=null)
	{
	for(int j=0;j<floors.get(elevator.currentFloor).awaiting.size() ;j++)//������� � ����
		{	
		
		if(floors.get(elevator.currentFloor).awaiting.get(j).WantToDir()==elevator.GetDirection() && elevator.currentCapacity>0) 
			{
				if(elevator.GetDirection()==true && floors.get(elevator.currentFloor).awaiting.get(j).GetWantTo()>elevator.maxFloor)//������ ������������ ���� � ������������ � ������ ����������
				{
					elevator.maxFloor=floors.get(elevator.currentFloor).awaiting.get(j).GetWantTo();
				}
				
				if(elevator.GetDirection()==false && floors.get(elevator.currentFloor).awaiting.get(j).GetWantTo()<elevator.maxFloor)//�������� �� ��, �� ���� ����.
				{
					elevator.maxFloor=floors.get(elevator.currentFloor).awaiting.get(j).GetWantTo();
				}
				
				elevator.passengers.add(floors.get(elevator.currentFloor).awaiting.get(j));
				
				elevator.currentCapacity--;
				System.out.println("������� ����� � ����. ��� ����� �� "+(elevator.passengers.get(elevator.passengers.size()-1).GetWantTo()+1)+" ����. �������� " + elevator.currentCapacity+" �����");							
			}		
		else
			tAwaiting.add(floors.get(elevator.currentFloor).awaiting.get(j));
		}	
	floors.get(elevator.currentFloor).awaiting= new ArrayList<User>();
	floors.get(elevator.currentFloor).awaiting.addAll(0, tAwaiting);	
	}
	
	
}

public void GoUp()
{
	
	
	if(elevator.currentFloor==storeys-1 ||(elevator.passengers.size()==0 && floors.get(elevator.currentFloor).WhereToGo()==false))
	{
		elevator.ChangeDirection();
		flag=false;
		System.out.println("������ �� ������������� ����");
	}
	else {
	if(elevator.currentFloor==elevator.maxFloor && elevator.currentCapacity==elevator.GetCapacity() && floors.get(elevator.currentFloor).WhereToGo()==false && elevator.currentFloor!=storeys)//���� � ����� �����, � �� ��� ������� �� ����� ������ ���� �����
		elevator.maxFloor++;
	
	elevator.currentFloor++;
	
	}
}

public void GoDown()
{
	
	
	if(elevator.currentFloor==0 || (elevator.passengers.size()==0 && floors.get(elevator.currentFloor).WhereToGo()==true))
	{
		elevator.ChangeDirection();
		flag=true;
		System.out.println("������ �� ������������� �����");
	}
	else {
	if(elevator.currentFloor==elevator.maxFloor && elevator.currentCapacity==elevator.GetCapacity() && floors.get(elevator.currentFloor).WhereToGo()==false && elevator.currentFloor!=0)
		elevator.maxFloor--;
	
	elevator.currentFloor--;
	
	}
}

public void ElevatorMovement()//�������� �����
{
	
	Scanner in = new Scanner(System.in);
	
	
		while(elevator.GetDirection()==flag)
		{			
			System.out.println("�� �� "+(elevator.currentFloor+1) + " �����");
			floors.get(elevator.currentFloor).AwaitingLog();
			PassengeresTransaction();
			floors.get(elevator.currentFloor).AwaitingLog();//���� ����� �� ����� � ����, ������� �� ��������� ���������. ������������� ��� ����� ����� ���� ����� � ������� ������. ����� ��������� ���� ���, ����� �������� ��������� � ������ �������� ����������.
			if(flag==true)
				GoUp();
			else
				GoDown();			
			
			int a=in.nextInt();
			if(a==0)
			{
				return;//������ ����� ���������. ���� � ������ �� ���������� �������� � ��������
			}
		}
			
		in.close();
}


}
