
public class HashClassImplementation {
	public static void main(String[] args)
	{
		String obj1 = new String("hell");
		String obj2 = new String("helo");

		String obj3 = new String("held");
		System.out.println("hashCode for an integer is " + obj1.hashCode());
		System.out.println("hashCode for a string is " + obj2.hashCode());
		System.out.println("hashCode for a string is " + obj3.hashCode());
	}
}
