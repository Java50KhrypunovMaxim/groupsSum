package telran.numbers.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import telran.numbers.*;
class GroupsSumTest {
private static final int N_GROUPS = 20000;
private static final int GROUP_LENGTH = 20000;
int[][] groups = {
		{1,2},
		{3,4},
		{5,6}
};
int[][] largeGroups = getLargeGroups(N_GROUPS, GROUP_LENGTH);
	@Test
	void goupsSumTaskThreadTest() {
		GroupsSum gs = new GroupsSumTaskThread(groups);
		assertEquals(21, gs.getSum());
	}
	
	private int[][] getLargeGroups(int nGroups, int groupLength) {
		Random random = new Random();
		int[][] arrays  = Stream.generate(()-> random.ints(groupLength, 0, 50)
				.toArray()).limit(nGroups).toArray(int[][]::new);	
		return arrays;
	}
	
	@Test
	void goupsSumThreadPoolTest() {
		GroupsSum gs = new GroupsSumThreadPool(groups);
		assertEquals(21, gs.getSum());
	}
	@Test
	void groupsSumTaskThreadPerformance() {
		new GroupsSumTaskThread(largeGroups).getSum();
	}
	@Test
	void groupsSumTaskThreadPoolsPerformance() {
		new GroupsSumThreadPool(largeGroups).getSum();
	}

}
