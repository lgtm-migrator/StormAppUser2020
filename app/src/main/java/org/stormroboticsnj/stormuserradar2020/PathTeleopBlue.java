package org.stormroboticsnj.stormuserradar2020;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PathTeleopBlue.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PathTeleopBlue#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PathTeleopBlue extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public PathTeleopBlue() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PathTeleopBlue.
     */
    // TODO: Rename and change types and number of parameters
    public static PathTeleopBlue newInstance(String param1, String param2) {
        PathTeleopBlue fragment = new PathTeleopBlue();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Declare view object for the layout
        View view = inflater.inflate(R.layout.fragment_path_teleop_red, container, false);

        // Declare Checkbox objects for different robot scoring zones
        CheckBox safePortZone = view.findViewById(R.id.cboPortSafeZoneB);
        CheckBox frontInitLine = view.findViewById(R.id.cboFrontLineB);
        CheckBox behindInitLine = view.findViewById(R.id.cboBehindLineB);
        CheckBox frontControlPanel = view.findViewById(R.id.cboFrontControlPanelB);
        CheckBox behindControlPanel = view.findViewById(R.id.cboBehindControlPanelB);
        CheckBox frontShield = view.findViewById(R.id.cboFrontShieldB);
        CheckBox behindShield = view.findViewById(R.id.cboBehindShieldB);

        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.cboPortSafeZoneB:
            case R.id.cboFrontLineB:
            case R.id.cboBehindLineB:
            case R.id.cboFrontControlPanelB:
            case R.id.cboBehindControlPanelB:
            case R.id.cboFrontShieldB:
            case R.id.cboBehindShieldB:
                if (checked){
                    // Rotation/Position control stage is complete
                } else {
                    // Rotation/Position control stage is not complete
                }
                break;
        }

        // Inflate the layout for this fragment
        return view;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
