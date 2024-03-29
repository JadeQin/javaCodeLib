package topCoder.srm476;

/**
 * Problem Statement      Badgers are lovely furry animals, and Manao has just
 * decided to start keeping a few. The pet shop has offered him N badgers, and
 * they are all so cute that Manao wants to take as many as he can feed.
 * Normally, a badger needs some amount of food per day to be satisfied.
 * However, if he sees other badgers eating, his greed awakens and he wants to
 * eat more. A badger will want a fixed additional amount of food for each
 * co-eater. You're given int[]s hunger and greed, both containing N elements.
 * The i-th element of hunger is the number of units of food that the i-th
 * badger needs per day if he's alone. The i-th element of greed is the amount
 * of additional units of food the i-th badger will need for each co-eater.
 * Return the maximum number of badgers Manao can take while keeping them all
 * satisfied if he can supply no more than totalFood units of food per day.
 * Definition      Class: Badgers Method: feedMost Parameters: int[], int[], int
 * Returns: int Method signature: int feedMost(int[] hunger, int[] greed, int
 * totalFood) (be sure your method is public)     
 * 
 * Constraints - hunger will contain between 1 and 50 elements, inclusive. -
 * greed will contain the same number of elements as hunger. - Each element of
 * hunger will be between 1 and 1000, inclusive. - Each element of greed will be
 * between 0 and 1000, inclusive. - totalFood will be between 1 and 1000000,
 * inclusive. Examples 0)
 * 
 *      {1,2,3} {2,2,1} 7 Returns: 2 Manao can take badger 0 and one of the
 * other two badgers. 1)
 * 
 *      {5,2,1,5} {0,2,4,1} 19 Returns: 3 Badger 2 is too greedy, but the rest
 * can be fed together and will only need (5 + 2 * 0) + (2 + 2 * 2) + (5 + 2 *
 * 1) = 18 units of food. 2)
 * 
 *      {1,1,1,1,1} {1000,1000,1000,1000,1000} 10 Returns: 1 They are too greedy
 * to eat together. 3)
 * 
 *      {1,2,3,4,5,6,7,8,9,10} {10,9,8,7,6,5,4,3,2,1} 100 Returns: 5
 * 
 * @author AAA
 * 
 */

public class Badgers {

	public int feedMost(int[] hunger, int[] greed, int totalFood) {
		return 0;
	}
}
