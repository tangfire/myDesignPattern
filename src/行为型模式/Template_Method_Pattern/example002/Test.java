package 行为型模式.Template_Method_Pattern.example002;

public class Test {
    public static void main(String[] args) {
        Game cricket = new Cricket();
        cricket.play();
        // 输出：
        // 板球游戏：初始化
        // 板球游戏：开始
        // 板球游戏：结束

        Game football = new Football();
        football.play();
        // 输出：
        // 足球游戏：初始化
        // 足球游戏：开始
        // 足球游戏：结束

    }
}

abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    // 模板方法
    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }
}

class Cricket extends Game {
    @Override
    void initialize() {
        System.out.println("板球游戏：初始化");
    }

    @Override
    void startPlay() {
        System.out.println("板球游戏：开始");
    }

    @Override
    void endPlay() {
        System.out.println("板球游戏：结束");
    }
}

class Football extends Game {
    @Override
    void initialize() {
        System.out.println("足球游戏：初始化");
    }

    @Override
    void startPlay() {
        System.out.println("足球游戏：开始");
    }

    @Override
    void endPlay() {
        System.out.println("足球游戏：结束");
    }
}

