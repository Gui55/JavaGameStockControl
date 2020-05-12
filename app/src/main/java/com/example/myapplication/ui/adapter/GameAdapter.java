package com.example.myapplication.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.services.model.Game;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.GameViewHolder> {

    public ArrayList<Game> games;
    ButtonClickListener buttonClickListenerA;
    ButtonClickListener buttonClickListenerB;

    public GameAdapter(ArrayList<Game> games, ButtonClickListener buttonClickListenerA, ButtonClickListener buttonClickListenerB) {
        this.games = games;
        this.buttonClickListenerA = buttonClickListenerA;
        this.buttonClickListenerB = buttonClickListenerB;
    }

    public interface ButtonClickListener{
        void onButtonClick(Game game);
    }

    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GameViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_line, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GameViewHolder holder, int position) {
        Game game = games.get(position);

        Picasso.get().load(game.getImage()).into(holder.photo);
        holder.name.setText(game.getId() +". "+game.getName());
        holder.stock.setText("Estoque: "+ game.getStock());

        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClickListenerA.onButtonClick(game);
            }
        });

        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClickListenerB.onButtonClick(game);
            }
        });
    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    public class GameViewHolder extends RecyclerView.ViewHolder{

        TextView name, stock;
        ImageView photo;

        ImageButton minus, plus;

        public GameViewHolder(@NonNull View itemView) {
            super(itemView);

            photo = itemView.findViewById(R.id.gamePhoto);
            name = itemView.findViewById(R.id.gameName);
            stock = itemView.findViewById(R.id.gameStock);

            minus = itemView.findViewById(R.id.minusButton);
            plus = itemView.findViewById(R.id.plusButton);
        }
    }


}
