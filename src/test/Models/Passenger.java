/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.Models;

/**
 *
 * @author Администратор
 */
public class Passenger implements test.Interfaces.iPassenger{
    private int wantTo;
    private int placedAt;
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
    public Passenger(int wantTo, int placedAt)
    {
        SetWantTo(wantTo);
        SetPlacedAt(placedAt);    
    }
}
