package com.example.appfragmentos4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();
    }


    public void addA(View view){
        FragmentA fragmentA= (FragmentA) manager.findFragmentByTag("A");
        if(fragmentA==null){
            fragmentA=new FragmentA();
            FragmentTransaction transaction=manager.beginTransaction();
            transaction.add(R.id.contenedor,fragmentA,"A");
            transaction.commit();
        }else{
            Toast.makeText(getApplicationContext(),"El fragmento A ya existe ",Toast.LENGTH_LONG).show();
        }
    }

    public void addB(View view){
        FragmentB fragmentB= (FragmentB) manager.findFragmentByTag("B");
        if(fragmentB==null){
            fragmentB=new FragmentB();
            FragmentTransaction transaction=manager.beginTransaction();
            transaction.add(R.id.contenedor,fragmentB,"B");
            transaction.commit();
        }else{
            Toast.makeText(getApplicationContext(),"El fragmento B ya existe ",Toast.LENGTH_LONG).show();
        }
    }

    public void removeA(View view){
        FragmentA fragmentA= (FragmentA) manager.findFragmentByTag("A");
        if(fragmentA!=null){
            FragmentTransaction transaction=manager.beginTransaction();
            transaction.remove(fragmentA);
            transaction.commit();
        }else{
            Toast.makeText(getApplicationContext(),"El fragmento A aun no ha sido agregado este fragmento",Toast.LENGTH_LONG).show();
        }
    }

    public void removeB(View view){
        FragmentB fragmentB= (FragmentB) manager.findFragmentByTag("B");
        if(fragmentB!=null){
            FragmentTransaction transaction=manager.beginTransaction();
            transaction.remove(fragmentB);
            transaction.commit();
        }else{
            Toast.makeText(getApplicationContext(),"El fragmento B aun no ha sido agregado este fragmento",Toast.LENGTH_LONG).show();
        }
    }

    public void replaceAWithB(View view){
        FragmentB fb=new FragmentB();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.contenedor,fb,"B");
        transaction.commit();
    }

    public void replaceBWithA(View view){
        FragmentA fb=new FragmentA();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.contenedor,fb,"A");
        transaction.commit();
    }

    public void attachA(View view){
        FragmentA fragmentA= (FragmentA) manager.findFragmentByTag("A");
        if(fragmentA!=null){
            FragmentTransaction transaction=manager.beginTransaction();
            transaction.attach(fragmentA);
            transaction.commit();
        }
    }

    public void detachA(View view){
        FragmentA fragmentA= (FragmentA) manager.findFragmentByTag("A");
        if(fragmentA!=null){
            FragmentTransaction transaction=manager.beginTransaction();
            transaction.detach(fragmentA);
            transaction.commit();
        }

    }





}