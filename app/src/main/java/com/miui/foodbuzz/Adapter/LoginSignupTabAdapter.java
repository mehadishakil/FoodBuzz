package com.miui.foodbuzz.Adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.miui.foodbuzz.Fragments.LoginTabFragment;
import com.miui.foodbuzz.Fragments.SignUpTabFragment;

public class LoginSignupTabAdapter extends FragmentStateAdapter {
    private Context context;
    int totalTabs;
    private String[] tabs = new String[]{"Login", "Signup"};

    public LoginSignupTabAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, Context context, int totalTabs) {
        super(fragmentManager, lifecycle);
        this.context = context;
        this.totalTabs = totalTabs;
    }



    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
                LoginTabFragment loginTabFragment = new LoginTabFragment();
                return loginTabFragment;
            case 1:
                SignUpTabFragment signUpTabFragment = new SignUpTabFragment();
                return signUpTabFragment;
            default:
                return null;
        }
    }


    @Override
    public int getItemCount() {
        return tabs.length;
    }

}
