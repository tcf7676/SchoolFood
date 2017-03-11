package com.ealgles.cmf.daeyoung;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by TCF on 2017-01-30.
 */

public class RecyclerViewOnClickListener implements RecyclerView.OnItemTouchListener{
    private OnItemClickListener onItemClickListener;
    private GestureDetector gestureDetector;
    RecyclerViewOnClickListener(Context context, RecyclerView recyclerView, OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onSingleTapUp(MotionEvent event){
                return true;
            }

        });
    }
    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View childView = rv.findChildViewUnder(e.getX(),e.getY());
        if (childView != null && onItemClickListener != null && gestureDetector.onTouchEvent(e)) {
            onItemClickListener.onItemClick(childView, rv.getChildAdapterPosition(childView));
            return true;
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
    public interface OnItemClickListener{
        public void onItemClick(View view, int position);
    }
}
