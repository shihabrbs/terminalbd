package com.terminalbd.www.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import com.terminalbd.www.R;
import com.terminalbd.www.model.StockItem;

import java.util.ArrayList;
import java.util.List;


public class SuggestionAdapter extends ArrayAdapter<StockItem> {

    private List<StockItem> suggestions;

    public SuggestionAdapter(Context context,List<StockItem> stockItems) {
        super(context,0,stockItems);
        suggestions = new ArrayList<>(stockItems);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView==null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.item_for_suggestion_item, parent, false
            );

        }

        TextView medName = convertView.findViewById(R.id.med_name);
        StockItem item = getItem(position);

        if (item != null) {
            medName.setText(item.getName());
        }

        return convertView;
    }

    @Override
    public Filter getFilter() {

        Filter myFilter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                FilterResults filterResults = new FilterResults();

                List<StockItem> itemList =new ArrayList<>();

                if (constraint == null || constraint.length()==0) {

                        itemList.addAll(suggestions);

            }else
                {
                 String filterPattern = constraint.toString().toLowerCase().trim();

                 for (StockItem item : suggestions)
                 {
                     if (item.getName().toLowerCase().contains(filterPattern))
                     {
                         itemList.add(item);
                     }
                 }

                }
                // Now assign the values and count to the FilterResults
                // object
                filterResults.values = itemList;
                filterResults.count = itemList.size();

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence contraint, FilterResults results) {
                    clear();
                    addAll((List) results.values);
                    notifyDataSetChanged();
            }

            @Override
            public CharSequence convertResultToString(Object resultValue) {
                return ((StockItem)resultValue).getName();
            }
        };

        return myFilter;
    }

}