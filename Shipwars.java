import java.util.*;
public class Shipwars{
  public static void main(String[] args){
    Scanner reader = new Scanner(System.in);
    int [][] player1 = new int[10][10];
    int [][] enemy1 = new int[10][10];
    Field player = new Field(2, 3, 3, 2, player1);
    Field enemy = new Field( 2, 3 , 3, 2, enemy1);
    System.out.print("choose dificulty(1-3)");
    int d = reader.nextInt();
    if(d == 1){
      enemy.setShip1(1);
      enemy.setShip2(1);
      enemy.setShip3(1);
      enemy.setShip4(1);
    }
      else if(d == 3){
        enemy.setShip1(1);
        enemy.setShip2(0);
        enemy.setShip3(0);
        enemy.setShip4(0);
      }
      player.create();
      enemy.create();
      while(true){
        System.out.println("********************YOUR DESK************************");
        System.out.println("                  0 1 2 3 4 5 6 7 8 9");
        player.printPlayer();
        System.out.println("********************ENEMY DESK***********************");
        System.out.println("                  0 1 2 3 4 5 6 7 8 9");
        enemy.printEnemy();
        System.out.println("Âגוהטעו םמלונ נÿהךא א ןמעמל סעמכבצא קעמ סענוכÿעü");
        int x = reader.nextInt();
        int y = reader.nextInt();
        if(x < 0 || x > 9 || y < 0 || y > 9){
          System.out.println("Error;77195855410");
        }
        else{
          enemy.playerFire(x,y);
          if(enemy.ship() == 0){
            System.out.println("YOU WIN");
            break;
          }
          player.enemyFire();
          if(player.ship() == 0){
            System.out.println("YOU LOSE");
          break;
          }
        }
        
      }
      reader.close();
  }
}
    