package test;

import java.util.Scanner;

class Result{
	
	int M;
	int T;
	int U;
	int F;
	int D;
	
	public Result() {
	}

	public Result(int M, int T, int U, int F, int D) {
		this.M = M;
		this.T = T;
		this.U = U;
		this.F = F;
		this.D = D;
	}
	
	public int solve (String[] data)
	{
		//logic here
		
		//m = max time to reach back starting point
		//t = no. of type of land (Flat, Uphill, Downhill)
		//u = time for uphill
		//f = time for flat
		//d = time for downhill
		
		int currentTime = 0;
		int counter = 0;
		
		for(int i=0; i< data.length; i++)
		{
			int temp = currentTime;
			if(data[i].equalsIgnoreCase("u") || data[i].equalsIgnoreCase("d"))
			{
				if((temp += U + D) <= M)
				{
					currentTime += U + D;				
					counter ++;
				}
				else
					break;
			}
			else if (data[i].equalsIgnoreCase("f"))
			{
				if((temp += F + F) <= M)
				{
					currentTime += F + F;					
					counter ++;
				}
				else
					break;
			}
			
		}
		return counter;
	}
	
	
}

class Jogging {

	
	public static void main(String[] args) {
		String [] road;
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int T = sc.nextInt();
		int U = sc.nextInt();
		int F = sc.nextInt();
		int D = sc.nextInt();
		
		Result result = new Result(M,T,U,F,D);
		
		road = new String[T];
		for(int i = 0; i<T; i++)
			road[i] = sc.next();
		
		int distance = result.solve(road);
		System.out.println(result);
		System.out.println(distance);
		
	}

}
