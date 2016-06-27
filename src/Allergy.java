enum dogs{bulldog,pomorian,greyhound}
public class Allergy {

	private int t;
	public Allergy(Color c)
	{
		
	}
	
	public enum Color{
	
	
	Violet,
	Indigo,
	Blue,
	Green,
	Yellow,
	Orange,
	Purple;
	
	int value;

	Color()
	{
		System.out.println("this= "+this);
	}
};

public enum Colors{
	
	Violet,
	Indigo,
	Blue,
	Green,
	Yellow,
	Orange,
	Purple;
	
	int value;
};

public static void main(String[] args){

	//Color  b=Color.Blue ;
//		if(b.equals(Color.Blue))
//		System.out.println("yes");
//		
	//System.out.println(Color.Blue);

	Allergy a=new Allergy(Color.Blue);
	a.t=1;
}
}
