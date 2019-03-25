package nguyendoannhan.com.content;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import nguyendoannhan.com.R;

public class LapHoaDonActivity extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lap_hoa_don);
        toolbar = (Toolbar) findViewById(R.id.toolbarDM);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp); // hỗ trọ nút mũi tên quay về màn hình  ban đầu
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    // chuyển về menu home;
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_check:{
                Toast.makeText(this, "check ok", Toast.LENGTH_SHORT).show();
                break;
            }
            default:// khong nhan gi thi tro ve home
                // tro ve home
                super.onBackPressed();
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.lap_hoa_don_menu, menu);
        return true;
    }
}

