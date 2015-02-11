import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Diving 
{
	static int judge;
	static int score;
	static double Total=0, difficulty;
	static double scoreTotal =0, calculateScore;
	static double [] allJudges = new double [7];
	public static void main(String[] args)
	{
		difficulty=inputValidDegreeOfDifficulty();	
		for (judge=0; judge<7;judge++)//for loop for each judge
		{
			score=inputValidScore();//input valid score method give a score between 0 and ten to a diver
			inputAllScores();//input all scores method places them in an array called allJudges 
		}		
		calculateScore=calculateScore();
		System.out.println("Diver's Final Score is "+(calculateScore*.6));//total scores multiplied by .6
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
		//nested for loop switches scores in order before printing out the lowest and highest score
		System.out.println("the lowest value ="+allJudges[0]);
		System.out.println("the highest value ="+allJudges[allJudges.length-1]);

		for(int y=1;y<allJudges.length-1;y++)//all scores except for the lowest and highest scores
		{
			scoreTotal=scoreTotal+allJudges[y];
		}
		System.out.println("total of all 5 scores is "+scoreTotal);
		scoreTotal=scoreTotal*difficulty;//total multiplied by difficulty
		System.out.println(" total score*difficulty is "+scoreTotal);
		
		return (scoreTotal);
	}
}
