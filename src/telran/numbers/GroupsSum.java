package telran.numbers;

import java.util.Arrays;

abstract public class GroupsSum {
	protected int[][] groups;
	
	public GroupsSum(int[][] groups) {
		super();
		this.groups = groups;
	}
	protected SumArrayTask[] getTasks() {
		return Arrays.stream(groups).map(a -> new SumArrayTask(a))
				.toArray(SumArrayTask[]::new);
	}
protected long sumOfGroups(SumArrayTask[] tasks) {
		
		return Arrays.stream(tasks).mapToLong(SumArrayTask::getResult)
				.sum();
	}
	abstract public long getSum();
}
