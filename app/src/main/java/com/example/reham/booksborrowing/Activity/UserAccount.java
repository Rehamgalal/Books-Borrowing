package com.example.reham.booksborrowing.Activity;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.example.reham.booksborrowing.OnListFragmentInteractionListener;
import com.example.reham.booksborrowing.R;
import com.example.reham.booksborrowing.fragment.BookDetails;
import com.example.reham.booksborrowing.fragment.BooksFragment;
import com.example.reham.booksborrowing.fragment.ItemFragment;
import com.example.reham.booksborrowing.fragment.SettingFragment;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserAccount extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener,
        SettingFragment.OnFragmentInteractionListener,
BooksFragment.OnListFragmentInteractionListener,
BookDetails.OnFragmentInteractionListener{
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.showlist)
    ImageButton showlist;
    @BindView(R.id.list_container)
    FrameLayout frameLayout;
    boolean on=false;
    String FRAGMENT_TAG= "ItemFragment";
    String FRAGMENT_TAG2= "Setting";
    String FRAGMENT_TAG3= "ItemBookFragment";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);
        ButterKnife.bind(this);
       // frameLayout.setVisibility(View.GONE);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        showlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (on==false){
                    on=true;
               // frameLayout.setVisibility(View.VISIBLE);
                ItemFragment itemFragment= new ItemFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction= fragmentManager.beginTransaction();
                transaction.setCustomAnimations(R.anim.enter_from_left,R.anim.exit_to_left);
                transaction.addToBackStack(null);
                transaction.add(R.id.list_container,itemFragment,FRAGMENT_TAG).commit();}
                else  {
                    on=false;
                    Fragment fragment = getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG);
                    FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
                    transaction.setCustomAnimations(R.anim.enter_from_left,R.anim.exit_to_left);
                    transaction.remove(fragment).commit();
                }
            }
        });
    }

    @Override
    public void onListFragmentInteraction(String item) {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG);
        FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_left,R.anim.exit_to_left);
        transaction.remove(fragment).commit();
        if (item.equals(getResources().getString(R.string.settings))){
            on=false;
            SettingFragment settingFragment= new SettingFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.settings_container,settingFragment,FRAGMENT_TAG2).commit();
        }else if (item.equals(getResources().getString(R.string.logout))){
            FirebaseAuth.getInstance().signOut();
            finish();
        }else if (item.equals(getResources().getString(R.string.home))){
            Fragment listBragment = getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG2);
            BooksFragment booksFragment= new BooksFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.settings_container,booksFragment,FRAGMENT_TAG3).commit();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onListFragmentInteraction(String id, String data) {
        Fragment bookList= getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG3);
        BookDetails bookDetails= new BookDetails();
        Bundle bundle=new Bundle();
        bundle.putString("id",data);
        bookDetails.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.settings_container,bookDetails).commit();
    }

    @Override
    public void onFragmentInteraction(String item) {

    }
}
