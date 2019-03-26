package org.blackist.modulize.ui.widget.homenu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.blackist.modulize.ui.R;

import java.util.List;

/**
 * @author LiangLiang.Dong[liangl.dong@gmail.com]
 * @since 2018/12/20
 */

public class HomenuAdapter extends RecyclerView.Adapter<HomenuAdapter.HomenuHolder> {

    private HomenuEvent homenuEvent;
    private List<Homenu> homenus;
    private LayoutInflater layoutInflater;

    public HomenuAdapter(Context context, List<Homenu> homenus, HomenuEvent event) {
        this.homenus = homenus;
        this.homenuEvent = event;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public HomenuHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.common_homenu, parent, false);
        return new HomenuHolder(view);
    }

    @Override
    public void onBindViewHolder(HomenuHolder holder, int position) {
        final Homenu homenu = homenus.get(position);
        holder.label.setText(homenu.getLabel());
        holder.icon.setImageResource(homenu.getIcon());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (homenuEvent != null) {
                    homenuEvent.onHomenu(homenu);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return homenus == null ? 0 : homenus.size();
    }

    static class HomenuHolder extends RecyclerView.ViewHolder {

        View itemView;
        TextView label;
        ImageView icon;

        public HomenuHolder(View view) {
            super(view);
            this.itemView = view;
            label = view.findViewById(R.id.homenu_label);
            icon = view.findViewById(R.id.homenu_icon);
        }
    }
}
