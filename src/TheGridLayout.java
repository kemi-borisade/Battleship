import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;
import java.awt.Frame;
import java.awt.GridLayout;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


public class TheGridLayout extends JFrame{

	 
	private Container content;
	 private JButton [][] squares = new JButton[10][10];

	private Color colorGrid = Color.CYAN;

	private int row = 7;
	private int col = 1;
		
	private ImageIcon ship = new ImageIcon("C:/Users/Administrator/My Documents/ship.jpg");

	public TheGridLayout()
	{
		super("GUI GridLayout Manager");
		content = getContentPane();
		content.setLayout(new GridLayout(10,10));
		ButtonHandler buttonHandler = new ButtonHandler();
		
		JFrame frame = new JFrame();
	
	
		for (int i = 0; i < 10; i++)
		{
			
			for (int j = 0; j < 10; j++)
			{
				squares[i][j] = new JButton();
			squares [i][j].setBackground(colorGrid);
				
				content.add(squares[i][j]);
				squares[i] [j].addActionListener(buttonHandler);
			}
		}
		squares[row][col].setIcon(ship);
		setSize(500, 500);
		setResizable(false);
		setLocationRelativeTo(null); //centres window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
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
					squares[i][j].setIcon(ship);
					return;
				}
					
			}
				
		}
		
	}
	
}
}





