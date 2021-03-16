
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	
	public final static String SEPARATOR = " ";
	
	public static void main(String[] args) throws IOException {
		
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 
		 String line = br.readLine();
		 
		 do{
			 int amount = Integer.parseInt(line);	 
			 int[] booksPrice = parseAndSortArray(br.readLine().split(SEPARATOR), amount);
			 int M = Integer.parseInt(br.readLine());
			 
			 bw.write(binarySearch(booksPrice, M));
			 
			 line = br.readLine(); 
			 line = br.readLine();
		 }while(line != null);
		 
		 br.close();
		 bw.close();
	}
	
	private static int[] parseAndSortArray(String[] booksPriceString, int amount) {
		int[] newArray = new int[amount];
		
		for(int i = 0; i < amount; i++) {
			newArray[i]=Integer.parseInt(booksPriceString[i]);
		}
		
		Arrays.sort(newArray);
		
		return newArray;
	}
	
	public static String binarySearch(int[] booksPrice, int M) {
		String out = "";
			
		int minimumDifference = M;
		int a = 0;
		int b = 0;
		
		int i = 0;
		int j = 0;
		for(int k = 0; k < booksPrice.length; k++ ) {
			
			i = k;
			j = booksPrice.length-1;
			
			int m = (k+j)/2;
			
			if(booksPrice[k] + booksPrice[m] != M) {
				
				while(i <= j && booksPrice[k] + booksPrice[m] != M) {
					m = (i+j)/2;
					
					if(booksPrice[k] + booksPrice[m] == M) {
						if(booksPrice[m]-booksPrice[k] < minimumDifference && k != m) {
							minimumDifference = booksPrice[m]-booksPrice[k];
							a = booksPrice[k];
							b = booksPrice[m];							
						}						
					} else if(booksPrice[k] + booksPrice[m] > M) {
						j = m - 1;
					} else {
						i = m + 1;
					}			
				}
				
			}	else {
				minimumDifference = booksPrice[m]-booksPrice[k];
				a = booksPrice[k];
				b = booksPrice[m];
			}
			
		}
		
		out = "Peter should buy books whose prices are " + a +" and " + b + ".\n\n";
			
		return out;
	}
	
	

}