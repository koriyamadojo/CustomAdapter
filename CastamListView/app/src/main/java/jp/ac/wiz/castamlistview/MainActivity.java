package jp.ac.wiz.castamlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //選択されたリストの項目のタイトルを表示する領域のインスタンスを保持する領域
    private TextView tvSelectText;
    //リストビューのインスタンス保持する領域
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //選択された項目のタイトル表示領域をxmlファイルと紐付けする
        tvSelectText = (TextView)findViewById(R.id.tvSelectText);
        //リストビューをxmlファイルと紐付けする
        lv = (ListView)findViewById(R.id.lv);
        //自作のアダプターのインスタンス生成
        CustomAdapter cAdapter = new CustomAdapter(this,createData());
        //自作アダプターをリストビューに登録
        lv.setAdapter(cAdapter);
        //リストビューのクリックリスナーを設定
        lv.setOnItemClickListener(new MyOnItemClickListener());
        
    }

    //リストビューを選択した時のリスナークラスを作成
    class MyOnItemClickListener implements AdapterView.OnItemClickListener{
        //項目を選択された時に呼ばれるメソッド
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            //選択された所のビューからタイトル情報を取得
            TextView tvTitle = (TextView)view.findViewById(R.id.tvTitle);
            //選択項目表示領域に取得したタイトル情報を設定
            tvSelectText.setText(tvTitle.getText());
        }
    }


    //リストに表示する情報を作成
    private ArrayList createData(){
        //データをまとめるようの領域
        ArrayList<ListRow> list = new ArrayList<ListRow>();
        //カレンダーのインスタンス取得
        Calendar calendar = Calendar.getInstance();
        //カレンダーの表示フォーマット作成
        SimpleDateFormat adf = new SimpleDateFormat("yyyy/MM/dd");
        //テストデータを30件分作成
        for(int i = 0 ; i < 30 ; i++){
            //一件分のデータを管理する
            ListRow lr = new ListRow();
            //タイトルデータを設定
            lr.setTitle("タイトルフィールド" + i);
            //日付を1日ずらしながら設定
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            lr.setDate(adf.format(calendar.getTime()));
            //画像情報設定
            lr.setResouceId(R.drawable.ic_launcher);
            //一件分のデータをリストに追加
            list.add(lr);
        }
        //完成したリストデータを返す
        return list;
    }

}
