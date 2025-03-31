package com.caro.controller;

import com.caro.interfaces.Playable;
import com.caro.model.Game;
import com.caro.utils.InputHandler;
import com.caro.view.CaroView;

public class CaroController implements Playable {
	private Game game;
	private CaroView view;
	private InputHandler input;
	private char currentPlayer;

	public CaroController(int size) {
		game = new Game(size);
		view = new CaroView();
		input = new InputHandler();
		currentPlayer = 'X';
	}

	@Override
	public void init() {
		view.displayMessage("Welcome to Caro!");
	}

	@Override
	public void launch() {
		while (true) {
			view.displayBoard(game.getBoard());
			
			view.displayMessage("Enter your move (x, y) : ");
			int[] move = input.getInput();
			int x = move[0];
			int y = move[1];
			
			if (game.makeMove(x, y, currentPlayer)) {
				char winner = game.checkWin();
				if (winner != ' ') {
					view.displayBoard(game.getBoard());
					view.displayMessage("Player " + winner + " wins!");
					break;
				}
				currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
			} else {
				view.displayMessage("Invalid move, try again.");
			}
		}
	}

	@Override
	public void close() {
		input.close();
		view.displayMessage("Game Over!");
	}
}
