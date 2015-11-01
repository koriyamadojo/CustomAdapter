package jp.ac.wiz.castamlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by takedanaoki on 2015/11/01.
 */
public class CustomAdapter extends BaseAdapter{
    //アプリケーション情報
    Context mContext;
    //アダプター内で使用する情報
    ArrayList<ListRow> mListRows;
    //xmlファイル同士を組み合わせる時に使用するクラス
    LayoutInflater mLayoutInflater;

    public CustomAdapter(Context context,ArrayList list) {
        //アプリケーション情報を取得
        this.mContext = context;
        //表示するデータを取得
        this.mListRows = list;
    }

    //ここから下は実装時なければいけないメソッド
    //データの件数取得メソッド
    @Override
    public int getCount() {
        return mListRows.size();
    }
    //1件分のデータ取得するメソッド
    @Override
    public Object getItem(int position) {
        return mListRows.get(position);
    }
    //1件分のデータのID取得するメソッド
    //今回はIDを決めていないのでそのままポジションを返しています。
    @Override
    public long getItemId(int position) {
        return (long)position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //アプリケーション情報を元にxmlを組み合わせるクラスのインスタンス作成
        mLayoutInflater = LayoutInflater.from(mContext);
        //リストの1項目分のビューに1項目分のxmlをセットする
        convertView = mLayoutInflater.inflate(R.layout.listrow, parent,false);

        //1項目分のxmlからそれぞれのオブジェクトを作成
        TextView tvTitle = (TextView)convertView.findViewById(R.id.tvTitle);
        TextView tvDate = (TextView)convertView.findViewById(R.id.tvDate);
        ImageView ivIcon = (ImageView)convertView.findViewById(R.id.ivIcon);


        //コンストラクタで取得していたデータから1項目分のデータを取得
        ListRow lr = mListRows.get(position);
        //1項目分のデータをオブジェクトにセットする
        tvTitle.setText(lr.getTitle());
        tvDate.setText(lr.getDate());
        ivIcon.setImageResource(lr.getResouceId());

        //完成した1項目分のビューを返す
        return convertView;
    }
}
