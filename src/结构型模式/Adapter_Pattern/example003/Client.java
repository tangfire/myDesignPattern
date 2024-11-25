package 结构型模式.Adapter_Pattern.example003;

// 客户端代码
public class Client {
    public static void main(String[] args) {
        MediaPlayer mediaPlayer = new AudioPlayer();
        mediaPlayer.playAudio("song.mp3");

        AdvancedMediaPlayer flacPlayer = new FlacPlayer();
        MediaPlayer mediaAdapter = new MediaAdapter(flacPlayer);
        mediaAdapter.playAudio("song.flac");
    }
}

// 播放器接口
interface MediaPlayer {
    void playAudio(String fileName);
    void playVideo(String fileName);
}

// 新的音频播放器接口
interface AdvancedMediaPlayer {
    void playMp3(String fileName);
    void playFlac(String fileName);
}

// 现有的播放器类
class AudioPlayer implements MediaPlayer {
    @Override
    public void playAudio(String fileName) {
        // 模拟播放MP3音频
        System.out.println("Playing MP3 file: " + fileName);
    }

    @Override
    public void playVideo(String fileName) {
        // 空实现，不支持视频播放
    }
}

// 新的音频播放器实现类
class FlacPlayer implements AdvancedMediaPlayer {
    @Override
    public void playMp3(String fileName) {
        // 空实现，不支持MP3格式
    }

    @Override
    public void playFlac(String fileName) {
        // 模拟播放FLAC音频
        System.out.println("Playing FLAC file: " + fileName);
    }
}


// 适配器类
class MediaAdapter implements MediaPlayer {
    private AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(AdvancedMediaPlayer advancedMediaPlayer) {
        this.advancedMediaPlayer = advancedMediaPlayer;
    }

    @Override
    public void playAudio(String fileName) {
        // 将请求适配为FLAC格式播放
        advancedMediaPlayer.playFlac(fileName);
    }

    @Override
    public void playVideo(String fileName) {
        // 空实现，不支持视频播放
    }
}


