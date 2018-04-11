package lambdasinaction.chap7;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

import static lambdasinaction.chap7.ParallelStreamsHarness.FORK_JOIN_POOL;

public class ForkJoinSumCalculator extends RecursiveTask<Long> {

    public static final long THRESHOLD = 10_000;

    private final long[] numbers;
    private final int start;
    private final int end;

    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    private ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD) {
            return computeSequentially();
        }
        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length/2);
        leftTask.fork();
        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length/2, end);
        Long rightResult = rightTask.compute(); //右分支在当前线程中计算；当然右分枝也会进行再次分支。
        Long leftResult = leftTask.join();
        return leftResult + rightResult;
    }

    private long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    public static long forkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        return FORK_JOIN_POOL.invoke(task);
    }
}