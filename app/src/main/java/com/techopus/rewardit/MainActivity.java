package com.techopus.rewardit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.net.Uri;
import android.os.Bundle;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.techopus.rewardit.databinding.ActivityMainBinding;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());




        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct!=null){
            String personName = acct.getDisplayName();
            String personEmail = acct.getEmail();




        }

        binding.bottomNavigationView.setOnItemReselectedListener(item -> {

            switch (item.getItemId()){

                case R.id.main_home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.invite:
                    replaceFragment(new InviteFragment());
                    break;
                case R.id.wallet:
                    replaceFragment(new WalletFragment());
                    break;
                case R.id.profile:
                    replaceFragment(new ProfileFragment());
                    break;

            }

        });

    }

    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }
}