package com.example.desarollo.myapplication3;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorEmpleados
        extends RecyclerView.Adapter<AdaptadorEmpleados.ViewHolderEmpleados> implements View.OnClickListener {


    ArrayList<Empleado> listaEmpleados;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    boolean isSelected;

    private View.OnClickListener listener;
    public AdaptadorEmpleados(ArrayList<Empleado> listaEmpl) {
        this.listaEmpleados = listaEmpl;
    }
    @Override
    public ViewHolderEmpleados onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout = 0;
        layout=R.layout.item_list2;
        View view= LayoutInflater.from(parent.getContext()).inflate(layout,null,false);

        view.setOnClickListener(this);

        return new ViewHolderEmpleados(view);
    }
    @Override
    public void onBindViewHolder(ViewHolderEmpleados holder, int position) {
        holder.etNombre.setText(listaEmpleados.get(position).getNombre());
        holder.etPHTD.setText(listaEmpleados.get(position).getPHTD());


    }
    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public int getItemCount() {
        return listaEmpleados.size();
    }




    @Override
    public void onClick(View v) {
        if (listener!=null){
            listener.onClick(v);
        }
    }
    public class ViewHolderEmpleados extends RecyclerView.ViewHolder {

        TextView etNombre,etPHTD;

        public ViewHolderEmpleados(View itemView) {
            super(itemView);
            etNombre= (TextView) itemView.findViewById(R.id.idNombre);
            etPHTD= (TextView) itemView.findViewById(R.id.idphtd);

        }
    }
}
