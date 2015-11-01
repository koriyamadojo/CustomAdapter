package jp.ac.wiz.castamlistview;

/**
 * Created by takedanaoki on 2015/10/31.
 */
public class ListRow {
    //タイトル
    private String title;
    //日付
    private String date;
    //画像のリソース
    private int resouceId;

    //日付データのセッター
    public void setDate(String date) {
        this.date = date;
    }
    //画像リソースのセッター
    public void setResouceId(int resouceId) {
        this.resouceId = resouceId;
    }
    //タイトルデータのセッター
    public void setTitle(String title) {
        this.title = title;
    }
    //日付データのゲッター
    public String getDate() {
        return date;
    }
    //画像リソースのゲッター
    public int getResouceId() {
        return resouceId;
    }
    //タトルデータのゲッター
    public String getTitle() {
        return title;
    }

}
