package soap.service;

/**
 * @author chamerling
 * 
 */
public class HelloServiceImpl implements HelloService {

/*
	@Override
	public String sayHi(String input) {
		System.out.println("Hello invoked : " + input);
		return String.format("Hello '%s'", input);
	}
	
	@Override
	public String hola() {
		
		return String.format("metodo hola");
	}*/
	
	@Override
    public Book get(@WebParam(name="id") int id) {
        Book b = new Book();
        b.id = id;
        return b;
    }
   

}
 public static final class Book {
        public int id = 1;
        public String title = "Java";
    }