package 行为型模式.Visitor_Pattern.example001;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Music wangyiyue = new Music("网易云音乐");
        Music kugou = new Music("酷狗");

        Websites websites = new Websites();
        websites.addWeb(wangyiyue);
        websites.addWeb(kugou);

        Visitor idler = new Idler("闲人");
        websites.accept(idler);

        System.out.println("-----------------------------");

        Visitor busy = new Busy("忙人");
        websites.accept(busy);
    }
}

interface Visitor {
    void visit(Music music);
    void visit(Video video);
}

abstract class Web {
    private String name;

    public Web(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void accept(Visitor visitor);
    public abstract void download();
}

class Music extends Web {
    public Music(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void download() {
        System.out.println("下载音乐~");
    }

    public void playMusic() {
        System.out.println("播放音乐ing");
    }
}

class Video extends Web {
    public Video(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void download() {
        System.out.println("下载视频~");
    }

    public void playVideo() {
        System.out.println("播放视频ing");
    }
}

class Idler implements Visitor {
    private String name;

    public Idler(String name) {
        this.name = name;
    }

    @Override
    public void visit(Music music) {
        System.out.println("闲人浏览音乐网站: " + music.getName());
        music.playMusic();
    }

    @Override
    public void visit(Video video) {
        System.out.println("闲人浏览视频网站: " + video.getName());
        video.playVideo();
    }
}

class Busy implements Visitor {
    private String name;

    public Busy(String name) {
        this.name = name;
    }

    @Override
    public void visit(Music music) {
        System.out.println("忙人浏览音乐网站: " + music.getName());
        music.download();
    }

    @Override
    public void visit(Video video) {
        System.out.println("忙人浏览视频网站: " + video.getName());
        video.download();
    }
}

class Websites {
    List<Web> list = new ArrayList<>();

    public void accept(Visitor visitor) {
        Iterator<Web> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next().accept(visitor);
        }
    }

    public void addWeb(Web web) {
        list.add(web);
    }
}
