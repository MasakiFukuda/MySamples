import java.util.List;

public class Tester{
    public static void main(String[] args){
        int count = Integer.parseInt(args[0]);
        
        for(int i = 0;i < count;i ++){
            String uId = UniqueKeyGenerator.generateKeys();
            UniqueKeyGenerator.getHashCode(uId);
            
        }
        
    }
}