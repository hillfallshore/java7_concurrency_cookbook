package chapter3.lesson2;

import java.util.concurrent.Semaphore;

/**
 * 创建一个打印队列类
 */

public class PrintQueue {

	/** 信号量对象 */
	public final Semaphore semaphore;

	public PrintQueue() {
		semaphore = new Semaphore(1);
	}

	/**
	 * 模拟文档的打印
	 */
	public void printJob(Object document) {
		try {

			// 获得信号量
			semaphore.acquire();

			// 模拟文档的打印，然后等待一段随机时间
			long duration = (long) (Math.random() * 10);
			System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n", Thread.currentThread().getName(),
					duration);
			Thread.sleep(duration);

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// 释放信号量
			semaphore.release();
		}
	}

}
