package line;

/**
 * @Author zhihongShee
 * @Date 2025/6/16 下午9:50
 * @Version 1.0
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = new int[]{0,1,2,3,4,4,4,5,6,6,6};
        int target = new BinarySearch().findTarget01(array, 6);
//        System.arraycopy();
        System.out.println(target);
    }

    // 自己版本
    public int findTarget(int[] array, int target) {
        int left = 0;
        // 要不要减1 ? 如果二分到最后一个值，这里不就溢出了
        int right = array.length - 1;
        while (left < right) {
            // 重点体会，注意这里需要加left，而不是直接(right - left) / 2，因为这里是数组的下标索引
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        // 这里也需要重点体会
        if (left == right && array[left] == target) {
            return left;
        }
        return -1;
    }

    // 优化版本
    public int findTarget01(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        // 注意这里的小于等于，这里为何要考虑小于等于的情况，因为如果left和right相等，
        // 并且这个值恰好就是要寻找的值，这里就有问题
        while (left <= right) {
            // 重点体会
//            int mid = (right + left) / 2;
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return -1;
    }

    // [0,1,2,3,4,4,4,5,6] 返回4中最左侧的数，找不到返回-1
    // leftmost
    public int findTarget02(int[] array, int target){
        int left = 0;
        int right = array.length - 1;
        // 注意这里的小于等于，这里为何要考虑小于等于的情况，因为如果left和right相等，
        // 并且这个值恰好就是要寻找的值，这里就有问题
        int candidate = -1;
        while (left <= right) {
            // 重点体会
//            int mid = (right + left) / 2;
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                candidate = mid;
                right = mid - 1;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return candidate;
    }


    // 二分查找15～17

}
