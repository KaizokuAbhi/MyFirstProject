package com.example.shoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.example.shoes.databinding.ActivityMainBinding;

import java.util.Objects;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    String Email,Password;
    String EmailRegex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String Email = Objects.requireNonNull(binding.email.getEditText()).getText().toString().trim();
        String Password = Objects.requireNonNull(binding.password.getEditText()).getText().toString().trim();
        binding.signin.setOnClickListener(view -> {
            if (!emailValidate() || !passwordValidate()){
                Toast.makeText(MainActivity.this, "Authenticatio Failed", Toast.LENGTH_SHORT).show();
            }
            startActivity(new Intent(getApplicationContext(),MainActivity2.class));
        });
    }
    private boolean emailValidate(){
        if(TextUtils.isEmpty(Email)){
            binding.email.setError("Email cannot be Empty");
            binding.email.requestFocus();
            return false;
        }
        binding.email.setError(null);
        return true;
    }
    private boolean passwordValidate(){
        if(TextUtils.isEmpty(Password)){
            binding.password.setError("Password cannot be Empty");
            binding.password.requestFocus();
            return false;
        }
        binding.password.setError(null);
        return true;
    }
}