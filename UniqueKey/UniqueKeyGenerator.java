import java.util.UUID;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class UniqueKeyGenerator{
    public static String generateKeys(){
    
        String uId = UUID.randomUUID().toString();

        System.out.println("uId = "+uId);


        return uId;
    }
    
    public static String getHashCode(String uId){

        MessageDigest md5 = null;
        
        try{
            md5 = MessageDigest.getInstance("MD5");
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        
        md5.update(uId.getBytes());
        byte[] hash = md5.digest();
        
        String mdStr = hexString(hash);
        
        System.out.println("生成されたハッシュキー : "+mdStr);
        
        
        return mdStr;
    }
    
    private static String hexString(byte[] bin){
        String str = "";
        int size = bin.length;
        
        for(int i = 0;i < size;i++){
            int n = bin[i];
            if(i < 0){
                n += 256;
            }
            String hex = Integer.toHexString(n);
            
            if(hex.length() == 1){
                hex = "0" + hex;
            }
            
            str += hex;
        }
        
        return str;
    }
}

// import java.util.UUID;
// import java.util.List;
// import java.util.ArrayList;

// import java.security.MessageDigest;
// import java.security.NoSuchAlgorithmException;

// public abstract class UniqueKeyGenerator{
//     public static List generateKeys(int count){
//         List result = new ArrayList();
        
//         for(int i = 0;i < count;i++){
//             System.out.println();
            
//             System.out.println((i+1)+"番目のユニークキーを生成します");
            
//             String uId = UUID.randomUUID().toString();

            
//             System.out.println("uId = "+uId);

//             MessageDigest md5 = null;
//             try{
//                 md5 = MessageDigest.getInstance("MD5");
//             }catch(NoSuchAlgorithmException e){
//                 e.printStackTrace();
//             }
//             md5.update(uId.getBytes());
//             byte[] hash = md5.digest();
            
//             String mdStr = hexString(hash);
            
//             System.out.println("生成されたハッシュキー : "+mdStr);
            
            
//             result.add(mdStr);
//         }
        
//         return result;
//     }
    
//     private static String hexString(byte[] bin){
//         String str = "";
//         int size = bin.length;
        
//         for(int i = 0;i < size;i++){
//             int n = bin[i];
//             if(i < 0){
//                 n += 256;
//             }
//             String hex = Integer.toHexString(n);
            
//             if(hex.length() == 1){
//                 hex = "0" + hex;
//             }
            
//             str += hex;
//         }
        
//         return str;
//     }
// }