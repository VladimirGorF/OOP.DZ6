public class Main{
	public static void main(String[] args){
		User user = new User("Bob");
		Controller controller = new Controller(user);
		controller.run();
	}
}