package com.droidplanner.fragments.helpers;

import java.util.ArrayList;

import android.app.Fragment;
import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGestureListener;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.droidplanner.R;

public class GestureMapFragment extends Fragment implements OnGestureListener {
	private GestureOverlayView overlay;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.gesture_map_fragment, container,
				false);
		overlay = (GestureOverlayView) view.findViewById(R.id.overlay1);
		overlay.addOnGestureListener(this);
		return view;
	}

	public void enableGestureDetection() {
		overlay.setEnabled(true);
	}
	
	@Override
	public void onGestureEnded(GestureOverlayView arg0, MotionEvent arg1) {
		Log.d("GESTURE", "ENDED ");
		overlay.setEnabled(false);

		ArrayList<Point> path = new ArrayList<Point>();
		float[] points = overlay.getGesture().getStrokes().get(0).points;
		for (int i = 0; i < points.length; i += 2) {
			path.add(new Point((int) points[i], (int) points[i + 1]));
		}
		for (Point point : path) {
			Log.d("GESTURE", "P: " + point.toString());
		}
	}

	@Override
	public void onGesture(GestureOverlayView arg0, MotionEvent arg1) {
	}

	@Override
	public void onGestureCancelled(GestureOverlayView arg0, MotionEvent arg1) {
	}

	@Override
	public void onGestureStarted(GestureOverlayView arg0, MotionEvent arg1) {
	}


}
