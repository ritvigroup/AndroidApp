package com.ritvi.cms.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ritvi.cms.R;
import com.ritvi.cms.adapter.ViewPagerWithTitleAdapter;
import com.ritvi.cms.fragment.connection.ConnectionLeaderFragment;
import com.ritvi.cms.fragment.connection.FriendsFragment;
import com.ritvi.cms.fragment.connection.OutgoingFragment;
import com.ritvi.cms.fragment.connection.RequestFragment;
import com.ritvi.cms.fragment.connection.SearchFragment;
import com.ritvi.cms.fragment.connection.SuggestionFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sunil on 27-02-2018.
 */

public class MyConnectionFragment extends Fragment{
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tabs)
    TabLayout tabs;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frag_my_connection,container,false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpTabswithViewPager();
    }

    public void setUpTabswithViewPager() {
        setupViewPager(viewPager);
        viewPager.setOffscreenPageLimit(2);
        tabs.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerWithTitleAdapter adapter = new ViewPagerWithTitleAdapter(getChildFragmentManager());
        adapter.addFrag(new SuggestionFragment(), "Suggestion");
        adapter.addFrag(new SearchFragment(), "Search");
        adapter.addFrag(new RequestFragment(), "Request");
        adapter.addFrag(new ContactFragment(), "Contact");
        adapter.addFrag(new FriendsFragment(), "Friends");
        adapter.addFrag(new ConnectionLeaderFragment(), "Leader");
        adapter.addFrag(new OutgoingFragment(), "Outgoing");
        viewPager.setAdapter(adapter);

    }
}
