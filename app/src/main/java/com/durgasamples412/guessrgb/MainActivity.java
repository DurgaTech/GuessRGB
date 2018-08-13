package com.durgasamples412.guessrgb;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    double randomcolor;
    TextView title;
    Button c1,c2,c3,c4,c5,c6,c7,c8,c9,level;
    int pickedcolor;
    List<RGB>cardcolors,cardcolors2;
    boolean isrowvisible = false;
    boolean isrow1visible = false;
    boolean isIsrow3visible =false;
    LinearLayout row1,row2,row3;
    Button playagain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c1 = findViewById(R.id.c1b);
        c2 = findViewById(R.id.c2b);
        row1 = findViewById(R.id.row1);
        row2 = findViewById(R.id.row2);
        c3 = findViewById(R.id.c3b);
        c7 = findViewById(R.id.c7b);
        c8 = findViewById(R.id.c8b);
        c9 = findViewById(R.id.c9b);
        row3 = findViewById(R.id.row3);
        level = findViewById(R.id.level);
        c4 = findViewById(R.id.c4b);
        c5 = findViewById(R.id.c5b);
        c6 = findViewById(R.id.c6b);
        title = findViewById(R.id.rgbcode);
        playagain = findViewById(R.id.playagain);
        cardcolors = new ArrayList <>();
        cardcolors2 = new ArrayList <>();

        row3.setVisibility(View.INVISIBLE);
        for (int i = 0; i < 6; i++) {
            RGB rgb = new RGB();
            isrow1visible = true;
            rgb.setR(Math.floor(Math.random() * 256));
            rgb.setG(Math.floor(Math.random() * 256));
            rgb.setB(Math.floor(Math.random() * 256));
            cardcolors.add(rgb);

            Log.d("rgb colors", rgb.toString());
        }
        pickedcolor = (int) Math.floor(Math.random() * cardcolors.size());
        title.setText("Guess this " + cardcolors.get(pickedcolor).toString());
        c1.setBackgroundColor(Color.rgb((int) cardcolors.get(0).getR(), (int) cardcolors.get(0).getG(), (int) cardcolors.get(0).getB()));
        c2.setBackgroundColor(Color.rgb((int) cardcolors.get(1).getR(), (int) cardcolors.get(1).getG(), (int) cardcolors.get(1).getB()));
        c3.setBackgroundColor(Color.rgb((int) cardcolors.get(2).getR(), (int) cardcolors.get(2).getG(), (int) cardcolors.get(2).getB()));
        c4.setBackgroundColor(Color.rgb((int) cardcolors.get(3).getR(), (int) cardcolors.get(3).getG(), (int) cardcolors.get(3).getB()));
        c5.setBackgroundColor(Color.rgb((int) cardcolors.get(4).getR(), (int) cardcolors.get(4).getG(), (int) cardcolors.get(4).getB()));
        c6.setBackgroundColor(Color.rgb((int) cardcolors.get(5).getR(), (int) cardcolors.get(5).getG(), (int) cardcolors.get(5).getB()));




        level.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_items);
                final RadioButton rb1 = dialog.findViewById(R.id.cb1);
                final RadioButton rb2 = dialog.findViewById(R.id.cb2);
                final RadioButton rb3 = dialog.findViewById(R.id.cb3);

                rb1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(rb1.isChecked()){
                            cardcolors.clear();
                            dialog.cancel();
                            isrow1visible = true;
                            row2.setVisibility(View.INVISIBLE);
                            row3.setVisibility(View.INVISIBLE);
                            for (int i = 0; i < 3; i++) {
                                RGB rgb = new RGB();
                                rgb.setR(Math.floor(Math.random() * 256));
                                rgb.setG(Math.floor(Math.random() * 256));
                                rgb.setB(Math.floor(Math.random() * 256));
                                cardcolors.add(rgb);

                                Log.d("rgb 3 colors", rgb.toString());
                            }
                            pickedcolor = (int) Math.floor(Math.random() * cardcolors.size());
                            Log.d("Pickedcolor",cardcolors.get(pickedcolor).toString());
                            title.setText("Guess this " + cardcolors.get(pickedcolor).toString());
                            c1.setBackgroundColor(Color.rgb((int) cardcolors.get(0).getR(), (int) cardcolors.get(0).getG(), (int) cardcolors.get(0).getB()));
                            c2.setBackgroundColor(Color.rgb((int) cardcolors.get(1).getR(), (int) cardcolors.get(1).getG(), (int) cardcolors.get(1).getB()));
                            c3.setBackgroundColor(Color.rgb((int) cardcolors.get(2).getR(), (int) cardcolors.get(2).getG(), (int) cardcolors.get(2).getB()));

                        }

                    }
                });

                rb2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(rb2.isChecked()){
                            dialog.cancel();
                           cardcolors.clear();
                            row2.setVisibility(View.VISIBLE);

                                row3.setVisibility(View.INVISIBLE);
                                for (int i = 0; i < 6; i++) {
                                    RGB rgb = new RGB();
                                    rgb.setR(Math.floor(Math.random() * 256));
                                    rgb.setG(Math.floor(Math.random() * 256));
                                    rgb.setB(Math.floor(Math.random() * 256));
                                    cardcolors.add(rgb);

                                    Log.d("rgb 6 colors", rgb.toString());
                                }
                                pickedcolor = (int) Math.floor(Math.random() * cardcolors.size());
                                Log.d("Pickedcolor",cardcolors.get(pickedcolor).toString());
                                title.setText("Guess this " + cardcolors.get(pickedcolor).toString());
                                c1.setBackgroundColor(Color.rgb((int) cardcolors.get(0).getR(), (int) cardcolors.get(0).getG(), (int) cardcolors.get(0).getB()));
                                c2.setBackgroundColor(Color.rgb((int) cardcolors.get(1).getR(), (int) cardcolors.get(1).getG(), (int) cardcolors.get(1).getB()));
                                c3.setBackgroundColor(Color.rgb((int) cardcolors.get(2).getR(), (int) cardcolors.get(2).getG(), (int) cardcolors.get(2).getB()));
                                c4.setBackgroundColor(Color.rgb((int) cardcolors.get(3).getR(), (int) cardcolors.get(3).getG(), (int) cardcolors.get(3).getB()));
                                c5.setBackgroundColor(Color.rgb((int) cardcolors.get(4).getR(), (int) cardcolors.get(4).getG(), (int) cardcolors.get(4).getB()));
                                c6.setBackgroundColor(Color.rgb((int) cardcolors.get(5).getR(), (int) cardcolors.get(5).getG(), (int) cardcolors.get(5).getB()));

                            /*else {
                                isIsrow3visible=false;
                                row3.setVisibility(View.VISIBLE);
                                for (int i = 0; i < 9; i++) {
                                    RGB rgb = new RGB();
                                    rgb.setR(Math.floor(Math.random() * 256));
                                    rgb.setG(Math.floor(Math.random() * 256));
                                    rgb.setB(Math.floor(Math.random() * 256));
                                    cardcolors.add(rgb);

                                    Log.d("rgb 9 colors", rgb.toString());
                                }
                                pickedcolor = (int) Math.floor(Math.random() * cardcolors.size());
                                Log.d("Pickedcolor",cardcolors.get(pickedcolor).toString());
                                title.setText("Guess this " + cardcolors.get(pickedcolor).toString());
                                c1.setBackgroundColor(Color.rgb((int) cardcolors.get(0).getR(), (int) cardcolors.get(0).getG(), (int) cardcolors.get(0).getB()));
                                c2.setBackgroundColor(Color.rgb((int) cardcolors.get(1).getR(), (int) cardcolors.get(1).getG(), (int) cardcolors.get(1).getB()));
                                c3.setBackgroundColor(Color.rgb((int) cardcolors.get(2).getR(), (int) cardcolors.get(2).getG(), (int) cardcolors.get(2).getB()));
                                c4.setBackgroundColor(Color.rgb((int) cardcolors.get(3).getR(), (int) cardcolors.get(3).getG(), (int) cardcolors.get(3).getB()));
                                c5.setBackgroundColor(Color.rgb((int) cardcolors.get(4).getR(), (int) cardcolors.get(4).getG(), (int) cardcolors.get(4).getB()));
                                c6.setBackgroundColor(Color.rgb((int) cardcolors.get(5).getR(), (int) cardcolors.get(5).getG(), (int) cardcolors.get(5).getB()));
                                c7.setBackgroundColor(Color.rgb((int) cardcolors.get(6).getR(), (int) cardcolors.get(6).getG(), (int) cardcolors.get(6).getB()));
                                c8.setBackgroundColor(Color.rgb((int) cardcolors.get(7).getR(), (int) cardcolors.get(7).getG(), (int) cardcolors.get(7).getB()));
                                c9.setBackgroundColor(Color.rgb((int) cardcolors.get(8).getR(), (int) cardcolors.get(8).getG(), (int) cardcolors.get(8).getB()));

                            }
*/
                        }
                    }
                });

                rb3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(row3.getVisibility()==View.INVISIBLE) {
                            dialog.cancel();
                            cardcolors.clear();
                            isIsrow3visible = true;
                            row3.setVisibility(View.VISIBLE);
                            row2.setVisibility(View.VISIBLE);
                            row1.setVisibility(View.VISIBLE);
                            for (int i = 0; i < 9; i++) {
                                RGB rgb = new RGB();
                                rgb.setR(Math.floor(Math.random() * 256));
                                rgb.setG(Math.floor(Math.random() * 256));
                                rgb.setB(Math.floor(Math.random() * 256));
                                cardcolors.add(rgb);
                                Log.d("rgb 9 colors", rgb.toString());

                            }
                            pickedcolor = (int) Math.floor(Math.random() * cardcolors.size());
                            Log.d("Pickedcolor", cardcolors.get(pickedcolor).toString());
                            title.setText("Guess this " + cardcolors.get(pickedcolor).toString());
                            c1.setBackgroundColor(Color.rgb((int) cardcolors.get(0).getR(), (int) cardcolors.get(0).getG(), (int) cardcolors.get(0).getB()));
                            c2.setBackgroundColor(Color.rgb((int) cardcolors.get(1).getR(), (int) cardcolors.get(1).getG(), (int) cardcolors.get(1).getB()));
                            c3.setBackgroundColor(Color.rgb((int) cardcolors.get(2).getR(), (int) cardcolors.get(2).getG(), (int) cardcolors.get(2).getB()));
                            c4.setBackgroundColor(Color.rgb((int) cardcolors.get(3).getR(), (int) cardcolors.get(3).getG(), (int) cardcolors.get(3).getB()));
                            c5.setBackgroundColor(Color.rgb((int) cardcolors.get(4).getR(), (int) cardcolors.get(4).getG(), (int) cardcolors.get(4).getB()));
                            c6.setBackgroundColor(Color.rgb((int) cardcolors.get(5).getR(), (int) cardcolors.get(5).getG(), (int) cardcolors.get(5).getB()));
                           c7.setVisibility(View.VISIBLE);
                            c8.setVisibility(View.VISIBLE);
                            c9.setVisibility(View.VISIBLE);

                            c7.setBackgroundColor(Color.rgb((int) cardcolors.get(6).getR(), (int) cardcolors.get(6).getG(), (int) cardcolors.get(6).getB()));
                            c8.setBackgroundColor(Color.rgb((int) cardcolors.get(7).getR(), (int) cardcolors.get(7).getG(), (int) cardcolors.get(7).getB()));
                            c9.setBackgroundColor(Color.rgb((int) cardcolors.get(8).getR(), (int) cardcolors.get(8).getG(), (int) cardcolors.get(8).getB()));
                        }
                    }
                });
                dialog.setTitle("Select a level");
                dialog.show();

            }
        });

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cardcolors.get(0).getR() == cardcolors.get(pickedcolor).getR() && cardcolors.get(0).getG() == cardcolors.get(pickedcolor).getG()
                        && cardcolors.get(0).getB() == cardcolors.get(pickedcolor).getB()) {
                    Toast.makeText(MainActivity.this, "yes they are equal", Toast.LENGTH_SHORT).show();
                    c2.setVisibility(View.GONE);
                    c3.setVisibility(View.GONE);
                    c4.setVisibility(View.GONE);
                    c5.setVisibility(View.GONE);
                    c6.setVisibility(View.GONE);
                    c7.setVisibility(View.GONE);
                    c8.setVisibility(View.GONE);
                    c9.setVisibility(View.GONE);

                } else {
                    Toast.makeText(MainActivity.this, "choose another one", Toast.LENGTH_SHORT).show();
                    c1.setVisibility(View.GONE);
                }

            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cardcolors.get(1).getR() == cardcolors.get(pickedcolor).getR() && cardcolors.get(1).getG() == cardcolors.get(pickedcolor).getG()
                        && cardcolors.get(1).getB() == cardcolors.get(pickedcolor).getB()) {
                    Toast.makeText(MainActivity.this, "yes they are equal", Toast.LENGTH_SHORT).show();
                    c1.setVisibility(View.GONE);
                    c3.setVisibility(View.GONE);
                    c4.setVisibility(View.GONE);
                    c5.setVisibility(View.GONE);
                    c6.setVisibility(View.GONE);
                    c7.setVisibility(View.GONE);
                    c8.setVisibility(View.GONE);
                    c9.setVisibility(View.GONE);

                } else {
                    Toast.makeText(MainActivity.this, "choose another one", Toast.LENGTH_SHORT).show();
                    c2.setVisibility(View.GONE);
                }
            }
        });

        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cardcolors.get(2).getR() == cardcolors.get(pickedcolor).getR() && cardcolors.get(2).getG() == cardcolors.get(pickedcolor).getG()
                        && cardcolors.get(2).getB() == cardcolors.get(pickedcolor).getB()) {
                    Toast.makeText(MainActivity.this, "yes they are equal", Toast.LENGTH_SHORT).show();
                    c2.setVisibility(View.GONE);
                    c1.setVisibility(View.GONE);
                    c4.setVisibility(View.GONE);
                    c5.setVisibility(View.GONE);
                    c6.setVisibility(View.GONE);
                    c7.setVisibility(View.GONE);
                    c8.setVisibility(View.GONE);
                    c9.setVisibility(View.GONE);

                } else {
                    Toast.makeText(MainActivity.this, "choose another one", Toast.LENGTH_SHORT).show();
                    c3.setVisibility(View.GONE);
                }
            }
        });

        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cardcolors.get(3).getR() == cardcolors.get(pickedcolor).getR() && cardcolors.get(3).getG() == cardcolors.get(pickedcolor).getG()
                        && cardcolors.get(3).getB() == cardcolors.get(pickedcolor).getB()) {
                    Toast.makeText(MainActivity.this, "yes they are equal", Toast.LENGTH_SHORT).show();
                    c2.setVisibility(View.GONE);
                    c3.setVisibility(View.GONE);
                    c1.setVisibility(View.GONE);
                    c5.setVisibility(View.GONE);
                    c6.setVisibility(View.GONE);
                    c7.setVisibility(View.GONE);
                    c8.setVisibility(View.GONE);
                    c9.setVisibility(View.GONE);

                } else {
                    Toast.makeText(MainActivity.this, "choose another one", Toast.LENGTH_SHORT).show();
                    c4.setVisibility(View.GONE);
                }
            }
        });

        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cardcolors.get(4).getR() == cardcolors.get(pickedcolor).getR() && cardcolors.get(4).getG() == cardcolors.get(pickedcolor).getG()
                        && cardcolors.get(4).getB() == cardcolors.get(pickedcolor).getB()) {
                    Toast.makeText(MainActivity.this, "yes they are equal", Toast.LENGTH_SHORT).show();
                    c2.setVisibility(View.GONE);
                    c3.setVisibility(View.GONE);
                    c4.setVisibility(View.GONE);
                    c1.setVisibility(View.GONE);
                    c6.setVisibility(View.GONE);
                    c7.setVisibility(View.GONE);
                    c8.setVisibility(View.GONE);
                    c9.setVisibility(View.GONE);

                } else {
                    Toast.makeText(MainActivity.this, "choose another one", Toast.LENGTH_SHORT).show();
                    c5.setVisibility(View.GONE);
                }
            }
        });

        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cardcolors.get(5).getR() == cardcolors.get(pickedcolor).getR() && cardcolors.get(5).getG() == cardcolors.get(pickedcolor).getG()
                        && cardcolors.get(5).getB() == cardcolors.get(pickedcolor).getB()) {
                    Toast.makeText(MainActivity.this, "yes they are equal", Toast.LENGTH_SHORT).show();
                    c2.setVisibility(View.GONE);
                    c3.setVisibility(View.GONE);
                    c4.setVisibility(View.GONE);
                    c5.setVisibility(View.GONE);
                    c1.setVisibility(View.GONE);
                    c7.setVisibility(View.GONE);
                    c8.setVisibility(View.GONE);
                    c9.setVisibility(View.GONE);

                } else {
                    Toast.makeText(MainActivity.this, "choose another one", Toast.LENGTH_SHORT).show();
                    c6.setVisibility(View.GONE);
                }
            }
        });

        c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cardcolors.get(6).getR() == cardcolors.get(pickedcolor).getR() && cardcolors.get(6).getG() == cardcolors.get(pickedcolor).getG()
                        && cardcolors.get(6).getB() == cardcolors.get(pickedcolor).getB()) {
                    Toast.makeText(MainActivity.this, "yes they are equal", Toast.LENGTH_SHORT).show();
                    c2.setVisibility(View.GONE);
                    c3.setVisibility(View.GONE);
                    c4.setVisibility(View.GONE);
                    c5.setVisibility(View.GONE);
                    c1.setVisibility(View.GONE);
                    c6.setVisibility(View.GONE);
                    c8.setVisibility(View.GONE);
                    c9.setVisibility(View.GONE);

                } else {
                    Toast.makeText(MainActivity.this, "choose another one", Toast.LENGTH_SHORT).show();
                    c7.setVisibility(View.GONE);
                }
            }
        });


        c8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cardcolors.get(7).getR() == cardcolors.get(pickedcolor).getR() && cardcolors.get(7).getG() == cardcolors.get(pickedcolor).getG()
                        && cardcolors.get(7).getB() == cardcolors.get(pickedcolor).getB()) {
                    Toast.makeText(MainActivity.this, "yes they are equal", Toast.LENGTH_SHORT).show();
                    c2.setVisibility(View.GONE);
                    c3.setVisibility(View.GONE);
                    c4.setVisibility(View.GONE);
                    c5.setVisibility(View.GONE);
                    c1.setVisibility(View.GONE);
                    c7.setVisibility(View.GONE);
                    c6.setVisibility(View.GONE);
                    c9.setVisibility(View.GONE);

                } else {
                    Toast.makeText(MainActivity.this, "choose another one", Toast.LENGTH_SHORT).show();
                    c8.setVisibility(View.GONE);
                }
            }
        });


        c9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cardcolors.get(8).getR() == cardcolors.get(pickedcolor).getR() && cardcolors.get(8).getG() == cardcolors.get(pickedcolor).getG()
                        && cardcolors.get(8).getB() == cardcolors.get(pickedcolor).getB()) {
                    Toast.makeText(MainActivity.this, "yes they are equal", Toast.LENGTH_SHORT).show();
                    c2.setVisibility(View.GONE);
                    c3.setVisibility(View.GONE);
                    c4.setVisibility(View.GONE);
                    c5.setVisibility(View.GONE);
                    c1.setVisibility(View.GONE);
                    c7.setVisibility(View.GONE);
                    c8.setVisibility(View.GONE);
                    c6.setVisibility(View.GONE);

                } else {
                    Toast.makeText(MainActivity.this, "choose another one", Toast.LENGTH_SHORT).show();
                    c9.setVisibility(View.GONE);
                }
            }
        });


        playagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(c4.getVisibility()==View.INVISIBLE&&c7.getVisibility()==View.INVISIBLE){
                    cardcolors.clear();
                    for (int i = 0; i < 3; i++) {
                        RGB rgb2 = new RGB();
                        rgb2.setR(Math.floor(Math.random() * 256));
                        rgb2.setG(Math.floor(Math.random() * 256));
                        rgb2.setB(Math.floor(Math.random() * 256));
                        cardcolors.add(rgb2);

                    }
                    Log.d("playagain 3 colors",cardcolors.toString());
                    c1.setBackgroundColor(Color.rgb((int) cardcolors.get(0).getR(), (int) cardcolors.get(0).getG(), (int) cardcolors.get(0).getB()));
                    c2.setBackgroundColor(Color.rgb((int) cardcolors.get(1).getR(), (int) cardcolors.get(1).getG(), (int) cardcolors.get(1).getB()));
                    c3.setBackgroundColor(Color.rgb((int) cardcolors.get(2).getR(), (int) cardcolors.get(2).getG(), (int) cardcolors.get(2).getB()));

                    pickedcolor = (int) Math.floor(Math.random() * cardcolors.size());
                    Log.d("pickedcolor", cardcolors.get(pickedcolor).toString());
                    Log.d("firstlistafterplayagain", cardcolors.get(0).toString());
                    title.setText("Guess this " + cardcolors.get(pickedcolor).toString());

                    c1.setVisibility(View.VISIBLE);
                    c2.setVisibility(View.VISIBLE);
                    c3.setVisibility(View.VISIBLE);

                }else
                if(row3.getVisibility()==View.VISIBLE){
                    cardcolors.clear();
                    Toast.makeText(MainActivity.this, ""+isrowvisible, Toast.LENGTH_SHORT).show();
                    for (int i = 0; i < 9; i++) {
                        RGB rgb2 = new RGB();
                        rgb2.setR(Math.floor(Math.random() * 256));
                        rgb2.setG(Math.floor(Math.random() * 256));
                        rgb2.setB(Math.floor(Math.random() * 256));
                        cardcolors.add(rgb2);

                    }

                    c1.setBackgroundColor(Color.rgb((int) cardcolors.get(0).getR(), (int) cardcolors.get(0).getG(), (int) cardcolors.get(0).getB()));
                    c2.setBackgroundColor(Color.rgb((int) cardcolors.get(1).getR(), (int) cardcolors.get(1).getG(), (int) cardcolors.get(1).getB()));
                    c3.setBackgroundColor(Color.rgb((int) cardcolors.get(2).getR(), (int) cardcolors.get(2).getG(), (int) cardcolors.get(2).getB()));
                    c4.setBackgroundColor(Color.rgb((int) cardcolors.get(3).getR(), (int) cardcolors.get(3).getG(), (int) cardcolors.get(3).getB()));
                    c5.setBackgroundColor(Color.rgb((int) cardcolors.get(4).getR(), (int) cardcolors.get(4).getG(), (int) cardcolors.get(4).getB()));
                    c6.setBackgroundColor(Color.rgb((int) cardcolors.get(5).getR(), (int) cardcolors.get(5).getG(), (int) cardcolors.get(5).getB()));
                    c7.setBackgroundColor(Color.rgb((int) cardcolors.get(6).getR(), (int) cardcolors.get(6).getG(), (int) cardcolors.get(6).getB()));
                    c8.setBackgroundColor(Color.rgb((int) cardcolors.get(7).getR(), (int) cardcolors.get(7).getG(), (int) cardcolors.get(7).getB()));
                    c9.setBackgroundColor(Color.rgb((int) cardcolors.get(8).getR(), (int) cardcolors.get(8).getG(), (int) cardcolors.get(8).getB()));


                    pickedcolor = (int) Math.floor(Math.random() * cardcolors.size());
                    Log.d("pickedcolor", cardcolors.get(pickedcolor).toString());
                    Log.d("firstlistafterplayagai", cardcolors.get(0).toString());
                    title.setText("Guess this " + cardcolors.get(pickedcolor).toString());

                    c1.setVisibility(View.VISIBLE);
                    c2.setVisibility(View.VISIBLE);
                    c3.setVisibility(View.VISIBLE);

                    c4.setVisibility(View.VISIBLE);
                    c5.setVisibility(View.VISIBLE);
                    c6.setVisibility(View.VISIBLE);

                    c7.setVisibility(View.VISIBLE);
                    c8.setVisibility(View.VISIBLE);
                    c9.setVisibility(View.VISIBLE);


                }else  {
                    cardcolors.clear();
                    for (int i = 0; i < 6; i++) {
                        RGB rgb2 = new RGB();
                        rgb2.setR(Math.floor(Math.random() * 256));
                        rgb2.setG(Math.floor(Math.random() * 256));
                        rgb2.setB(Math.floor(Math.random() * 256));
                        cardcolors.add(rgb2);

                        Log.d("rgb colors", rgb2.toString());
                    }


                    c1.setBackgroundColor(Color.rgb((int) cardcolors.get(0).getR(), (int) cardcolors.get(0).getG(), (int) cardcolors.get(0).getB()));
                    c2.setBackgroundColor(Color.rgb((int) cardcolors.get(1).getR(), (int) cardcolors.get(1).getG(), (int) cardcolors.get(1).getB()));
                    c3.setBackgroundColor(Color.rgb((int) cardcolors.get(2).getR(), (int) cardcolors.get(2).getG(), (int) cardcolors.get(2).getB()));
                    c4.setBackgroundColor(Color.rgb((int) cardcolors.get(3).getR(), (int) cardcolors.get(3).getG(), (int) cardcolors.get(3).getB()));
                    c5.setBackgroundColor(Color.rgb((int) cardcolors.get(4).getR(), (int) cardcolors.get(4).getG(), (int) cardcolors.get(4).getB()));
                    c6.setBackgroundColor(Color.rgb((int) cardcolors.get(5).getR(), (int) cardcolors.get(5).getG(), (int) cardcolors.get(5).getB()));

                    pickedcolor = (int) Math.floor(Math.random() * cardcolors.size());
                    Log.d("pickedcolor", cardcolors.get(pickedcolor).toString());
                    Log.d("firstlistafterplayagai", cardcolors.get(0).toString());
                    title.setText("Guess this " + cardcolors.get(pickedcolor).toString());

                    c1.setVisibility(View.VISIBLE);
                    c2.setVisibility(View.VISIBLE);
                    c3.setVisibility(View.VISIBLE);
                    c4.setVisibility(View.VISIBLE);
                    c5.setVisibility(View.VISIBLE);
                    c6.setVisibility(View.VISIBLE);
                }


            }

        });

    }

}
