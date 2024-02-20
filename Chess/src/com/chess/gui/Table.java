package com.chess.gui;  
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

import chess.Move;
import chess.board.Board;
import chess.board.Place;
import chess.pieces.Piece;


public class Table {
	
private final Board chessBoard;
private static final Dimension OUTER_FRAME_DIMENSION = new Dimension(600,600);
private static final Dimension BPDIMENSION = new Dimension(400,350);
private static final Dimension TPDIMENSION = new Dimension(10,10);
private static final Color LIGHTCOLOR = Color.DARK_GRAY;
private static final Color DARKCOLOR = Color.LIGHT_GRAY;
private final JFrame gameFrame;
private final BoardPanel boardPanel;
private static String pieceImagesPath = "art/";
private Place sourcePlace;
private Place destinationPlace;
private Piece humanPiece;

	public Table() {
		this.chessBoard = new Board();
		this.gameFrame = new JFrame("Chess");
		this.gameFrame.setLayout(new BorderLayout());
		final JMenuBar tableMenuBar = new JMenuBar();
		populateMenuBar(tableMenuBar);
		this.gameFrame.setJMenuBar(tableMenuBar);
		this.gameFrame.setSize(OUTER_FRAME_DIMENSION);
		
		this.boardPanel = new BoardPanel();
		this.gameFrame.add(this.boardPanel, BorderLayout.CENTER);
		
		this.gameFrame.setVisible(true);
		}
	
	
	private void populateMenuBar(final JMenuBar tableMenuBar) {
		tableMenuBar.add(createFileMenu());
		
	}


	private JMenu createFileMenu() {
		final JMenu fileMenu = new JMenu("File");
		final JMenuItem openPGN = new JMenuItem("Load PGN File");
		openPGN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("open a pgn file");
				
			}
		});
		fileMenu.add(openPGN);
		
		final JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
		});
		fileMenu.add(exitMenuItem);
		return fileMenu;
	}
	
	private class BoardPanel extends JPanel{
	
		private static final long serialVersionUID = 1L;
		final TilePanel[][] boardTiles;
		
		
		BoardPanel(){
			super(new GridLayout(8,8));
			this.boardTiles = new TilePanel[8][8];
			for(int i=0; i < 8; i++) {
				for(int j = 0; j < 8; j++) {
				final TilePanel tilePanel = new TilePanel(this, i, j);
				this.boardTiles[i][j] = (tilePanel);
				add(tilePanel);
			}
			}
			setPreferredSize(BPDIMENSION);
			validate();
		}
		
	}
	
	private class TilePanel extends JPanel{
			
		private static final long serialVersionUID = 1L;
			final int x;
			final int y;
		
		TilePanel(final BoardPanel boardPanel, final int x, final int y){
			super(new GridBagLayout());
			this.x = x;
			this.y = y;
			setPreferredSize(TPDIMENSION);
			assignTileColor();
			assignTilePieceIcon(chessBoard);
			
			
			//TODO: working here
			
			addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(final MouseEvent e) {
					if(SwingUtilities.isRightMouseButton(e)) {
						sourcePlace = null;
						humanPiece = null;
						reApplyBackground(chessBoard);
						repaintTiles(chessBoard);
						
					} else if (SwingUtilities.isLeftMouseButton(e)) {
						
						
						if(sourcePlace == null) {
							sourcePlace = chessBoard.getSquare(x, y);
							humanPiece = sourcePlace.getPiece();
							
							
							//highlight available moves
							if(humanPiece != null) {
							
							reApplyBackground(chessBoard);
							highlightMoves(sourcePlace, chessBoard);
							repaintTiles(chessBoard);
							
							}
							
							if(humanPiece == null) {
								sourcePlace = null;
							} else if(humanPiece.isWhite() != chessBoard.getCurrentPlayer().isWhite()) {
								
								humanPiece = null;
								sourcePlace = null;
								
							}
							
							
						} else {
							//subsequent clicks
							
							destinationPlace = chessBoard.getSquare(x, y);
							reApplyBackground(chessBoard);
							repaintTiles(chessBoard);
							
							
							if (destinationPlace.getPiece() != null) {
								if (destinationPlace.getPiece().isWhite() == sourcePlace.getPiece().isWhite()) {
									sourcePlace = null;
									humanPiece = null;
									reApplyBackground(chessBoard);
									repaintTiles(chessBoard);
									return;
								}
							}
							
							final Move move = new Move(chessBoard.getCurrentPlayer(), humanPiece, sourcePlace, destinationPlace);
							ArrayList<Move> l = sourcePlace.getPiece().getLegalMoves(chessBoard, sourcePlace);
							ArrayList<Place> legalPlaces = new ArrayList<Place>();
							for (Move m:l) {
								legalPlaces.add(m.getEnd());	
							}
							for (Place p:legalPlaces) {
								if (destinationPlace == p){
									chessBoard.applyMove(move);
									sourcePlace = null;
									humanPiece = null;
									//reApplyBackground(chessBoard);
									repaintTiles(chessBoard);

									chessBoard.advanceTurn();
									
								}
							
							} 
							sourcePlace = null;
							humanPiece = null;
						
						}
					}
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
			});
			
			
			validate();
		}
		
		private void highlightMoves (Place place, final Board board) {
			ArrayList<Move> l = place.getPiece().getLegalMoves(board, place);
			ArrayList<Place> legalPlaces = new ArrayList<Place>();
		
			for (Move m:l) {
				legalPlaces.add(m.getEnd());	
			}
			for (Place p:legalPlaces) {
					boardPanel.boardTiles[p.getX()][p.getY()].setBackground(Color.blue);;
					}
					validate();
					repaint();
		}
		
		private void reApplyBackground(final Board board) {
			for(int i=0; i < 8; i++) {
				for(int j = 0; j < 8; j++) {
				
				boardPanel.boardTiles[i][j].assignTileColor();
				}
				validate();
				repaint();
			}
		}
		private void repaintTiles(final Board board) {
			for(int i=0; i < 8; i++) {
				for(int j = 0; j < 8; j++) {	
				boardPanel.boardTiles[i][j].assignTilePieceIcon(board);
				
				}
				validate();
				repaint();
			}
		}
		
		private void assignTilePieceIcon(final Board board) {
			this.removeAll();
			if(board.getSquare(this.x, this.y).getPiece() != null) {
				try {
										
					final BufferedImage image = ImageIO.read(new File(pieceImagesPath 
						+ String.valueOf(board.getSquare(this.x, this.y).getPiece().isWhite()).substring(0,1)
						+ board.getSquare(this.x,  this.y).getPiece().getType() + ".gif"));
				
					add(new JLabel(new ImageIcon(image)));
					validate();
					repaint();
				}catch(IOException e){
					e.printStackTrace();
				} 
				} else if(board.getSquare(this.x, this.y).getPiece() == null) {
					removeAll();
					validate();
					repaint();
				}
		}
		private void assignTileColor() {
			if(this.x % 2 != 0) {
				setBackground(this.y % 2 == 0 ? LIGHTCOLOR : DARKCOLOR);
				
			} else {
				setBackground(this.y % 2 != 0 ? LIGHTCOLOR : DARKCOLOR);
			}
			
		}
		
	}
	}


