package agileJava.ch1;

/**
 * 棋子
 * 
 * @author AAA
 * 
 */
public class Piece {

	public enum COLOR {
		WHITE("white"), BLACK("black");

		private String name;

		private COLOR(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	};

	public enum NAME {
		PAWN("P"), KNIGHT("N"), ROOK("R"), BISHOP("B"), QUEEN("Q"), KING("K");

		private String name;

		private NAME(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

	};

	private COLOR color;
	private NAME name;

	public Piece(COLOR color, NAME name) {
		this.color = color;
		this.name = name;
	}

	public boolean isWhite() {
		if (color.equals(COLOR.WHITE)) {
			return true;
		} else {
			return false;
		}
	}

	public String printShortName() {
		if (color.equals(COLOR.WHITE)) {
			return name.getName().toLowerCase();
		} else {
			return name.getName();
		}
	}

	public COLOR getColor() {
		return color;
	}

	public NAME getName() {
		return name;
	}
}
