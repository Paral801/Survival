import cosc343.assig2.Creature;
import java.util.Random;

/**
* The MyCreate extends the cosc343 assignment 2 Creature.  Here you implement
* creatures chromosome and the agent function that maps creature percepts to
* actions.
*
* @author Alfred J Pardoe 7150195
* @version 1.0
* @since   2017-04-05
*/
public class MyCreature extends Creature {
  Random rand = new Random(); // Random number generator
  private int[] chromosone = new chromosome[9];

  //Constructor initialises chromosomes to states
  public MyCreature(int numPercepts, int numActions) {
    for(int x = 0; x < numPercepts; x++){
      chromosome[x] = rand.nextInt(10);
    }
    int this.numActions = 9;
  }

  //Function that reads information and makes decisions for each creature
  //on what action to take based on its percepts information
  //Returns Array of those actions laid out
  @Override
  public float[] AgentFunction(int[] percepts, int numPercepts, int numExpectedActions) {

      for(int x = 0; x < numPercepts; x++){
        if(percept[4] == 1 || percept[4] == 2){
          int ch = 0;
          if(percept[4] ==1){//if green
            ch = rand.nextInt(50) + 50;
          }else{
            ch = rand.nextInt(50);
          }

          if(getEnergy() > 100){
            if(ch > rand.nextInt(50)){
              actions[9] == 1;
            }
          }else if(getEnergy() > 50 && getEnergy() < 100){
            if(ch > rand.nextInt(25) + 50){
              actions[9] == 1;
            }
          }else if(getEnergy() > 0 && getEnergy() > 50){
            if(ch > rand.nextInt(75)){
              actions[9] == 1;
            }
          }
          actions[9] == 0;
        }

        if(percepts[x] == 3){//food
          actions[x] =  (rand.nextInt(2) + 5) * chromosome[x];
        }else if(percepts[x] == 2){//creature
          actions[x] =  (rand.nextInt(2) + 3) * chromosome[x];
        }else if(percepts[x] == 1){//monster
          actions[x] =  rand.nextInt(2) * chromosome[x];
          actions[8 - x] = rand.nextInt(2) + 8 * chromosome[x];
        }else{//empty
          actions[x] =  rand.nextInt(2) + 8 * chromosome[x];
        }
      }//end for

      return actions;
  }//end AgentFunction

}
