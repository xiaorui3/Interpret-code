package 代码解释.数组解释;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

public class 新增方法JDK8 {
    /**
     *  1）oid parallelPrefix(xxx[] array, XxxBinaryOperator op)
     *     该方法使用 op 参数指定的计算公式计算得到的结果作为新的元素。op 计算公式包括 left、right 两个形参，其中 left 代表数组中前一个索引处的元素，
     *     right 代表数组中当前索引处的元素，当计算第一个新数组元素时，left 的值默认为 1。
     *             2）void parallelPrefix(xxx[] array, int fromIndex, int toIndex, XxxBinaryOperator op)
     *     该方法与上一个方法相似，区别是该方法仅重新计算 fromIndex 到 toIndex 索引的元素。
     *             3）void setAll(xxx[] array, IntToXxxFunction generator)
     *     该方法使用指定的生成器（generator）为所有数组元素设置值，该生成器控制数组元素的值的生成算法。
     *             4）void parallelSetAll(xxx[] array, IntToXxxFunction generator)
     *     该方法的功能与上一个方法相同，只是该方法增加了并行能力，可以利用多 CPU 并行来提高性能。
     *             5）void parallelSort(xxx[] a)
     *     该方法的功能与 Arrays 类以前就有的 sort() 方法相似，只是该方法增加了并行能力，可以利用多 CPU 并行来提高性能。
     *             6）void parallelSort(xxx[] a，int fromIndex, int toIndex)
     *     该方法与上一个方法相似，区別是该方法仅对 fromIndex 到 toIndex 索引的元素进行排序。
     *             7）Spliterator.OfXxx spliterator(xxx[] array)
     *     将该数组的所有元素转换成对应的 Spliterator 对象。
     *             8）Spliterator.OfXxx spliterator(xxx[] array, int startInclusive, int endExclusive)
     *     该方法与上一个方法相似，区别是该方法仅转换 startInclusive 到 endExclusive 索引的元素。
     *             9）XxxStream stream(xxx[] array)
     *     该方法将数组转换为 Stream，Stream 是 Java 8 新增的流式编程的 API。
     *             10）XxxStream stream(xxx[] array, int startInclusive, int endExclusive)
     *     该方法与上一个方法相似，区别是该方法仅将 fromIndex 到 toIndex 索引的元索转换为 Stream。
     *
     *     上面方法列表中，所有以 parallel 开头的方法都表示该方法可利用 CPU 并行的能力来提高性能。上面方法中的 xxx 代表不同的数据类型，
     *     比如处理 int[] 型数组时应将 xxx 换成 int，处理 long[] 型数组时应将 XXX 换成 long。
     * @param args
     */
    public static void main(String[] args) {
        int[] arr1 = new int[] { 3, 4, 25, 16, 30, 18 };
        // 对数组arr1进行并发排序
        Arrays.parallelSort(arr1);
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = new int[] { 13, -4, 25, 16, 30, 18 };
        Arrays.parallelPrefix(arr2, new IntBinaryOperator() {
            // left 代表数组中前一个索引处的元素，计算第一个元素时，left为1
            // right代表数组中当前索引处的元素
            public int applyAsInt(int left, int right) {
                return left * right;
            }
        });
        System.out.println(Arrays.toString(arr2));
        int[] arr3 = new int[5];
        Arrays.parallelSetAll(arr3, new IntUnaryOperator() {
            // operand代表正在计算的元素索引
            public int applyAsInt(int operand) {
                return operand * 5;
            }
        });
        System.out.println(Arrays.toString(arr3));
    }
}
