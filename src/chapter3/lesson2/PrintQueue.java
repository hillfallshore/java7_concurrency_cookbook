package chapter3.lesson2;

import java.util.concurrent.Semaphore;

/**
 * ����һ����ӡ������
 */

public class PrintQueue {

	/** �ź������� */
	public final Semaphore semaphore;

	public PrintQueue() {
		semaphore = new Semaphore(1);
	}

	/**
	 * ģ���ĵ��Ĵ�ӡ
	 */
	public void printJob(Object document) {
		try {

			// ����ź���
			semaphore.acquire();

			// ģ���ĵ��Ĵ�ӡ��Ȼ��ȴ�һ�����ʱ��
			long duration = (long) (Math.random() * 10);
			System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n", Thread.currentThread().getName(),
					duration);
			Thread.sleep(duration);

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// �ͷ��ź���
			semaphore.release();
		}
	}

}
