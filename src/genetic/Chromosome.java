package genetic;

import java.util.List;
import java.util.Vector;

/**
 * Created by oliver on 20/02/15.
 */
public interface Chromosome<T> {
    public float getFitness();
    public void setFitness(float fitness);
    public Vector<T> getValue();
    public void setValue(Vector<T> value);
    public Chromosome<T> crossover(Chromosome<?> partner);
    public Chromosome<T> mutate(float rate);

    public int getLength();
}
