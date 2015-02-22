package tests.genetic;

import genetic.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

/**
 * Created by oliver on 19/02/15.
 */
public class GeneralTest {


    public FitnessFunction fitFunc;
    public Tester tester;

    @Test
    public void thisShouldAlwaysPass(){
        return;
    }
    @Test
    public void createConcreteChromosome(){
        Chromosome<Float> testChromo = new ConcreteChromosome<>(new Vector<>(10));
        testChromo.getLength();
    }
    @Test
    public void createFitnessFunction(){

        this.fitFunc = chromosome -> {
            float total = 0.0f;
            Vector data = chromosome.getValue();
            for(int i = 0; i < data.size(); i++){
                total = total + (Float) data.get(i);
            }
            return total;
        };
    }
    @Test
    public void createTester(){
        ChromosomeGenerator gen = new ConcreteGenerator();
        this.tester = new ConcreteTester(gen.generateChromosomes(10,10));
    }
    @Test
    public void runTest(){
        this.createTester();
        this.createFitnessFunction();
        this.tester.runTest(3, this.fitFunc);
        this.tester.getBestChromosome();
    }
}
