package genetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Vector;

/**
 * Created by oliver on 22/02/15.
 */
public class ConcreteGenerator implements ChromosomeGenerator {

    private Random random;
    public ConcreteGenerator() {
        this.random = new Random();
    }

    @Override
    public ArrayList<Chromosome<?>> generateChromosomes(int size, int length) {
        ArrayList<Chromosome<?>> ret = new ArrayList<>();
        for (int i = 0; i < size; i++){
            Vector<Float> data  = new Vector<Float>();
            for(int j = 0; j < length; j++){
                data.add(this.random.nextFloat());
            }
            ret.add(new ConcreteChromosome<>(data));
        }

        return ret;
    }
}
