package com.example.exam12_service;

public class CustomThread extends Thread {

	
	
	@Override
	public void run() {
		int i = 0;
		while (!this.interrupted()) {
			i++;
			try {
				Thread.sleep(1000);
				System.out.println(i);
			} 
			catch (InterruptedException e) {
				this.interrupt();
				System.out.println("interrupt");
			}
		}
		super.run();
	}
}
