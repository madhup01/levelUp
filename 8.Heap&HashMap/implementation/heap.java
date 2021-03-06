import java.util.ArrayList;

public class heap {

    private ArrayList<Integer> arr;
    private boolean isMaxHeap = true; //by default max heap

    void constructHeap() { // O(nLogn) (n for array taversal O(log n) for downheapify) -> O(n) //---- proof in copy ---- ///
        for (int i = arr.size() - 1; i >= 0; i--) {
            downHeapify(i);
        }
    }

    void defaultValue(boolean isMaxHeap) {
        this.arr = new ArrayList<>();
        this.isMaxHeap = isMaxHeap;
    }

    heap() {
        defaultValue(true);//ek ek kar ke element to dalana in heap but heap is of max type
    }

    heap(boolean isMaxHeap) {
        defaultValue(isMaxHeap);//ek ek kar ke element to dalana in heap but of min/max type
    }

    heap(int[] arr, boolean isMaxHeap) {
        defaultValue(isMaxHeap);//given array to heap me convert karna

        for (int ele : arr)
            this.arr.add(ele);//copy values in arraylist

        constructHeap();
    }

    int size() {
        return this.arr.size();
    }

    boolean isEmpty() {
        return this.arr.size() == 0;

    }

    void add(int data) { // O(logn)
        this.arr.add(data);
        int n = this.arr.size();

        upHeapify(n - 1);
    }

    int remove() { // O(Logn)
        int rEle = arr.get(0);

        int n = this.arr.size();
        swap(0, n - 1);
        this.arr.remove(n - 1);

        downHeapify(0);
        return rEle;
    }

    int top() { // O(1)
        return this.arr.get(0);
    }

    private void swap(int i, int j) { // O(1)
        int temp = this.arr.get(i);
        this.arr.set(i, this.arr.get(j));
        this.arr.set(j, temp);
    }

    private void downHeapify(int pi) { // O(logn)
        int maxIdx = pi;
        int lci = 2 * pi + 1;
        int rci = 2 * pi + 2;

        if (lci < arr.size() && this.arr.get(lci) > this.arr.get(maxIdx))
            maxIdx = lci;

        if (rci < arr.size() && this.arr.get(rci) > this.arr.get(maxIdx))
            maxIdx = rci;

        if (maxIdx != pi) {
            swap(pi, maxIdx);
            downHeapify(maxIdx);
        }
    }
    private void upHeapify(int ci) { // O(logn)
        int pi = (ci - 1) / 2;

        if (pi >= 0 && compareTo(ci, pi)) {
            swap(pi, ci);
            upHeapify(pi);
        }
    }
}

// int[] arr2 = { 10, 20, 30, -2, -3, -4, 5, 6, 7, 8, 9, 22, 11, 13 };
