public class ImmutableVSmutable {

	public static void main(String[] args) {
		//String are immutable because in string once the object is created we can modify the string but when you modify
		//new object will be created.
		//the referenced object may also reference multiple references.
		//eg in below code
		 String a="arun";
		 String b="arun";
		 String c="arun";
		 //in the heap area only one object is created and multiple reference are pointing to that one objet.
		 c=c+"java";
		 //once the changes made in object it will created new object and reference to that new object.
		 
		 
		 //StringBuilder and StringBuffer are same only the difference is 
		 //StringBuilder is non-Synchronized
		 //StringBuffer is Synchronized.
		 // both are mutable.
		 
		 StringBuilder br =new StringBuilder();
		 br.append("arun");
		 StringBuffer bf=new StringBuffer();
		 br.append("java");
		 
	}

}
