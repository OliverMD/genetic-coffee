package genetic;

import java.util.*;

/**
 * Created by oliver on 19/02/15.
 */
public class ConcreteTester implements Tester {

    private ArrayList<Chromosome<?>> chromosomes;
    private final Random random;

    public ConcreteTester(ArrayList<Chromosome<?>> chromosomes) {
        this.chromosomes = chromosomes;
        random = new Random();
    }


    @Override
    public void runTest(int numberOfGenerations, FitnessFunction fitnessFunction) {
        //For every chromosome in chromosomes, run fitnessFunction
        int i = 0;
        while (i < numberOfGenerations) {

            //Go through and crossover chromosomes
            for (int i1 = 0; i1 < this.chromosomes.size(); i1++) {
                Chromosome<?> chromosome = this.chromosomes.get(i1);
                this.chromosomes.set(i1, chromosome.crossover(this.chromosomes.get(Math.abs(random.nextInt()) % (this.chromosomes.size()-1))).mutate(0.5f));
            }

            for (Chromosome<?> chromosome2 : this.chromosomes) {
                chromosome2.setFitness(fitnessFunction.fitnessFunction(chromosome2));
            }
            Collections.sort(this.chromosomes, new Comparator<Chromosome<?>>() {
                @Override
                public int compare(Chromosome<?> chromosome, Chromosome<?> t1) {
                    return Math.round(chromosome.getFitness()) - Math.round(t1.getFitness());
                }
            });
            //Sum the fitness
            float fitnessSum = 0.0f;
            for (Chromosome<?> chromosome1 : this.chromosomes) {
                fitnessSum += chromosome1.getFitness();
            }
            //Change fitness to normalized fitness
            for (Chromosome<?> chromosome : this.chromosomes) {
                chromosome.setFitness(chromosome.getFitness() / fitnessSum);
            }
            i++;
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
