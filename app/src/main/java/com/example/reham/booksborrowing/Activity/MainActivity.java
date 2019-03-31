package com.example.reham.booksborrowing.Activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.reham.booksborrowing.R;
import com.example.reham.booksborrowing.fragment.Login;
import com.example.reham.booksborrowing.fragment.SignUp_Fragment;

public class MainActivity extends AppCompatActivity implements SignUp_Fragment.OnFragmentInteractionListener,Login.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment signup = new SignUp_Fragment();
        FragmentManager fragmentManager= getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.container,signup).commit();
    }

    @Override
    public void onFragmentInteraction(String className, Button button) {
        if(button==null){
        Fragment fragment = null;
        Class fragmentClass=null;
        if (className.equals("login")){
            fragmentClass= Login.class;
        }else if (className.equals("signup")){
            fragmentClass= SignUp_Fragment.class;
        }
        try {
            fragment = (Fragment) fragmentClass.newInstance(); }
        catch (Exception e) {
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();}
        else if (button!=null){
            Intent intent= new Intent(MainActivity.this,UserAccount.class);
            startActivity(intent);

        }

    }
}
