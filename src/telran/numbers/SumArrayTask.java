package telran.numbers;

import java.util.Arrays;

public class SumArrayTask implements Runnable {
	private int[] array;
	private long result;
	
	public long getResult() {
		return result;
	}


	public SumArrayTask(int[] array) {
		this.array = array;
	}


	@Override
	public void run() {
		result = Arrays.stream(array).asLongStream().sum();

	}

}
