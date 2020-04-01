package multithreading.critical.sections;

import multithreading.basic.ThreadSleeper;

public class QMatic implements Runnable {

	private volatile int orderNo;
	
	private Object LOCK = new Object();
	
	public QMatic() {
		this.orderNo = 0;
	}
	
	@Override
	public void run() {
		
		// a little bit delay to see race condition!
		ThreadSleeper.sleep(50);
		
		// Critical section for all threads!
		
		synchronized (LOCK) {
			this.orderNo = this.orderNo + 1;
			
			StringBuilder builder = new StringBuilder();
			builder.append(Thread.currentThread().getName());
			builder.append(" thread got ");
			builder.append(this.orderNo);
			builder.append(" from Qmatic!");

			System.out.println(builder.toString());
		}
		
	}
	
	// metot ile synchronized kullanımına örnek 
	private synchronized void increment() {
		
		this.orderNo = this.orderNo + 1;
		
		StringBuilder builder = new StringBuilder();
		builder.append(Thread.currentThread().getName());
		builder.append(" thread got ");
		builder.append(this.orderNo);
		builder.append(" from Qmatic!");

		System.out.println(builder.toString());
	}
}
