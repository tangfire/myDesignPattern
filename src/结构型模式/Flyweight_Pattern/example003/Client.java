package 结构型模式.Flyweight_Pattern.example003;

import java.util.HashMap;
import java.util.Map;

// 客户端代码
public class Client {
    public static void main(String[] args) {
        ChessPieceFactory chessPieceFactory = new ChessPieceFactory();

        ChessPiece blackPiece1 = chessPieceFactory.getChessPiece("black");
        ChessPiece blackPiece2 = chessPieceFactory.getChessPiece("black");
        ChessPiece whitePiece1 = chessPieceFactory.getChessPiece("white");
        ChessPiece whitePiece2 = chessPieceFactory.getChessPiece("white");

        System.out.println(blackPiece1 == blackPiece2);
        System.out.println(whitePiece1 == whitePiece2);

        System.out.println("-------------------------------------");


        blackPiece1.display(1, 2);  // 输出：Chess Piece color: black, position: (1,2)
        blackPiece2.display(3, 4);  // 输出：Chess Piece color: black, position: (3,4)
        whitePiece1.display(5, 6);  // 输出：Chess Piece color: white, position: (5,6)
        whitePiece2.display(7, 8);  // 输出：Chess Piece color: white, position: (7,8)
    }
}


// 棋子接口
interface ChessPiece {
    void setColor(String color);
    void display(int x, int y);
}


// 具体棋子类
class ConcreteChessPiece implements ChessPiece {
    private String color;

    public ConcreteChessPiece(String color) {
        this.color = color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void display(int x, int y) {
        System.out.println("Chess Piece color: " + color + ", position: (" + x + "," + y + ")");
    }
}


// 享元工厂类
class ChessPieceFactory {
    private Map<String, ChessPiece> chessPieces;

    public ChessPieceFactory() {
        this.chessPieces = new HashMap<>();
    }

    public ChessPiece getChessPiece(String color) {
        ChessPiece chessPiece = chessPieces.get(color);
        if (chessPiece == null) {
            chessPiece = new ConcreteChessPiece(color);
            chessPieces.put(color, chessPiece);
        }
        return chessPiece;
    }
}
