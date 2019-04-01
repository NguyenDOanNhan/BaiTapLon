package nguyendoannhan.com;

import android.app.Dialog;
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
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import nguyendoannhan.com.content.LapHoaDonActivity;
import nguyendoannhan.com.content.ThemSanPhamActivity;
import nguyendoannhan.com.fragment.DSKhachHangFragment;
import nguyendoannhan.com.fragment.DanhDachMHFragment;
import nguyendoannhan.com.fragment.DanhSachHoaDonFragment;
import nguyendoannhan.com.fragment.ManHinhFragment;
import nguyendoannhan.com.fragment.PhanLoaiFragment;
import nguyendoannhan.com.fragment.ThongKeFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private Toolbar toolbar; // là nơi để viết tiêu đề áp , bình thường là mặc định tên app

    private Dialog dialog;
    private EditText edt_dilog_tenDM;
    private EditText edt_dilog_thutuDM;
    private Button btn_dilog_huybo;
    private Button btn_dilog_guidi;


    private int menuId;// la thuoc tinh de gan cho mot fragemt để nó hoạt động floatActonButton theo tung giao dien

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitActivity();
        FloatingActionButton fl_btnAdd = (FloatingActionButton) findViewById(R.id.fl_btnAdd);
        fl_btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (menuId) {
                    case 0:
                        startActivity(new Intent(MainActivity.this, LapHoaDonActivity.class));
                        break;
                    case 1: {
                        //alert hien thi dang nhap them danh muc phan loai
                        DilogThemDanhMuc();
                        break;
                    }
                    case 2: {
                        startActivity(new Intent(MainActivity.this, ThemSanPhamActivity.class));
                        break;
                    }
                    case 3: {
                        startActivity(new Intent(MainActivity.this, LapHoaDonActivity.class));
                        break;
                    }
                }


            }


        });

        NavigationView navigationView = (NavigationView) findViewById(R.id.nar_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    public void InitActivity() {
        // là nơi ánh xạ các chức năng
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        setSupportActionBar(toolbar);// hien thi cua so tool bar
        toolbar.setTitle(getCurentTime()); // set time cho home\
        toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState(); // ho tro nut button bar

    }

    @Override
    public void onBackPressed() {
        // quay vè màn hình toolbar sau khi chọn các sự kiện trong navigation
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
                // hien len alert doi mat khau
                // chuyên màn hình khi nhấn sự kiện này, và chuyên theo doạn intent
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
                menuId = 3;
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new DanhSachHoaDonFragment()).commit();
                toolbar.setTitle("Danh sách hóa đơn");
                break;
            }
            case R.id.nar_thongke: {
                menuId = 4;
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ThongKeFragment()).commit();
                toolbar.setTitle("Thống kê");
                break;
            }
            case R.id.nar_account: {
                menuId = 5;
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new DSKhachHangFragment()).commit();
                toolbar.setTitle("Danh sách khách hàng");
                break;
            }
            case R.id.nar_inform: {
                menuId = 6;
                Toast.makeText(this, "Thông tin của hàng", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.nar_huongdan: {
                menuId = 7;
                Toast.makeText(this, "Hưỡng Dẫn về app", Toast.LENGTH_SHORT).show();
                break;
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        // đóng narvigation khi nhấn vào item

        return true;
    }


    public String getCurentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // định dạng ngày tháng
        Date currentDate = new Date();
        return dateFormat.format(currentDate.getTime()).toString();
    }

    public void DilogThemDanhMuc() {
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dilog_them_danh_muc);
        // cua dilog them danh muc
        edt_dilog_tenDM = (EditText) dialog.findViewById(R.id.edt_ThemDM);
        edt_dilog_thutuDM = (EditText) dialog.findViewById(R.id.edt_ThutuDM);
        btn_dilog_guidi = (Button) dialog.findViewById(R.id.btn_dilog_guidi);
        btn_dilog_huybo = (Button) dialog.findViewById(R.id.btn_dilog_huy);
        //
        btn_dilog_guidi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tendanhmuc = edt_dilog_tenDM.getText().toString();
                int thutuDM = Integer.parseInt(edt_dilog_thutuDM.getText().toString());
                // đây là ví dụ thôi nhé, mn làm một Grawview rồi cho vào nhé

                if (tendanhmuc.equals("nhan") && thutuDM == 1) {
                    Toast.makeText(MainActivity.this, "ok da nhap dung danh muc", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Lỗi nhập danh mục", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_dilog_huybo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss(); //  tat mot của sổ hiện tại nếu là intent thi dùng finish()
            }
        });

        dialog.show();


    }
}
