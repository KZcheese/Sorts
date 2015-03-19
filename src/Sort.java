import java.util.ArrayList;

public class Sort {
	public static void selectionSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int mindex = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[mindex])
					mindex = j;
			}
			int temp = a[mindex];
			a[mindex] = a[i];
			a[i] = temp;
		}
	}

	public static void selectionSort(ArrayList<String> a) {
		for (int i = 0; i < a.size() - 1; i++) {
			int mindex = i;
			for (int j = i + 1; j < a.size(); j++) {
				if (a.get(j).compareTo(a.get(mindex)) < 0)
					mindex = j;
			}
			a.set(mindex, a.set(i, a.get(mindex)));
		}
	}

	public static void insertionSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int index = i;
			int val = a[i];
			while (index > 0 && val < a[index - 1]) {
				a[index] = a[index - 1];
				index--;
			}
			a[index] = val;
		}
	}

	public static void insertionSort(ArrayList<String> a) {
		for (int i = 1; i < a.size(); i++) {
			int index = i;
			String val = a.get(i);
			while (index > 0 && val.compareTo(a.get(index - 1)) < 0) {
				a.set(index, a.get(index - 1));
				index--;
			}
			a.set(index, val);
		}
	}

	public static void mergeSort(int[] a) {
		if (a.length < 2)
			return;
		int mid = a.length / 2;
		int[] left = subArray(a, 0, mid);
		int[] right = subArray(a, mid, a.length);
		mergeSort(left);
		mergeSort(right);
		for (int i = 0, j = 0, n = 0; n < a.length; n++) {
			if (i > left.length - 1 || j < right.length && left[i] > right[j])
				a[n] = right[j++];
			else
				a[n] = left[i++];
		}
	}

	public static int[] subArray(int[] a, int start, int end) {
		int[] out = new int[end - start];
		for (int i = start, j = 0; i < end; i++, j++)
			out[j] = a[i];
		return out;
	}

	public static void mergeSort(ArrayList<String> a) {
		if (a.size() < 2)
			return;
		int mid = a.size() / 2;
		ArrayList<String> left = subArrayList(a, 0, mid);
		ArrayList<String> right = subArrayList(a, mid, a.size());
		mergeSort(left);
		mergeSort(right);
		for (int i = 0, j = 0, n = 0; n < a.size(); n++) {
			if (i > left.size() - 1 || j < right.size()
					&& left.get(i).compareTo(right.get(j)) > 0)
				a.set(n, right.get(j++));
			else
				a.set(n, left.get(i++));
		}
	}

	public static ArrayList<String> subArrayList(ArrayList<String> a,
			int start, int end) {
		ArrayList<String> out = new ArrayList<String>();
		for (int i = start; i < end; i++)
			out.add(a.get(i));
		return out;
	}

	public static void quickSort(int[] a) {
		quickSort(a, 0, 1, a.length - 1);
	}

	public static void quickSort(int[] a, int pivot, int left, int right) {
		int leftCount = left;
		int rightCount = right;
		while (a[leftCount] < a[pivot] && leftCount < rightCount)
			leftCount++;
		while (a[rightCount] > a[pivot] && leftCount < rightCount)
			rightCount--;
		if (rightCount < leftCount) {
			int temp = a[pivot];
			a[pivot] = a[leftCount];
			a[leftCount] = temp;
			System.out.println(rightCount);
			if (rightCount < 1 || rightCount > a.length - 1)
				return;
			quickSort(a, 0, left, rightCount - 1);
			quickSort(a, 0, rightCount, right);
		} else {
			System.out.println(rightCount);
			int temp = a[leftCount];
			a[leftCount] = a[rightCount];
			a[rightCount] = temp;

			if (rightCount < 1 || rightCount > a.length - 1)
				return;
			quickSort(a, pivot, ++leftCount, --rightCount);
		}
	}

	public static void bogoSort(int[] a) {
		boolean isSorted = true;
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) {
				isSorted = false;
				break;
			}
		}
		if (isSorted)
			return;
	}

	public static String arrayString(int[] a) {
		String out = "[";
		for (int n : a)
			out += n + ", ";
		return out.substring(0, out.length() - 2) + "]";
	}

	public static void main(String[] args) {
		int[] a = { 5, 6, 8, 4, 0, 7, 3, 7, 4 };
		System.out.println(arrayString(a));
		quickSort(a);
		System.out.println(arrayString(a));
		ArrayList<String> al = new ArrayList<>();
		al.add("word");
		al.add("");
		al.add("woot");
		al.add("banananannananana");
		al.add("apple");
		System.out.println(al);
		mergeSort(al);
		System.out.println(al);
	}
}
