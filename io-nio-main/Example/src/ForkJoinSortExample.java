import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ForkJoinPool;
import java.util.Arrays;

public class ForkJoinSortExample {

    static class SortTask extends RecursiveAction {
        private final int[] array;
        private final int start;
        private final int end;
        private static final int THRESHOLD = 10;

        public SortTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (end - start <= THRESHOLD) {
                // Сортируем напрямую, если задача маленькая
                Arrays.sort(array, start, end);
            } else {
                // Разделяем задачу
                int mid = (start + end) / 2;
                SortTask leftTask = new SortTask(array, start, mid);
                SortTask rightTask = new SortTask(array, mid, end);

                invokeAll(leftTask, rightTask); // Запускаем обе подзадачи
                merge(array, start, mid, end); // Сливаем результаты
            }
        }

        private void merge(int[] array, int start, int mid, int end) {
            int[] temp = new int[end - start];
            int i = start, j = mid, k = 0;
            while (i < mid && j < end) {
                temp[k++] = (array[i] <= array[j]) ? array[i++] : array[j++];
            }
            while (i < mid) {
                temp[k++] = array[i++];
            }
            while (j < end) {
                temp[k++] = array[j++];
            }
            System.arraycopy(temp, 0, array, start, temp.length);
        }
    }

    public static void main(String[] args) {
        int[] array = { 5, 8, 2, 9, 1, 7, 4, 6, 3 };
        ForkJoinPool pool = new ForkJoinPool();

        SortTask task = new SortTask(array, 0, array.length);
        pool.invoke(task);


        System.out.println("Отсортированный массив: " + Arrays.toString(array));
    }
}