package 结构型模式.Proxy_Pattern.example02;

// 客户端代码
public class Client {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        // 图像并未加载，直到调用display()方法
        image1.display(); // 输出：显示加载中... \n 从磁盘加载图像：image1.jpg \n 显示图像：image1.jpg
        image2.display(); // 输出：显示加载中... \n 从磁盘加载图像：image2.jpg \n 显示图像：image2.jpg

        // 第二次调用，图像不再加载，直接显示
        image1.display(); // 输出：显示图像：image1.jpg
        image2.display(); // 输出：显示图像：image2.jpg
    }
}

// 图像接口
interface Image {
    void display();
}


// 具体图像类
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("从磁盘加载图像：" + filename);
    }

    @Override
    public void display() {
        System.out.println("显示图像：" + filename);
    }
}


// 代理图像类
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
        System.out.println("显示加载中...");
        realImage.display();
    }
}

