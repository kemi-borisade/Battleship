import java.util.ArrayList;
import java.util.List;


public class Main {

	
	
	public static void main(String arg[]){
		Player player1 = new Player();
		initialisePlayer1(player1);
		board(player1.getShips());
		  
		TheGridLayout grid = new TheGridLayout();
		
		}

private static void initialisePlayer1(Player player1){
	
	Patrolboat patrolBoat1 = new Patrolboat();
	Battleship battleShip1 = new Battleship();
	
	List<Ship> ships = new ArrayList();
	
	ships.add(patrolBoat1);
	ships.add(battleShip1);
	
	player1.setShips(ships);
	
}

private static void board(List <Ship> ships){
	String[][] board =  new String [6][6];

	for (int r = 0; r<board.length;r++){
		   for (int c = 0; c <board.length;c++){
		      board[r][c] = "_";  // Initialize the cell
		      
		      for (Ship ship: ships){
		    	  board[ship.getX()][ship.getY()] = "***";
		      }
		      System.out.print("[" +board[r][c] + "]"); // Display the content of cell board
		      
		   }
		   System.out.println("");
	}
	}
}
	

