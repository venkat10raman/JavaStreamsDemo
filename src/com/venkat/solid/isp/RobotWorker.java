package com.venkat.solid.isp;

public class RobotWorker implements Workable {

	@Override
	public void work() {
		System.out.println("Robot is working...");
	}
	
	/* 
	 Explanation: Interfaces are split into Workable and Eatable. 
	 RobotWorker only implements Workable, 
	 avoiding unnecessary method implementations.
	  
	  
	  Interface Segregation Principle (ISP)
	  Clients should not be forced to depend on interfaces they don’t use.
	 */

}
