import java.awt.*;
import java.util.*;
import javax.swing.*;
import org.omg.PortableServer.ServantRetentionPolicyValue;

class CountDownTest extends JFrame {
	private JLabel label;
	private JLabel label1;

	class MyThread extends Thread {
		int ab = 0;

		public MyThread(int a) {
			ab = a;
		}

		public void run() {
			if (ab == 1) {
				for (int i = 10; i >= 0; i--) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					label.setText(i + "");
				}
			}
			if (ab == 2) {
				for (int i = 10; i >= 0; i -= 2) {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					label1.setText(i + "");
				}
			}

		}

	}

	public CountDownTest() {
		setTitle("카운트 다운");
		setSize(300, 200);
		label = new JLabel("st1");
		label1 = new JLabel("st2");
		label.setFont(new Font("Serif", Font.BOLD, 50));
		label1.setFont(new Font("Serif", Font.BOLD, 50));
		setLayout(new FlowLayout());
		add(label);
		add(label1);
		MyThread t1 = new MyThread(1);
		MyThread t2 = new MyThread(2);
		t1.start();
		t2.start();
		setVisible(true);

	}
}

public class InterruptSample {
	public static void main(String[] args) {
		CountDownTest t = new CountDownTest();

	}
}
