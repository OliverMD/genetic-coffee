package genetic;

import java.util.ArrayList;

/**
 * Created by oliver on 19/02/15.
 */
public abstract class AbstractTester<T> implements Tester<T> {

    private ArrayList<T> chromosomes;
    private final int guid;
    private final int chromosomeLength;

    public AbstractTester(T rawValue, ArrayList<T> chromosomes, int guid, int chromosomeLength) {
        this.chromosomes = chromosomes;
        this.chromosomeLength = chromosomeLength;
        this.guid = guid;
    }


    @Override
    public void runTest(int numberOfGenerations, FitnessFunction<T> fitnessFunction) {
        //For every chromsome in chromosomes, run fitnessFunction

    }

    @Override
    public T getBestChromosome() {
        return this.chromosomes.get(0);
    }
}
