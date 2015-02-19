package genetic;

/**
 * Created by olivermd on 19/02/15.
 */
abstract class Chromosome<T> {

    private float fitness;

    public Chromosome(float fitness) {
        this.fitness = fitness;
    }

    /**
     * Get the value of the chromosome
     * @return <T>
     */
    public abstract T getValue();

    /**
     * Returns the fitness of the chromosome
     * @return float
     */
    public abstract float getFitness();

    public abstract Chromosome<T> crossover(Chromosome<T> partner);

    protected void setFitness(float fitness) {
        this.fitness = fitness;
    }


}
