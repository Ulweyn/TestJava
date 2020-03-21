package test.SuppClasses;
import java.util.ArrayList;
import java.lang.Math;
//����������, ���� ���������
public class User {
	private int wantTo;//���� ����� �������
	private int placedAt;//�� ����� ����� ���������
	
	public void SetWantTo(int wantTo)
	{
		this.wantTo=wantTo;
	}
	public void SetPlacedAt(int placedAt)
	{
		this.placedAt=placedAt;
	}
	public int GetWantTo()
	{
		return wantTo;
	}
	public int GetPlacedAt()
	{
		return placedAt;
	}
	public void SetWantToRand(int placedAt, int storeys)
	{
		int WantTo=placedAt;
		while(WantTo==placedAt)//�������� �������� ���� ���, ����� �� �� �������� � �������
		{
			WantTo=(int)(Math.random()*(storeys));
		}
		SetWantTo(WantTo);
	}
	public boolean WantToDir()
	{
		return wantTo>placedAt;//���� ����� ������ - ������ true, ���� - false
	}
	public User(int placedAt, int storeys)
	{
		SetPlacedAt(placedAt);		
		SetWantToRand(placedAt, storeys);
	}
	
}
