package kg.kloop.rinat.newcarel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private CarelGrid grid;
    private GameCanvas canvas;
    private Carel carel;

    Button bts;

    //Дальше ничего не меняем.*************************************




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        move();
        move();
        turnRight();
        move();
        move();
        stepBack();


    }//Здесь пишем новые методы.***********************************

    private void stepBack() {
        turnLeft();
        turnLeft();
        move();
        turnLeft();
        turnLeft();
    }

    private void turnRight() {
        turnLeft();
        turnLeft();
        turnLeft();
    }


    private void move(){
        carel.move();
    }

    private void turnLeft(){
        carel.turnLeft();
    }

    private void collectBeeper(){
        carel.collectBeeper();
    }

    private void dropBeeper(){
        carel.dropBeeper();
    }

    private boolean isFrontClear(){
        return carel.isFrontClear();
    }

    private boolean isBeeper(){
        return carel.isBeeper();
    }


    private void init() {
        textView = (TextView)findViewById(R.id.textView);
        grid = new CarelGrid();
        canvas = new GameCanvas(textView);
        carel = new Carel(canvas, grid);
    }
}