package 行为型模式.State_Pattern.example001;

public class Test {
    public static void main(String[] args) {
        Context context = new Context();
        context.fallInLove();
        context.movies();  // 输出: 一起上电影院看大片

        context.disappearInLove();
        context.movies();  // 输出: 一个人看电影
    }
}

interface PersonState {
    void movies();
}

class SingleState implements PersonState {  // 更换类名，使其更具语义
    @Override
    public void movies() {
        System.out.println("一个人看电影");
    }
}

class LoveState implements PersonState {
    @Override
    public void movies() {
        System.out.println("一起上电影院看大片");
    }
}

class Context {
    private PersonState personState;

    public void setPersonState(PersonState personState) {
        this.personState = personState;
    }

    public void fallInLove() {
        setPersonState(new LoveState());
    }

    public void disappearInLove() {
        setPersonState(new SingleState());
    }

    public void movies() {
        if (personState == null) {
            System.out.println("没有设置状态，无法观看电影");
        } else {
            personState.movies();
        }
    }
}
