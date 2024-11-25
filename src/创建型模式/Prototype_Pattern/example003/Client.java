package 创建型模式.Prototype_Pattern.example003;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Card card1 = new Card();
        card1.setNum(9527);
        Card card2 = card1.clone();
        System.out.println(card1);
        System.out.println("-----------------------");
        System.out.println(card2);
    }
}

class Card implements Cloneable {
    private int num; // 卡号

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public Card clone() throws CloneNotSupportedException {
        return (Card) super.clone();
    }

    @Override
    public String toString() {
        return "Card{" +
                "num=" + num +
                '}';
    }
}
