package test.SuppClasses;
import java.util.ArrayList;

public class Elevator {

	private int capacity=5;//����� ����������� �����
	public int currentFloor;
	public int currentCapacity;//������� ������� ����� ��� ����� � ����
	public int maxFloor=1;//�� ��������� ����� 2 �����(����� �� ������� �� ��������� � ������������� �� ������), ����� ����� ��������� � ����������� �� ��������� ����������
	private boolean direction;//����������� �������� ����� true - �����, false - ����. 
	public ArrayList<User> passengers;
	
	public int GetCapacity()
	{
		return capacity;
	}
	
	public boolean GetDirection()
	{
		return direction;
	}
	public void SetDirection(boolean direction)//������������ ������ ��� �����
	{
		this.direction=direction;
	}
	
	public void ChangeDirection()//������ ����������� �������� �����
	{
		direction=!direction;
	}
	
	public Elevator()
	{
		currentFloor=0;//��� �������� ����� �������� � ������� �����
		currentCapacity=capacity;//��� �������� ���� ����
		direction=true;
		passengers=new ArrayList<User>();
	}
}
