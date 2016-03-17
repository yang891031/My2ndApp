package com.example.yang.my2ndapp;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.shinelw.library.ColorArcProgressBar;

//import com.blackcj.designsupportexample.adapters.RecyclerViewAdapter;

/**
 * Created by chris.black on 6/11/15.
 */
public class PageFragment3 extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private SwipeRefreshLayout mSwipeRefreshLayout;
    //protected RecyclerViewAdapter.OnItemClickListener mCallback;
    private int mPage;
    private Button button3;
    private ColorArcProgressBar bar3;


    public static PageFragment3 create(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        PageFragment3 fragment = new PageFragment3();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page3, container, false);

        /*RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this.getActivity(), 2));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mPage);
        recyclerView.setAdapter(adapter);
        if(mCallback != null) {
            adapter.setOnItemClickListener(mCallback);
        }*/

        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.contentView3);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }, 1000);
            }
        });
        mSwipeRefreshLayout.setEnabled(false);
        bar3 = (ColorArcProgressBar) view.findViewById(R.id.bar3);
        button3 = (Button) view.findViewById(R.id.button3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bar3.setCurrentValues(77);
            }
        });
        return view;
    }

    /*@Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof RecyclerViewAdapter.OnItemClickListener) {
            mCallback = (RecyclerViewAdapter.OnItemClickListener)activity;
        }
    }*/

    @Override
    public void onPause() {
        super.onPause();
        if (mSwipeRefreshLayout != null) {
            mSwipeRefreshLayout.setRefreshing(false);
            mSwipeRefreshLayout.setEnabled(false);
            mSwipeRefreshLayout.destroyDrawingCache();
            mSwipeRefreshLayout.clearAnimation();
        }
    }

    public void setSwipeToRefreshEnabled(boolean enabled) {
        mSwipeRefreshLayout.setEnabled(enabled);
    }

    /**
     * Clear callback on detach to prevent null reference errors after the view has been
     */
    /*@Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }*/
}
