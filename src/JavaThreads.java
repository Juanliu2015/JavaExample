package JavaExample;

public class JavaThreads {

	public JavaThreads() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		/*Thread thread1 = new Thread(new RunnableThread(), "thread1");
		Thread thread2 = new Thread(new RunnableThread(), "thread2");
		RunnableThread thread3 = new RunnableThread("thread3");
		//Start the threads
		thread1.start();
		thread2.start();
		try {
			//delay for one second
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
		}
		//Display info about the main thread
		System.out.println(Thread.currentThread());*/
		
		Thread thread1 = new Thread(new XThread(), "thread1");
		Thread thread2 = new Thread(new XThread(), "thread2");
		//	    The below 2 threads are assigned default names
		Thread thread3 = new XThread();
		Thread thread4 = new XThread();
		Thread thread5 = new XThread("thread5");
		//Start the threads
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		try {
	//The sleep() method is invoked on the main thread to cause a one second delay.
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
		}
		//Display info about the main thread
		System.out.println(Thread.currentThread());
	}
	

	
}

class RunnableThread implements Runnable {

	Thread runner;
	public RunnableThread() {
	}
	public RunnableThread(String threadName) {
		runner = new Thread(this, threadName); // (1) Create a new thread.
		System.out.println(runner.getName());
		runner.start(); // (2) Start the thread.
	}
	public void run() {
		//Display info about this particular thread
		System.out.println(Thread.currentThread());
	}
	
}

class XThread extends Thread {

	XThread() {
	}
	XThread(String threadName) {
		super(threadName); // Initialize thread.
		System.out.println(this);
		start();
	}
	public void run() {
		//Display info about this particular thread
		System.out.println(Thread.currentThread().getName());
	}
}