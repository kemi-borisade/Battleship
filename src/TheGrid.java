import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;




public class TheGrid extends JFrame {
	private Container content;
	 private JButton [][] squares = new JButton[10][10];

	private Color colorMagenta = Color.magenta;

	private int row = 7;
	private int col = 1;
		
	private ImageIcon ship = new ImageIcon("ship.jpg");
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TheGrid window = new TheGrid();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TheGrid() {
	super("GUI GridLayout Manager");
	initialize();
		
		
	}
	private boolean isValid(int i, int j){
		int theRow = Math.abs(i = row);
		int theCol = Math.abs(j - col);
		if ((theRow == 1)&& (theCol == 2))
		{
			return true;
		}
		if ((theCol == 1)&& (theRow == 2))
		{
			return true;
		}
		
			return false;
		
	}
	private void theClick(int i, int j){
		
		if (isValid(i, j) == false){
			return;
		}
		squares[row][col].setIcon(ship);
		row = i;
		col = j;
	}


	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object source = e.getSource();
			
			for (int i = 0; i<10; i++)
			{
				for (int j = 0; j <10; j++)
				{
					if (source == squares[i][j])
					{
						theClick(i, j);
						return;
					}
						
				}
					
			}
			
		}
		
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		content = getContentPane();
		content.setLayout(new GridLayout(10,10));
		ButtonHandler buttonHandler = new ButtonHandler();
		
	
	
		for (int i = 0; i < 10; i++)
		{
			
			for (int j = 0; j < 10; j++)
			{
				squares[i][j] = new JButton();
			squares [i][j].setBackground(colorMagenta);
				
				content.add(squares[i][j]);
				squares[i] [j].addActionListener(buttonHandler);
			}
		}
		squares[row][col].setIcon(ship);
		setSize(500, 500);
		setResizable(false);
		setLocationRelativeTo(null); //centres window
		setVisible(true);
	}

}
