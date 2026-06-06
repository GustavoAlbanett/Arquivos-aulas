public class Ex3{
	public static void main(String args[]){
		int n = Integer.parseInt(args[0]);
		int resul = 1; 
		for (; n != 0; n--){
			resul = resul * n;  		
		}	
		System.out.println(resul);
			
		
	}

}