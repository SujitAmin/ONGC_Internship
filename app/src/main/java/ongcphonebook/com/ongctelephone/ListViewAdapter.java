package ongcphonebook.com.ongctelephone;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 23-Jun-17.
 */

public class ListViewAdapter extends BaseAdapter {

    LayoutInflater inflater;
    Context mContext;
    private ArrayList<WorldPopulation> arrayList;
    private List<WorldPopulation> worldPopulationList = null;

    public ListViewAdapter(Context context, List<WorldPopulation> list) {
        this.mContext = context;
        this.worldPopulationList = list;
        this.inflater = LayoutInflater.from(this.mContext);
        this.arrayList = new ArrayList();
        this.arrayList.addAll(list);

    }// tis is very useful

    /*
    enable aggressive block sorting
     */
    public void filter(String string2) {
        String string3 = string2.toLowerCase();
        this.worldPopulationList.clear();
        if (string3.length() == 0) {
            this.worldPopulationList.addAll(this.arrayList);
        } else {
            for (WorldPopulation worldPopulation : this.arrayList) {
                if (!worldPopulation.getCpf().toLowerCase().contains(string3) && !worldPopulation.getName().toLowerCase().contains(string3) && !worldPopulation.getDesignation().toLowerCase().contains(string3) && !worldPopulation.getLocation().toLowerCase().contains(string3) && !worldPopulation.getMobi().toLowerCase().contains(string3) /*&& !worldPopulation.getOffice().toLowerCase().contains((CharSequence)string3)*/ /*&& !worldPopulation.getCity().toLowerCase().contains((CharSequence)string3) */ && !worldPopulation.getOffTel().toLowerCase().contains(string3))
                    continue;
                this.worldPopulationList.add(/*(Object)*/worldPopulation);
            }
        }
        this.notifyDataSetChanged();
    }

    public int getCount() {
        return this.worldPopulationList.size();
    }

    public WorldPopulation getItem(int n) {
        return this.worldPopulationList.get(n);
    }

    public long getItemId(int n) {
        return n;
    }

    public View getView(final int n, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder =/*(ListViewAdapter)*/this.new ViewHolder();
            view = this.inflater.inflate(R.id.mList_View, null);
            // look here
            viewHolder.Name = (TextView) view.findViewById(R.id.editText_search);
            viewHolder.cpf = (TextView) view.findViewById(R.id.editText_search);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.Name.setText(this.worldPopulationList.get(n).getName());
        if (this.worldPopulationList.get(n).getCpf().equals("null")) {
            viewHolder.cpf.setText("CPF no. -");
        } else {
            viewHolder.cpf.setText("CPF no." + this.worldPopulationList.get(n).getCpf());
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListViewAdapter.this.mContext, Details.class);
                intent.putExtra("Location", ListViewAdapter.this.worldPopulationList.get(n).getLocation());
                //  intent.putExtra("Office",((WorldPopulation)ListViewAdapter.this.worldPopulationList.get(n)).getOffice());
                //   intent.putExtra("SubOffice",((WorldPopulation)ListViewAdapter.this.worldPopulationList.get(n)).getSubOffice());
                intent.putExtra("Name", ListViewAdapter.this.worldPopulationList.get(n).getName());
                intent.putExtra("mail", ListViewAdapter.this.worldPopulationList.get(n).getCpf());
                intent.putExtra("Designation", ListViewAdapter.this.worldPopulationList.get(n).getDesignation());
                intent.putExtra("Office-tel", ListViewAdapter.this.worldPopulationList.get(n).getOffTel());
                intent.putExtra("Mobile", ListViewAdapter.this.worldPopulationList.get(n).getMobi());
                //  intent.putExtra("City",((WorldPopulation)ListViewAdapter.this.worldPopulationList.get(n)).getCity());
                ListViewAdapter.this.mContext.startActivity(intent);
            }

        });
        return view;

    }


    public class ViewHolder {
        TextView Designation;
        TextView Location;
        TextView Mobile;
        TextView Name;
        TextView Office;
        TextView Office_Tel;
        TextView cpf;
    }

}
