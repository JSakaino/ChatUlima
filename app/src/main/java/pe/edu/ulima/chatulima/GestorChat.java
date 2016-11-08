package pe.edu.ulima.chatulima;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GestorChat {
    private static GestorChat gestor = null;

    public static GestorChat getInstance(){
        if (gestor == null){
            gestor = new GestorChat();
        }
        return gestor;
    }

    private GestorChat(){}

    public void enviarMensaje(OnEnviarMensaje callback){

    }
    public void obtenerMensajes(final OnObtenerMensajes callback){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference ref = firebaseDatabase.getReference("personas");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data : dataSnapshot.getChildren()){
                    Log.i("GestorChat",data.getKey());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("GestorChat",databaseError.getMessage());
            }
        });

    }

    public interface OnObtenerMensajes{
        public void OnObtenerMensajesExito(List<Mensaje> mensajes);
        public void OnObtenerMensajesError(String error);
    }
    public interface OnEnviarMensaje{
        public void OnEnviarMensajeExito();
        public void OnEnviarMensajeError();
    }
}
