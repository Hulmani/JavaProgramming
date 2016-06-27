import java.math.BigInteger;


public class PrimeGenerator {

	public static void main(String[] args) {
		//System.out.println(Integer.MAX_VALUE);
		
		BigInteger i=new BigInteger("1");
		BigInteger j=new BigInteger("10");//("10000000000");;
			for(;;)
			{
				if(i.compareTo(j)==0)
					break;
				if(isPrime(i))
				System.out.println("Yes "+i);
				else
					System.out.println("No "+i);
				i=i.add(BigInteger.ONE);
			}
	}

	private static boolean isPrime(BigInteger i) {
		// TODO Auto-generated method stub
		BigInteger p=new BigInteger("2");
		if(i.compareTo(BigInteger.ONE)==-1)
			return false;
		
		
		for(;p.compareTo(i)==0;)
		{
			
			if(i.mod(p)==BigInteger.ZERO)
				return true;
			
			System.out.println(i+" "+p);
			p=p.add(BigInteger.ONE);
		}
		
		return false;
	}

}
