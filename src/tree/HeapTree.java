package tree;

/**
 * @Author zhihongShee
 * @Date 2025/6/17 下午11:51
 * @Version 1.0
 */
public class HeapTree {
    public static void main(String[] args) {

    }

    /**
     * 小顶堆： 父节点 小于等于 子节点值
     */
    class MinHeap {

    }

    /**
     * 大顶堆： 父节点 大于等于 子节点值
     */
    class MaxHeap {
        private int[] tree;

        private int currentLen;

        private int capacity;

        public MaxHeap(int capacity) {
            this.capacity = capacity;
            this.currentLen = 0;
            tree = new int[capacity];
        }

        /**
         * 插入
         */
        private void insert(int value) {
            if (currentLen > capacity) {
                throw new RuntimeException("");
            }
            tree[currentLen] = value;
            this.currentLen++;
            heapIfUp(currentLen);
        }

        private void heapIfUp(int index) {
            int parent = parent(index);
            while (index > 0 && tree[parent] < tree[index]) {
                swap(parent, index);
                index = parent;
                parent = parent(index);
            }
        }

        /**
         * 返回最大值
         */
        private int pop() {
            if (currentLen == 0) {
                throw new RuntimeException("Heap is empty");
            }
            int max = tree[0];
            tree[0] = tree[currentLen]; // 最后一个叶子节点，移动到父节点，保持一个完全二叉树
            currentLen--;
            heapIfDown(0);
            return max;
        }

        private void heapIfDown(int index) {
            if (index == capacity) {
                return;
            }
            int value = tree[index];
            int left = leftChild(index);
            int right = rightChild(index);
            if (tree[left] > value) {
                swap(index, left);
                index = left;
                heapIfDown(index);
            } else {
                swap(index, right);
                index = right;
                heapIfDown(index);
            }
        }

        private void swap(int index, int parent) {
            int temp = tree[index];
            tree[index] = tree[parent];
            tree[parent] = temp;
        }

        private int parent(int index) {
            return (index - 1) / 2;
        }

        private int leftChild(int index) {
            return index * 2 + 1;
        }

        private int rightChild(int index) {
            return index * 2 + 2;
        }
    }
}
