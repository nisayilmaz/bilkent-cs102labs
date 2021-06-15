public class Game {
    public static void main(String[] args) {
        //FilledFrame frame = new FilledFrame();
        int goal =(int) Math.random() * 25;
        int bomb1 = 0;
        int bomb2 = 0;
         
        
        do {
            bomb2 = (int) Math.random() * 25;
        } while (bomb2 == goal || bomb2 == bomb1);
        do {
            bomb1 = (int) Math.random() * 25;
        } while (bomb1 == goal || bomb1 == bomb2);
        System.out.println(bomb1+"," + bomb2+"," +goal);
    }
}
