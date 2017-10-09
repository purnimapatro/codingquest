public class BubbleSort {

	public static void main(String[] args) {
		Integer[] list = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		System.out.println("Before sorting");
		printList(list);
		BubbleSort obj = new BubbleSort();
		obj.bubbleSort(list);
		System.out.println("After sorting");
		printList(list);
	}

	private static void printList(Integer[] list) {
		if (list.length < 1) {
			return;
		}
		for (Integer i : list) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	private void swap(int i, int j, Integer[] list) {
		int temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}

	private void bubbleSort(Integer[] list) {
		int len = list.length;
		for (int i = 0; i < len; i++) {
			for (int j = 1; j < len; j++) {
				if (list[j] < list[j-1]) {
					swap(j, j-1, list);
				}
			}
		}
	}
}
