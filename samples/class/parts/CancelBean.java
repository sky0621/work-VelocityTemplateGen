// こぴーらいと
package xxxx.yyyy.mail.bean.parts;

import static xxxx.yyyy.enums.DateFormatEnums.AD.YYYYMMDDHHMM_JP;

import java.util.Date;

/**
 * キャンセル系通知共通Bean
 *
 * @author XXXX
 */
public class CancelBean {

	/** 受付日時 */
	private Date insDate;

	/** キャンセル日時 */
	private Date cancelDate;

	/** 内容照会キャンセル用Bean */
	private ContentCancelBean ContentCancelBean;

	/** 注意事項Bean */
	private NoticeBean NoticeBean;

	/** フッタBean */
	private FooterBean FooterBean;

	/**
	 * 「yyyy年MM月dd日 HH時mm分」形式で受付日時を返す。
	 *
	 * @return 「yyyy年MM月dd日 HH時mm分」形式の受付日時
	 */
	public String getInsDate() {
		return insDate == null ? null : YYYYMMDDHHMM_JP.format(insDate);
	}

	/**
	 * 受付日時をセットする。
	 *
	 * @param insDate 受付日時
	 */
	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}

	/**
	 * 「yyyy年MM月dd日 HH時mm分」形式でキャンセル日時を返す。
	 *
	 * @return 「yyyy年MM月dd日 HH時mm分」形式のキャンセル日時
	 */
	public String getCancelDate() {
		return cancelDate == null ? null : YYYYMMDDHHMM_JP.format(cancelDate);
	}

	/**
	 * キャンセル日時をセットする。
	 *
	 * @param cancelDate キャンセル日時
	 */
	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}

	/**
	 * 内容照会キャンセル用Beanを返す。
	 *
	 * @return 内容照会キャンセル用Bean
	 */
	public ContentCancelBean getContentCancelBean() {
		return ContentCancelBean;
	}

	/**
	 * 内容照会キャンセル用Beanをセットする。
	 *
	 * @param ContentCancelBean 内容照会キャンセル用Bean
	 */
	public void setContentCancelBean(ContentCancelBean ContentCancelBean) {
		this.ContentCancelBean = ContentCancelBean;
	}

	/**
	 * 注意事項Beanを返す。
	 *
	 * @return 注意事項Bean
	 */
	public NoticeBean getNoticeBean() {
		return NoticeBean;
	}

	/**
	 * 注意事項Beanをセットする。
	 *
	 * @param NoticeBean 注意事項Bean
	 */
	public void setNoticeBean(NoticeBean NoticeBean) {
		this.NoticeBean = NoticeBean;
	}

	/**
	 * フッタBeanを返す。
	 *
	 * @return フッタBean
	 */
	public FooterBean getFooterBean() {
		return FooterBean;
	}

	/**
	 * フッタBeanをセットする。
	 *
	 * @param FooterBean フッタBean
	 */
	public void setFooterBean(FooterBean FooterBean) {
		this.FooterBean = FooterBean;
	}

}
