package genetic;

/**
 * Created by oliver on 19/02/15.
 */
public interface Tester<T> {
    public void runTest(int numberOfGenerations, FitnessFunction<T> fitnessFunction);
    public T getBestChromosome();

}
