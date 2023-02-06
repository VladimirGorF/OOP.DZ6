public class Controller implements Functionable {
    private User user;


    public Controller(User user) {
        this.user = user;
    }

    @Override
    public void save(User user) {
        System.out.println("Save user: " + user.getName());
        
    }

    @Override
    public void report(User user) {
        System.out.println("Report for user: " + user.getName());
    }

    public void run() {
        save(user);
        report(user);
    }



    
}
