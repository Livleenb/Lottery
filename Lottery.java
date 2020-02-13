package proj3sp17;
import java.util.Random;
/**
 * <p>Title: The Lottery Class</p>
 *
 * <p>Description: This class will implement the methods written in the LinkedSet 
 * class to create sets with random generated numbers for the CSC Lotto games. 
 * It will also store the players numbers in a set as well. This class will 
 * determine if the player has win or lost the game.</p>
 *
 * @author Livleen Bhullar
 */

public class Lottery {
	//instance variables
	protected LinkedSet<Integer> pick3Set;
	protected LinkedSet<Integer> lotto54;
	protected LinkedSet<Integer> crazyLotto;
	protected LinkedSet<Integer> playerNum;
	protected LinkedSet<Integer> playerNum2;
	protected LinkedSet<Integer> playerNum3;
	private Random rand;
	private int supplementaryNum;

	/**
	 * default Lottery constructor - initializes
	 * the instance variables
	 * 
	 */
	public Lottery()
	{
		rand = new Random();
		pick3Set = new LinkedSet<Integer>();
		lotto54 = new LinkedSet<Integer>();
		crazyLotto = new LinkedSet<Integer>();
		playerNum = new LinkedSet<Integer>();
		playerNum2 = new LinkedSet<Integer>();
		playerNum3 = new LinkedSet<Integer>();
		supplementaryNum = 0;
	}

	/**
	 * compPick3 method - this method generates unique numbers for the pick3
	 * game, 
	 * @return - LinkedSet - a set with unique generated numbers  
	 */
	public LinkedSet<Integer> compPick3()
	{
		//generating random numbers 
		int num;
		for(int i = 0; i < 3; i++)
		{
			num = rand.nextInt(10);
			if(pick3Set.isEmpty())
			{
				pick3Set.add(num);
			}
			else if(pick3Set.contains(num) == true)
			{
				while(!pick3Set.contains(num))
				{
					num = rand.nextInt(10);
				}
				pick3Set.add(num);
			}
			else
				pick3Set.add(num);
		}
		return pick3Set;
	}

	/**
	 * pick3 method - this method adds elements to the playerNum set and
	 * determines if the player won or lost using the intersection method
	 * @param - elements that are being added to the set 
	 * @return - String - string containing the winning and players numbers
	 * and if the player won or lost
	 */
	public String pick3(int num1, int num2, int num3)
	{
		LinkedSet<Integer> win = new LinkedSet<Integer>();
		LinkedSet<Integer> player = new LinkedSet<Integer>();
		//adding user input to player set 
		player.add(num1);
		player.add(num2);
		player.add(num3);
		win = pick3Set.intersection(playerNum);
		//determining win or loss 
		if(win.size() == 3)
			return "Your numbers" + player.toString() + "\nWinning numbers:"
			+ pick3Set.toString() + "\nYou won the game!";
		else
			return "Your numbers" + player.toString() + "\nWinning numbers:"
			+ pick3Set.toString() + "\nYou lost the game.";
	}

	/**
	 * compLotto54 method - this method generates unique numbers for the lotto54
	 * game, 
	 * @return - LinkedSet - a set with unique generated numbers  
	 */
	public LinkedSet<Integer> compLotto54()
	{
		//generating random numbers for set
		int num;
		supplementaryNum = rand.nextInt(54) + 1;
		for(int i = 0; i < 6; i++)
		{
			num = rand.nextInt(54) + 1;
			if(lotto54.isEmpty())
			{
				lotto54.add(num);
			}
			else if (lotto54.contains(num) == true && 
					lotto54.contains(supplementaryNum) == true)
			{
				while(!lotto54.contains(num))
				{
					num = rand.nextInt(10);
				}
				lotto54.add(num);
			}
			else
				lotto54.add(num);
		}
		return lotto54;
	}
	/**
	 * lotto54 method - this method adds elements to the playerNum2 set and
	 * determines if the player won or lost using the intersection method
	 * @param - elements that are being added to the set 
	 * @return - String - string containing the winning and players numbers
	 * and if the player won or lost
	 */
	public String lotto54(int num1, int num2, int num3, 
			int num4, int num5, int num6)
	{
		LinkedSet<Integer> win = new LinkedSet<Integer>();
		//adding user numbers to set 
		playerNum2.add(num1);
		playerNum2.add(num2);
		playerNum2.add(num3);
		playerNum2.add(num4);
		playerNum2.add(num5);
		playerNum2.add(num6);
		win = lotto54.intersection(playerNum2);
		//determining win or loss 
		if(win.size() == 3 && playerNum2.contains(supplementaryNum))
			return "Your numbers " + playerNum2.toString() + "\nWinning numbers: " +
			lotto54.toString() + "\nYou got 4th Place!";
		else if (win.size() == 4)
			return "Your numbers " + playerNum2.toString() + "\nWinning numbers: " +
			lotto54.toString() + "\nYou got 3rd Place!";
		else if(win.size() == 5)
			return "Your numbers " + playerNum2.toString() + "\nWinning numbers: " +
			lotto54.toString() + "\nYou got 2nd Place!";
		else if (win.size() == 6)
			return "Your numbers " + playerNum2.toString() + "\nWinning numbers: " +
			lotto54.toString() + "\nYou got 1st Place!!";
		else
			return "Your numbers " + playerNum2.toString() + "\nWinning numbers: " +
			lotto54.toString() + "\nYou lost the game.";
	}
	/**
	 * compCrazyLotto method - this method generates unique numbers for the
	 * crazy/mixed up lotto game
	 * @return - LinkedSet - a set with unique generated numbers  
	 */
	public LinkedSet<Integer> compCrazyLotto()
	{
		//generating random numbers for set 
		int num;
		for(int i = 0; i < 6; i++)
		{
			num = rand.nextInt(25) + 1;
			if(crazyLotto.isEmpty())
			{
				crazyLotto.add(num);
			}
			else if(crazyLotto.contains(num) == true)
			{
				while(!crazyLotto.contains(num))
				{
					num = rand.nextInt(25) + 1;
				}
				crazyLotto.add(num);
			}
			else
				crazyLotto.add(num);
		}
		return crazyLotto;
	}

	/**
	 * crazyLotto method - this method adds elements to the playerNum3 set and
	 * determines if the player won or lost using the difference method
	 * @param - elements that are being added to the set 
	 * @return - String - string containing the winning and players numbers
	 * and if the player won or lost
	 */
	public String crazyLotto(int num1, int num2, int num3, 
			int num4, int num5, int num6)
	{
		//adds numbers to player sets 
		LinkedSet<Integer> win = new LinkedSet<Integer>();
		playerNum3.add(num1);
		playerNum3.add(num2);
		playerNum3.add(num3);
		playerNum3.add(num4);
		playerNum3.add(num5);
		playerNum3.add(num6);
		win = crazyLotto.difference(playerNum3);
		//determining the win or loss 
		if(win.size() == 4)
			return "Your numbers " + playerNum3.toString() + "\nWinning numbers: " +
			crazyLotto.toString() + "\nYou got 3rd Place!";
		else if(win.size() == 5)
			return "Your numbers " + playerNum3.toString() + "\nWinning numbers: " +
			crazyLotto.toString() + "\nYou got 2nd Place!";
		else if (win.size() == 6)
			return "Your numbers " + playerNum3.toString() + "\nWinning numbers: " +
			crazyLotto.toString() + "\nYou got 1st Place!";
		else
			return "Your numbers " + playerNum3.toString() + "\nWinning numbers: " +
			crazyLotto.toString() + "\nYou lost the game.";
	}
}
