package chapter2.interfaces;

public class Lion implements Run {

	@Override
	public boolean isQuadruped() {
		return true;
	}

	@Override
	public boolean canHuntWhileRunning() {
		return true;
	}

	@Override
	public double getMaxSpeed() {
		return 100;
	}

}
