package genetic;

/**
 * Created by oliver on 19/02/15.
 */
public interface FitnessFunction<T> {
    public float fitnessFunction(Chromosome<T> chromosome);
}
