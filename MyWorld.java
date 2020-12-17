import cosc343.assig2.World;
import cosc343.assig2.Creature;
import java.util.*;

/**
* The MyWorld extends the cosc343 assignment 2 World.  Here you can set
* some variables that control the simulations and override functions that
* generate populations of creatures that the World requires for its
* simulations.
*
* @author Alfred J Pardoe 7150195
* @version 1.0
* @since   2017-04-05
*/
public class MyWorld extends World {

  /* Here you can specify the number of turns in each simulation
   * and the number of generations that the genetic algorithm will
   * execute.
  */
  private final int _numTurns = 100;
  private final int _numGenerations = 500;

  /* Constructor.

     Input: griSize - the size of the world
            windowWidth - the width (in pixels) of the visualisation window
            windowHeight - the height (in pixels) of the visualisation window
            repeatableMode - if set to true, every simulation in each
                             generation will start from the same state
            perceptFormat - format of the percepts to use: choice of 1, 2, or 3
  */
  public MyWorld(int gridSize, int windowWidth, int windowHeight, boolean repeatableMode, int perceptFormat) {
      // Initialise the parent class - don't remove this
      super(gridSize, windowWidth,  windowHeight, repeatableMode, perceptFormat);
      // Set the number of turns and generations
      this.setNumTurns(_numTurns);
      this.setNumGenerations(_numGenerations);
  }

  /* The main function for the MyWorld application*/
  public static void main(String[] args) {
     int gridSize = 24;
     int windowWidth =  1600;
     int windowHeight = 900;
     boolean repeatableMode = true;

     int perceptFormat = 3;

     MyWorld sim = new MyWorld(gridSize, windowWidth, windowHeight, repeatableMode, perceptFormat);
  }//end main method


  /* The MyWorld class must override this function, which is
     used to fetch a population of creatures at the beginning of the
     first simulation.  This is the place where you need to  generate
     a set of creatures with random behaviours.

     Input: numCreatures - this variable will tell you how many creatures
                           the world is expecting

     Returns: An array of MyCreature objects - the World will expect numCreatures
              elements in that array
  */
  @Override
  public MyCreature[] firstGeneration(int numCreatures) {

    int numPercepts = this.expectedNumberofPercepts();
    int numActions = this.expectedNumberofActions();

    // This is just an example code.  You may replace this code with
    // your own that initialises an array of size numCreatures and creates
    // a population of your creatures
    MyCreature[] population = new MyCreature[numCreatures];
    for(int i = 0; i < numCreatures; i++) {
        population[i] = new MyCreature(numPercepts, numActions);
    }
    return population;
  }

  public int fitnessLevel(MyCreature creatue){
    int fitness = 0;
    if (creature.getEnergy() >= 33 && creature.getEnergy() < 66){
      fitness += 1;
    }else if(creature.getEnergy() >= 66){
      fitness += 2;
    }
    if(!creature.isDead()){
      fitness += 1;
    }
    if(creature.timeOfDeath() > 33 && creature.timeOfDeath() < 66){
      fitness += 1;
    }else if(creature.timeOfDeath() > 66){
      fitness += 2;
    }
    return fitness;
    //determines the fitness value of the creature between 1 and 10
  }

  /* The MyWorld class must override this function, which is
     used to fetch the next generation of the creatures.  This World will
     proivde you with the old_generation of creatures, from which you can
     extract information relating to how they did in the previous simulation...
     and use them as parents for the new generation.

     Input: old_population_btc - the generation of old creatures before type casting.
                              The World doesn't know about MyCreature type, only
                              its parent type Creature, so you will have to
                              typecast to MyCreatures.  These creatures
                              have been simulated over and their state
                              can be queried to compute their fitness
            numCreatures - the number of elements in the old_population_btc
                           array


  Returns: An array of MyCreature objects - the World will expect numCreatures
           elements in that array.  This is the new population that will be
           use for the next simulation.
  */
  @Override
  public MyCreature [] nextGeneration(Creature[] old_population_btc, int numCreatures) {
    // Typcast old_population of Creatures to array of MyCreatures
     MyCreature [] old_population = (MyCreature[]) old_population_btc;
     // Create a new array for the new population
     MyCreature [] new_population = new MyCreature[numCreatures];

     float avgLifeTime = 0f;
     int nSurvivors = 0;
     int needed = numCreatures;
     int fitness;

     for(MyCreature creature : old_population){
       if(creature.isDead()){
         int timeOfDeath = creature.timeOfDeath();
         avgLifeTime += (float) timeOfDeath;
         int myFitness = fitnessLevel(creature);
         if(myFitness > 0 && myFitness < 2){

         }else if(myFitness > 2 && myFitness <= 4){

         }else if(myFitness == 5){

         }
       }else{
         nSurvivors += 1;
         avgLifeTime += (float) _numTurns;
         int myFitness = fitnessLevel(creature);
         if(myFitness > 0 && myFitness < 2){

         }else if(myFitness > 2 && myFitness <= 4){

         }else if(myFitness == 5){

         }
       }
     }

     //creates new creatures to fill up new population of non survivors
     for(int i = (numCreatures - needed); i < needed; i++) {
        new_population[i] = old_population[i];
     }

     //Fitness information
     avgLifeTime /= (float) numCreatures;
     System.out.println("Simulation stats:");
     System.out.println("  Survivors    : " + nSurvivors + " out of " + numCreatures);
     System.out.println("  Avg life time: " + avgLifeTime + " turns");

     // Return new population of cratures.
     return new_population;
  }

}
