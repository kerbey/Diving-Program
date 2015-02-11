import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Diving 
{//use doubles for array
	static int judge;
	static int score;
	static double Total=0, difficulty;
	static double scoreTotal =0, calculateScore;
	static double [] allJudges = new double [7];
	//static double judge =0;
	public static void main(String[] args)
	{
		difficulty=inputValidDegreeOfDifficulty();	
		for (judge=0; judge<7;judge++)
		{
			score=inputValidScore();
			inputAllScores();
		}		
		calculateScore=calculateScore();
		System.out.println("Diver's Final Score is "+(calculateScore*.6));
	}

	public static int inputValidScore()
	{
		score =(int)(Math.random() *10);
		return score;
	}
	public static double []inputAllScores()
	{
		allJudges[judge]=score;
		System.out.println("judge "+(judge+1)+" Score "+allJudges[judge]);
		return allJudges;
	}
	public static double inputValidDegreeOfDifficulty()
	{
		Scanner input=new Scanner(System.in);
		System.out.println("enter in any degree of difficulty from 1.2 to 3.8");
		double degreeOfDifficulty =input.nextDouble();
		System.out.println("Degree of difficulty "+degreeOfDifficulty);
		return degreeOfDifficulty;
	}
	public static double calculateScore()
	{
		for(int judge=0;judge<allJudges.length;judge++)
		{
			for(int eachJudge=0;eachJudge<allJudges.length-1;eachJudge++)
			{
				if(allJudges[eachJudge]>allJudges[eachJudge+1])
				{
					double temp=allJudges[eachJudge];
					allJudges[eachJudge]=allJudges[eachJudge+1];
					allJudges[eachJudge+1]=temp;
				}	
			}	
		}
		System.out.println("the lowest value ="+allJudges[0]);
		System.out.println("the highest value ="+allJudges[allJudges.length-1]);

		for(int y=1;y<allJudges.length-1;y++)
		{
			scoreTotal=scoreTotal+allJudges[y];
		}
		System.out.println("total of all 5 scores is "+scoreTotal);
		scoreTotal=scoreTotal*difficulty;
		System.out.println(" total score*difficulty is "+scoreTotal);
		
		return (scoreTotal);
	}
}