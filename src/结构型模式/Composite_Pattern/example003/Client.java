package 结构型模式.Composite_Pattern.example003;

import java.util.ArrayList;
import java.util.List;

// 客户端代码
public class Client {
    public static void main(String[] args) {
        FileSystemComponent file1 = new File("file1.txt");
        FileSystemComponent file2 = new File("file2.txt");
        FileSystemComponent file3 = new File("file3.txt");

        FileSystemComponent subDirectory1 = new Directory("Sub Directory 1");
        subDirectory1.addComponent(file1);
        subDirectory1.addComponent(file2);

        FileSystemComponent subDirectory2 = new Directory("Sub Directory 2");
        subDirectory2.addComponent(file3);

        FileSystemComponent rootDirectory = new Directory("Root Directory");
        rootDirectory.addComponent(subDirectory1);
        rootDirectory.addComponent(subDirectory2);

        rootDirectory.display();
    }
}



interface FileSystemComponent {
    void display();
    void addComponent(FileSystemComponent component); // 声明方法
}

class File implements FileSystemComponent {
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println("File: " + name);
    }

    @Override
    public void addComponent(FileSystemComponent component) {
        throw new UnsupportedOperationException("Cannot add component to a file");
    }
}

class Directory implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components;

    public Directory(String name) {
        this.name = name;
        this.components = new ArrayList<>();
    }

    @Override
    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    @Override
    public void display() {
        System.out.println("Directory: " + name);
        for (FileSystemComponent component : components) {
            component.display();
        }
    }
}
