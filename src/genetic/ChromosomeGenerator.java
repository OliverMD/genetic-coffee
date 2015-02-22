package genetic;

import java.util.ArrayList;

/**
 * Created by oliver on 22/02/15.
 */
public interface ChromosomeGenerator {
    public ArrayList<Chromosome<?>> generateChromosomes(int size, int length);
}
