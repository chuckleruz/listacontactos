package com.academiaandroid.listacontactos;

//Aplicación Android en el que utilizamos un componente de tipo selección
//ListView para mostrar datos de contactos almacenados.
//
//academiaandroid.com
//
//by José Antonio Gázquez Rodríguez

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.academiaandroid.contacto.Contacto;
import java.util.ArrayList;

import static android.widget.Toast.*;


/*Clase MainActivity, que hereda de la clase base Activity, que permite mostrar
los contactos almacenados en un componente de tipo selección ListView.*/
public class MainActivity extends Activity {
    private ListView listContactos;
    private EditText edDatosContacto;
    private ArrayList<Contacto> datosContacto;
    private Contacto contacto,contacto2;
    private Adaptador adaptadorPersonalizado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Se inicializa el componente ListView, enlazándolo con su recurso a nivel de layout.*/
        listContactos = (ListView) findViewById(R.id.list);
        edDatosContacto = (EditText) findViewById(R.id.edDatosContacto);
        /*Se inicializan dos objetos de la clase Contacto.*/
        contacto = new Contacto("Teléfono casa", "Juán Antonio", "012345678");
        contacto2 = new Contacto("Teléfono móvil", "Francisco Hernández", "876543210");
        datosContacto = new ArrayList<Contacto>();
        datosContacto.add(contacto);
        datosContacto.add(contacto2);
        adaptadorPersonalizado = new Adaptador(this);
        /*Se almacenan los datos de los dos objetos inicializados en el componente ListView.*/
        listContactos.setAdapter(adaptadorPersonalizado);
            //Evento lanzado al realizar click sobre uno de los ítem de la lista.
            listContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String contactoSeleccionado = datosContacto.get(position).getDatos();
                    /*Se asigna el contenido del ítem seleccionado al componente EditText definido.*/
                    edDatosContacto.setText(datosContacto.get(position).getDatos());
                    Log.d("TAG", contactoSeleccionado);
                }
            });
        }

        public void tipsAndroid()
        {
            makeText(this, "Tips Android Studio", LENGTH_LONG);
        }

    }
    /*Clase Adaptador, que hereda de la clase base ArrayAdapter, que sobrescribe el método getView(),
    y que permite construir una vista personalizada para el componente de tipo selección ListView.*/
    class Adaptador extends ArrayAdapter {

        private Activity context;

        public Adaptador(Activity context) {
            super(context, R.layout.itemcontacto, datosContacto);
            this.context = context;
        }


        /*Método que devuelve una vista con los datos en la posición especificada en el almacén de datos.
	    Se asigna un layout personalizado con dos componentes de tipo TextView para mostrar el número de
	    teléfono y tipo.*/
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.itemcontacto, null);

            TextView tvNumero = (TextView)item.findViewById(R.id.tvNumero);
            tvNumero.setText(datosContacto.get(position).getNumero());

            TextView tvTipo = (TextView)item.findViewById(R.id.tvTipo);
            tvTipo.setText(datosContacto.get(position).getTipo());

            return(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}


