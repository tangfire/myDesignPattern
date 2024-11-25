package 创建型模式.Builder_Pattern.example002;

public class Test {
    public static void main(String[] args) {
        PizzaBuilder pizzaBuilder = new PizzaBuilder();
        Pizza pizza = pizzaBuilder.setSize("大")
                .addCheese()
                .addPepperoni()
                .addBacon()
                .build();

        System.out.println("您的披萨：大小-" + pizza.getSize() +
                "，奶酪-" + pizza.isCheese() +
                "，意式辣香肠-" + pizza.isPepperoni() +
                "，培根-" + pizza.isBacon());

    }
}

class Pizza {
    private String size;
    private boolean cheese;
    private boolean pepperoni;
    private boolean bacon;

    public Pizza(String size, boolean cheese, boolean pepperoni, boolean bacon) {
        this.size = size;
        this.cheese = cheese;
        this.pepperoni = pepperoni;
        this.bacon = bacon;
    }



    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isCheese() {
        return cheese;
    }

    public void setCheese(boolean cheese) {
        this.cheese = cheese;
    }

    public boolean isPepperoni() {
        return pepperoni;
    }

    public void setPepperoni(boolean pepperoni) {
        this.pepperoni = pepperoni;
    }

    public boolean isBacon() {
        return bacon;
    }

    public void setBacon(boolean bacon) {
        this.bacon = bacon;
    }
}

class PizzaBuilder {
    private String size;
    private boolean cheese;
    private boolean pepperoni;
    private boolean bacon;

    public PizzaBuilder setSize(String size) {
        this.size = size;
        return this;
    }

    public PizzaBuilder addCheese() {
        this.cheese = true;
        return this;
    }

    public PizzaBuilder addPepperoni() {
        this.pepperoni = true;
        return this;
    }

    public PizzaBuilder addBacon() {
        this.bacon = true;
        return this;
    }

    public Pizza build() {
        return new Pizza(size, cheese, pepperoni, bacon);
    }
}



