package com.venkat.solid.lsp;

public class BirdWatcher {
	
	public void observeFlyingBirds(Flyable[] flyableBirds) {
        for (Flyable bird : flyableBirds) {
            bird.fly(); // Only Flyable birds are passed
        }
    }

    public void observeEatingBirds(Bird[] birds) {
        for (Bird bird : birds) {
            bird.eat(); // All birds can eat
        }
    }

	public static void main(String[] args) {
		Flyable[] flyingBirds = {new Sparrow()};
        Bird[] eatingBirds = {new Sparrow(), new Ostrich()};
        
        BirdWatcher watcher = new BirdWatcher();
        watcher.observeFlyingBirds(flyingBirds); // Works fine
        watcher.observeEatingBirds(eatingBirds); // Works fine
	}

}
