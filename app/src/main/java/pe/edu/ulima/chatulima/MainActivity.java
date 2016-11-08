package pe.edu.ulima.chatulima;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements GestorChat.OnObtenerMensajes{
    ListView lviMensajes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lviMensajes = (ListView) findViewById(R.id.lviMensajes);

        GestorChat.getInstance().obtenerMensajes(this);

    }

    @Override
    public void OnObtenerMensajesExito(List<Mensaje> mensajes) {
        Log.i("MainActivity", "Dim:" + mensajes.size() + "");
        MensajesAdapter adapter = new MensajesAdapter(this, mensajes);
        lviMensajes.setAdapter(adapter);

    }

    @Override
    public void OnObtenerMensajesError(String error) {
        Log.e("MainActivity", error);
        Toast.makeText(this, "Error: " + error, Toast.LENGTH_LONG).show();
    }
}
