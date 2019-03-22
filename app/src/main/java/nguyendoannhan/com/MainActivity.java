package nguyendoannhan.com;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import nguyendoannhan.com.content.DanhMucActivity;
import nguyendoannhan.com.fragment.DSKhachHangFragment;
import nguyendoannhan.com.fragment.DanhDachMHFragment;
import nguyendoannhan.com.fragment.DanhSachHoaDonFragment;
import nguyendoannhan.com.fragment.ManHinhFragment;
import nguyendoannhan.com.fragment.PhanLoaiFragment;
import nguyendoannhan.com.fragment.ThongKeFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private int menuId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getCurentTime());
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        FloatingActionButton fl_btnAdd = (FloatingActionButton) findViewById(R.id.fl_btnAdd);
        fl_btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (menuId) {
                    case 0:
                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:{
                        Toast.makeText(MainActivity.this, "nhan", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }


            }


        });

        NavigationView navigationView = (NavigationView) findViewById(R.id.nar_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu_app, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_doiMK: {
                startActivity(new Intent(MainActivity.this, DanhMucActivity.class));
//                Toast.makeText(this, "Đồi mật khẩu", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.menu_dangXuat: {
                Toast.makeText(this, "Đăng Xuất", Toast.LENGTH_SHORT).show();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nar_home: {
                toolbar.setTitle(getCurentTime());
                menuId = 0;
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ManHinhFragment()).commit();
                break;
            }
            case R.id.nar_branche: {
                menuId = 1;
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PhanLoaiFragment()).commit();
                toolbar.setTitle("Phân loại, danh mục");
                break;
            }

            case R.id.nar_listProduct: {
                menuId = 2;
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new DanhDachMHFragment()).commit();
                toolbar.setTitle("Danh sách món hàng");
                break;
            }
            case R.id.nar_bill: {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new DanhSachHoaDonFragment()).commit();
                toolbar.setTitle("Danh sách hóa đơn");
                break;
            }
            case R.id.nar_thongke: {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ThongKeFragment()).commit();
                toolbar.setTitle("Thống kê");
                break;
            }
            case R.id.nar_account: {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new DSKhachHangFragment()).commit();
                toolbar.setTitle("Danh sách khách hàng");
                break;
            }
            case R.id.nar_inform: {
                Toast.makeText(this, "Thông tin của hàng", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.nar_huongdan: {
                Toast.makeText(this, "Hưỡng Dẫn về app", Toast.LENGTH_SHORT).show();
            }
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }


    public String getCurentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date currentDate = new Date();
        return dateFormat.format(currentDate.getTime()).toString();
    }
}
