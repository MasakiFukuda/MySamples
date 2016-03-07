public class Main{
    public static void main(String[] args){
        String loginId = args[0];
        String password = args[1];
        
        String hash = PasswordSaffer.getStretchedPassword(password,loginId);
        System.out.println(hash);
        System.out.println(hash.length());
        
    }
}