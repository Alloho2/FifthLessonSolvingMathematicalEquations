package com.msaggik.fifthlessonsolvingmathematicalequations;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;
public class MainActivity extends AppCompatActivity {

    // поля
    private TextView equationOne, equationTwo, equationThree; // поля вывода примеров
    private EditText solvingOne, solvingTwo, solvingThree; // поля ввода ответов
    private int[] equationValue; // массив шести числел (для трёх примеров)
    private boolean right = false; // флаг правильности решения примеров
    private Button refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // привязка к полям
        equationOne = findViewById(R.id.equationOne);
        equationTwo = findViewById(R.id.equationTwo);
        equationThree = findViewById(R.id.equationThree);
        solvingOne = findViewById(R.id.solvingOne);
        solvingTwo = findViewById(R.id.solvingTwo);
        solvingThree = findViewById(R.id.solvingThree);
        refresh = findViewById(R.id.refresh);
        refresh.setOnClickListener(listenerRefresh);

        // формирование массива случайных чисел
        equationValue = valueArrayRandom();

        // заполнение строк примерами для решения
        equationOne.setText(equationValue[0] + " + " + equationValue[1] + " = ");
        equationTwo.setText(equationValue[2] + " + " + equationValue[3] + " = ");
        equationThree.setText(equationValue[4] + " + " + equationValue[5] + " = ");

        // обработаем фокусировку/снятие фокусировки с EditText
        solvingOne.setOnFocusChangeListener(focusListener);
        solvingTwo.setOnFocusChangeListener(focusListener);
        solvingThree.setOnFocusChangeListener(focusListener);
    }

    // создание слушателя фокусировку/снятие фокусировки с EditText

    private View.OnFocusChangeListener focusListener = new View.OnFocusChangeListener() {
        @Override

        public void onFocusChange(View view, boolean b) {


            // с помощью view.getId() определение с каким виджетом происходят действия

            switch (view.getId()) {

                case R.id.solvingOne:
                    try {
                        if (!b) { // при потери фокуса производим проверку введённого числа
                            // если посчитано верно
                            if (Integer.parseInt(solvingOne.getText().toString()) == (equationValue[0] + equationValue[1])) {
                                solvingOne.setBackgroundColor(Color.GREEN); // закрашиваем в зелённый цвет
                                right = true;
                            } else { // иначе
                                solvingOne.setBackgroundColor(Color.RED); // закрашиваем в красный цвет
                                right = false;
                            }
                        }
                    } catch (Exception e) {
                        solvingOne.setHint("Введите ответ");
                    }
                    break;
                case R.id.solvingTwo:
                    try {
                        if (!b) { // при потери фокуса производим проверку введённого числа
                            // если посчитано верно
                            if (Integer.parseInt(solvingTwo.getText().toString()) == (equationValue[2] + equationValue[3])) {
                                solvingTwo.setBackgroundColor(Color.GREEN); // закрашиваем в зелённый цвет
                                right = true;
                            } else { // иначе
                                solvingTwo.setBackgroundColor(Color.RED); // закрашиваем в красный цвет
                                right = false;
                            }
                        }
                    } catch (Exception e) {
                        solvingTwo.setHint("Введите ответ");
                    }
                    break;
                case R.id.solvingThree:
                    try {
                        if (!b) { // при потери фокуса производим проверку введённого числа
                            // если посчитано верно
                            if (Integer.parseInt(solvingThree.getText().toString()) == (equationValue[4] + equationValue[5])) {
                                solvingThree.setBackgroundColor(Color.GREEN); // закрашиваем в зелённый цвет
                                right = true;
                            } else { // иначе
                                solvingThree.setBackgroundColor(Color.RED); // закрашиваем в красный цвет
                                right = false;
                            }
                        }
                    } catch (Exception e) {
                        solvingThree.setHint("Введите ответ");
                    }
                    break;
            }
        }
    };

    private View.OnClickListener listenerRefresh = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            solvingOne.setText("");
            solvingTwo.setText("");
            solvingThree.setText("");
            solvingOne.setBackgroundColor(Color.rgb(231, 228, 236));
            solvingTwo.setBackgroundColor(Color.rgb(231, 228, 236));
            solvingThree.setBackgroundColor(Color.rgb(231, 228, 236));
            equationValue = valueArrayRandom();
            equationOne.setText(equationValue[0] + " + " + equationValue[1] + " = ");
            equationTwo.setText(equationValue[2] + " + " + equationValue[3] + " = ");
            equationThree.setText(equationValue[4] + " + " + equationValue[5] + " = ");
        }
    };

    // метод генерации массива 6 случайных чисел (для трёх примеров)
    private int[] valueArrayRandom() {
        Random random = new Random(); // создание объекта класса Random
        int[] arrayValue = new int[6]; // создание массива для заполнения
        for (int i = 0; i < arrayValue.length; i++) { // цикл заполнения массива случайными числами
            arrayValue[i] = random.nextInt(99) + 1;
        }
        return arrayValue;
    }
}