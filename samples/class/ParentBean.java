// こぴーらいと
package xxxx.yyyy.mail.bean.content;

import xxxx.yyyy.mail.bean.parts.CancelBean;

/**
 * キャンセル確認メール用Bean
 *
 * @author XXXX
 */
public class ParentBean {

	/** ヘッダー用差し込み枠 */
	private String pcHeaderPartsText;

	/** 店名 */
	private String storeName;

	/** キャンセル系通知共通Bean */
	private CancelBean CancelBean;

	/**
	 * ヘッダー用差し込み枠を返す。
	 *
	 * @return ヘッダー用差し込み枠
	 */
	public String getPcHeaderPartsText() {
		return pcHeaderPartsText;
	}

	/**
	 * ヘッダー用差し込み枠をセットする。
	 *
	 * @param pcHeaderPartsText ヘッダー用差し込み枠
	 */
	public void setPcHeaderPartsText(String pcHeaderPartsText) {
		this.pcHeaderPartsText = pcHeaderPartsText;
	}

	/**
	 * 店名を返す。
	 *
	 * @return 店名
	 */
	public String getStoreName() {
		return storeName;
	}

	/**
	 * 店名をセットする。
	 *
	 * @param storeName 店名
	 */
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	/**
	 * キャンセル系通知共通Beanを返す。
	 *
	 * @return キャンセル系通知共通Bean
	 */
	public CancelBean getCancelBean() {
		return CancelBean;
	}

	/**
	 * キャンセル系通知共通Beanをセットする。
	 *
	 * @param CancelBean キャンセル系通知共通Bean
	 */
	public void setCancelBean(CancelBean CancelBean) {
		this.CancelBean = CancelBean;
	}

}
