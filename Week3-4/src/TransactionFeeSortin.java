import java.util.*;

class Transaction {
    int id;
    double fee;
    String time;

    Transaction(int id, double fee, String time) {
        this.id = id;
        this.fee = fee;
        this.time = time;
    }
}

public class TransactionFeeSorting {
    public static void bubbleSort(ArrayList<Transaction> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).fee > list.get(j + 1).fee) {
                    Collections.swap(list, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void insertionSort(ArrayList<Transaction> list) {
        for (int i = 1; i < list.size(); i++) {
            Transaction key = list.get(i);
            int j = i - 1;

            while (j >= 0 && list.get(j).fee > key.fee) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    public static void main(String[] args) {
        ArrayList<Transaction> list = new ArrayList<>();
        list.add(new Transaction(1, 10.5, "10:00"));
        list.add(new Transaction(2, 25.0, "09:30"));
        list.add(new Transaction(3, 5.0, "10:15"));

        bubbleSort(list);

        for (Transaction t : list) {
            System.out.println(t.id + " -> " + t.fee);
        }
    }
}