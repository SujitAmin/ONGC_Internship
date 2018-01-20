package ongcphonebook.com.ongctelephone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

//import static ongcphonebook.com.ongctelephone.R.id.List_View;

public class Search extends AppCompatActivity {

    private ListView mList_View;
    private ArrayList<WorldPopulation> arrayList;
    private FirebaseListAdapter<WorldPopulation> firebaseListAdapter = null;
    private EditText editText_search;
    private String filterText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        mList_View = (ListView) findViewById(R.id.mList_View);
        this.arrayList = new ArrayList();
        editText_search = (EditText) findViewById(R.id.editText_search);
        filterText = editText_search.getText().toString();


        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://ongctelephone-57cad.firebaseio.com/employees");
//modify here
        databaseReference.keepSynced(true);
        firebaseListAdapter = new FirebaseListAdapter<WorldPopulation>(
                this,
                WorldPopulation.class,
                android.R.layout.simple_list_item_1
                , databaseReference
        ) {

            @Override
            protected void populateView(View v, WorldPopulation data, int position) {

                TextView textView = (TextView) v.findViewById(android.R.id.text1);
                textView.setText(data.getName());
            }


        };
        mList_View.setAdapter(firebaseListAdapter);

        editText_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                WorldPopulation.this.firebaseListAdapter.getFilter().filter(s);//check here
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public View getView(final int n, View view, ViewGroup viewGroup) {
        ListViewAdapter.ViewHolder viewHolder;
        if (view == null) {
            viewHolder = (FirebaseListAdapter) this.new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
            view = this.getLayoutInflater().inflate(R.id.mList_View, null);
            // look here
            viewHolder.Name = (TextView) view.findViewById(R.id.editText_search);
            viewHolder.cpf = (TextView) view.findViewById(R.id.editText_search);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ListViewAdapter.ViewHolder) view.getTag();
        }
        viewHolder.Name.setText(((WorldPopulation) this.firebaseListAdapter).getName());
        if (((WorldPopulation) this.firebaseListAdapter).getCpf().equals("null")) {
            viewHolder.cpf.setText("CPF no. -");
            //google
        } else {
            viewHolder.cpf.setText("CPF no." + ((WorldPopulation) this.firebaseListAdapter).getCpf());
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
//vv
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
