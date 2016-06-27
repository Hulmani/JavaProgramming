import java.util.Scanner;


public class GenomeMatch {

	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		String genome="";
		String matchSequence="";
		genome=scan.next();
		matchSequence=scan.next();
		searchSequence(genome.toCharArray(),matchSequence.toCharArray());
		
		
	}

	public static void searchSequence(char[] genome, char[] sequence) {
        int i = 0, j = 0;
        
        int geneLength = sequence.length;
        int genomeLength = genome.length;
 
       
        int[] states = buildState(sequence);
        for(int k=0;k<states.length;k++)
        {
        	 System.out.print(states[k]);
        } System.out.println();
        while (i < genomeLength) {
            while (j >= 0 && genome[i] != sequence[j]) {
                j = states[j];
            }
            i++;
            j++;
 
           
            if (j == geneLength) {
                System.out.println("found sequence at index:" + (i - geneLength));
                j = states[j];
                //return;
            }
            
        }
        System.out.println("Not found");
        
    }
	public static int[] buildState(char[] sequence) {
	    int i = 0, j = -1;
	    int pLength = sequence.length;
	    int[] states = new int[pLength + 1];
	 
	    states[i] = j;
	    while (i < pLength) {            
	            while (j >= 0 && sequence[i] != sequence[j]) {
	           
	            j = states[j];
	        }
	        i++;
	        j++;
	        states[i] = j;
	    }
	    return states;
	}
}
