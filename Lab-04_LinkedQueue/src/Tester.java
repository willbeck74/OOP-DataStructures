
public class Tester {
	
	
	public static void main(String[] args) {
		
		LinkedQueue<Integer> nums = new LinkedQueue();
		//ArrayQueue<Integer> nums = new ArrayQueue<Integer>(5);
		
		nums.add(1);			System.out.printf("add(1): %-20s %s%n", nums, nums.showActualArray());
		nums.add(2);			System.out.printf("add(2): %-20s %s%n", nums, nums.showActualArray());
		nums.add(3);			System.out.printf("add(3): %-20s %s%n", nums, nums.showActualArray());
		nums.add(4);			System.out.printf("add(4): %-20s %s%n", nums, nums.showActualArray());
		nums.add(5);			System.out.printf("add(4): %-20s %s%n", nums, nums.showActualArray());
		nums.remove();			System.out.printf("remove: %-20s %s%n", nums, nums.showActualArray());
		nums.remove();			System.out.printf("remove: %-20s %s%n", nums, nums.showActualArray());
		nums.add(6);			System.out.printf("add(6): %-20s %s%n", nums, nums.showActualArray());
		nums.add(7);			System.out.printf("add(7): %-20s %s%n", nums, nums.showActualArray());
		nums.add(8);			System.out.printf("add(7): %-20s %s%n", nums, nums.showActualArray());
		nums.remove();			System.out.printf("remove: %-20s %s%n", nums, nums.showActualArray());
		nums.remove();			System.out.printf("remove: %-20s %s%n", nums, nums.showActualArray());
		nums.remove();			System.out.printf("remove: %-20s %s%n", nums, nums.showActualArray());
		nums.remove();			System.out.printf("remove: %-20s %s%n", nums, nums.showActualArray());
		nums.remove();			System.out.printf("remove: %-20s %s%n", nums, nums.showActualArray());
		nums.remove();			System.out.printf("remove: %-20s %s%n", nums, nums.showActualArray());
		nums.add(1);			System.out.printf("add(1): %-20s %s%n", nums, nums.showActualArray());
		nums.add(2);			System.out.printf("add(2): %-20s %s%n", nums, nums.showActualArray());
		nums.add(3);			System.out.printf("add(3): %-20s %s%n", nums, nums.showActualArray());		
		nums.add(4);			System.out.printf("add(4): %-20s %s%n", nums, nums.showActualArray());
		nums.add(5);			System.out.printf("add(4): %-20s %s%n", nums, nums.showActualArray());
		
	}	
	
}
