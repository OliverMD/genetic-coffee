package genetic;

import java.util.List;
import java.util.Random;
import java.util.Vector;

/**
 * Created by oliver on 20/02/15.
 */
public class ConcreteChromosome<T> implements Chromosome<T> {

    private int length;
    protected Vector<T> data;
    private Random random;
    private float mutateAmount;
    private float fitness;

    public ConcreteChromosome(Vector<T> data) {
        this.data = data;
        this.length = data.size();
        this.random = new Random();
        this.mutateAmount = 0.125f;
        this.fitness = Float.MAX_VALUE;
    }


    @Override
    public float getFitness() {
        return this.fitness;
    }

    @Override
    public void setFitness(float fitness) {
        this.fitness = fitness;
    }

    @Override
    public Vector<T> getValue() {
        return this.data;
    }

    @Override
    public void setValue(Vector<T> value) {
        this.data = value;
    }

    public void mutate(float rate) {
        if (this.random.nextFloat() < rate){
            //Mutate
            for (int i = 0; i < this.length; i++){
                //Swap 25% of elements with each other.
                if (this.random.nextFloat() > this.mutateAmount){
                    T temp = this.data.get(i);
                    this.data.set(i, this.data.get(this.length - i - 1));
                    this.data.set(this.length - i - 1, temp);
                }
            }
        }

    }

    public Chromosome<T> crossover(ConcreteChromosome<T> partner) {
        Vector<T> newData = new Vector<>();
        for (int i = 0; i < Math.min(this.length, partner.getLength()); i++){
            if (this.random.nextFloat() < 0.5f){
                newData.add(this.data.get(i));
            } else {
                newData.add(partner.data.get(i));
            }
        }

        return new ConcreteChromosome<T>(newData);
    }

    @Override
    public int getLength() {
        return this.length;
    }
}
