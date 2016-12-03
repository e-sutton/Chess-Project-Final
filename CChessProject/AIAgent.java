import java.util.*;

import javax.swing.JOptionPane;

public class AIAgent {
	Random rand;
	int count = 0;

	public AIAgent() {
		rand = new Random();
	}

	/*
	 * The method randomMove takes as input a stack of potential moves that the
	 * AI agent can make. The agent uses a rondom number generator to randomly
	 * select a move from the inputted Stack and returns this to the calling
	 * agent.
	 */

	public Move randomMove(Stack possibilities) {
		int moveID = rand.nextInt(possibilities.size());
		System.out.println("Agent randomly selected move : " + moveID);
		for (int i = 1; i < (possibilities.size() - (moveID)); i++) {
			possibilities.pop();
		}
		Move selectedMove = (Move) possibilities.pop();
		return selectedMove;
	}

	public Move nextBestMove(Stack<Move> possibilities, Stack<Square> allBlackSquares) {

		Stack<Move> possibleAttackMoves = new Stack<Move>();

		for(Move move : possibilities){
			Square s = move.getLanding();
			int x = s.getXC();
			int y = s.getYC();
			for(Square square : allBlackSquares){
				int x2 = square.getXC();
				int y2 = square.getYC();
				if ((x == x2) && (y == y2)){
					Move attackableMove = move;
					count++;
					possibleAttackMoves.push(attackableMove);
				}
			}
		}

		int moveID = rand.nextInt(possibilities.size());
		for (int i = 1; i < (possibilities.size() - (moveID)); i++) {
			possibilities.pop();
		}
		Move selectedMove = (Move) possibilities.pop();

		System.out.println("number of moves available to use in attacking moves is "+possibleAttackMoves.size());

		if(count>0){
			System.out.println("returning an attacking move");
			count = 0;
			return possibleAttackMoves.peek();
		}
		else{
			System.out.println("returning a random move");
			return selectedMove;
		}

	}

	public Move twoLevelsDeep(Stack possibilities) {
		Move selectedMove = new Move();
		return selectedMove;
	}

}
