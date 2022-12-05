package com.gerry.myquote.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gerry.myquote.Model.QuoteModel;
import com.gerry.myquote.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterQuote extends RecyclerView.Adapter<AdapterQuote.ViewHolderQuote>{
    private List<QuoteModel>ListQuote = new ArrayList<>();
    private Context ctx;

    public AdapterQuote(List<QuoteModel> listQuote, Context ctx) {
        ListQuote = listQuote;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ViewHolderQuote onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.item_quote,parent,false);
        return new ViewHolderQuote(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderQuote holder, int position) {
        QuoteModel QM = ListQuote.get(position);
        holder.tvText.setText(QM.getText());
        holder.tvAuthor.setText(QM.getAuthor());

    }

    @Override
    public int getItemCount() {
        return ListQuote.size();
    }

    public class ViewHolderQuote extends RecyclerView.ViewHolder {
        TextView tvText, tvAuthor;
        public ViewHolderQuote(@NonNull View itemView) {
            super(itemView);
            tvText = itemView.findViewById(R.id.tv_text);
            tvAuthor = itemView.findViewById(R.id.tv_author);
        }
    }
}
