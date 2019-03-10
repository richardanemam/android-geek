package com.example.capitais.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.capitais.model.CapitalsModel;
import com.example.capitais.R;
import com.example.capitais.adapter.CapitalsAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GridView gvCapitals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
    }

    private void initializeViews() {
        gvCapitals = findViewById(R.id.gridview_capital);
        initializeGrid();
    }

    private List<CapitalsModel> capitalsInfo(){
        String[] capitalsNames = {"São Paulo", "Rio de Janeiro", "Brasília", "Curitiba",
                "Rio Branco", "Maceió", "Macapá", "Manaus", "Salvador", "Fortaleza", "Vitótria",
                "Goiânia","São Luís", "Cuiabá", "Campo Grande", "Belo Horizonte", "Belém",
                "João Pessoa", "Recife", "Teresina", "Natal", "Porto Alegre", "Porto Velho",
                "Boa Vista", "Florianópolis", "Aracaju", "Palmas"};

        int[] capitalsThumnails = {R.drawable.saopaulo, R.drawable.rio, R.drawable.brasilia,
                R.drawable.curitiba, R.drawable.riobranco, R.drawable.maceio, R.drawable.macapa,
                R.drawable.manaus, R.drawable.salvador, R.drawable.fortaleza, R.drawable.vitoria,
                R.drawable.goiania, R.drawable.saoluis, R.drawable.cuiaba, R.drawable.campogrande,
                R.drawable.belohorizonte, R.drawable.belem, R.drawable.joaopessoa, R.drawable.recife,
                R.drawable.teresina, R.drawable.natal, R.drawable.portoalegre, R.drawable.portovelho,
                R.drawable.boavista, R.drawable.florianopolis, R.drawable.aracaju, R.drawable.palmas};

        List<CapitalsModel> capitalsList = new ArrayList<>();

        for(int i = 0; i<capitalsNames.length; i++){
                 CapitalsModel c = new CapitalsModel(capitalsNames[i], capitalsThumnails[i]);
                 capitalsList.add(c);
        }

        return capitalsList;
    }


    private void initializeGrid(){
        final List<CapitalsModel> capitalsData = capitalsInfo();
        CapitalsAdapter capitalsAdapter = new CapitalsAdapter(this, capitalsData);
        gvCapitals.setAdapter(capitalsAdapter);
        gvCapitals.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String cityName = capitalsData.get(i).getCity();
                String cityNameFormat = cityName.replace(" ", "_");
                String url = "https://en.wikipedia.org/wiki/" + cityNameFormat;
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
    }
}
