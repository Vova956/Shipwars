public class Field{
  private int ship1;
  private int ship2;
  private int ship3;
  private int ship4;
  private int[][] arr;
  
  public Field(int ship1, int ship2, int ship3, int ship4, int[][] arr){
    this.ship1 = ship1;
    this.ship2 = ship2;
    this.ship3 = ship3;
    this.ship4 = ship4;
    this.arr = arr;
  }
  
  public void reset(){
    for(int i = 0;i < 10;i++){
      for(int j = 0;j < 10;j++){
        arr[i][j] = 0; 
      }
    }
  }
  
  public void setShip1(int ship1){this.ship1 = ship1;}
  public void setShip2(int ship2){this.ship2 = ship2;}
  public void setShip3(int ship3){this.ship3 = ship3;}
  public void setShip4(int ship4){this.ship4 = ship4;}
 
  
  public void printEnemy(){
    System.out.print("                ");
    for(int i = 0;i < 10;i++){
      for(int j = 0;j < 10;j++){
        if(j == 0)
          System.out.print(i + " ");
        if(arr[i][j] == 0 || arr[i][j] == 1)
          System.out.print("* ");
        else if(arr[i][j] == 2)
          System.out.print("- ");
        else if (arr[i][j] == 3)
          System.out.print("[] ");
      }
      System.out.println(" " + i);
      System.out.print("                ");
    }
    System.out.println("  0 1 2 3 4 5 6 7 8 9");
  }
  
  public void printPlayer(){
    System.out.print("                ");
    for(int i = 0;i < 10;i++){
      for(int j = 0;j < 10;j++){
        if(j == 0)
          System.out.print(i + " ");
        if(arr[i][j] == 0)
          System.out.print("* ");
        else if(arr[i][j] == 1)
          System.out.print("# ");
        else if(arr[i][j] == 2)
          System.out.print("- ");
        else if (arr[i][j] == 3)
          System.out.print("[] ");
      }
      System.out.println(" " + i);
      System.out.print("                ");
    }
    System.out.println("  0 1 2 3 4 5 6 7 8 9");
  }
  
  public void create4(){
    int x = (int)(Math.random()*10);
    int y = (int)(Math.random()*10);
    int v = (int)(Math.random()*5);
    if(v == 1 && x - 3 >= 0){
      for(int i = 0;i < 4;i++){
        arr[x - i][y] = 1;
      }
    }
    else if(v == 2 && y + 3 <= 9){
      for(int i = 0;i < 4;i++){
        arr[x][y + i] = 1;
      }
    }
    else if (v == 3 && x + 3 <= 9){
      for(int i = 0;i < 4;i++){
        arr[x + i][y] = 1;
      }
    }
    else if(v == 4 && y - 3 >= 0){
      for(int i = 0;i < 4;i++){
        arr[x][y - i] = 1;
      }
    }
    else{
      create4();
    }
  }
  
  public void create3(){
    int x = (int)(Math.random()*10);
    int y = (int)(Math.random()*10);
    if(arr[x][y] == 0){
      int v = (int)(Math.random()*5);
      if(v == 1 && x - 2 >= 0 && arr[x-1][y] == 0 && arr[x-2][y] == 0){
        for(int i = 0;i < 3;i++){
          arr[x - i][y] = 1;
        }
      }
      else if(v == 2 && y + 2 <= 9 && arr[x][y+1] == 0 && arr[x][y+2] == 0){
        for(int i = 0;i < 3;i++){
          arr[x][y + i] = 1;
        }
      }
      else if (v == 3 && x + 2 <= 9 && arr[x+1][y] == 0 && arr[x+2][y] == 0){
        for(int i = 0;i < 3;i++){
          arr[x + i][y] = 1;
        }
      }
      else if(v == 4 && y - 2 >= 0 && arr[x][y-1] == 0 && arr[x][y-1] == 0){
        for(int i = 0;i < 3;i++){
          arr[x][y - i] = 1;
        }
      }
      else{
        create3();
      }
    }
  }
  
  public void create2(){
    int x = (int)(Math.random()*10);
    int y = (int)(Math.random()*10);
    int v = (int)(Math.random()*5);
    if(v == 1 && x - 1 >= 0 && arr[x-1][y] == 0){
      for(int i = 0;i < 2;i++){
        arr[x - i][y] = 1;
      }
    }
    else if(v == 2 && y + 1 <= 9 && arr[x][y+1] == 0){
      for(int i = 0;i < 2;i++){
        arr[x][y + i] = 1;
      }
    }
    else if (v == 3 && x + 1 <= 9 && arr[x+1][y] == 0){
      for(int i = 0;i < 2;i++){
        arr[x + i][y] = 1;
      }
    }
    else if(v == 4 && y - 1 >= 0 && arr[x][y-1] == 0){
      for(int i = 0;i < 2;i++){
        arr[x][y - i] = 1;
      }
    }
    else{ 
      create2();
    }
  }
  
  public void create1(){
    int x = (int)(Math.random()*10);
    int y = (int)(Math.random()*10);
    if(arr[x][y] == 0){
      arr[x][y] = 1;
    }
    else{ 
      create1();
    }
  }
  
  public void create(){
    reset();
    for(int i = 0;i < ship4;i++)
      create4();
    for(int i = 0;i < ship3;i++)
      create3();
    for(int i = 0;i < ship2;i++){
      create2();
    }
    for(int i = 0;i < ship1;i++){
      create1();
    }
  }
  
  public void playerFire(int x, int y){
    if(arr[x][y] == 1){
      arr[x][y] = 3;
      System.out.print("Ти попал!");
    }
    else if(arr[x][y] == 0){
      arr[x][y] = 2;
      System.out.println("Промах!");
    }
    else{
      System.out.println("Чел ти туда уже стрелял, лол, не трать партони.");
    }
  }
  
  public void enemyFire(){
    int x  = (int)(Math.random()*10);
    int y  = (int)(Math.random()*10);
    if(arr[x][y] == 0){
      arr[x][y] = 2;
    }
    else if (arr[x][y] == 1){
      arr[x][y] = 3;
    }
    else if(arr[x][y] == 2 || arr[x][y] == 3)
      enemyFire();
  }
  public int ship(){
    int y = 0;
    for(int i = 0;i < 10;i++){
      for(int j = 0;j < 10;j++){
        if(arr[i][j] == 1)
          y++;
      }
    }
    return y;
  }
}
  
  
  
  
  
  
  
  
  
