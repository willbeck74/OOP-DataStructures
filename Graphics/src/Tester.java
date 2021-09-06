import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Tester extends JPanel {

	JFrame window = new JFrame("My First Game");
	Timer tmr = null;
	Random rnd = new Random();
	int x = 0, y = 0, speedX = 0, speedY = 0;
	public Tester() {
		window.setBounds(100, 100, 600, 600);
		window.setAlwaysOnTop(true);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().add(this);
		window.setVisible(true);
		
		// ============================================================================
		tmr = new Timer(100, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				x += speedX;
				y += speedY;
				repaint();
			}
		});
		// ============================================================================
		addMouseListener(new MouseListener() {

			@Override
			public void mousePressed(MouseEvent e) {
				tmr.stop();
				x = e.getX();
				y = e.getY();
				repaint();
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				tmr.start();
			}
			@Override public void mouseExited(MouseEvent e) {}
			@Override public void mouseEntered(MouseEvent e) {}
			@Override public void mouseClicked(MouseEvent e) {}
		});
		// ============================================================================
		addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if(!tmr.isRunning()) {
					x = e.getX();
					y = e.getY();
					repaint();
				}
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				mouseMoved(e);
			}
		});
		// ============================================================================
		window.addKeyListener(new KeyListener() {
			@Override public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 37) {speedX = -10; speedY = 0;}
				else if(e.getKeyCode() == 38) {speedY = -10; speedX = 0;}
				else if(e.getKeyCode() == 39) {speedX = 10; speedY = 0;}
				else if(e.getKeyCode() == 40) {speedY = 10; speedX = 0;}
			}
			
			@Override public void keyTyped(KeyEvent e) {}
			@Override public void keyReleased(KeyEvent e) {}
			
		});
		
		tmr.start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect(x, y, 100, 100);
	}
	
	
	
	
	// ============================================================================
	public static void main(String[] args) {
		new Tester();

	}

}
