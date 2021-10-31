package com.example.app14recyclerviewfilmtasarimi;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.CardViewTasarimiNesneleriniTutucu> {

    private Context mContext;
    private List<Filmler> filmlerList;

    public FilmAdapter(Context mContext, List<Filmler> filmlerList) {
        this.mContext = mContext;
        this.filmlerList = filmlerList;
    }

    public class CardViewTasarimiNesneleriniTutucu extends RecyclerView.ViewHolder {

        public ImageView imageViewFilmResim;
        public TextView textViewFilmBaslik;
        public TextView textViewFilmFiyat;
        public Button buttonSepeteEkle;

        public CardViewTasarimiNesneleriniTutucu(@NonNull View itemView) {
            super(itemView);
            imageViewFilmResim = itemView.findViewById(R.id.imageViewFilmResim);
            textViewFilmBaslik = itemView.findViewById(R.id.textViewFilmBaslik);
            textViewFilmFiyat = itemView.findViewById(R.id.textViewFilmFiyat);
            buttonSepeteEkle = itemView.findViewById(R.id.buttonSepeteEkle);

        }
    }

    @NonNull
    @Override
    public CardViewTasarimiNesneleriniTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.card_film_tasarim, parent, false);
        return new CardViewTasarimiNesneleriniTutucu(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewTasarimiNesneleriniTutucu holder, int position) {

        final Filmler film = filmlerList.get(position);

        holder.textViewFilmBaslik.setText(film.getFilm_ad());
        holder.textViewFilmFiyat.setText(film.getFilm_fiyat()+"");
        holder.imageViewFilmResim.setImageResource(mContext.getResources()
                .getIdentifier(film.getFilm_resim_ad(), "drawable", mContext.getPackageName()));

        //holder.imageViewFilmResim.setImageResource(R.drawable.interstellar);

        holder.buttonSepeteEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Sepete Eklenen Film : " +film.getFilm_ad(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return filmlerList.size();
    }

}
