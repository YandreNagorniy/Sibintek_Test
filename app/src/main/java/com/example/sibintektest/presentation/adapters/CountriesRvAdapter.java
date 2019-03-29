package com.example.sibintektest.presentation.adapters;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.sibintektest.R;
import com.example.sibintektest.data.pojo.CountriesModel;
import com.example.sibintektest.data.pojo.CountriesModelInfo;
import com.example.sibintektest.databinding.CardCountriesBinding;
import com.example.sibintektest.presentation.info.InfoActivityImpl;
import com.example.sibintektest.presentation.main.MainActivityImpl;

import java.util.List;

public class CountriesRvAdapter extends RecyclerView.Adapter<CountriesRvAdapter.ViewHolder> {
    private List<CountriesModel> list;
    private Context mContext;

    public CountriesRvAdapter(List<CountriesModel> list, MainActivityImpl mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public CountriesRvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        CardCountriesBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.card_countries, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.setCountry(list.get(position));
        Glide.with(mContext)
                .load(list.get(position).flag)
                .into(holder.binding.ivFlag);

        holder.itemView.setOnClickListener(v -> {
            String name = list.get(position).name;
            Intent intent = new Intent(mContext, InfoActivityImpl.class);
            intent.putExtra("countryName", name);
            mContext.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        CardCountriesBinding binding;

        ViewHolder(CardCountriesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
