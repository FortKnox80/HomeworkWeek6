package cakeProxy;

import java.rmi.*;

public class BakeryMonitorTest {

	public static void main(String[] args) {
		
		String [] location = {"rmi://santafe.CakeBakery.com/cakebakery"};
		
		CakeMonitor[] monitor = new CakeMonitor[location.length];
		
		for(int i =0; i<location.length; i++) {
			
			try {
				CakeBakery cakeBakery = (CakeBakery) Naming.lookup(location[i]);
				monitor[i] = new CakeMonitor(cakeBakery);
				System.out.println(monitor[i]);
				
			}catch (Exception e) 
			{
				e.printStackTrace();
			}
			
		}
		for(int i =0; i<location.length; i++) {
			
			monitor[i].report();
			
		}
	}

}
