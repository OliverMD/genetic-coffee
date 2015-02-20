package genetic;

import java.util.ArrayList;

/**
 * Created by oliver on 19/02/15.
 */
public interface Tester {
    public void runTest(int numberOfGenerations, FitnessFunction fitnessFunction);
    public Chromosome<?> getBestChromosome();
    public void setPopulation(ArrayList<Chromosome<?>> newPopulation);
    public ArrayList<Chromosome<?>> getPopulation();

}
