package first.bank;

import java.util.ArrayList;       //This class is import for using ArrayList
import static java.lang.System.*; //This class is import for avoid System from System.out.println 
public class electronicShop {

	public static void main(String[] args) {
	
		electronics e1=new electronics(11,"Laptop","Lenovo",50000,"ideapad slim-3");
		electronics e2=new electronics(11,"Mobile","Samsung",80000,"Samsung s12");
		electronics e3=new electronics(11,"Watch","Apple",15000,"i-series");
		electronics e4=new electronics(11,"Laptop","Dell",45000,"Dell inspiron 15");
		electronics e5=new electronics(11,"Mobile","Apple",80000,"iphone-13");
		
		ArrayList<electronics> ll=new ArrayList<electronics>();
		ll.add(e1);
		ll.add(e2);
		ll.add(e3);
		ll.add(e4);
		ll.add(e5);
		
		 ll.stream()
         .filter(best->best.ePrice>30000)
         .filter(best->(best.eName=="Laptop"))
         .forEach(best->{
             out.println(best.eCompany+" "+best.eName+" Rs: "+best.ePrice);

         });

		
		
		
		
	}

}
