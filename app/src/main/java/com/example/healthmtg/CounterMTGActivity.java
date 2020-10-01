package com.example.healthmtg;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.pwittchen.swipe.library.rx2.Swipe;
import com.github.pwittchen.swipe.library.rx2.SwipeListener;




public class CounterMTGActivity extends AppCompatActivity {

    private Swipe swipe;
    int life_pl1 = 20;
    int life_pl2 = 20;
    int infect_pl1 = 0;
    int infect_pl2 = 0;
    boolean infect_activity_pl1 = false;
    boolean infect_activity_pl2 = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //TODO finire splash screen
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipe = new Swipe();

        //da qui in poi ci sono le funzioni per gli eventi di swipe su/giù/destra/sinistra
        //TODO mettere le texwiev in focus per lo swipe

        swipe.setListener(new SwipeListener() {

            @Override public void onSwipingLeft(final MotionEvent event) {
            }

            @Override public boolean onSwipedLeft(final MotionEvent event) {
                TextView tv = (TextView) findViewById(R.id.life_pl2);

                if (infect_activity_pl2 == false) {
                    tv.setBackground(getResources().getDrawable(R.drawable.infect));
                    infect_activity_pl2 = true;
                    tv.setText(String.valueOf(infect_pl2));
                }else if(infect_activity_pl2 == true){
                    tv.setBackgroundColor(0x66000000);
                    infect_activity_pl2 = false;
                    tv.setText(String.valueOf(life_pl2));
                }
                return false;
            }

            @Override public void onSwipingRight(final MotionEvent event) {
            }

            @Override public boolean onSwipedRight(final MotionEvent event) {

                TextView tv = (TextView) findViewById(R.id.life_pl1);
                if (infect_activity_pl1 == false) {
                    tv.setBackground(getResources().getDrawable(R.drawable.infect));
                    infect_activity_pl1 = true;
                    tv.setText(String.valueOf(infect_pl1));
                }else if(infect_activity_pl1 == true){
                    tv.setBackgroundColor(0x66000000); 
                    infect_activity_pl1 = false;
                    tv.setText(String.valueOf(life_pl1));

                }
                return false;
            }

            @Override public void onSwipingUp(final MotionEvent event) {
                // info.setText("SWIPING_UP");
            }

            @Override public boolean onSwipedUp(final MotionEvent event) {
                //info.setText("SWIPED_UP");
                return false;
            }

            @Override public void onSwipingDown(final MotionEvent event) {
                //info.setText("SWIPING_DOWN");
            }

            @Override public boolean onSwipedDown(final MotionEvent event) {
                //info.setText("SWIPED_DOWN");
                return false;
            }
        });
    }

    @Override public boolean dispatchTouchEvent(MotionEvent event) {
        swipe.dispatchTouchEvent(event);
        return super.dispatchTouchEvent(event);
    }

    //da qui in poi ci sono le funzioni dei tasti per aumentare/diminuire i punti vita/infettare

    public void changeUpLP1(View v) {
        TextView tv = (TextView) findViewById(R.id.life_pl1);
        if(infect_activity_pl1  && infect_pl1 == 10){

        }else if(!infect_activity_pl1  || infect_pl1 < 10) {

            if (!infect_activity_pl1) {

                life_pl1++;
                tv.setText(String.valueOf(life_pl1));
                if (life_pl1 > 0) {
                    tv.setTextColor(Color.WHITE);
                }
            } else if (infect_activity_pl1) {

                infect_pl1++;
                tv.setText(String.valueOf(infect_pl1));
                if (infect_pl1 != 10) {
                    tv.setTextColor(Color.WHITE);
                } else if (infect_pl1 == 10) {
                    tv.setTextColor(Color.RED);
                }

            }
        }
    }

    public void changeDownLP1(View v) {
        TextView tv = (TextView) findViewById(R.id.life_pl1);
        if(infect_activity_pl1  && infect_pl1 == 0){

        }else if(!infect_activity_pl1  || infect_pl1 != 0) {
            if (!infect_activity_pl1) {

                life_pl1--;
                tv.setText(String.valueOf(life_pl1));
                if (life_pl1 > 0) {
                    tv.setTextColor(Color.WHITE);
                }
            } else if (infect_activity_pl1) {

                infect_pl1--;
                tv.setText(String.valueOf(infect_pl1));
                if (infect_pl1 != 10) {
                    tv.setTextColor(Color.WHITE);
                } else if (infect_pl1 == 10) {
                    tv.setTextColor(Color.RED);
                }

            }
        }
    }

    public void changeUpLP2(View v) {
        TextView tv = (TextView) findViewById(R.id.life_pl2);

        if(infect_activity_pl2  && infect_pl2 == 10){

        }else if(!infect_activity_pl2  || infect_pl2 < 10){

            if(!infect_activity_pl2 ) {

                life_pl2++;
                tv.setText(String.valueOf(life_pl2));

                if (life_pl2 > 0) {

                    tv.setTextColor(Color.WHITE);

                }
            }
            else if(infect_activity_pl2){

                infect_pl2 ++;
                tv.setText(String.valueOf(infect_pl2));

                if (infect_pl2 != 10) {

                    tv.setTextColor(Color.WHITE);

                }else if(infect_pl2 ==10){

                    tv.setTextColor(Color.RED);

                }
            }
        }

    }

    public void changeDownLP2(View v) {
        TextView tv = (TextView) findViewById(R.id.life_pl2);

        if (infect_activity_pl2 && infect_pl2 == 0) {

        } else if (!infect_activity_pl2 || infect_pl2 != 0) {
            if (!infect_activity_pl2) {

                life_pl2--;
                tv.setText(String.valueOf(life_pl2));

                if (life_pl1 <= 0) {
                    tv.setTextColor((Color.RED));
                }
            } else if (infect_activity_pl2) {

                infect_pl2--;
                tv.setText(String.valueOf(infect_pl2));
                if (infect_pl2 != 10) {
                    tv.setTextColor(Color.WHITE);
                } else if (infect_pl2 == 10) {
                    tv.setTextColor(Color.RED);
                }
            }
        }
    }
}






