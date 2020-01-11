package com.example.stormuserradar2020;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.stormroboticsnj.stormuserradar2020.MainActivity;
import org.stormroboticsnj.stormuserradar2020.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Auto.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Auto#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Auto extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Auto() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Auto.
     */
    // TODO: Rename and change types and number of parameters
    public static Auto newInstance(String param1, String param2) {
        Auto fragment = new Auto();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_auto, container, false);

        final Button lessBottomBtn = view.findViewById(R.id.abtnLessBottom);
        final Button moreBottomBtn = view.findViewById(R.id.abtnMoreBottom);
        final Button lessOuterBtn = view.findViewById(R.id.abtnLessOuter);
        final Button moreOuterBtn = view.findViewById(R.id.abtnMoreOuter);
        final Button lessInnerBtn = view.findViewById(R.id.abtnLessInner);
        final Button moreInnerBtn = view.findViewById(R.id.abtnMoreInner);
        final Button lessIntakeBtn = view.findViewById(R.id.abtnLessIntake);
        final Button moreIntakeBtn = view.findViewById(R.id.abtnMoreIntake);

        final TextView bottomScoreTxt = view.findViewById(R.id.atxtNumScoredBottom);
        final TextView outerScoreTxt = view.findViewById(R.id.atxtNumScoredOuter);
        final TextView innerScoreTxt = view.findViewById(R.id.atxtNumScoredInner);
        final TextView intakeScoreTxt = view.findViewById(R.id.atxtNumScoredIntake);

        final MainActivity act = (MainActivity) getActivity();

        moreBottomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                act.incaPowerCell1();
                bottomScoreTxt.setText(String.valueOf(act.getaPowerCell1()));
            }
        });
        lessBottomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                act.decaPowerCell1();
                bottomScoreTxt.setText(String.valueOf(act.getaPowerCell1()));
            }
        });
        moreOuterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                act.incaPowerCell2();
                bottomScoreTxt.setText(String.valueOf(act.getaPowerCell2()));
            }
        });





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
