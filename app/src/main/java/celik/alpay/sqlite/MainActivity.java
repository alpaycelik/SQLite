package celik.alpay.sqlite;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.List;
import java.util.Random;

public class MainActivity extends ListActivity {
    VeriKaynagi vk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vk = new VeriKaynagi(this);
        vk.ac();
        List<Kullanici> kullanicilar = vk.listele();
        final ArrayAdapter<Kullanici> adaptor = new ArrayAdapter<Kullanici>(this,android.R.layout.simple_list_item_1,kullanicilar);
        setListAdapter(adaptor);
        Button ekle = (Button) findViewById(R.id.add);
        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String isimler [] = {"ali demir","veli yıldız","ahmet yıldız","fatma demir"};
                Random r = new Random();
                int ras = r.nextInt(3);
                Kullanici k = new Kullanici(isimler[ras]);
                int sonid = vk.kullaniciOlustur(k.getIsim());
                k.setId(sonid);
                adaptor.add(k);
            }
        });
        Button sil = (Button) findViewById(R.id.delete);
        sil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Kullanici k = (Kullanici) getListAdapter().getItem(0);
                vk.kullaniciSil(k);
                adaptor.remove(k);
            }
        });
    }
    protected void onResume(){
        vk.ac();
        super.onResume();
    }
    protected void onPause(){
        vk.kapat();
        super.onResume();
    }
}
