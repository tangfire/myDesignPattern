package 结构型模式.Proxy_Pattern.example03;

// 客户端代码
public class Client {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        image1.display();  // 输出：Before displaying image1.jpg, do some pre-processing.
                           //        Loading image1.jpg from disk.
                           //        Displaying image1.jpg
        image2.display();  // 输出：Before displaying image2.jpg, do some pre-processing.
                           //        Loading image2.jpg from disk.
                           //        Displaying image2.jpg
    }
}


// 图片接口
interface Image {
    void display();
}


// 具体图片类
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Loading " + filename + " from disk.");
    }

    @Override
    public void display() {
        System.out.println("Displaying " + filename);
    }
}


// 代理图片类
class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        beforeDisplay();
        realImage.display();
    }

    private void beforeDisplay() {
        System.out.println("Before displaying " + filename + ", do some pre-processing.");
    }
}
