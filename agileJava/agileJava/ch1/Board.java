package agileJava.ch1;

import agileJava.ch1.Piece.COLOR;
import agileJava.ch1.Piece.NAME;

/**
 * 棋盘
 * 
 * @author AAA
 * 
 */
public class Board {

	private Piece[][] pieces = new Piece[8][8];

	public Board() {
	}

	public Board(Piece[][] pieces) {
		this.pieces = pieces;
	}

	public void init() {
		for (int i = pieces.length - 1; i >= 0; i--) {
			pieces[1][i] = new Piece(COLOR.WHITE, NAME.PAWN);
			pieces[6][i] = new Piece(COLOR.BLACK, NAME.PAWN);
		}
		pieces[0][0] = new Piece(COLOR.WHITE, NAME.ROOK);
		pieces[0][1] = new Piece(COLOR.WHITE, NAME.KNIGHT);
		pieces[0][2] = new Piece(COLOR.WHITE, NAME.BISHOP);
		pieces[0][3] = new Piece(COLOR.WHITE, NAME.QUEEN);
		pieces[0][4] = new Piece(COLOR.WHITE, NAME.KING);
		pieces[0][5] = new Piece(COLOR.WHITE, NAME.BISHOP);
		pieces[0][6] = new Piece(COLOR.WHITE, NAME.KNIGHT);
		pieces[0][7] = new Piece(COLOR.WHITE, NAME.ROOK);

		pieces[7][0] = new Piece(COLOR.BLACK, NAME.ROOK);
		pieces[7][1] = new Piece(COLOR.BLACK, NAME.KNIGHT);
		pieces[7][2] = new Piece(COLOR.BLACK, NAME.BISHOP);
		pieces[7][3] = new Piece(COLOR.BLACK, NAME.QUEEN);
		pieces[7][4] = new Piece(COLOR.BLACK, NAME.KING);
		pieces[7][5] = new Piece(COLOR.BLACK, NAME.BISHOP);
		pieces[7][6] = new Piece(COLOR.BLACK, NAME.KNIGHT);
		pieces[7][7] = new Piece(COLOR.BLACK, NAME.ROOK);
	}

	public int pawnCount() {
		int count = 0;
		for (int i = pieces.length - 1; i >= 0; i--) {
			for (int j = pieces.length - 1; j >= 0; j--) {
				if (pieces[i][j] != null) {
					count++;
				}
			}
		}
		return count;
	}

	public String printLinePawn(int line) {
		StringBuffer bf = new StringBuffer();
		Piece[] piece = pieces[line - 1];
		for (int i = piece.length - 1; i >= 0; i--) {
			if (null != piece[i]) {
				bf.append(piece[i].printShortName());
			} else {
				bf.append(".");
			}

		}
		return bf.toString();
	}

	public String printAllBoard() {
		StringBuffer sb = new StringBuffer();
		for (int i = pieces.length - 1; i >= 0; i--) {
			for (int j = 0; j < pieces.length; j++) {
				if (pieces[i][j] != null) {
					sb.append(pieces[i][j].printShortName()).append(" ");
				} else {
					sb.append(". ");
				}
			}
			sb.append(System.getProperty("line.separator"));
		}
		return sb.toString();
	}

	public void setPiece(int rank, char col, Piece piece) {
		pieces[rank - 1][col - 97] = piece;
	}

	public int getPieceCountByName(COLOR color, NAME name) {
		int count = 0;
		for (int i = pieces.length - 1; i >= 0; i--) {
			for (int j = 0; j < pieces.length; j++) {
				Piece p = pieces[i][j];
				if (null != p && p.getColor().equals(color)
						&& p.getName().equals(name)) {
					count++;
				}
			}
		}
		return count;
	}

	public Piece getPiece(String point) {
		char c = point.charAt(0);
		int rank = Integer.valueOf(point.substring(1));
		return pieces[rank - 1][c - 97];
	}

	public void movePiece(int srcRank, char srcCol, int desRank, char desCol,
			Piece piece) {
		pieces[srcRank - 1][srcCol - 97] = null;
		pieces[desRank - 1][desCol - 97] = piece;
	}

	public double getGrade(COLOR color) {
		double grade = 0;
		for (int i = 0; i < pieces.length; i++) {
			for (int j = 0; j < pieces.length; j++) {
				Piece p = pieces[i][j];
				if (null != p && p.getColor().equals(color)) {
					switch (p.getName()) {
					case PAWN: {
						if ((j < pieces.length - 2 && pieces[i][j + 1] != null && pieces[i][j + 1]
								.getName().equals(NAME.PAWN))
								|| (j > 0 && pieces[i][j - 1] != null && pieces[i][j - 1]
										.getName().equals(NAME.PAWN))) {
							grade += 0.5;
						} else {
							grade += 1;
						}
					}
						break;
					case BISHOP:
						grade += 3;
						break;
					case KNIGHT:
						grade += 2.5;
						break;
					case QUEEN:
						grade += 5;
						break;
					case ROOK:
						grade += 5;
						break;
					case KING:
						grade += 4;
						break;
					}
				}
			}
		}
		return grade;
	}
}
