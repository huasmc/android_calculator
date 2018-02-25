package com.example.huascar.calculator;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.huascar.calculator.databinding.ActivityMainBinding;
import com.example.huascar.calculator.models.Calculator;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Calculator calculator = new Calculator();


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        }

        public void onNumberClick(View view) {
            Button button = (Button) view;
            String result = this.getButtonText(button);
            this.setValueView(result);

            int number = Integer.parseInt(result);
            calculator.numberClick(number);
        }

        public void onOperatorClick(View view) {
            Button button = (Button) view;
            String result = this.getButtonText(button);

            calculator.operatorClick(result);
        }

        public void onDotClick (View view) {
            Button button = (Button) view;
            String result = this.getButtonText(button);

//            calculator.addDot(result);
        }

        private String getButtonText(Button button) {
            String result = button.getText().toString();
            return result;
        }

        private void setValueView(String value){
            binding.editText.setText(binding.editText.getText() + value);
        }
}
