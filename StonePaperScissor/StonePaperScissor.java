import java.util.Scanner;
import java.util.Random;
import java.io.*;

class Player
{
	final String name;
	int score;

	Player(String n)
	{
		this.name = n;
		this.score = 0;
	}

	public void updateScore()
	{
		++this.score;
	}

	public String toString()
	{
		return (  this.name + " :     \t" + this.score  );
	}
}

class Game
{
	Game()
	{
		System.out.println("New Game has been created..........");
	}

	void playgame()
	{
		Scanner scan = new Scanner(System.in);
		Random random = new Random(3);

		System.out.println("Starting game......");
		System.out.print("Enter your name(No space allowed):   ");
		String name = scan.next();
		Player P1 = new Player(name);
		Player Bot1 = new Player("Computer");
		System.out.println("Game started");

		int rounds;
		System.out.print("Enter number of rounds you want to play:    ");
		rounds = scan.nextInt();

		System.out.println("Enter:\t1-->Stone\t2-->Paper\t3-->Scissor");
		int choice1;
		int choice2;
		for(int i=0;i<rounds;i++)
		{
			System.out.println();
			System.out.print("Enter your choice:   ");
			choice1 = scan.nextInt();
			choice2 = random.nextInt(3);

			System.out.println();
			System.out.println("Your choice:  " + choice1);
			System.out.println("Computer choice:  " + (choice2+1));
			System.out.println();

			if(  (choice1 == 1 && choice2 == 0) || (choice1 == 2 && choice2 == 1) || (choice1 == 3 && choice2 == 2)  )
			{
				System.out.println("Draw");
				continue;
			}
			else if(  (choice1 == 1 && choice2 == 1) || (choice1 == 2 && choice2 == 2) || (choice1 == 3 && choice2 == 0)  )
			{
				Bot1.updateScore();
				System.out.println("You Lose");
			}
			else if(  (choice1 == 2 && choice2 == 0) || (choice1 == 3 && choice2 == 1) || (choice1 == 1 && choice2 == 2)  )
			{
				P1.updateScore();
				System.out.println("You Win");
			}
		}
		System.out.println("Round Over.");

		System.out.println();
		System.out.println();
		System.out.println("Name\t\tScore");
		System.out.println(P1);
		System.out.println(Bot1);

		System.out.print("RESULT :    ");
		if(P1.score > Bot1.score)
		{
			System.out.println("You Win this round  :-)");
		}
		else if(P1.score < Bot1.score)
		{
			System.out.println("You Loose this round  :-(");
		}
		else if(P1.score == Bot1.score)
		{
			System.out.println("This is a draw :-|");
		}
	}
}

class StonePaperScissor
{

	public static void main(String args[])
	{
		int rider;
		Scanner scan = new Scanner(System.in);



		do
		{
			System.out.println();
			System.out.println("\t\t\t\t================CHOICE================");
			System.out.println();
			System.out.println("\t\t\t\t\t\t1) PLAY\n\t\t\t\t\t\t0)EXIT");
			System.out.println();
			System.out.print("Enter your choice:  ");
			rider = scan.nextInt();

			switch(rider)
			{
				case 1:
					Game G1 = new Game();
					G1.playgame();
					break;
				case 0:
					System.out.println("Thank You for playing. Please come again........");
					return;
				default:
					System.out.println("Invalid choice. Try again.....");
					break;
			}
		}while(rider != 0);
	}
}