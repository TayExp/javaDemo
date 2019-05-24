package threadLocal;


class User{
	String name;
	int level;
	
	public User(String name, int level){
		this.name = name;
		this.level = level;
	}
}

class UserContext implements AutoCloseable{
	//全局唯一静态变量：
	static final ThreadLocal<User> context = new ThreadLocal<>();
	
	//获取当前线程User
	public static User getCurrentUser(){
		return context.get();
	}
	//初始化
	public UserContext(User user){
		context.set(user);
	}
	//移除ThreadLocal关联的User
	public void close(){
		context.remove();
	}
}

class ProcessThread extends Thread {
	User user;
	
	ProcessThread(User user){
		this.user = user;
	}
	public void run(){
		try (UserContext ctx = new UserContext(user)){
			//step1
			Greeting.hello();
			
			//step2
			Level.checkLevel();
		}
	}
}

class Greeting{
	static void hello(){
		User user = UserContext.getCurrentUser();
		System.out.println("Hello, this is thread: "+user.name);
	}
}

class Level{
	static void checkLevel(){
		User user = UserContext.getCurrentUser();
		if (user.level > 100){
			System.out.println(user.name + " is a VIP user.");
		} else {
			System.out.println(user.name + " is a registed user.");
		}
	}
}

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new ProcessThread(new User("bob", 120));
		Thread t2 = new ProcessThread(new User("alice", 80));
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("Main end");
	}

}
