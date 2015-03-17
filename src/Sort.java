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
			String val = a.remove(i);
			while (index > 0 && val.compareTo(a.get(index - 1)) < 0)
				index--;
			a.add(index, val);
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
			if (i > left.length - 1 || j < right.length && left[i] > right[j]) {
				a[n] = right[j];
				j++;
			} else {
				a[n] = left[i];
				i++;
			}
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
		ArrayList<String> left = (ArrayList<String>) a.subList(0, mid);
		ArrayList<String> right = (ArrayList<String>) a.subList(mid, a.size());
		mergeSort(left);
		mergeSort(right);
		for (int i = 0, j = 0, n = 0; n < a.size(); n++) {
			if (i > left.size() - 1 || j < right.size()
					&& left.get(i).compareTo(right.get(j)) > 1)
				a.add(n, right.get(j++));
			else
				a.add(n, left.get(i++));
		}
	}

	public static int[] subArrayList(ArrayList<String> a, int start, int end){
		ArrayList<Integer> out = new ArrayList<> (end - start);
		for (int i = start, j = 0; i < end; i++, j++)
			out.add(a.get(i));
		return out;
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
		insertionSort(a);
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
