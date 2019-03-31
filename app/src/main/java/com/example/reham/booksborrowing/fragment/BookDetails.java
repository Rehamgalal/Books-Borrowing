package com.example.reham.booksborrowing.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.reham.booksborrowing.Data.Book;
import com.example.reham.booksborrowing.Data.ImageLinks;
import com.example.reham.booksborrowing.Data.Items;
import com.example.reham.booksborrowing.Data.VolumeInformation;
import com.example.reham.booksborrowing.OnListFragmentInteractionListener;
import com.example.reham.booksborrowing.R;
import com.example.reham.booksborrowing.Retrofit.ApiClient;
import com.example.reham.booksborrowing.Retrofit.BooksService;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookDetails extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.bookimage)
    ImageView bookImage;
    @BindViews({R.id.booktitle,R.id.bookauthor,R.id.bookcategory,R.id.bookpublisher,R.id.bookdescription,R.id.pagecount,R.id.booklanguage})
    List<TextView> textViews;
    @BindViews({R.id.reading,R.id.borrowing,R.id.lending})
    List<CheckBox> checkBoxes;
    @BindView(R.id.previewlink)
    Button previewLink;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public BookDetails() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BookDetails.
     */
    // TODO: Rename and change types and number of parameters
    public static BookDetails newInstance(String param1, String param2) {
        BookDetails fragment = new BookDetails();
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
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_book_details, container, false);
        ButterKnife.bind(this,view);
        String id=getArguments().getString("id");
        final Context mContext= view.getContext();
        BooksService booksService= ApiClient.getClient().create(BooksService.class);
        Call<Items> call=booksService.getBook(id);
        call.enqueue(new Callback<Items>() {
            @Override
            public void onResponse(Call<Items> call, Response<Items> response) {
                Items item=response.body();
                VolumeInformation informations=item.getVolumeInformation();
                String image=informations.getImageLinks().getMedium();
                Log.i("imagePath","the"+image);
              Picasso.with(mContext).load(image).into(bookImage);
                String[] Author=informations.getAuthor();
                String[] Categories=informations.getCategories();
                textViews.get(0).setText(informations.getTitle());
                textViews.get(1).setText("by: "+Author[0]);
                textViews.get(2).setText("Categories: "+Categories[0]);
                textViews.get(3).setText("Published by: "+informations.getPublisher());
                textViews.get(4).setText(informations.getDescription());
                textViews.get(4).setTextSize(20f);
                textViews.get(5).setText(informations.getPageCount()+" pages");
                textViews.get(6).setText("Book Language: "+informations.getLanguage());
              }
            @Override
            public void onFailure(Call<Items> call, Throwable t) {

            }
        });
    return view;}

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String item) {
        if (mListener != null) {
            mListener.onFragmentInteraction(item);
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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String item);
    }
}
