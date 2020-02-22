package cakeProxy;

import java.rmi.*;
import java.rmi.server.*;


public class CakeBakery extends UnicastRemoteObject implements RemoteBakery {

	private static final long serialVersionUID = 1L;
	State cakeIsSoldState;
	State cakeIsMadeState;
	State noMoreCakesState;
	State noOrderState;
	State orderCakeFromCaseState;
	State takingSpecialOrderState;

	State state;

	int cakeInventory = 0;
	String cakeLocation;

	public CakeBakery(int numberCakes, String location) throws RemoteException {
		cakeIsSoldState = new CakeIsSoldState(this);
		cakeIsMadeState = new CakeIsMadeState(this);
		noMoreCakesState = new NoMoreCakesState(this);
		noOrderState = new NoOrderState(this);
		takingSpecialOrderState = new TakingSpecialOrderState(this);
		orderCakeFromCaseState = new OrderCakeFromCaseState(this);

		this.cakeInventory = numberCakes;
		this.cakeLocation = location;
		// If there are cakes in the case, and the order is a case order set the state
		// to case order state
		if (numberCakes > 0 ) {
			state = orderCakeFromCaseState;
			// If the order is a special order, just set the state to special order
		} 
	}

	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("Welcome to your beautiful bakery. We have " + cakeInventory + " cakes.");
		return result.toString();
	}

	public void takeMoney() {
		state.takeMoney();
	}

	public void placeSpecialOrder() {
		state.placeSpecialOrder();
	}

	public void placeCaseOrder() {
		state.placeCaseOrder();
		this.cakeInventory -= cakeInventory;
	}

	public void fillOrder() {
		state.fillOrder();
	}

	public void makeMoreCakes() {
		state.makeMoreCakes();
	}

	// Print out the welcome sign to the shop

	public void makeCakesForCase(int cakeCount) {
		cakeInventory += cakeCount;
		System.out.println("We've made " + cakeCount + " beautiful cakes for the case today. "
				+ "It is a vertiable feast of yummy confections.\nNow we have " + cakeInventory + " cakes total.");
	}

	void setState(State state) {
		this.state = state;
	}

	public State getState() {
		return state;
	}

	// Allow the class to return the states
	public State cakeIsSoldState() {
		return cakeIsSoldState;
	}

	public State cakeIsMadeState() {
		return cakeIsMadeState;
	}

	public State noMoreCakesState() {
		return noMoreCakesState;
	}

	public State noOrderState() {
		return noOrderState;
	}

	public State orderCakeFromCaseState() {
		return orderCakeFromCaseState;
	}

	public String getLocation() {
		return cakeLocation;
	}


	public int getCakeCount() {
		return cakeInventory;
	}
}
