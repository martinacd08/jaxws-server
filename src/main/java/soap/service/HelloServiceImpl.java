package soap.service;

/**
 * @author chamerling
 * 
 */
public class HelloServiceImpl implements HelloService {


	@Override
	public String sayHi(String input) {
		System.out.println("Hello invoked : " + input);
		return String.format("Hello '%s'", input);
	}
	
	@Override
	public String hola() {
		
		
		return Response.ok(String.format("metodo hola")).header("Access-Control-Allow-Origin", "*").build();
		
		
	}
	/*
	@Override
    public Book get(int id) {
        Book b = new Book(id);
        
        return b;
    }
   */

}
 