package multithreading.basic;

public class Main {

	public static void main(String[] args) {
		
		SimpleThread simpleThread = new SimpleThread();
		simpleThread.start();

		SimpleThread simpleThread2 = new SimpleThread();
		simpleThread2.start();
		
		// Runnable interface'den kalıtım almış olan "SimpleRunnable" sınıfından bir nesne oluşturuyoruz.
		SimpleRunnable simpleRunnable = new SimpleRunnable();
		
		// Runnable tipindeki nesneyi Thread kurucusuna gönderiyoruz.
		Thread simpleThread3 = new Thread(simpleRunnable);
		
		// start fonksiyonunu çağırdığımızda "SimpleRunnable" sınıfı içindeki "run" fonksiyonu işletilecektir.
		simpleThread3.start();
		
		ThreadSleeper.sleep(10000);
		
		simpleRunnable.stop();
	}

}
