public class Tester{
    public static void main(String[] args) throws java.io.IOException{
        ImageResizer resize = new ImageResizer();
        String result = resize.doResize(new java.io.File("sample.jpg"),1500,500);
        System.out.println(result);
    }
}