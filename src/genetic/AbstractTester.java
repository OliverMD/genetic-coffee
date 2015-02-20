package genetic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by oliver on 19/02/15.
 */
public abstract class AbstractTester implements Tester {

    private ArrayList<Chromosome<?>> chromosomes;
    private final int chromosomeLength;

    public AbstractTester( ArrayList<Chromosome<?>> chromosomes, int chromosomeLength) {
        this.chromosomes = chromosomes;
        this.chromosomeLength = chromosomeLength;
    }


    @Override
    public void runTest(int numberOfGenerations, FitnessFunction fitnessFunction) {
        //For every chromosome in chromosomes, run fitnessFunction
        for (int i = 0; i < numberOfGenerations; i++){
            for (int j = 0; j < this.chromosomes.size();j++){
                this.chromosomes.get(j).setFitness(fitnessFunction.fitnessFunction(this.chromosomes.get(j)));
            }
            Collections.sort(this.chromosomes, new Comparator<Chromosome<?>>() {
                @Override
                public int compare(Chromosome<?> chromosome, Chromosome<?> t1) {
                    return Math.round(chromosome.getFitness()) - Math.round(t1.getFitness());
                }
            });
            /* TODO:
            * Add crossover and fitness logic.
            * Add mutator logic
            *
            * */
        }

    }

    @Override
    public Chromosome<?> getBestChromosome() {
        return this.chromosomes.get(0);
    }

    @Override
    public void setPopulation(ArrayList<Chromosome<?>> newPopulation) {
        this.chromosomes = newPopulation;
    }

    @Override
    public ArrayList<Chromosome<?>> getPopulation() {
        return this.chromosomes;
    }
}
