import java.util.*; 
class ArraysAsListDemo
{
	public static void main(String[] args)
	{
		String[] s={"A","Z","B"};
		List l=Arrays.asList(s); 
		System.out.println("list: "+l);  //[A, Z, B] 
		
		s[0]="K";
		System.out.println("list: "+l);   //[K, Z, B] 
		
		l.set(1,"L");
		System.out.println("String arrays: "+s);
		
		// l.add("ashok"); //java.lang.UnsupportedOperationException
		// l.remove(2); //java.lang.UnsupportedOperationException
	}
	
}

