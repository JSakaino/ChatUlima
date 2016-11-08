package pe.edu.ulima.chatulima;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MensajesAdapter extends BaseAdapter {
    private List<Mensaje> mMensajes;
    private Context mContext;
    public MensajesAdapter(Context context , List<Mensaje> mensajes){
        mContext = context;
        mMensajes = mensajes;
    }
    @Override
    public int getCount() {
        return mMensajes.size();
    }

    @Override
    public Object getItem(int i) {
        return mMensajes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null){
            view =
                    LayoutInflater.from(mContext).inflate(
                            R.layout.item_mensaje, viewGroup, false);

            viewHolder = new ViewHolder();
            viewHolder.tviMensajeUsuario =
                    (TextView) view.findViewById(R.id.tviMensajeUsuario);
            viewHolder.tviMensajeTexto=
                    (TextView) view.findViewById(R.id.tviMensajeTexto);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }

        Mensaje mensaje = mMensajes.get(i);
        viewHolder.tviMensajeUsuario.setText(mensaje.getUsuario());
        viewHolder.tviMensajeTexto.setText(mensaje.getMensaje());

        return view;
    }
    class ViewHolder{
        TextView tviMensajeUsuario;
        TextView tviMensajeTexto;
    }
}
