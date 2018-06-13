package model;

public class Calemdaratt {
	//JavaBeansのモデル

	/* JavaBeansのルール
	 * ①直列化可能である（java.io.Serializableをインポートしている）
	 * ②クラスはpublicでパッケージに所属する
	 * ③publicで引数のないコンストラクタを持つ
	 * ④フィールドはカプセル化されている
	 * ⑤命名規則に従ったgetter/setterを持つ
	 */

	   private String title;

	    /**
	     * カレンダーの開始日付
	     */
	    private String start;

	    /**
	     * カレンダーの終了日付
	     */
	    private String end;

	    public String getTitle() {
	        return title;
	    }
	    public void setTitle(String title) {
	        this.title = title;
	    }
	    public String getStart() {
	        return start;
	    }
	    public void setStart(String start) {
	        this.start = start;
	    }
	    public String getEnd() {
	        return end;
	    }
	    public void setEnd(String end) {
	        this.end = end;
	    }

}
