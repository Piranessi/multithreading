package thr;

class Threads implements Runnable {
	private Thread thread;
	private String nameThread;
	private int amountOfLoops;
	private int msSleep;
	
	@Override
	public void run() {
		System.out.println("run invocated, name of thread: " + this.nameThread);
		
		try {
			for(int i=0; i<this.amountOfLoops; ++i) {
				Thread.sleep(this.msSleep); 
				System.out.println("Run " + i + ", thread: " + this.nameThread );
				}
		} catch(InterruptedException e) { System.out.println("Thread interrupted: " + "nameThread"); }
		
		System.out.println("Thread terminated: " + this.nameThread);
	}
	
	Threads(String nameThreadP, int amountOfLoopsP, int msSleepP) {
		this.nameThread = nameThreadP;
		this.amountOfLoops = amountOfLoopsP;
		this.msSleep = msSleepP;
		System.out.println("Created thread " + this.nameThread);
	}
	
	public void Start()
	{
		if(null == this.thread) {
			this.thread = new Thread(this, this.nameThread);
			System.out.println("Started thread: " + this.nameThread);
			this.thread.start();
		} else {
			System.out.println("Thread obj was not null");
		}
		
	}
}

public class gl {
	public static void main(String[] args) {
		Threads obj1 = new Threads("First", 30, 1000);
		Threads obj2 = new Threads("Second", 30, 800);
		Threads obj3 = new Threads("Third", 30, 600);
		Threads obj4 = new Threads("Fourth", 30,700);
		
		obj1.Start();
		obj2.Start();
		obj3.Start();
		obj4.Start();

	}
}